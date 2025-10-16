package org.example.atd;

public abstract class UserMoveController<T, E> {

    //Команды

    //постусловие: будет выполнена перестановка ячеек и подсчитаны очки за ход
    public abstract T swapFieldCells(Integer firstRow, Integer firstColumn, Integer secondRow, Integer secondColumn);

    //постусловие: будет изменено игровое поле с использованием действия из бонуса и подсчитаны очки за ход
    public abstract T useBonusMove(String bonusName);

    // Запросы
    public abstract E getUserBonus();
}
