package abstractFactoryExample;

import abstractFactoryExample.factories.MacOSFactory;
import abstractFactoryExample.factories.WindowsFactory;

public class Main {

    // Абстрактная фабрика — это порождающий паттерн проектирования,
    // который решает проблему создания целых семейств связанных продуктов,
    // без указания конкретных классов продуктов.

    public static void main(String[] args) {
        App appWindows = new App(new WindowsFactory());
        appWindows.paint();

        App appMacOS = new App(new MacOSFactory());
        appMacOS.paint();
    }
}
