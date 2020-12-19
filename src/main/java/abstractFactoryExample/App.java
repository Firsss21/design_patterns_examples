package abstractFactoryExample;

import abstractFactoryExample.buttons.Button;
import abstractFactoryExample.checkBoxes.Checkbox;
import abstractFactoryExample.factories.AbstractFactory;

public class App {
    private Button button;
    private Checkbox checkbox;

    public App(AbstractFactory factory) {
        this.button = factory.createButton();
        this.checkbox = factory.createCheckbox();
    }

    public void paint() {
        button.paint();
        checkbox.paint();
    }
}
