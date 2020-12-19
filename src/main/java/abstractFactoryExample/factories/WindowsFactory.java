package abstractFactoryExample.factories;

import abstractFactoryExample.buttons.Button;
import abstractFactoryExample.buttons.WindowsButton;
import abstractFactoryExample.checkBoxes.Checkbox;
import abstractFactoryExample.checkBoxes.WindowsCheckbox;

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
