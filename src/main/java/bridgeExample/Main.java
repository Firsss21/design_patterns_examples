package bridgeExample;

import bridgeExample.devices.Device;
import bridgeExample.devices.Radio;
import bridgeExample.devices.TV;
import bridgeExample.remote.AdvancedRemote;
import bridgeExample.remote.BasicRemote;

public class Main {

    // Мост — это структурный паттерн,
    // который разделяет бизнес-логику или большой класс на несколько отдельных иерархий,
    // которые потом можно развивать отдельно друг от друга.

    public static void main(String[] args) {

        testDevice(new TV());
        testDevice(new Radio());

    }

    public static void testDevice(Device device) {

        System.out.println("Tests with basic remote.");
        BasicRemote basicRemote = new BasicRemote(device);
        basicRemote.power();
        device.printStatus();

        System.out.println("Tests with advanced remote.");
        AdvancedRemote advancedRemote = new AdvancedRemote(device);
        advancedRemote.power();
        advancedRemote.mute();
        device.printStatus();

    }

}
