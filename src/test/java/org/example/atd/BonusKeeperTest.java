package org.example.atd;

import org.example.realization.dto.Bonus;
import org.example.realization.service.BonusKeeperImpl;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BonusKeeperTest {

    @Test
    void newBonusTest() {
        BonusKeeper<Bonus> bonusKeeper = new BonusKeeperImpl();

        List<Bonus> allBonuses = bonusKeeper.getAllBonuses();

        assertThat(allBonuses).isEmpty();
    }

    @Test
    void addBonusTest() {
        BonusKeeper<Bonus> bonusKeeper = new BonusKeeperImpl();

        bonusKeeper.calculateBonus(123);

        List<Bonus> updatedBonuses = bonusKeeper.getAllBonuses();

        assertThat(updatedBonuses).isNotEmpty();
    }

    @Test
    void cleanBonusTest() {
        BonusKeeper<Bonus> bonusKeeper = new BonusKeeperImpl();

        bonusKeeper.calculateBonus(123);

        bonusKeeper.cleanBonus();

        List<Bonus> cleanedBonuses = bonusKeeper.getAllBonuses();

        assertThat(cleanedBonuses).isEmpty();
    }
}
