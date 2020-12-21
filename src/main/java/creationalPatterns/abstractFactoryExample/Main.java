package creationalPatterns.abstractFactoryExample;

import creationalPatterns.abstractFactoryExample.factories.AbstractFactory;
import creationalPatterns.abstractFactoryExample.factories.MacOSFactory;
import creationalPatterns.abstractFactoryExample.factories.WindowsFactory;

public class Main {

    // Абстрактная фабрика — это порождающий паттерн проектирования,
    // который решает проблему создания целых семейств связанных продуктов,
    // без указания конкретных классов продуктов.

    private static App configureApplication() {
        App app;
        AbstractFactory factory;
        String osName = System.getProperty("os.name").toLowerCase();
        if (osName.contains("mac")) {
            factory = new MacOSFactory();
            app = new App(factory);
        } else {
            factory = new WindowsFactory();
            app = new App(factory);
        }
        return app;
    }

    public static void main(String[] args) {
        App appWindows = new App(new WindowsFactory());
        appWindows.paint();

        App appMacOS = new App(new MacOSFactory());
        appMacOS.paint();

        App appCurrent = configureApplication();
        appCurrent.paint();
    }
}
