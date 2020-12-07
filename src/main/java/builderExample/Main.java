package builderExample;

public class Main {
    public static void main(String[] args) {
        Something mySomething = new Something.Builder()
                .withOne("1")
                .withTwo("2")
                .withThree(3)
                .withFour(4)
                .build();

        System.out.println("mySomething one: " + mySomething.getOne());
        System.out.println("mySomething two: " + mySomething.getTwo());
        System.out.println("mySomething three: " + mySomething.getThree());
        System.out.println("mySomething four: " + mySomething.getFour());

    }
}
