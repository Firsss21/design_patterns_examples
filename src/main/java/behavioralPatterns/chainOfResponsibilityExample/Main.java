package behavioralPatterns.chainOfResponsibilityExample;

import behavioralPatterns.chainOfResponsibilityExample.chain.Middleware;
import behavioralPatterns.chainOfResponsibilityExample.chain.RequestLimitCheckMiddleware;
import behavioralPatterns.chainOfResponsibilityExample.chain.RoleCheckMiddleware;
import behavioralPatterns.chainOfResponsibilityExample.chain.UserAuthCheckMiddleware;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    // Цепочка обязанностей — это поведенческий паттерн проектирования,
    // который позволяет передавать запросы последовательно по цепочке обработчиков.

    // Каждый последующий обработчик решает,
    // может ли он обработать запрос сам и стоит ли передавать запрос дальше по цепи.

    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static Server server;

    private static void init() {
        server = new Server();
        server.register("admin@example.com", "admin_pass");
        server.register("user@example.com", "user_pass");

        // Проверки связаны в одну цепь. Клиент может строить различные цепи,
        // используя одни и те же компоненты.
        Middleware middleware = new RequestLimitCheckMiddleware(2);
        middleware.linkWith(new UserAuthCheckMiddleware(server))
                .linkWith(new RoleCheckMiddleware());

        // Сервер получает цепочку от клиентского кода.
        server.setMiddleware(middleware);
    }

    public static void main(String[] args) throws IOException {

        init();

        boolean success;
        do {
            System.out.print("Enter email: ");
            String email = reader.readLine();
            System.out.print("Input password: ");
            String password = reader.readLine();
            success = server.logIn(email, password);
        } while (!success);
    }
}
