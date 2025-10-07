package org.example.atd;

public abstract class GameController<T, E> {

    //Команды

    //предусловие: не должно быть запущенных игр
    //постусловие: будет подготовлено поле и игровой счет для начала игры
    public abstract void startGame();

    //предусловие: должна быть запущена игра
    //постусловие: состояние игры, включая поле и очки, будет сброшено до момента старта игры
    public abstract void restartGame();

    //предусловие: должна быть запущена игра
    //постусловие: будут подсчитаны итоговые очки, игра прекращается
    public abstract void endGame();

    // Запросы

    //предусловие: игра должна быть начата или перезапущена
    public abstract E getFirstField();

    //предусловие: игра должна быть закончена
    public abstract T gameResult();
}
