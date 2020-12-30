package behavioralPatterns.strategyExample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

    // Стратегия — это поведенческий паттерн,
    // выносит набор алгоритмов в собственные классы
    // и делает их взаимозаменимыми.

    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    private static Order order = new Order();
    private static PayStrategy strategy;

    private static Map<Integer, Integer> priceOnProducts = new HashMap<>();
    static {
        priceOnProducts.put(1, 2200);
        priceOnProducts.put(2, 1850);
        priceOnProducts.put(3, 1100);
        priceOnProducts.put(4, 890);
    }

    private static void printMenu() {
        System.out.print("Please, select a product:" + "\n" +
                "1 - Mother board" + "\n" +
                "2 - CPU" + "\n" +
                "3 - HDD" + "\n" +
                "4 - Memory" + "\n");
    }

    public static void main(String[] args) throws IOException {

        while (!order.isClosed()) {

            int cost;
            String continueChoice;

            do {    // Выбор продукта и количества
                printMenu();

                int choice = Integer.parseInt(reader.readLine());
                cost = priceOnProducts.get(choice);

                System.out.print("Count: ");
                int count = Integer.parseInt(reader.readLine());
                order.setTotalCost(cost * count);

                System.out.print("Do you wish to continue selecting products? Y/N: ");
                continueChoice = reader.readLine();

            } while (continueChoice.equalsIgnoreCase("Y"));


            if (strategy == null) { // Выбираем способ оплаты

                System.out.println("Please, select a payment method:" + "\n"
                        + "1 - PayPal" + "\n"
                        + "2 - Credit Card");
                String paymentMethod = reader.readLine();
                if (paymentMethod.equals("1")) {
                    strategy = new PayByPaypal();
                } else {
                    strategy = new PayByCreditCard();
                }
            }

            // Объект заказа делегирует сбор платёжных данны стратегии, т.к.
            // только стратегии знают какие данные им нужны для приёма оплаты.
            order.processOrder(strategy);

            System.out.print("Pay " + order.getTotalCost() + " units or Continue shopping? P/C: ");
            String proceed = reader.readLine();
            if (proceed.equalsIgnoreCase("P")) {
                // И наконец, стратегия запускает приём платежа.
                if (strategy.pay(order.getTotalCost())) {
                    System.out.println("Payment has been successful.");
                } else {
                    System.out.println("FAIL! Please, check your data.");
                }
                order.setClosed();
            }
        }

    }
}
