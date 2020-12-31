package behavioralPatterns.mediatorExample.component;

import behavioralPatterns.mediatorExample.Mediator;

public interface Component {
    void setMediator(Mediator mediator);
    String getName();
}