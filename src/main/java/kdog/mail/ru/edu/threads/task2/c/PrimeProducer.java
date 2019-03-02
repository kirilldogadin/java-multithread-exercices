package kdog.mail.ru.edu.threads.task2.c;

import java.math.BigInteger;
import java.util.concurrent.BlockingQueue;

public class PrimeProducer extends Thread {
    private final BlockingQueue<BigInteger> queue;
    private static final long PAUSE = 500L;

    public PrimeProducer(BlockingQueue<BigInteger> queue) {
        this.queue = queue;
    }

    public void run() {

        BigInteger p = BigInteger.ONE;
        while (true) {//подсказка: вот тут нужно добавить условие
            try { //подсказка - этот блок должен быть не в цикле
                queue.put(p = p.nextProbablePrime());
                sleep(PAUSE);

            } catch (InterruptedException consumed) {
                /* сюдда добавить что-то ещё */
            }

        }

    }

}