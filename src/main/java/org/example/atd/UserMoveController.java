package org.example.atd;

public abstract class UserMoveController<T, E> {

    //Команды

    //постусловие: будет выполнена перестановка ячеек и подсчитаны очки за ход
    public abstract void swapFieldCells();

    //постусловие: будет изменено игровое поле с использованием действия из бонуса и подсчитаны очки за ход
    public abstract void useBonusMove();

    // Запросы

    public abstract T getField();
    public abstract E getUserStatus();

    public abstract int getSwapFieldCellsResult();
    public abstract int getUseBonusMove();
}
