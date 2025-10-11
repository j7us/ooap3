package org.example.atd;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FieldKeeperTest {

    @Test
    void fieldCreateTest() {
        FieldKeeper fieldKeeper = new FieldKeeper();

        fieldKeeper.generateField();

        String[][] field = fieldKeeper.getField();

        assertThat(field).isNotNull();
    }

    @Test
    void getFieldTest() {
        FieldKeeper fieldKeeper = new FieldKeeper();

        fieldKeeper.generateField();
        fieldKeeper.clear();

        String[][] field = fieldKeeper.getField();

        assertThat(field).isNull();
    }

    @Test
    void applyChangeTest() {
        FieldKeeper fieldKeeper = new FieldKeeper();

        fieldKeeper.generateField();

        String[][] createdField = fieldKeeper.getField();

        fieldKeeper.applyChanges(new FieldActionVisitor());

        String[][] updatedField = fieldKeeper.getField();

        assertThat(createdField).isNotEqualTo(updatedField);
    }
}
