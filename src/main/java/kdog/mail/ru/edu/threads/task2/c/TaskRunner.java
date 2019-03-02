package kdog.mail.ru.edu.threads.task2.c;

import java.math.BigInteger;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class TaskRunner {

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<BigInteger> queue = new ArrayBlockingQueue<BigInteger>(15);
        PrimeProducer primeProducer = new PrimeProducer(queue);

        primeProducer.start();

        new Thread(()->{

            while (true) {
                try {
                    System.out.println(queue.take());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        Thread.sleep(1000L);
      primeProducer.interrupt();



    }
}
