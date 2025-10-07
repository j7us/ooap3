package org.example.atd;

public abstract class GameController<T, E> {

    //Команды

    //предусловие: не должно быть запущенных игр
    //постусловие: будет подготовлено начало игры
    public abstract void startGame();

    //предусловие: должна быть запущена игра
    //постусловие: состояние игры сброшено до момента старта игры
    public abstract void restartGame();

    //предусловие: должна быть запущена игра
    //постусловие: будут подсчитаны итоговые очки, игра прекращается
    public abstract void endGame();

    // Запросы

    //предусловие: игра должна быть начата или перезапущена
    public abstract E getFirstMove();

    //предусловие: игра должна быть закончена
    public abstract T gameResult();
}
