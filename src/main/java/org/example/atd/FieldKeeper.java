package org.example.atd;

public abstract class FieldKeeper {

    //Команды

    //предусловие: поле еще не создано
    //постусловие: поле создано
    public abstract void generateField();

    //предусловие: поле уже создано
    //постусловие: поле удалено
    public abstract void clear();

    //предусловие: поле должно быть сгенерировано
    //постусловие: поле изменено
    public abstract void applyChanges(FieldActionVisitor visitor);

    //Запрос

    //предусловие: поле должно быть сгенерировано
    public abstract String[][] getField();
}
