package org.example.poker.service;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.example.poker.model.Card;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class DeckService {

    private List<Card> deck;

    @NonNull
    private final boolean wildCardEnabled;

    public DeckService(boolean wildCardEnabled){
        this.wildCardEnabled = wildCardEnabled;
        resetDeck();
    }

    /**
     * Takes a random number of cards from deck according to input.
     *
     * @param quantity of cards to be taken from Deck - positive integer
     * @return A List of cards
     * @throws IllegalStateException    if input quantity is bigger than available cards on deck
     * @throws IllegalArgumentException if input quantity is negative
     */
    public List<Card> takeCards(int quantity) {

        //Check deck availability
        if (deck.size() < quantity) {
            final var deckException = new IllegalStateException(
                    String.format("Unable to serve cards: There are %d cards left on deck", deck.size()));

            log.error("Error getting cards: ", deckException);
            throw deckException;
        }

        //Check input
        if (quantity < 0) {
            final var quantityException = new IllegalArgumentException(
                    "Unable to serve cards: This method expects a positive int argument");

            log.error("Error getting cards: ", quantityException);
            throw quantityException;
        }

        //Ensure that cards are being always shuffled
        Collections.shuffle(this.deck);

        //Take cards from deck
        final var cards = this.deck.subList(0, quantity);

        removeCardsFromDeck(cards);

        return cards;
    }

    /**
     * Remove cards from deck for subsequent calls
     *
     * @param cards
     */
    private void removeCardsFromDeck(List<Card> cards) {
        this.deck = this.deck.stream()
                .filter(card -> !cards.contains(card))
                .collect(Collectors.toList());
    }

    /**
     * Resets the deck for a new round
     */
    public void resetDeck() {
        deck = Arrays.asList(Card.values());
        if (!wildCardEnabled) {
            deck = deck.stream()
                    .filter(c -> !c.equals(Card.JOKER))
                    .collect(Collectors.toList());
        }
    }
}
