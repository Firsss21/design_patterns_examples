package compositeExample;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

public abstract class Composite implements Component {

    private final List<Component> children = new ArrayList<>();
    private Component parent;
    private final String componentId;

    public Composite(String componentId) {
        this.componentId = componentId;
    }

    @Override
    public void setParent(Component component) {
        parent = component;
    }

    @Override
    public Component getParent() {
        return parent;
    }

    @Override
    public void show() {
        System.out.println("Node: " + getId());

        System.out.println("Child nodes: ");

        for (Component child : children)
        {
            System.out.print("  ");
            child.show();
        }
    }

    @Override
    public void checkOverweight() {
        for (Component child : children)
            child.checkOverweight();
    }

    @Override
    public float getAllWeight() {
        return 0;
    }

    @Override
    public float getMaxWeightPerComponent() {
        return 0;
    }

    @Override
    public String getId() {
        return componentId;
    }

    public List<Component> getChildren() {
        return children;
    }

    public Optional<Component> findRequiredComponentBy(String id) // !!!
    // optional - контейнер, значащий, что вернутся может и пустой список
    {

        // stream api - апи, позволяющий работать со списками и коллекциями
        // не нужно писать for, в котором нужно будет что-то возвращать
        // filter по нужному условию находит элементы.
        // ищем первое совпадение, т.к ид уникальный у нас.

      Optional<Component> childComponent =
        getChildren().stream().filter(child -> child.getId().equals(id)).findFirst();

      if (childComponent.isPresent()) // isPresent = !isEmpty
        return childComponent;


      for (Component child : getChildren())
      {
          if (child instanceof Composite)
          {
             Optional<Component> component = ((Composite) child).findRequiredComponentBy(id);

             if (component.isPresent())
                 return component;
          }
      }
      return Optional.empty();
    }
    public void appendChild(Component child)
    {
        children.add(child);
        child.setParent(this);
    }

    public void remove(Component child) {
        Iterator<Component> childrenIterator = children.iterator();

        while (childrenIterator.hasNext())
        {
            Component childComponent = childrenIterator.next();

            if (childComponent.getId().equals(child.getId()))
            {
                childrenIterator.remove();
                System.out.println("Child " + child.getId() + " successfully removed");
                return;
            }
            else
            {
                if (childComponent instanceof Composite){
                    Composite childComposite = (Composite) childComponent;
                    childComposite.remove(child);
                }
            }

        }
    }
}
