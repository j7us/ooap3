package org.example.atd;

import org.example.realization.service.FieldKeeperImpl;
import org.example.realization.visitor.BonusMoveFieldActionVisitor;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FieldKeeperTest {

    @Test
    void fieldCreateTest() {
        FieldKeeper<String[][]> fieldKeeper = new FieldKeeperImpl();

        fieldKeeper.generateNewField();

        String[][] field = fieldKeeper.getField();

        assertThat(field).isNotNull();
    }

    @Test
    void getFieldTest() {
        FieldKeeper<String[][]> fieldKeeper = new FieldKeeperImpl();

        fieldKeeper.generateNewField();
        String[][] field = fieldKeeper.getField();

        fieldKeeper.generateNewField();

        String[][] newField = fieldKeeper.getField();

        assertThat(field).isNotEqualTo(newField);
    }

    @Test
    void applyChangeTest() {
        FieldKeeper<String[][]> fieldKeeper = new FieldKeeperImpl();

        fieldKeeper.generateNewField();

        String[][] createdField = fieldKeeper.getField();

        fieldKeeper.applyChanges(new BonusMoveFieldActionVisitor("a"));

        String[][] updatedField = fieldKeeper.getField();

        assertThat(createdField).isNotEqualTo(updatedField);
    }
}
