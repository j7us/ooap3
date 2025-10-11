package org.example.atd;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class GameStageIntegrationTest {
    @Autowired
    GameController gameController;

    @Autowired
    FieldKeeper fieldKeeper;

    @Autowired
    ScoreKeeper scoreKeeper;

    @Autowired
    BonusKeeper bonusKeeper;

    @Test
    void gameStartTest() {
        gameController.startGame();

        Object firstMove = gameController.getFirstMove();

        assertThat(firstMove).isNotNull();
    }

    @Test
    void gameRestartTest() {
        gameController.startGame();
        gameController.restartGame();

        Object firstMove = gameController.getFirstMove();

        assertThat(firstMove).isNotNull();
    }

    @Test
    void gameEndTest() {
        gameController.startGame();
        gameController.endGame();

        Object object = gameController.gameResult();

        assertThat(object).isNotNull();
    }
}
