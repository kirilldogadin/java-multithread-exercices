package kdog.mail.ru.edu.threads.task2.c.answer;

import java.math.BigInteger;
import java.util.concurrent.BlockingQueue;

public class PrimeConsumer extends Thread {

    private final BlockingQueue<BigInteger> queue;
    private static final long PAUSE = 200L;

    public PrimeConsumer(BlockingQueue<BigInteger> queue) {
        this.queue = queue;
    }


    @Override
    public void run(){
        while (true) {
            try {
                System.out.println(queue.take());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }


}
