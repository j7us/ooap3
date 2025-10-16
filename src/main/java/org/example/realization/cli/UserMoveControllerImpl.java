package org.example.realization.cli;

import org.example.atd.*;
import org.example.realization.dto.Bonus;
import org.example.realization.visitor.UserMoveFieldActionVisitor;
import org.springframework.shell.command.annotation.Command;
import org.springframework.shell.command.annotation.Option;
import org.springframework.stereotype.Component;

@Component
@Command
public class UserMoveControllerImpl extends UserMoveController<String, String> {
    private final FieldKeeper<String[][]> fieldKeeper;
    private final ScoreKeeper<Integer> scoreKeeper;
    private final BonusKeeper<Bonus> bonusKeeper;

    public UserMoveControllerImpl(FieldKeeper<String[][]> fieldKeeper,
                                  ScoreKeeper<Integer> scoreKeeper,
                                  BonusKeeper<Bonus> bonusKeeper) {
        this.fieldKeeper = fieldKeeper;
        this.scoreKeeper = scoreKeeper;
        this.bonusKeeper = bonusKeeper;
    }

    @Override
    @Command(description = "cell swap command")
    public String swapFieldCells(@Option(longNames = "first-row") Integer firstRow,
                                 @Option(longNames = "first-col") Integer firstColumn,
                                 @Option(longNames = "second-row") Integer secondRow,
                                 @Option(longNames = "second-col") Integer secondColumn) {
        FieldActionVisitor userMoveFieldActionVisitor = new UserMoveFieldActionVisitor(
                firstRow, firstColumn, secondRow, secondColumn);

        fieldKeeper.applyChanges(userMoveFieldActionVisitor);
        String[][] field = fieldKeeper.getField();
        int deletedCellCount = fieldKeeper.cellDeletedByLastMove();

        scoreKeeper.calculateScore(deletedCellCount);
        Integer lastMoveScore = scoreKeeper.getLastMoveScore();

        bonusKeeper.calculateBonus(lastMoveScore);

        return arrayToString(field);
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
    @Command
    public String useBonusMove(@Option(longNames = "bonus-name") String bonusName) {
        Bonus bonus = bonusKeeper.getBonus(bonusName);

        fieldKeeper.applyChanges(bonus.getBonusMoveFieldActionVisitor());
        String[][] field = fieldKeeper.getField();
        int deletedCellCount = fieldKeeper.cellDeletedByLastMove();

        scoreKeeper.calculateScore(deletedCellCount);

        return arrayToString(field);
    }

    @Override
    @Command
    public String getUserBonus() {
        return bonusKeeper.getAllBonuses().stream()
                .map(Bonus::getName)
                .reduce((a, b) -> a + ", " + b)
                .orElse("");
    }
}
