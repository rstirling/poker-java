package org.example.poker;

import lombok.extern.slf4j.Slf4j;
import org.example.poker.service.CroupierService;
import org.example.poker.service.DeckService;

@Slf4j
public class Main {

    public static void main(String[] args) {
        final var deckService = new DeckService(false);
        final var croupierService = new CroupierService(deckService);

        final var handOne = croupierService.getHand();
        final var handTwo = croupierService.getHand();

        final var categoryHandOne = croupierService.getCategory(handOne);
        final var categoryHandTwo = croupierService.getCategory(handTwo);

        log.info("Hand One category[{}] cards{}", categoryHandOne, handOne);
        log.info("Hand Two category[{}] cards{}", categoryHandTwo, handTwo);

        final var result = croupierService.compareHands(handOne, handTwo);

        if(result == 1){
            log.info("Hand One Wins!");
        } else if( result == -1){
            log.info("Hand Two Wins!");
        }else {
            log.info("A Draw!");
        }

    }
}
