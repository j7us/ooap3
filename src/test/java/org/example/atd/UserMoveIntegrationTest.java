package org.example.atd;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class UserMoveIntegrationTest {
    @Autowired
    GameController gameController;

    @Autowired
    UserMoveController userMoveController;

    @Test
    void userMoveTest() {
        gameController.startGame();

        Object firstMove = gameController.getFirstMove();

        userMoveController.swapFieldCells(1, 1, 2, 1);

        Object field = userMoveController.getField();

        assertThat(firstMove).isNotEqualTo(field);
    }

    @Test
    void userMoveResulTest() {
        gameController.startGame();

        gameController.getFirstMove();

        userMoveController.swapFieldCells(1, 1, 2, 1);

        Object userStatus = userMoveController.getUserStatus();

        assertThat(userStatus).isNotNull();
    }
}
