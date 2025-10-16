package org.example.realization.service;

import org.example.atd.BonusKeeper;
import org.example.realization.dto.Bonus;
import org.example.realization.visitor.BonusMoveFieldActionVisitor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class BonusKeeperImpl extends BonusKeeper<Bonus> {
    private String[] letters = {"a", "b", "c", "d", "e", "f"};
    private Random random = new Random();
    private List<Bonus> bonuses = new ArrayList<>();

    @Override
    public void calculateBonus(int scoreByPlayerTurn) {
        if (scoreByPlayerTurn < 3) {
            return;
        }

        String symbol = letters[random.nextInt(letters.length)];

        Bonus bonus = new Bonus(
                "Бонус уничтожитель " + symbol,
                new BonusMoveFieldActionVisitor(symbol));

        bonuses.add(bonus);
    }

    @Override
    public void cleanBonus() {
        bonuses.clear();
    }

    @Override
    public List<Bonus> getAllBonuses() {
        return bonuses;
    }

    @Override
    public Bonus getBonus(String name) {
        return bonuses.stream()
                .filter(o -> o.getName().equals(name))
                .findFirst()
                .orElseThrow(RuntimeException::new);
    }
}
