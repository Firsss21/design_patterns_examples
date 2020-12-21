package creationalPatterns.builderExample;

import java.util.Set;

public class Something {
    private String one;
    private String two;
    private int three;
    private int four;
    private Set<Something> five;

    public String getOne() {
        return one;
    }

    public String getTwo() {
        return two;
    }

    public int getThree() {
        return three;
    }

    public int getFour() {
        return four;
    }

    public Set<Something> getFive() {
        return five;
    }

// Билдер решает проблему миллиона конструкторов класса, типа таких:

//    public Something(String one) {
//        this.one = one;
//    }
//    public Something(String one, String two) {
//        this.one = one;
//        this.two = two;
//    }
//    public Something(String one, String two, int three) {
//        this.one = one;
//        this.two = two;
//        this.three = three;
//    }
//    public Something(String one, String two, int three, int four) {
//        this.one = one;
//        this.two = two;
//        this.three = three;
//        this.four = four;
//    }

    // Можно сделать такой билдер
    public static class Builder {
        private Something newSomething;

        public Builder() {
            newSomething = new Something();
        }

        public Builder withOne(String one) {
            newSomething.one = one;
            return this;
        }

        public Builder withTwo(String two) {
            newSomething.two = two;
            return this;
        }
        public Builder withThree(int three) {
            newSomething.three = three;
            return this;
        }
        public Builder withFour(int four) {
            newSomething.four = four;
            return this;
        }
        public Builder withFive(Set five) {
            newSomething.five = five;
            return this;
        }

        public Something build() {
            return newSomething;
        }
    }



}
