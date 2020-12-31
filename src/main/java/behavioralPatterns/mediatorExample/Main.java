package behavioralPatterns.mediatorExample;


import behavioralPatterns.mediatorExample.component.*;

import javax.swing.*;

public class Main {

    // Посредник — это поведенческий паттерн проектирования,
    // который позволяет уменьшить связанность множества классов между собой,
    // благодаря перемещению этих связей в один класс-посредник.

    public static void main(String[] args) {
        Mediator mediator = new Editor();

        mediator.registerComponent(new Title());
        mediator.registerComponent(new TextBox());
        mediator.registerComponent(new AddButton());
        mediator.registerComponent(new DeleteButton());
        mediator.registerComponent(new SaveButton());
        mediator.registerComponent(new List(new DefaultListModel()));
        mediator.registerComponent(new Filter());

        mediator.createGUI();
    }
}
