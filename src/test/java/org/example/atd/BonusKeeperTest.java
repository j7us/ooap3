package org.example.atd;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BonusKeeperTest {

    @Test
    void newBonusTest() {
        BonusKeeper<Integer> bonusKeeper = new BonusKeeper();

        List<Integer> allBonuses = bonusKeeper.getAllBonuses();

        assertThat(allBonuses).isEmpty();
    }

    @Test
    void addBonusTest() {
        BonusKeeper<Integer> bonusKeeper = new BonusKeeper();

        bonusKeeper.calculateBonus(123);

        List<Integer> updatedBonuses = bonusKeeper.getAllBonuses();

        assertThat(updatedBonuses).isNotEmpty();
    }

    @Test
    void addBonusTest() {
        BonusKeeper<Integer> bonusKeeper = new BonusKeeper();

        bonusKeeper.calculateBonus(123);

        bonusKeeper.cleanBonus();

        List<Integer> cleanedBonuses = bonusKeeper.getAllBonuses();

        assertThat(cleanedBonuses).isEmpty();
    }
}
