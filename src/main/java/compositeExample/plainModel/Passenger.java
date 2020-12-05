package compositeExample.plainModel;

import compositeExample.Component;
import compositeExample.Composite;

public class Passenger extends Composite {

    public Passenger(String componentId) {
        super(componentId);
    }

    @Override
    public float getAllWeight() {
        float allWeight = 0;
        for (Component child : getChildren())
            allWeight += child.getAllWeight();
        return allWeight;
    }

    @Override
    public float getMaxWeightPerComponent() {
        return getParent().getMaxWeightPerComponent();
    }

    @Override
    public void checkOverweight() {
        float allWeight = getAllWeight();

        if (allWeight > getMaxWeightPerComponent())
            System.out.println("Overweight confirmed");
    }

    @Override
    public void show() {
        System.out.println(getId());
    }
}
