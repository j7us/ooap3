package org.example.atd;

public abstract class ScoreKeeper<T> {

    //Команды

    //постусловие: добавлены очки за ход
    public abstract void calculateScore(int cellDeletedByPlayerTurn);

    //постусловие: обнулены очки
    public abstract void clearScore();


    //Запрос

    public abstract T getScore();
    public abstract T getLastMoveScore();
}
