package org.example.atd;

import java.util.List;

public abstract class BonusKeeper<E> {
    //Команды

    //постусловие: возможно добавлен бонус
    public abstract void calculateBonus(int scoreByPlayerTurn);

    //постусловие: обнулены бонусы
    public abstract void cleanBonus();

    //Запросы

    public abstract List<E> getAllBonuses();
    public abstract E getBonus(String name);
}
