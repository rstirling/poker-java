package org.example.poker.service;

import org.example.poker.model.Card;
import org.example.poker.model.Category;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.ArgumentMatchers.anyInt;

@ExtendWith(MockitoExtension.class)
class CroupierServiceTest {

    private CroupierService croupierService;

    @Mock
    private DeckService mockDeckService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        croupierService = new CroupierService(mockDeckService);
    }

    @Test
    @DisplayName("Flush")
    void getCategoryFlush() {

        Mockito.when(mockDeckService.takeCards(anyInt()))
                .thenReturn(
                        List.of(Card.JACK_DIAMONDS,
                                Card.NINE_DIAMONDS,
                                Card.EIGHT_DIAMONDS,
                                Card.FOUR_DIAMONDS,
                                Card.THREE_DIAMONDS)
                );

        final var hand = croupierService.getHand();

        final var category = croupierService.getCategory(hand);

        Assertions.assertEquals(Category.FLUSH, category);
    }

    @Test
    @DisplayName("Straight Flush")
    void getCategoryStraightFlush() {

        Mockito.when(mockDeckService.takeCards(anyInt()))
                .thenReturn(
                        List.of(Card.JACK_DIAMONDS,
                                Card.TEN_DIAMONDS,
                                Card.NINE_DIAMONDS,
                                Card.EIGHT_DIAMONDS,
                                Card.SEVEN_DIAMONDS)
                );

        final var hand = croupierService.getHand();

        final var category = croupierService.getCategory(hand);

        Assertions.assertEquals(Category.STRAIGHT_FLUSH, category);
    }

    @Test
    @DisplayName("Straight Flush Ace")
    void getCategoryStraightFlushAce() {

        Mockito.when(mockDeckService.takeCards(anyInt()))
                .thenReturn(
                        List.of(Card.FIVE_DIAMONDS,
                                Card.FOUR_DIAMONDS,
                                Card.THREE_DIAMONDS,
                                Card.TWO_DIAMONDS,
                                Card.ACE_DIAMONDS)
                );

        final var hand = croupierService.getHand();

        final var category = croupierService.getCategory(hand);

        Assertions.assertEquals(Category.STRAIGHT_FLUSH, category);
    }

    @Test
    @DisplayName("Four of a Kind")
    void getCategoryFourOfAKind() {

        Mockito.when(mockDeckService.takeCards(anyInt()))
                .thenReturn(
                        List.of(Card.FIVE_CLUBS,
                                Card.FIVE_DIAMONDS,
                                Card.FIVE_HEARTS,
                                Card.FIVE_SPADES,
                                Card.SEVEN_DIAMONDS)
                );

        final var hand = croupierService.getHand();

        final var category = croupierService.getCategory(hand);

        Assertions.assertEquals(Category.FOUR_OF_A_KIND, category);
    }

    @Test
    @DisplayName("Straight")
    void getCategoryStraight() {

        Mockito.when(mockDeckService.takeCards(anyInt()))
                .thenReturn(
                        List.of(Card.TEN_DIAMONDS,
                                Card.NINE_SPADES,
                                Card.EIGHT_HEARTS,
                                Card.SEVEN_DIAMONDS,
                                Card.SIX_CLUBS)
                );

        final var hand = croupierService.getHand();

        final var category = croupierService.getCategory(hand);

        Assertions.assertEquals(Category.STRAIGHT, category);
    }


    @Test
    @DisplayName("Three Of A Kind")
    void getCategoryThreeOfAKind() {

        Mockito.when(mockDeckService.takeCards(anyInt()))
                .thenReturn(
                        List.of(Card.SIX_SPADES,
                                Card.SIX_HEARTS,
                                Card.SIX_DIAMONDS,
                                Card.KING_CLUBS,
                                Card.QUEEN_CLUBS)
                );

        final var hand = croupierService.getHand();

        final var category = croupierService.getCategory(hand);

        Assertions.assertEquals(Category.THREE_OF_A_KIND, category);
    }

    @Test
    @DisplayName("Two Pair")
    void getCategoryTwoPair() {

        Mockito.when(mockDeckService.takeCards(anyInt()))
                .thenReturn(
                        List.of(Card.JACK_HEARTS,
                                Card.JACK_SPADES,
                                Card.THREE_CLUBS,
                                Card.THREE_SPADES,
                                Card.TWO_HEARTS)
                );

        final var hand = croupierService.getHand();

        final var category = croupierService.getCategory(hand);

        Assertions.assertEquals(Category.TWO_PAIR, category);
    }

    @Test
    @DisplayName("One Pair")
    void getCategoryOnePair() {

        Mockito.when(mockDeckService.takeCards(anyInt()))
                .thenReturn(
                        List.of(Card.TEN_SPADES,
                                Card.TEN_HEARTS,
                                Card.EIGHT_SPADES,
                                Card.SEVEN_HEARTS,
                                Card.FOUR_CLUBS)
                );

        final var hand = croupierService.getHand();

        final var category = croupierService.getCategory(hand);

        Assertions.assertEquals(Category.ONE_PAIR, category);
    }

    @Test
    @DisplayName("High Card")
    void getCategoryHighCard() {

        Mockito.when(mockDeckService.takeCards(anyInt()))
                .thenReturn(
                        List.of(Card.KING_DIAMONDS,
                                Card.QUEEN_DIAMONDS,
                                Card.SEVEN_SPADES,
                                Card.FOUR_SPADES,
                                Card.THREE_HEARTS)
                );

        final var hand = croupierService.getHand();

        final var category = croupierService.getCategory(hand);

        Assertions.assertEquals(Category.HIGH_CARD, category);
    }

    @Test
    @DisplayName("Get 2 Hands")
    void testHands() {

        Mockito.when(mockDeckService.takeCards(anyInt()))
                .thenReturn(
                        List.of(Card.TEN_SPADES,
                                Card.TEN_HEARTS,
                                Card.EIGHT_SPADES,
                                Card.SEVEN_HEARTS,
                                Card.FOUR_CLUBS)
                );

        Mockito.when(mockDeckService.takeCards(anyInt()))
                .thenReturn(
                        List.of(Card.TEN_SPADES,
                                Card.TEN_HEARTS,
                                Card.EIGHT_SPADES,
                                Card.SEVEN_HEARTS,
                                Card.FOUR_CLUBS)
                );

        final var handOne = croupierService.getHand();
        final var handTwo = croupierService.getHand();

        final var categoryHandOne = croupierService.getCategory(handOne);
        final var categoryHandTwo = croupierService.getCategory(handTwo);

        Assertions.assertEquals(5, handOne.size());
        Assertions.assertEquals(5, handTwo.size());

        Assertions.assertTrue(categoryHandOne instanceof Category);
        Assertions.assertTrue(categoryHandTwo instanceof Category);
    }

    @Test
    @DisplayName("Compare Two Hands: same category and hand1 wins")
    void testSameCategoryAndHand1Wins() {

        Mockito.when(mockDeckService.takeCards(anyInt()))
                .thenReturn(
                        List.of(Card.TEN_SPADES,
                                Card.TEN_HEARTS,
                                Card.TEN_DIAMONDS,
                                Card.SEVEN_HEARTS,
                                Card.FOUR_CLUBS)
                );

        final var hand1 = croupierService.getHand();

        Mockito.when(mockDeckService.takeCards(anyInt()))
                .thenReturn(
                        List.of(Card.NINE_SPADES,
                                Card.NINE_HEARTS,
                                Card.NINE_DIAMONDS,
                                Card.SEVEN_CLUBS,
                                Card.FOUR_DIAMONDS)
                );

        final var hand2 = croupierService.getHand();

        final var winnerHand = croupierService.compareHands(hand1, hand2);

        Assertions.assertEquals(1, winnerHand);
    }

    @Test
    @DisplayName("Compare Two Hands: same category and hand2 wins")
    void testSameCategoryAndHand2Wins() {

        Mockito.when(mockDeckService.takeCards(anyInt()))
                .thenReturn(
                        List.of(Card.NINE_SPADES,
                                Card.NINE_HEARTS,
                                Card.NINE_DIAMONDS,
                                Card.SEVEN_CLUBS,
                                Card.FOUR_DIAMONDS)
                );

        final var hand1 = croupierService.getHand();

        Mockito.when(mockDeckService.takeCards(anyInt()))
                .thenReturn(
                        List.of(Card.TEN_SPADES,
                                Card.TEN_HEARTS,
                                Card.TEN_DIAMONDS,
                                Card.SEVEN_HEARTS,
                                Card.FOUR_CLUBS)
                );

        final var hand2 = croupierService.getHand();

        final var winnerHand = croupierService.compareHands(hand1, hand2);

        Assertions.assertEquals(-1, winnerHand);
    }

}