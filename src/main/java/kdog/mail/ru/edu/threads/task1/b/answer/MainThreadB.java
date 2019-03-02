package kdog.mail.ru.edu.threads.task1.b.answer;

import kdog.mail.ru.edu.threads.task1.AdditionalThread;

public class MainThreadB {

    public static void main(String[] args) throws InterruptedException {
        Thread additionalThread = new AdditionalThread();
        additionalThread.start();    //Создание потока и Запуск потока

        Thread.currentThread().join(450);                //

        System.out.println("Главный поток завершён...");
    }
}