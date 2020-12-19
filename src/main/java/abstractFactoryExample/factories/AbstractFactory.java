package abstractFactoryExample.factories;

import abstractFactoryExample.buttons.Button;
import abstractFactoryExample.checkBoxes.Checkbox;

public interface AbstractFactory {
    // Абстрактная фабрика знает обо всех типах продуктов
    Button createButton();
    Checkbox createCheckbox();
}
