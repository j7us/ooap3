package org.example.atd;

public abstract class FieldKeeper<T> {

    //Команды

    //постусловие: поле создано
    public abstract void generateNewField();

    //постусловие: поле изменено
    public abstract void applyChanges(FieldActionVisitor visitor);

    //Запрос

    //предусловие: поле должно быть сгенерировано
    public abstract T getField();

    //предусловие: поле должно быть сгенерировано
    public abstract int cellDeletedByLastMove();
}
