package kdog.mail.ru.edu.threads.task2.c.answer;

import java.math.BigInteger;
import java.util.concurrent.BlockingQueue;

public class PrimeProducerAnswer extends Thread {
    private final BlockingQueue<BigInteger> queue;
    private static final long PAUSE = 500L;

    PrimeProducerAnswer(BlockingQueue<BigInteger> queue) {
        this.queue = queue;
    }

    public void run() {
        try {
            BigInteger p = BigInteger.ONE;

            while (!Thread.currentThread().isInterrupted()) {
                queue.put(p = p.nextProbablePrime());
                sleep(PAUSE); //ЕСЛИ У ПОТОКА ВЫЗЫВАТЬ МЕТОД INTERRUPT ПОКА ОН SLEPP ТО БУДЕТ InterruptedException
            }

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            /* Allow thread to exit */
        }
        System.out.println("Генератор простых чисел остановлен");
    }


}