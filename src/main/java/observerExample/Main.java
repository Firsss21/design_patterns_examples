package observerExample;

import observerExample.listeners.EmailNotificationListener;
import observerExample.listeners.LogOpenListener;

public class Main {

    // Наблюдатель — это поведенческий паттерн,
    // который позволяет объектам оповещать другие объекты об изменениях своего состояния.

    public static void main(String[] args) {
        Editor editor = new Editor();
        editor.events.subscribe("open", new LogOpenListener("/path/to/log/file.txt"));
        editor.events.subscribe("save", new EmailNotificationListener("admin@example.com"));

        try {
            editor.openFile("test.txt");
            editor.saveFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
