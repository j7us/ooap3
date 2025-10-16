package org.example.realization.dto;

import org.example.realization.visitor.BonusMoveFieldActionVisitor;

public class Bonus {
    private String name;
    private BonusMoveFieldActionVisitor bonusMoveFieldActionVisitor;

    public Bonus(String name, BonusMoveFieldActionVisitor bonusMoveFieldActionVisitor) {
        this.name = name;
        this.bonusMoveFieldActionVisitor = bonusMoveFieldActionVisitor;
    }

    public String getName() {
        return name;
    }

    public BonusMoveFieldActionVisitor getBonusMoveFieldActionVisitor() {
        return bonusMoveFieldActionVisitor;
    }
}
