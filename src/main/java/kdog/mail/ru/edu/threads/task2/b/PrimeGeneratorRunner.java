package kdog.mail.ru.edu.threads.task2.b;

import java.math.BigInteger;

import static java.lang.Thread.*;

public class PrimeGeneratorRunner {
    private static final long PAUSE = 500L;

    public static void main(String[] args) throws InterruptedException {


        Thread primeGenerator = new Thread(() -> {
            BigInteger p = BigInteger.ONE;
            while (!currentThread().isInterrupted()) {
                try {
                    System.out.println(p = p.nextProbablePrime());
                    sleep(PAUSE); //ЕСЛИ У ПОТОКА ВЫЗЫВАТЬ МЕТОД INTERRUPT ПОКА ОН SLEEP ТО БУДЕТ InterruptedException
                } catch (InterruptedException ignored) {

                }
            }
        });
        primeGenerator.start();

        sleep(PAUSE*5);
        primeGenerator.interrupt();

    }

}