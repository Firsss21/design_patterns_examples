package abstractFactoryExample.factories;

import abstractFactoryExample.buttons.Button;
import abstractFactoryExample.buttons.MacOSButton;
import abstractFactoryExample.checkBoxes.Checkbox;
import abstractFactoryExample.checkBoxes.MacOSCheckbox;

public class MacOSFactory implements AbstractFactory {
    @Override
    public Button createButton() {
        return new MacOSButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new MacOSCheckbox();
    }
}
