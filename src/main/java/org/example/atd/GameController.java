package org.example.atd;

public abstract class GameController<T, E> {

    //Команды

    //предусловие: не должно быть запущенных игр
    //постусловие: будет подготовлено начало игры
    public abstract T startGame();

    //предусловие: должна быть запущена игра
    //постусловие: состояние игры сброшено до момента старта игры
    public abstract T restartGame();

    //предусловие: должна быть запущена игра
    //постусловие: будут подсчитаны итоговые очки, игра прекращается
    public abstract E endGame();
}
