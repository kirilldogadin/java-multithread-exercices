package kdog.mail.ru.edu.threads.task3.a.answer;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorsMain {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        //ExecutorService executorService = Executors.newWorkStealingPool();


        Future<?> submit = executorService.submit(() -> {
            System.out.println(1 / 0);
        });

        try {
            submit.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        executorService.submit(() -> {
            try {

                System.out.println(1 / 0);
            } catch (RuntimeException e){
                e.printStackTrace();
            }

        });




        executorService.shutdown();
//        final Future<Integer> division = executorService.submit(() -> 1 / 0);
////ниже будет выброшено ExecutionException, вызванное ArithmeticException
//        division.get();

    }
}
