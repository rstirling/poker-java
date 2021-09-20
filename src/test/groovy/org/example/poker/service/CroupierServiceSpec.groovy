package org.example.poker.service

import org.example.poker.model.Card
import org.example.poker.model.Category
import org.example.poker.service.CroupierService
import org.example.poker.service.DeckService
import spock.lang.Specification
import spock.lang.Unroll

class CroupierServiceSpec extends Specification {

    CroupierService croupierService;

    void setup() {
        def deckService = new DeckService(true)
        croupierService = new CroupierService(deckService)
    }

    @Unroll
    def "Category of #hand is #category"() {

        expect:
        croupierService.getCategory(hand) == category

        where:
        category                 | hand
        Category.STRAIGHT_FLUSH  | [Card.JACK_DIAMONDS, Card.TEN_DIAMONDS, Card.NINE_DIAMONDS, Card.EIGHT_DIAMONDS, Card.SEVEN_DIAMONDS]
        Category.STRAIGHT_FLUSH  | [Card.FIVE_DIAMONDS, Card.FOUR_DIAMONDS, Card.THREE_DIAMONDS, Card.TWO_DIAMONDS, Card.ACE_DIAMONDS]
        Category.STRAIGHT_FLUSH  | [Card.ACE_CLUBS, Card.TWO_CLUBS, Card.THREE_CLUBS, Card.FOUR_CLUBS, Card.FIVE_CLUBS]
        Category.STRAIGHT_FLUSH  | [Card.QUEEN_HEARTS, Card.JACK_HEARTS, Card.TEN_HEARTS, Card.NINE_HEARTS, Card.EIGHT_HEARTS]
        Category.STRAIGHT_FLUSH  | [Card.ACE_HEARTS, Card.KING_HEARTS, Card.QUEEN_HEARTS, Card.JACK_HEARTS, Card.TEN_HEARTS]
        Category.STRAIGHT_FLUSH  | [Card.FIVE_DIAMONDS, Card.FOUR_DIAMONDS, Card.THREE_DIAMONDS, Card.TWO_DIAMONDS, Card.ACE_DIAMONDS]
        Category.STRAIGHT_FLUSH  | [Card.QUEEN_CLUBS, Card.JACK_CLUBS, Card.TEN_CLUBS, Card.NINE_CLUBS, Card.EIGHT_CLUBS]
        Category.STRAIGHT_FLUSH  | [Card.FIVE_SPADES, Card.FOUR_SPADES, Card.THREE_SPADES, Card.TWO_SPADES, Card.ACE_SPADES]
        Category.STRAIGHT_FLUSH  | [Card.ACE_HEARTS, Card.KING_HEARTS, Card.QUEEN_HEARTS, Card.JACK_HEARTS, Card.TEN_HEARTS]
        Category.STRAIGHT_FLUSH  | [Card.NINE_CLUBS, Card.EIGHT_CLUBS, Card.SEVEN_CLUBS, Card.SIX_CLUBS, Card.FIVE_CLUBS]
        Category.STRAIGHT_FLUSH  | [Card.TEN_CLUBS, Card.NINE_CLUBS, Card.EIGHT_CLUBS, Card.SEVEN_CLUBS, Card.SIX_CLUBS]
        Category.STRAIGHT_FLUSH  | [Card.EIGHT_HEARTS, Card.SEVEN_HEARTS, Card.SIX_HEARTS, Card.FIVE_HEARTS, Card.FOUR_HEARTS]
        Category.STRAIGHT_FLUSH  | [Card.SIX_SPADES, Card.FIVE_SPADES, Card.FOUR_SPADES, Card.THREE_SPADES, Card.TWO_SPADES]
        Category.STRAIGHT_FLUSH  | [Card.SEVEN_DIAMONDS, Card.SIX_DIAMONDS, Card.FIVE_DIAMONDS, Card.FOUR_DIAMONDS, Card.THREE_DIAMONDS]
        Category.STRAIGHT_FLUSH  | [Card.SEVEN_SPADES, Card.SIX_SPADES, Card.FIVE_SPADES, Card.FOUR_SPADES, Card.THREE_SPADES]
        Category.STRAIGHT_FLUSH  | [Card.ACE_DIAMONDS, Card.KING_DIAMONDS, Card.QUEEN_DIAMONDS, Card.JACK_DIAMONDS, Card.TEN_DIAMONDS]
        Category.FOUR_OF_A_KIND  | [Card.NINE_CLUBS, Card.NINE_HEARTS, Card.NINE_DIAMONDS, Card.NINE_SPADES, Card.JACK_HEARTS]
        Category.FOUR_OF_A_KIND  | [Card.KING_DIAMONDS, Card.KING_HEARTS, Card.KING_CLUBS, Card.KING_SPADES, Card.THREE_HEARTS]
        Category.FOUR_OF_A_KIND  | [Card.SEVEN_SPADES, Card.SEVEN_DIAMONDS, Card.SEVEN_HEARTS, Card.SEVEN_CLUBS, Card.QUEEN_HEARTS]
        Category.FOUR_OF_A_KIND  | [Card.SEVEN_SPADES, Card.SEVEN_DIAMONDS, Card.SEVEN_HEARTS, Card.SEVEN_CLUBS, Card.TEN_SPADES]
        Category.FOUR_OF_A_KIND  | [Card.FOUR_SPADES, Card.FOUR_DIAMONDS, Card.FOUR_HEARTS, Card.FOUR_CLUBS, Card.NINE_SPADES]
        Category.FOUR_OF_A_KIND  | [Card.FOUR_SPADES, Card.FOUR_DIAMONDS, Card.FOUR_HEARTS, Card.FOUR_CLUBS, Card.NINE_DIAMONDS]
        Category.FULL_HOUSE      | [Card.THREE_CLUBS, Card.THREE_SPADES, Card.THREE_DIAMONDS, Card.SIX_CLUBS, Card.SIX_HEARTS]
        Category.FULL_HOUSE      | [Card.EIGHT_SPADES, Card.EIGHT_DIAMONDS, Card.EIGHT_HEARTS, Card.SEVEN_DIAMONDS, Card.SEVEN_CLUBS]
        Category.FULL_HOUSE      | [Card.FOUR_DIAMONDS, Card.FOUR_SPADES, Card.FOUR_CLUBS, Card.NINE_DIAMONDS, Card.NINE_CLUBS]
        Category.FULL_HOUSE      | [Card.FOUR_DIAMONDS, Card.FOUR_SPADES, Card.FOUR_CLUBS, Card.FIVE_CLUBS, Card.FIVE_DIAMONDS]
        Category.FULL_HOUSE      | [Card.KING_CLUBS, Card.KING_SPADES, Card.KING_DIAMONDS, Card.JACK_CLUBS, Card.JACK_SPADES]
        Category.FULL_HOUSE      | [Card.KING_CLUBS, Card.KING_HEARTS, Card.KING_DIAMONDS, Card.JACK_CLUBS, Card.JACK_HEARTS]
        Category.FLUSH           | [Card.JACK_DIAMONDS, Card.NINE_DIAMONDS, Card.EIGHT_DIAMONDS, Card.FOUR_DIAMONDS, Card.THREE_DIAMONDS]
        Category.FLUSH           | [Card.KING_CLUBS, Card.TEN_CLUBS, Card.SEVEN_CLUBS, Card.SIX_CLUBS, Card.FOUR_CLUBS]
        Category.FLUSH           | [Card.JACK_HEARTS, Card.EIGHT_HEARTS, Card.FOUR_HEARTS, Card.THREE_HEARTS, Card.TWO_HEARTS]
        Category.FLUSH           | [Card.KING_DIAMONDS, Card.JACK_DIAMONDS, Card.NINE_DIAMONDS, Card.SIX_DIAMONDS, Card.FOUR_DIAMONDS]
        Category.FLUSH           | [Card.QUEEN_CLUBS, Card.JACK_CLUBS, Card.SEVEN_CLUBS, Card.SIX_CLUBS, Card.FIVE_CLUBS]
        Category.FLUSH           | [Card.JACK_HEARTS, Card.TEN_HEARTS, Card.NINE_HEARTS, Card.FOUR_HEARTS, Card.TWO_HEARTS]
        Category.FLUSH           | [Card.JACK_SPADES, Card.TEN_SPADES, Card.EIGHT_SPADES, Card.SIX_SPADES, Card.THREE_SPADES]
        Category.FLUSH           | [Card.JACK_HEARTS, Card.TEN_HEARTS, Card.EIGHT_HEARTS, Card.FOUR_HEARTS, Card.THREE_HEARTS]
        Category.FLUSH           | [Card.JACK_CLUBS, Card.TEN_CLUBS, Card.EIGHT_CLUBS, Card.FOUR_CLUBS, Card.TWO_CLUBS]
        Category.FLUSH           | [Card.TEN_DIAMONDS, Card.EIGHT_DIAMONDS, Card.SEVEN_DIAMONDS, Card.SIX_DIAMONDS, Card.FIVE_DIAMONDS]
        Category.FLUSH           | [Card.TEN_CLUBS, Card.EIGHT_CLUBS, Card.SEVEN_CLUBS, Card.SIX_CLUBS, Card.FIVE_CLUBS]
        Category.STRAIGHT        | [Card.SEVEN_CLUBS, Card.SIX_SPADES, Card.FIVE_SPADES, Card.FOUR_HEARTS, Card.THREE_HEARTS]
        Category.STRAIGHT        | [Card.ACE_DIAMONDS, Card.KING_CLUBS, Card.QUEEN_CLUBS, Card.JACK_DIAMONDS, Card.TEN_SPADES]
        Category.STRAIGHT        | [Card.FIVE_CLUBS, Card.FOUR_DIAMONDS, Card.THREE_HEARTS, Card.TWO_HEARTS, Card.ACE_SPADES]
        Category.STRAIGHT        | [Card.FIVE_HEARTS, Card.FOUR_SPADES, Card.THREE_HEARTS, Card.TWO_CLUBS, Card.ACE_DIAMONDS]
        Category.STRAIGHT        | [Card.TEN_DIAMONDS, Card.NINE_SPADES, Card.EIGHT_HEARTS, Card.SEVEN_DIAMONDS, Card.SIX_CLUBS]
        Category.STRAIGHT        | [Card.ACE_CLUBS, Card.KING_SPADES, Card.QUEEN_SPADES, Card.JACK_DIAMONDS, Card.TEN_SPADES]
        Category.STRAIGHT        | [Card.TEN_HEARTS, Card.NINE_SPADES, Card.EIGHT_CLUBS, Card.SEVEN_CLUBS, Card.SIX_DIAMONDS]
        Category.STRAIGHT        | [Card.JACK_HEARTS, Card.TEN_HEARTS, Card.NINE_CLUBS, Card.EIGHT_SPADES, Card.SEVEN_HEARTS]
        Category.STRAIGHT        | [Card.TEN_SPADES, Card.NINE_SPADES, Card.EIGHT_CLUBS, Card.SEVEN_HEARTS, Card.SIX_SPADES]
        Category.STRAIGHT        | [Card.SIX_CLUBS, Card.FIVE_SPADES, Card.FOUR_HEARTS, Card.THREE_SPADES, Card.TWO_DIAMONDS]
        Category.STRAIGHT        | [Card.NINE_CLUBS, Card.EIGHT_CLUBS, Card.SEVEN_CLUBS, Card.SIX_DIAMONDS, Card.FIVE_DIAMONDS]
        Category.STRAIGHT        | [Card.NINE_SPADES, Card.EIGHT_SPADES, Card.SEVEN_SPADES, Card.SIX_HEARTS, Card.FIVE_HEARTS]
        Category.STRAIGHT        | [Card.ACE_CLUBS, Card.KING_CLUBS, Card.QUEEN_HEARTS, Card.JACK_SPADES, Card.TEN_SPADES]
        Category.STRAIGHT        | [Card.FIVE_SPADES, Card.FOUR_DIAMONDS, Card.THREE_DIAMONDS, Card.TWO_SPADES, Card.ACE_HEARTS]
        Category.THREE_OF_A_KIND | [Card.SIX_SPADES, Card.SIX_HEARTS, Card.SIX_DIAMONDS, Card.KING_CLUBS, Card.QUEEN_CLUBS]
        Category.THREE_OF_A_KIND | [Card.TWO_DIAMONDS, Card.TWO_SPADES, Card.TWO_CLUBS, Card.KING_SPADES, Card.SIX_HEARTS]
        Category.THREE_OF_A_KIND | [Card.SIX_HEARTS, Card.SIX_DIAMONDS, Card.SIX_SPADES, Card.QUEEN_CLUBS, Card.FOUR_SPADES]
        Category.THREE_OF_A_KIND | [Card.THREE_DIAMONDS, Card.THREE_SPADES, Card.THREE_CLUBS, Card.KING_SPADES, Card.TWO_SPADES]
        Category.THREE_OF_A_KIND | [Card.THREE_DIAMONDS, Card.THREE_SPADES, Card.THREE_CLUBS, Card.JACK_CLUBS, Card.SEVEN_HEARTS]
        Category.THREE_OF_A_KIND | [Card.THREE_DIAMONDS, Card.THREE_SPADES, Card.THREE_CLUBS, Card.JACK_SPADES, Card.FIVE_DIAMONDS]
        Category.THREE_OF_A_KIND | [Card.NINE_CLUBS, Card.NINE_HEARTS, Card.NINE_DIAMONDS, Card.TEN_DIAMONDS, Card.EIGHT_HEARTS]
        Category.THREE_OF_A_KIND | [Card.NINE_CLUBS, Card.NINE_HEARTS, Card.NINE_DIAMONDS, Card.TEN_DIAMONDS, Card.EIGHT_DIAMONDS]
        Category.TWO_PAIR        | [Card.JACK_HEARTS, Card.JACK_SPADES, Card.THREE_CLUBS, Card.THREE_SPADES, Card.TWO_HEARTS]
        Category.TWO_PAIR        | [Card.JACK_HEARTS, Card.JACK_CLUBS, Card.FOUR_CLUBS, Card.FOUR_SPADES, Card.NINE_HEARTS]
        Category.TWO_PAIR        | [Card.TEN_DIAMONDS, Card.TEN_SPADES, Card.TWO_SPADES, Card.TWO_CLUBS, Card.KING_CLUBS]
        Category.TWO_PAIR        | [Card.FIVE_CLUBS, Card.FIVE_SPADES, Card.FOUR_DIAMONDS, Card.FOUR_HEARTS, Card.TEN_HEARTS]
        Category.TWO_PAIR        | [Card.FIVE_CLUBS, Card.FIVE_SPADES, Card.THREE_CLUBS, Card.THREE_DIAMONDS, Card.QUEEN_SPADES]
        Category.TWO_PAIR        | [Card.FIVE_CLUBS, Card.FIVE_SPADES, Card.THREE_CLUBS, Card.THREE_DIAMONDS, Card.JACK_SPADES]
        Category.TWO_PAIR        | [Card.KING_DIAMONDS, Card.KING_SPADES, Card.SEVEN_DIAMONDS, Card.SEVEN_HEARTS, Card.EIGHT_HEARTS]
        Category.TWO_PAIR        | [Card.KING_DIAMONDS, Card.KING_SPADES, Card.SEVEN_DIAMONDS, Card.SEVEN_HEARTS, Card.EIGHT_CLUBS]
        Category.ONE_PAIR        | [Card.TEN_SPADES, Card.TEN_HEARTS, Card.EIGHT_SPADES, Card.SEVEN_HEARTS, Card.FOUR_CLUBS]
        Category.ONE_PAIR        | [Card.FOUR_HEARTS, Card.FOUR_SPADES, Card.KING_SPADES, Card.TEN_DIAMONDS, Card.FIVE_SPADES]
        Category.ONE_PAIR        | [Card.NINE_CLUBS, Card.NINE_DIAMONDS, Card.QUEEN_SPADES, Card.JACK_HEARTS, Card.FIVE_HEARTS]
        Category.ONE_PAIR        | [Card.SIX_DIAMONDS, Card.SIX_HEARTS, Card.KING_SPADES, Card.SEVEN_HEARTS, Card.FOUR_CLUBS]
        Category.ONE_PAIR        | [Card.SIX_DIAMONDS, Card.SIX_HEARTS, Card.QUEEN_HEARTS, Card.JACK_SPADES, Card.TWO_CLUBS]
        Category.ONE_PAIR        | [Card.SIX_DIAMONDS, Card.SIX_HEARTS, Card.QUEEN_HEARTS, Card.EIGHT_CLUBS, Card.SEVEN_DIAMONDS]
        Category.ONE_PAIR        | [Card.SIX_DIAMONDS, Card.SIX_HEARTS, Card.QUEEN_DIAMONDS, Card.EIGHT_HEARTS, Card.THREE_SPADES]
        Category.ONE_PAIR        | [Card.EIGHT_SPADES, Card.EIGHT_DIAMONDS, Card.TEN_HEARTS, Card.SIX_CLUBS, Card.FIVE_SPADES]
        Category.ONE_PAIR        | [Card.EIGHT_SPADES, Card.EIGHT_DIAMONDS, Card.TEN_CLUBS, Card.SIX_SPADES, Card.FIVE_CLUBS]
        Category.HIGH_CARD       | [Card.QUEEN_SPADES, Card.KING_SPADES, Card.ACE_CLUBS, Card.TWO_HEARTS, Card.THREE_DIAMONDS]
        Category.HIGH_CARD       | [Card.KING_DIAMONDS, Card.QUEEN_DIAMONDS, Card.SEVEN_SPADES, Card.FOUR_SPADES, Card.THREE_HEARTS]
        Category.HIGH_CARD       | [Card.KING_SPADES, Card.SIX_CLUBS, Card.FIVE_HEARTS, Card.THREE_DIAMONDS, Card.TWO_CLUBS]
        Category.HIGH_CARD       | [Card.QUEEN_SPADES, Card.JACK_DIAMONDS, Card.SIX_CLUBS, Card.FIVE_HEARTS, Card.THREE_CLUBS]
        Category.HIGH_CARD       | [Card.QUEEN_SPADES, Card.TEN_DIAMONDS, Card.EIGHT_CLUBS, Card.SEVEN_DIAMONDS, Card.FOUR_SPADES]
        Category.HIGH_CARD       | [Card.QUEEN_HEARTS, Card.TEN_HEARTS, Card.SEVEN_CLUBS, Card.SIX_HEARTS, Card.FOUR_SPADES]
        Category.HIGH_CARD       | [Card.QUEEN_CLUBS, Card.TEN_CLUBS, Card.SEVEN_DIAMONDS, Card.FIVE_CLUBS, Card.FOUR_DIAMONDS]
        Category.HIGH_CARD       | [Card.QUEEN_HEARTS, Card.TEN_DIAMONDS, Card.SEVEN_SPADES, Card.FIVE_SPADES, Card.TWO_HEARTS]
        Category.HIGH_CARD       | [Card.TEN_CLUBS, Card.EIGHT_SPADES, Card.SEVEN_SPADES, Card.SIX_HEARTS, Card.FOUR_DIAMONDS]
        Category.HIGH_CARD       | [Card.TEN_DIAMONDS, Card.EIGHT_DIAMONDS, Card.SEVEN_SPADES, Card.SIX_CLUBS, Card.FOUR_CLUBS]
        Category.HIGH_CARD       | [Card.SEVEN_SPADES, Card.FIVE_CLUBS, Card.FOUR_DIAMONDS, Card.THREE_DIAMONDS, Card.TWO_CLUBS]
        Category.HIGH_CARD       | [Card.SIX_CLUBS, Card.FOUR_SPADES, Card.THREE_HEARTS, Card.TWO_HEARTS, Card.ACE_DIAMONDS]
        Category.STRAIGHT        | [Card.FIVE_CLUBS, Card.FOUR_SPADES, Card.THREE_HEARTS, Card.TWO_HEARTS, Card.ACE_DIAMONDS]
        Category.STRAIGHT_FLUSH  | [Card.FIVE_SPADES, Card.FOUR_SPADES, Card.THREE_SPADES, Card.TWO_SPADES, Card.ACE_SPADES]
        Category.FIVE_OF_A_KIND  | [Card.ACE_SPADES, Card.ACE_CLUBS, Card.ACE_HEARTS, Card.ACE_DIAMONDS, Card.JOKER]
    }

    @Unroll
    def "Compare #category and hand\'#winner\' wins"() {

        expect:
        croupierService.compareHands(hand0, hand1) == winner

        where:
        category                           | winner | hand0                                                                                                 | hand1
        Category.FOUR_OF_A_KIND            | -1     | [Card.FIVE_CLUBS, Card.FIVE_DIAMONDS, Card.FIVE_HEARTS, Card.FIVE_SPADES, Card.SEVEN_DIAMONDS]        | [Card.SIX_CLUBS, Card.SIX_DIAMONDS, Card.SIX_HEARTS, Card.SIX_SPADES, Card.NINE_DIAMONDS]
        Category.FOUR_OF_A_KIND            | -1     | [Card.FIVE_CLUBS, Card.FIVE_DIAMONDS, Card.FIVE_HEARTS, Card.FIVE_SPADES, Card.SEVEN_DIAMONDS]        | [Card.SIX_CLUBS, Card.SIX_DIAMONDS, Card.SIX_HEARTS, Card.SIX_SPADES, Card.NINE_DIAMONDS]
        Category.FOUR_OF_A_KIND            | -1     | [Card.FIVE_CLUBS, Card.FIVE_DIAMONDS, Card.FIVE_HEARTS, Card.FIVE_SPADES, Card.SEVEN_DIAMONDS]        | [Card.SIX_CLUBS, Card.SIX_DIAMONDS, Card.SIX_HEARTS, Card.SIX_SPADES, Card.NINE_DIAMONDS]
        Category.STRAIGHT_FLUSH            | 1      | [Card.TEN_CLUBS, Card.NINE_CLUBS, Card.EIGHT_CLUBS, Card.SEVEN_CLUBS, Card.SIX_CLUBS]                 | [Card.NINE_HEARTS, Card.EIGHT_HEARTS, Card.SEVEN_HEARTS, Card.SIX_HEARTS, Card.FIVE_HEARTS]
        Category.STRAIGHT_FLUSH            | -1     | [Card.SIX_SPADES, Card.FIVE_SPADES, Card.FOUR_SPADES, Card.THREE_SPADES, Card.TWO_SPADES]             | [Card.NINE_HEARTS, Card.EIGHT_HEARTS, Card.SEVEN_HEARTS, Card.SIX_HEARTS, Card.FIVE_HEARTS]
        Category.STRAIGHT_FLUSH            | 0      | [Card.SIX_SPADES, Card.FIVE_SPADES, Card.FOUR_SPADES, Card.THREE_SPADES, Card.TWO_SPADES]             | [Card.SIX_DIAMONDS, Card.FIVE_DIAMONDS, Card.FOUR_DIAMONDS, Card.THREE_DIAMONDS, Card.TWO_DIAMONDS]
        Category.FOUR_OF_A_KIND            | 1      | [Card.KING_DIAMONDS, Card.KING_HEARTS, Card.KING_CLUBS, Card.KING_SPADES, Card.THREE_HEARTS]          | [Card.SEVEN_SPADES, Card.SEVEN_DIAMONDS, Card.SEVEN_HEARTS, Card.SEVEN_CLUBS, Card.QUEEN_HEARTS]
        Category.FOUR_OF_A_KIND            | 1      | [Card.SEVEN_SPADES, Card.SEVEN_DIAMONDS, Card.SEVEN_HEARTS, Card.SEVEN_CLUBS, Card.QUEEN_HEARTS]      | [Card.SEVEN_SPADES, Card.SEVEN_DIAMONDS, Card.SEVEN_HEARTS, Card.SEVEN_CLUBS, Card.TEN_SPADES]
        Category.FOUR_OF_A_KIND            | -1     | [Card.SEVEN_SPADES, Card.SEVEN_DIAMONDS, Card.SEVEN_HEARTS, Card.SEVEN_CLUBS, Card.QUEEN_HEARTS]      | [Card.KING_DIAMONDS, Card.KING_HEARTS, Card.KING_CLUBS, Card.KING_SPADES, Card.THREE_HEARTS]
        Category.FOUR_OF_A_KIND            | 0      | [Card.FOUR_SPADES, Card.FOUR_DIAMONDS, Card.FOUR_HEARTS, Card.FOUR_CLUBS, Card.NINE_SPADES]           | [Card.FOUR_SPADES, Card.FOUR_DIAMONDS, Card.FOUR_HEARTS, Card.FOUR_CLUBS, Card.NINE_DIAMONDS]
        Category.FULL_HOUSE                | 1      | [Card.EIGHT_SPADES, Card.EIGHT_DIAMONDS, Card.EIGHT_HEARTS, Card.SEVEN_DIAMONDS, Card.SEVEN_CLUBS]    | [Card.FOUR_DIAMONDS, Card.FOUR_SPADES, Card.FOUR_CLUBS, Card.NINE_DIAMONDS, Card.NINE_CLUBS]
        Category.FULL_HOUSE                | -1     | [Card.FOUR_DIAMONDS, Card.FOUR_SPADES, Card.FOUR_CLUBS, Card.FIVE_CLUBS, Card.FIVE_DIAMONDS]          | [Card.FOUR_DIAMONDS, Card.FOUR_SPADES, Card.FOUR_CLUBS, Card.NINE_DIAMONDS, Card.NINE_CLUBS]
        Category.FULL_HOUSE                | 0      | [Card.KING_CLUBS, Card.KING_SPADES, Card.KING_DIAMONDS, Card.JACK_CLUBS, Card.JACK_SPADES]            | [Card.KING_CLUBS, Card.KING_HEARTS, Card.KING_DIAMONDS, Card.JACK_CLUBS, Card.JACK_HEARTS]
        Category.FLUSH                     | 1      | [Card.KING_DIAMONDS, Card.JACK_DIAMONDS, Card.NINE_DIAMONDS, Card.SIX_DIAMONDS, Card.FOUR_DIAMONDS]   | [Card.QUEEN_CLUBS, Card.JACK_CLUBS, Card.SEVEN_CLUBS, Card.SIX_CLUBS, Card.FIVE_CLUBS]
        Category.FLUSH                     | -1     | [Card.JACK_HEARTS, Card.TEN_HEARTS, Card.NINE_HEARTS, Card.FOUR_HEARTS, Card.TWO_HEARTS]              | [Card.QUEEN_CLUBS, Card.JACK_CLUBS, Card.SEVEN_CLUBS, Card.SIX_CLUBS, Card.FIVE_CLUBS]
        Category.FLUSH                     | 0      | [Card.TEN_DIAMONDS, Card.EIGHT_DIAMONDS, Card.SEVEN_DIAMONDS, Card.SIX_DIAMONDS, Card.FIVE_DIAMONDS]  | [Card.TEN_CLUBS, Card.EIGHT_CLUBS, Card.SEVEN_CLUBS, Card.SIX_CLUBS, Card.FIVE_CLUBS]
        Category.STRAIGHT                  | 1      | [Card.JACK_HEARTS, Card.TEN_HEARTS, Card.NINE_CLUBS, Card.EIGHT_SPADES, Card.SEVEN_HEARTS]            | [Card.TEN_SPADES, Card.NINE_SPADES, Card.EIGHT_CLUBS, Card.SEVEN_HEARTS, Card.SIX_SPADES]
        Category.STRAIGHT                  | -1     | [Card.SIX_CLUBS, Card.FIVE_SPADES, Card.FOUR_HEARTS, Card.THREE_SPADES, Card.TWO_DIAMONDS]            | [Card.TEN_SPADES, Card.NINE_SPADES, Card.EIGHT_CLUBS, Card.SEVEN_HEARTS, Card.SIX_SPADES]
        Category.STRAIGHT                  | 0      | [Card.NINE_CLUBS, Card.EIGHT_CLUBS, Card.SEVEN_CLUBS, Card.SIX_DIAMONDS, Card.FIVE_DIAMONDS]          | [Card.NINE_SPADES, Card.EIGHT_SPADES, Card.SEVEN_SPADES, Card.SIX_HEARTS, Card.FIVE_HEARTS]//        Category.THREE_OF_A_KIND | 1      | [Card.SIX_HEARTS, Card.SIX_DIAMONDS, Card.SIX_SPADES, Card.QUEEN_CLUBS, Card.FOUR_SPADES]             | [Card.THREE_DIAMONDS, Card.THREE_SPADES, Card.THREE_CLUBS, Card.KING_SPADES, Card.TWO_SPADES]
        Category.THREE_OF_A_KIND           | -1     | [Card.THREE_DIAMONDS, Card.THREE_SPADES, Card.THREE_CLUBS, Card.KING_SPADES, Card.TWO_SPADES]         | [Card.SIX_HEARTS, Card.SIX_DIAMONDS, Card.SIX_SPADES, Card.QUEEN_CLUBS, Card.FOUR_SPADES]
        Category.THREE_OF_A_KIND           | 0      | [Card.NINE_CLUBS, Card.NINE_HEARTS, Card.NINE_DIAMONDS, Card.TEN_DIAMONDS, Card.EIGHT_HEARTS]         | [Card.NINE_CLUBS, Card.NINE_HEARTS, Card.NINE_DIAMONDS, Card.TEN_DIAMONDS, Card.EIGHT_DIAMONDS]
        Category.TWO_PAIR                  | 1      | [Card.TEN_DIAMONDS, Card.TEN_SPADES, Card.TWO_SPADES, Card.TWO_CLUBS, Card.KING_CLUBS]                | [Card.FIVE_CLUBS, Card.FIVE_SPADES, Card.FOUR_DIAMONDS, Card.FOUR_HEARTS, Card.TEN_HEARTS]
        Category.TWO_PAIR                  | -1     | [Card.FIVE_CLUBS, Card.FIVE_SPADES, Card.FOUR_DIAMONDS, Card.FOUR_HEARTS, Card.TEN_HEARTS]            | [Card.KING_CLUBS, Card.KING_SPADES, Card.SEVEN_DIAMONDS, Card.SEVEN_HEARTS, Card.EIGHT_HEARTS]
        Category.TWO_PAIR                  | 0      | [Card.KING_CLUBS, Card.KING_SPADES, Card.SEVEN_DIAMONDS, Card.SEVEN_HEARTS, Card.EIGHT_HEARTS]        | [Card.KING_DIAMONDS, Card.KING_HEARTS, Card.SEVEN_CLUBS, Card.SEVEN_SPADES, Card.EIGHT_CLUBS]
        Category.ONE_PAIR                  | 1      | [Card.NINE_CLUBS, Card.NINE_DIAMONDS, Card.QUEEN_SPADES, Card.JACK_HEARTS, Card.FIVE_HEARTS]          | [Card.SIX_DIAMONDS, Card.SIX_HEARTS, Card.KING_SPADES, Card.SEVEN_HEARTS, Card.FOUR_CLUBS]
        Category.ONE_PAIR                  | -1     | [Card.SIX_DIAMONDS, Card.SIX_HEARTS, Card.KING_SPADES, Card.SEVEN_HEARTS, Card.FOUR_CLUBS]            | [Card.EIGHT_SPADES, Card.EIGHT_DIAMONDS, Card.TEN_HEARTS, Card.SIX_CLUBS, Card.FIVE_SPADES]
        Category.ONE_PAIR                  | 0      | [Card.EIGHT_SPADES, Card.EIGHT_DIAMONDS, Card.TEN_HEARTS, Card.SIX_CLUBS, Card.FIVE_SPADES]           | [Card.EIGHT_SPADES, Card.EIGHT_DIAMONDS, Card.TEN_CLUBS, Card.SIX_SPADES, Card.FIVE_CLUBS]
        Category.HIGH_CARD                 | 1      | [Card.KING_SPADES, Card.SIX_CLUBS, Card.FIVE_HEARTS, Card.THREE_DIAMONDS, Card.TWO_CLUBS]             | [Card.QUEEN_SPADES, Card.JACK_DIAMONDS, Card.SIX_CLUBS, Card.FIVE_HEARTS, Card.THREE_CLUBS]
        Category.HIGH_CARD                 | -1     | [Card.QUEEN_SPADES, Card.TEN_DIAMONDS, Card.EIGHT_CLUBS, Card.SEVEN_DIAMONDS, Card.FOUR_SPADES]       | [Card.QUEEN_SPADES, Card.JACK_DIAMONDS, Card.SIX_CLUBS, Card.FIVE_HEARTS, Card.THREE_CLUBS]
        Category.HIGH_CARD                 | 0      | [Card.TEN_CLUBS, Card.EIGHT_SPADES, Card.SEVEN_SPADES, Card.SIX_HEARTS, Card.FOUR_DIAMONDS]           | [Card.TEN_DIAMONDS, Card.EIGHT_DIAMONDS, Card.SEVEN_SPADES, Card.SIX_CLUBS, Card.FOUR_CLUBS]
        "STRAIGHT_FLUSH_VS_FOUR_OF_A_KIND" | 1      | [Card.JACK_DIAMONDS, Card.TEN_DIAMONDS, Card.NINE_DIAMONDS, Card.EIGHT_DIAMONDS, Card.SEVEN_DIAMONDS] | [Card.FIVE_CLUBS, Card.FIVE_DIAMONDS, Card.FIVE_HEARTS, Card.FIVE_SPADES, Card.SEVEN_DIAMONDS]
        "TWO_PAIR_VS_THREE_OF_A_KIND"      | -1     | [Card.JACK_HEARTS, Card.JACK_SPADES, Card.THREE_CLUBS, Card.THREE_SPADES, Card.TWO_HEARTS]            | [Card.SIX_SPADES, Card.SIX_HEARTS, Card.SIX_DIAMONDS, Card.KING_CLUBS, Card.QUEEN_CLUBS]
    }


    @Unroll
    def "Compare hands with error - Should return an IllegalArgumentException"() {
        when:
        croupierService.compareHands(hand0, hand1)

        then:
        thrown(IllegalArgumentException)

        where:
        hand0 | hand1
        null  | []
        []    | null
        []    | [Card.NINE_SPADES]


    }

}
