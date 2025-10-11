package org.example.atd;

public abstract class FieldKeeper {

    //Команды

    //постусловие: поле сделано заново
    public abstract void recreate();

    //постусловие: поле изменено
    public abstract void applyChanges(FieldActionVisitor visitor);

    //Запрос

    //предусловие: поле должно быть сгенерировано
    public abstract String[][] getField();
}
