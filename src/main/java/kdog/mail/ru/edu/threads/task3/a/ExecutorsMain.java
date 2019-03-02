package kdog.mail.ru.edu.threads.task3.a;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;

public class ExecutorsMain {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newSingleThreadExecutor();


        executorService.submit(() -> {
            System.out.println(1 / 0);
        });

        Future<?> submit = executorService.submit(() -> {
            Thread.currentThread().setUncaughtExceptionHandler((Thread t, Throwable e) ->
                    System.out.println("!!!!!!!!Error in thread" + t + "erorr:" + e));
            System.out.println(1 / 0);
        });



    }
}
