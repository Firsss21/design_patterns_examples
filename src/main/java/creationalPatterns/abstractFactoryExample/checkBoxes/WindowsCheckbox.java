package creationalPatterns.abstractFactoryExample.checkBoxes;

public class WindowsCheckbox implements Checkbox {
    @Override
    public void paint() {
        System.out.println("You have created WindowsButton.");
    }
}
