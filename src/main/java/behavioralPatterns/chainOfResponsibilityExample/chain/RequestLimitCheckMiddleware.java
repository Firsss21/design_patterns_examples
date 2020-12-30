package behavioralPatterns.chainOfResponsibilityExample.chain;

public class RequestLimitCheckMiddleware extends Middleware{
    private int requestPerMinute;
    private int request;
    private long currentTime;

    public  RequestLimitCheckMiddleware(int requestPerMinute) {
        this.requestPerMinute = requestPerMinute;
        this.currentTime = System.currentTimeMillis();
    }

    // Вызов checkNext() можно вставить как в начале этого метода, так и в середине или в конце.

    // Это даёт еще один уровень гибкости по сравнению с проверками в цикле.

    public boolean check(String email, String password) {
        if (System.currentTimeMillis() > currentTime + 60_000) {
            request = 0;
            currentTime = System.currentTimeMillis();
        }

        request++;

        if (request > requestPerMinute) {
            System.out.println("Request limit exceeded!");
            Thread.currentThread().interrupt();
        }
        return checkNext(email, password);
    }

}
