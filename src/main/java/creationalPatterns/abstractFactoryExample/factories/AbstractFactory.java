package creationalPatterns.abstractFactoryExample.factories;

import creationalPatterns.abstractFactoryExample.buttons.Button;
import creationalPatterns.abstractFactoryExample.checkBoxes.Checkbox;

public interface AbstractFactory {
    // Абстрактная фабрика знает обо всех типах продуктов
    Button createButton();
    Checkbox createCheckbox();
}
