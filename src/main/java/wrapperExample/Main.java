package wrapperExample;

public class Main {

    // Декоратор — это структурный паттерн,
    // который позволяет добавлять объектам новые поведения на лету,
    // помещая их в объекты-обёртки.

    public static void main(String[] args) {
        String records = "String for example";


        DataSourceWrapper encoded = new CompressionWrapper(
                new EncryptionWrapper(
                        new FileDataSource("./target/classes/OutputDemo.txt")));

        encoded.writeData(records);

        DataSource plain = new FileDataSource("./target/classes/OutputDemo.txt");

        System.out.println("Input : \n" + records);
        System.out.println("Encoded: \n" + plain.readData());
        System.out.println("Decoded: \n" + encoded.readData());
    }


}
