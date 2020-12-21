package structuralPatterns.bridgeExample.devices;

public class Radio extends AbstractDevice {

//    private boolean on = false;
//    private int volume = 30;
//    private int channel = 1;

    @Override
    public void printStatus() {
        System.out.println("------------------------------------");
        System.out.println("| I'm radio.");
        System.out.println("| I'm " + (on ? "enabled" : "disabled"));
        System.out.println("| Current volume is " + volume + "%");
        System.out.println("| Current channel is " + channel);
        System.out.println("------------------------------------\n");
    }
}
