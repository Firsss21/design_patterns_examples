package structuralPatterns.compositeExample;

import java.util.Optional;

public class AdministrationClient {
    private final Composite plain;
    public AdministrationClient(Composite plain) {
        this.plain = plain;
    }

    public Optional<Component> findAndShowResult(String id) {
        Optional<Component> component = plain.findRequiredComponentBy(id);

        if (component.isPresent())
            System.out.println("Component with id = " + id + " has been found");
        else
            System.out.println("No component with id = " + id);

        return component;
    }

    public void removeComponent(String id) {

        Optional<Component> component = findAndShowResult(id);
        if (component.isPresent())
        {
            System.out.println("Component with id = " + id + " has been removed");
            plain.remove(component.get());
        }
    }
}
