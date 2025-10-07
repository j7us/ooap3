package org.example.atd;

import java.util.List;

public abstract class BonusKeeper<E> {
    public static final int BONUS_RECEIVED = 0;
    public static final int BONUS_NOT_RECEIVED = 1;

    //Команды

    //постусловие: возможно добавлен бонус
    public abstract void calculateBonus(int scoreByPlayerTurn);

    //постусловие: обнулены бонусы
    public abstract void cleanBonus();

    //Запросы

    public abstract List<E> getAllBonuses();
    public abstract int getCalculatedBonusResult();
}
