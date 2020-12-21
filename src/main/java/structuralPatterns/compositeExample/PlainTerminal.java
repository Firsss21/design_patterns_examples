package structuralPatterns.compositeExample;

public class PlainTerminal
{
    private final Composite plain;

    public PlainTerminal(Composite plain) {
        this.plain = plain;
    }

    // просматривает элементы и смотрим перевес.

    public void showPlainStructure() {
        plain.show();
    }

    public void checkOverweight() {
        plain.checkOverweight();
    }
}
