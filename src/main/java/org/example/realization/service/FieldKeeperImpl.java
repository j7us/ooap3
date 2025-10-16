package org.example.realization.service;

import org.example.atd.FieldActionVisitor;
import org.example.atd.FieldKeeper;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class FieldKeeperImpl extends FieldKeeper<String[][]> {
    private String[] letters = {"a", "b", "c", "d", "e", "f"};
    private Random random = new Random();
    private String[][] field;
    private int cellDeletedByLastMove;

    @Override
    public void generateNewField() {
        String[][] newField = new String[7][7];

        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                newField[i][j] = generateRandomCellValue(newField, i, j);
            }
        }

        field = newField;
    }

    private String generateRandomCellValue(String[][] newField, int i, int j) {
        String candidate;
        do {
            candidate = letters[random.nextInt(letters.length)];
        } while (createsMatch(newField, i, j, candidate));

        return candidate;
    }

    private boolean createsMatch(String[][] grid, int i, int j, String value) {
        if (j >= 2
                && value.equals(grid[i][j - 1])
                && value.equals(grid[i][j - 2])) {
            return true;
        }

        if (i >= 2
                && value.equals(grid[i - 1][j])
                && value.equals(grid[i - 2][j])) {
            return true;
        }
        return false;
    }

    @Override
    public void applyChanges(FieldActionVisitor visitor) {
        visitor.apply(field);
        dropAndFill(field);
    }

    private void dropAndFill(String[][] field) {
        int rows = field.length;
        int cols = field[0].length;
        int deleted = 0;

        for (int j = 0; j < cols; j++) {
            for (int i = rows - 1; i >= 0; i--) {
                if (field[i][j] == null) {
                    int k = i - 1;
                    while (k >= 0 && field[k][j] == null) {
                        k--;
                        deleted++;
                    }
                    if (k >= 0) {
                        field[i][j] = field[k][j];
                        field[k][j] = null;
                    } else {
                        field[i][j] = generateRandomCellValue(field, i, j);
                    }
                }
            }
        }

        cellDeletedByLastMove = deleted;
    }

    @Override
    public String[][] getField() {
        return field;
    }

    @Override
    public int cellDeletedByLastMove() {
        return cellDeletedByLastMove;
    }
}
