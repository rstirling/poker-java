package org.example.poker.service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.poker.model.Card;
import org.example.poker.model.Category;
import org.example.poker.model.Rank;
import org.example.poker.model.Suit;

import java.util.*;
import java.util.stream.Collectors;

import static org.example.poker.model.Category.*;
import static org.example.poker.model.Rank.ACE;
import static org.example.poker.model.Rank.FIVE;

@Slf4j
@RequiredArgsConstructor
public class CroupierService {

    @NonNull
    private DeckService deckService;

    /**
     * Takes 5 Cards from Deck
     *
     * @return a List containing 5 Cards
     */
    public List<Card> getHand() {
        return deckService.takeCards(5);
    }

    /**
     * Evaluate a hand of cards and returns a Hand-Rank Category
     * Based on https://en.wikipedia.org/wiki/List_of_poker_hands
     *
     * @param hand
     * @return Category
     */
    public Category getCategory(List<Card> hand) {

        final Set<Suit> suits = new HashSet<>();
        final List<Rank> ranks = new ArrayList<>();

        for (Card card : hand) {
            suits.add(card.getSuite());
            ranks.add(card.getRank());
        }

        final var handRanks = getSortedHandRanks(hand);

        int handRankCount = handRanks.size();

        if (handRankCount == 5) {
            return getFiveRanksCategory(suits, handRanks);
        } else if (handRankCount == 4) {
            return ONE_PAIR;
        } else if (handRankCount == 3) {
            return getThreeRanksCategory(ranks);
        } else if (hand.contains(Card.JOKER) && handRanks.size() == 1) {
            return FIVE_OF_A_KIND;
        } else {
            return ranks.stream()
                    .filter(Objects::nonNull)
                    .collect(Collectors.groupingBy(r -> r))
                    .entrySet()
                    .stream()
                    .anyMatch(r -> r.getValue().size() == 3) ? FULL_HOUSE : FOUR_OF_A_KIND;
        }

    }

    private Category getThreeRanksCategory(List<Rank> ranks) {
        return ranks.stream()
                .map(r -> Collections.frequency(ranks, r))
                .anyMatch(f -> f == 3) ? THREE_OF_A_KIND : TWO_PAIR;
    }

    private Category getFiveRanksCategory(Set<Suit> suits, List<Rank> handRanks) {

        final var flush = suits.size() == 1;
        final var firstRank = handRanks.get(0);

        if (firstRank.ordinal() - handRanks.get(handRanks.size() - 1).ordinal() == 4) {
            return flush ? STRAIGHT_FLUSH : STRAIGHT;
        } else if (firstRank == ACE && handRanks.get(1) == FIVE) {
            return flush ? STRAIGHT_FLUSH : STRAIGHT;
        } else {
            return flush ? FLUSH : HIGH_CARD;
        }
    }

    /**
     * Compare two distinct same-size hands of cards and returns the winning according to @return
     *
     * @param hand0 list of cards
     * @param hand1 list of cards
     * @return 1 if hand0 wins, -1 if hand1 wins and 0 if equal
     * @throws IllegalArgumentException
     */
    public int compareHands(List<Card> hand0, List<Card> hand1) {

        if (hand0 == null || hand1 == null || hand0.size() != hand1.size()) {
            var inputException = new IllegalArgumentException("Hands are null or not have the same size");
            log.error("Error Comparing Hands:", inputException);
            throw inputException;
        }

        final var categoryHand0 = getCategory(hand0);
        log.debug("Hand1 category[{}] - cards{}", categoryHand0, hand0);

        final var categoryHand1 = getCategory(hand1);
        log.debug("Hand2 category[{}] - cards{}", categoryHand1, hand1);

        //High Cards power are evaluated differently
        if (categoryHand0.equals(categoryHand1) && categoryHand0.equals(HIGH_CARD)) {

            return compareHighHands(hand0, hand1);

        } else if (categoryHand0.equals(categoryHand1)) {

            final var powerHand0 = hand0.stream()
                    .mapToInt(r -> r.getRank().ordinal())
                    .sum();

            final var powerHand1 = hand1.stream()
                    .mapToInt(r -> r.getRank().ordinal())
                    .sum();
            if (Objects.equals(powerHand0, powerHand1)) {
                return 0;
            } else {
                return powerHand0 > powerHand1 ? 1 : -1;
            }
        }

        return categoryHand0.ordinal() > categoryHand1.ordinal() ? 1 : -1;
    }

    /**
     * Compares two high-hands based on ranks.
     *
     * @param hand0
     * @param hand1
     * @return 1 if hand0 wins, -1 if hand1 wins and 0 if equal
     */
    private int compareHighHands(List<Card> hand0, List<Card> hand1) {
        final var sortedHand0 = getSortedHandRanks(hand0);
        final var sortedHand1 = getSortedHandRanks(hand1);

        int count = 0;
        int result = 0;

        while (count < hand0.size()) {
            final var rank0 = sortedHand0.get(count).ordinal();
            final var rank1 = sortedHand1.get(count).ordinal();

            result = Integer.compare(rank0, rank1);

            if (result != 0) {
                break;
            }

            count++;
        }
        return result;
    }

    private List<Rank> getSortedHandRanks(List<Card> hand0) {
        return hand0.stream()
                .map(Card::getRank)
                .filter(Objects::nonNull)
                .distinct()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
    }

}
