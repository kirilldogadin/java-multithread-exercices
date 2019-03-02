package kdog.mail.ru.edu.threads.task2.c.answer;

import java.math.BigInteger;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class TaskRunner {

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<BigInteger> queue = new ArrayBlockingQueue<BigInteger>(1024);
        PrimeProducerAnswer primeProducer = new PrimeProducerAnswer(queue);
        PrimeConsumer primeConsumer = new PrimeConsumer(queue);

        System.out.println("Начинается генерация чисел");
        primeProducer.start();
        primeConsumer.start();


        //ПОЧЕМУ ОШИБКА
        Thread.sleep(3000L);
        System.out.println("Флаг прерывания потока: " + primeProducer.isInterrupted());
     //   System.out.println("Прерываем");
        primeProducer.interrupt();
        System.out.println("Флаг прерывания потока: " + primeProducer.isInterrupted());
        System.out.println();


    }
}
