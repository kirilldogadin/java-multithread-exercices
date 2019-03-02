package kdog.mail.ru.edu.threads.task3.b;

import java.util.concurrent.*;

import static java.lang.Thread.sleep;

public class ExecutorsMain {

    public static void main(String[] args) throws InterruptedException{

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        //ExecutorService executorService = Executors.newWorkStealingPool();


        Future<?> futureOne = executorService.submit(() -> {
            while (true) {
                System.out.println("1");
                //sleep(500L);
            }
        });


        sleep(1000L);
        futureOne.cancel(false);
        System.out.println("Прервано: may=false" + futureOne.isCancelled());
        sleep(1000L);
        futureOne.cancel(true);
//        futureTwo.cancel(true);
        System.out.println("Прервано: may=true" + futureOne.isCancelled());
//        System.out.println(futureTwo.isCancelled());

        executorService.shutdown();

        sleep(1000L);
        executorService.shutdownNow();

        System.out.println("Прервано:" + executorService.isShutdown());


        executorService.shutdown();
        try {
            futureOne.get(1000,TimeUnit.MILLISECONDS);
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }

        executorService.awaitTermination(100,TimeUnit.MILLISECONDS);


    }
}
