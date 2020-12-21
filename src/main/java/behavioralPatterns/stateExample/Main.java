package behavioralPatterns.stateExample;

public class Main {

    // Состояние — это поведенческий паттерн,
    // позволяющий динамически изменять поведение объекта при смене его состояния.

    public static void main(String[] args) {
        Player player = new Player();
        UI ui = new UI(player);
        ui.init();
    }
}
