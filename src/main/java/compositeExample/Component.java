package compositeExample;

public interface Component {

    Component getParent();

    void setParent(Component component);

    String getId();

    void checkOverweight();

    float getAllWeight();

    float getMaxWeightPerComponent();

    void show();
}
