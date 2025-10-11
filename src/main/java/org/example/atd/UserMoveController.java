package org.example.atd;

public abstract class UserMoveController<T, E> {

    //Команды

    //постусловие: будет выполнена перестановка ячеек и подсчитаны очки за ход
    public abstract void swapFieldCells(int firstRow, int firstColumn, int secondRow, int secondColumn);

    //постусловие: будет изменено игровое поле с использованием действия из бонуса и подсчитаны очки за ход
    public abstract void useBonusMove();

    // Запросы

    public abstract T getField();
    public abstract E getUserBonus();

    public abstract int getSwapFieldCellsResult();
    public abstract int getUseBonusMoveResult();
}
