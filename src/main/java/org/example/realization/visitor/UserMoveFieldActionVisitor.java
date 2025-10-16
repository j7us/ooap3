package org.example.realization.visitor;

import org.example.atd.FieldActionVisitor;
import org.example.realization.dto.Cell;

public class UserMoveFieldActionVisitor extends FieldActionVisitor {
    private Cell first;
    private Cell second;

    public UserMoveFieldActionVisitor(int firstRow, int firstColumn, int secondRow, int secondColumn) {
        this.first = new Cell(firstRow, firstColumn);
        this.second = new Cell(secondRow, secondColumn);
    }

    @Override
    public void apply(String[][] field) {
        String firstCellValue = field[first.getRow()][second.getColumn()];
        String secondCellValue = field[second.getRow()][first.getColumn()];

        field[first.getRow()][second.getColumn()] = secondCellValue;
        field[second.getRow()][first.getColumn()] = firstCellValue;

        clearMatches(field, first.getRow(), first.getColumn());
        clearMatches(field, second.getRow(), second.getColumn());
    }

    private void clearMatches(String[][] field, int row, int column) {
        String value = field[row][column];

        int minColumn = column;
        for (int i = column - 1; i >= 0 && value.equals(field[row][i]); i--) minColumn = i;

        int maxColumn = column;
        for (int i = column + 1; i < 7 && value.equals(field[row][i]); i++) maxColumn = i;

        if (maxColumn - minColumn >= 2) {
            cleanInRow(field, row, minColumn, maxColumn);
        }


        int minRow = row;
        for (int i = row - 1; i >= 0 && value.equals(field[i][column]); i--) minRow = i;

        int maxRow = row;
        for (int i = row + 1; i < 7 && value.equals(field[i][column]); i++) maxRow = i;

        if (maxRow - minRow >= 2) {
            cleanInColumn(field, column, minRow, maxRow);
        }
    }

    private void cleanInRow(String[][] field, int row, int columnFrom, int columnTo) {
        for (int i = columnFrom; i < columnTo; i++) {
            field[row][i] = null;
        }
    }

    private void cleanInColumn(String[][] field, int column, int rowFrom, int rowTo) {
        for (int i = rowFrom; i <= rowTo; i++) {
            field[i][column] = null;
        }
    }
}
