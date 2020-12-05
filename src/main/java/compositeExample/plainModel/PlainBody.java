package compositeExample.plainModel;
import compositeExample.Component;
import compositeExample.Composite;

public class PlainBody extends Composite {

    private final int maxClassCount;

    public PlainBody(String componentId ,int maxClassCount) {
        super(componentId);
        this.maxClassCount = maxClassCount;
    }

    @Override
    public void appendChild(Component child) {
        if (getChildren().size() < maxClassCount)
            super.appendChild(child);
        else
            System.out.println("Reached max elements quantity");
    }
}
