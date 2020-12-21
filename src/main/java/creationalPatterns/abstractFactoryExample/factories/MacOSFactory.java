package creationalPatterns.abstractFactoryExample.factories;

import creationalPatterns.abstractFactoryExample.buttons.Button;
import creationalPatterns.abstractFactoryExample.buttons.MacOSButton;
import creationalPatterns.abstractFactoryExample.checkBoxes.Checkbox;
import creationalPatterns.abstractFactoryExample.checkBoxes.MacOSCheckbox;

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
