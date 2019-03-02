package kdog.mail.ru.edu.threads.task1.a.answer;

import kdog.mail.ru.edu.threads.task1.AdditionalThread;

public class MainThreadA {

    public static void main(String[] args) throws InterruptedException {
        Thread additionalThread = new AdditionalThread();
        additionalThread.start();    //Создание потока и Запуск потока

        Thread.currentThread().join();                //

        System.out.println("Главный поток завершён...");
    }
}