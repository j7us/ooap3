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
        String[][] firstMove = (String[][])gameController.startGame();

        assertThat(firstMove).isNotNull();
    }

    @Test
    void gameRestartTest() {
        gameController.startGame();
        String[][] firstMove = (String[][])gameController.restartGame();

        assertThat(firstMove).isNotNull();
    }

    @Test
    void gameEndTest() {
        gameController.startGame();
        String object = (String)gameController.endGame();

        assertThat(object).isNotNull();
    }
}
