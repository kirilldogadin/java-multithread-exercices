package kdog.mail.ru.edu.threads.task3.с.answer;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorsMain {


    ExecutorService executorService = Executors.newWorkStealingPool();
    public static void main(String[] args) {

        ExecutorService executorService = Executors.newSingleThreadExecutor();

    }

    private void sendAllEmails(List<String> emails) throws InterruptedException {
        emails.forEach(email ->
                executorService.submit(() ->
                     sendEmail(email)));
        executorService.shutdown();
        final boolean done = executorService.awaitTermination(1, TimeUnit.MINUTES);
        //log.debug("Все ли письма были отправлены? {}", done);
    }

    void sendEmail(String email){

    }
}
