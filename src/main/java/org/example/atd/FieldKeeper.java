package org.example.atd;

public abstract class FieldKeeper {

    //Команды

    //предусловие: поле пустое
    //постусловие: поле сгенерировано
    public abstract void generateField();

    //предусловие: поле не пустое
    //постусловие: поле удалено
    public abstract void clear();

    //предусловие: поле должно быть сгенерировано
    //постусловие: поле изменено
    public abstract void applyChanges(FieldActionVisitor visitor);

    //Запрос

    //предусловие: поле должно быть сгенерировано
    public abstract String[][] getField();
}
