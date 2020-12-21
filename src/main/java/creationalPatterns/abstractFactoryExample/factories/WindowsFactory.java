package creationalPatterns.abstractFactoryExample.factories;

import creationalPatterns.abstractFactoryExample.buttons.Button;
import creationalPatterns.abstractFactoryExample.buttons.WindowsButton;
import creationalPatterns.abstractFactoryExample.checkBoxes.Checkbox;
import creationalPatterns.abstractFactoryExample.checkBoxes.WindowsCheckbox;

public class WindowsFactory implements AbstractFactory {
    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new WindowsCheckbox();
    }
}
