package kdog.mail.ru.edu.wait.task1.a;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static java.lang.Thread.sleep;
import static java.util.Arrays.asList;

public class CounterRunner {

    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        ExecutorService executor =  Executors.newFixedThreadPool(10);


        Callable<Integer> callable = () -> {
            while (counter.getCount() < 10_000){
                try {
                    sleep(1L); // между проверкой условия b действием над состоянием условие успевает изменится
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                counter.increment();

            }
            return counter.getCount();
        };

        executor.invokeAll(asList(callable, callable, callable, callable, callable));

        System.out.println("Final result: " + counter.getCount());

        executor.shutdown();




    }
}
