package org.example.atd;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class UserMoveIntegrationTest {
    @Autowired
    GameController<String[][], String> gameController;

    @Autowired
    UserMoveController<String[][], String> userMoveController;

    @Test
    void userMoveTest() {
        String[][] firstMove = (String[][])gameController.startGame();

        String[][] field = (String[][])userMoveController.swapFieldCells(1, 1, 2, 1);

        assertThat(firstMove).isNotEqualTo(field);
    }

    @Test
    void userMoveResulTest() {
        String[][] firstMove = (String[][])gameController.startGame();

        userMoveController.swapFieldCells(1, 1, 2, 1);

        String userBonus = userMoveController.getUserBonus();

        assertThat(userBonus).isNotEmpty();
    }
}
