package org.example.realization.cli;

import org.example.atd.BonusKeeper;
import org.example.atd.FieldKeeper;
import org.example.atd.GameController;
import org.example.atd.ScoreKeeper;
import org.example.realization.dto.Bonus;
import org.springframework.shell.command.annotation.Command;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@Command
public class GameControllerImpl extends GameController<String, String> {
    private final FieldKeeper<String[][]> fieldKeeper;
    private final ScoreKeeper<Integer> scoreKeeper;
    private final BonusKeeper<Bonus> bonusKeeper;

    public GameControllerImpl(FieldKeeper<String[][]> fieldKeeper,
                              ScoreKeeper<Integer> scoreKeeper,
                              BonusKeeper<Bonus> bonusKeeper) {
        this.fieldKeeper = fieldKeeper;
        this.scoreKeeper = scoreKeeper;
        this.bonusKeeper = bonusKeeper;
    }

    @Override
    @Command(description = "Command for game start")
    public String startGame() {
        scoreKeeper.clearScore();
        bonusKeeper.cleanBonus();
        fieldKeeper.generateNewField();
        return arrayToString(fieldKeeper.getField());
    }

    private String arrayToString(String[][] array) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                result.append(array[i][j]).append("\t"); // добавляем элемент и табуляцию
            }
            result.append("\n"); // переход на новую строку
        }

        return result.toString();
    }

    @Override
    @Command(description = "Command for game restart")
    public String restartGame() {
        scoreKeeper.clearScore();
        bonusKeeper.cleanBonus();
        fieldKeeper.generateNewField();

        return arrayToString(fieldKeeper.getField());
    }

    @Override
    @Command(description = "Command for game end")
    public String endGame() {
        int score = scoreKeeper.getScore();
        List<Bonus> allBonuses = bonusKeeper.getAllBonuses();

        String bonusesNames = allBonuses.stream()
                .map(Bonus::getName)
                .reduce((a, b) -> a + ", " + b)
                .orElse("Бонусов нет");

        return "Очки за игру: " + score + "\n" + "Бонусы: " + bonusesNames;
    }
}
