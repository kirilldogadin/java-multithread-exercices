package kdog.mail.ru.edu.threads.task3.с;

import java.util.List;
import java.util.concurrent.*;

public class ExecutorsMain {


    ExecutorService executorService = Executors.newWorkStealingPool();
    public static void main(String[] args) {

        ExecutorService executorService = Executors.newSingleThreadExecutor();

    }

    private void sendAllEmails(List<String> emails) {
        emails.forEach(email ->
                executorService.submit(() ->
                     sendEmail(email)));
    }

    void sendEmail(String email){

    }
}
