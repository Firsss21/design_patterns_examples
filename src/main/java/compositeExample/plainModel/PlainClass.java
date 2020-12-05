package compositeExample.plainModel;

import compositeExample.Component;
import compositeExample.Composite;

public class PlainClass extends Composite {
    private final int armcharisCount;
    private final float maxWeightPerPassenger;

    public PlainClass(String componentId, int armcharisCount, float maxWeightPerPassenger)
    {
        super(componentId);
        this.armcharisCount = armcharisCount;
        this.maxWeightPerPassenger = maxWeightPerPassenger;
    }

    @Override
    public void appendChild(Component child) {
        if (getChildren().size() <= armcharisCount)
            super.appendChild(child);
        else
            System.out.println("reached max passengers quantity");
    }

    @Override
    public float getMaxWeightPerComponent() {
        return maxWeightPerPassenger;
    }
}
