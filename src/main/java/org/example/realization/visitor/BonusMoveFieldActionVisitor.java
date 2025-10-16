package org.example.realization.visitor;

import org.example.atd.FieldActionVisitor;

public class BonusMoveFieldActionVisitor extends FieldActionVisitor {
    private String symbol;

    public BonusMoveFieldActionVisitor(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public void apply(String[][] field) {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                String cellValue = field[i][j];

                field[i][j] = symbol.equals(cellValue) ? null : cellValue;
            }
        }
    }
}
