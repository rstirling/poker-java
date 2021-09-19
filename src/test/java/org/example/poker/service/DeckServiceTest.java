package org.example.poker.service;

import org.example.poker.model.Card;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DeckServiceTest {

    private DeckService deckService;

    @BeforeEach
    void setUp() {
        deckService = new DeckService(false);
    }

    @Test
    @DisplayName("Get 5 cards from deck")
    void getCards() {
        final var cards = deckService.takeCards(5);
        Assertions.assertEquals(5, cards.size());
    }

    @Test
    @DisplayName("Get 0 cards from deck")
    void getCardsZeroCards() {
        final var cards = deckService.takeCards(0);
        Assertions.assertEquals(0, cards.size());
    }

    @Test
    @DisplayName("Get negative number of cards from deck - Should return an IllegalArgumentException")
    void getNegative() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> deckService.takeCards(-3));
    }

    @Test
    @DisplayName("Get more cards than deck's capacity - Should return an IllegalStateException")
    void getCardsBeyondCapacityFromFullDeck() {
        Assertions.assertThrows(IllegalStateException.class,
                () -> deckService.takeCards(54));
    }

    @Test
    @DisplayName("Get more cards than existing on deck - Should return an IllegalStateException")
    void getCardsBeyondCapacity() {
        //Take 50 cards from a 52 cards deck
        deckService.takeCards(50);

        Assertions.assertThrows(IllegalStateException.class,
                () -> deckService.takeCards(4));
    }

    @Test
    @DisplayName("Reset deck")
    void resetDeckTest() {

        //Take some cards from deck
        final var cardsBeforeReset = deckService.takeCards(50);

        deckService.resetDeck();

        //Take all cards from deck
        final var cards = deckService.takeCards(52);

        Assertions.assertEquals(52, cards.size());
        Assertions.assertTrue(cards.containsAll(cardsBeforeReset));
        Assertions.assertFalse(cardsBeforeReset.containsAll(cards));
    }

    @Test
    @DisplayName("Enable WildCard Usage deck")
    void wildCardEnabled() {

        var service = new DeckService(true);

        //Take some cards from deck
        final var cardsBeforeReset = service.takeCards(50);

        service.resetDeck();

        //Take all cards from deck
        final var cards = service.takeCards(53);

        Assertions.assertTrue(cards.contains(Card.JOKER));

        Assertions.assertEquals(53, cards.size());
        Assertions.assertTrue(cards.containsAll(cardsBeforeReset));
        Assertions.assertFalse(cardsBeforeReset.containsAll(cards));
    }
}