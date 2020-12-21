package behavioralPatterns.commandExample;

public class Main {

    // Команда — это поведенческий паттерн проектирования,
    // который превращает запросы в объекты,
    // позволяя передавать их как аргументы при вызове методов,
    // ставить запросы в очередь, логировать их, а также поддерживать отмену операций.

    public static void main(String[] args) {
        Editor editor = new Editor();
        editor.init();
    }
}
