package org.example.realization.cli;

import org.example.atd.*;
import org.example.realization.dto.Bonus;
import org.example.realization.visitor.UserMoveFieldActionVisitor;
import org.springframework.shell.command.annotation.Command;
import org.springframework.stereotype.Component;

@Component
@Command
public class UserMoveControllerImpl extends UserMoveController<String[][], String> {
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
    @Command
    public String[][] swapFieldCells(int firstRow, int firstColumn, int secondRow, int secondColumn) {
        FieldActionVisitor userMoveFieldActionVisitor = new UserMoveFieldActionVisitor(
                firstRow, firstColumn, secondRow, secondColumn);

        fieldKeeper.applyChanges(userMoveFieldActionVisitor);
        String[][] field = fieldKeeper.getField();
        int deletedCellCount = fieldKeeper.cellDeletedByLastMove();

        scoreKeeper.calculateScore(deletedCellCount);
        Integer lastMoveScore = scoreKeeper.getLastMoveScore();

        bonusKeeper.calculateBonus(lastMoveScore);

        return field;
    }

    @Override
    @Command
    public String[][] useBonusMove(String bonusName) {
        Bonus bonus = bonusKeeper.getBonus(bonusName);

        fieldKeeper.applyChanges(bonus.getBonusMoveFieldActionVisitor());
        String[][] field = fieldKeeper.getField();
        int deletedCellCount = fieldKeeper.cellDeletedByLastMove();

        scoreKeeper.calculateScore(deletedCellCount);

        return field;
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
