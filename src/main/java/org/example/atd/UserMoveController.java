package org.example.atd;

public abstract class UserMoveController<T, E> {

    //Команды

    //постусловие: будет выполнена перестановка ячеек и подсчитаны очки за ход
    public abstract T swapFieldCells(int firstRow, int firstColumn, int secondRow, int secondColumn);

    //постусловие: будет изменено игровое поле с использованием действия из бонуса и подсчитаны очки за ход
    public abstract T useBonusMove(String bonusName);

    // Запросы
    public abstract E getUserBonus();
}
