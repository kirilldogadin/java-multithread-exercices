package kdog.mail.ru.edu.threads.task1;

public class MainThreadA {

    public static void main(String[] args) throws InterruptedException {
        Thread additionalThread = new AdditionalThread();
        additionalThread.setName("AdditionalThread");
        additionalThread.start();    //Создание потока и Запуск потока

        System.out.println("Последнее действие главного потока");
    }
}