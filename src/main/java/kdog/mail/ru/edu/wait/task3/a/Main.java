package kdog.mail.ru.edu.wait.task3.a;


import kdog.mail.ru.edu.wait.task3.AbstractStore;
import kdog.mail.ru.edu.wait.task3.a.answer.Store2;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        AbstractStore store2 = new Store2();

        //region producer if-wait2 - поведение НЕДЕТЕРМЕНИРОВАНО - Race Conditions
        Thread producer2 = new Thread(() -> {
            Thread.currentThread().setName("producer2");
            for (int i = 0; i < 2; i++) {
                store2.putOneProduct();

            }
        });

        Thread consumer2 = new Thread(() -> {
            Thread.currentThread().setName("consumer2");
            for (int i = 0; i < 2; i++) {
                store2.getOneProduct();
            }
        });
        Thread consumer3 = new Thread(() -> {
            Thread.currentThread().setName("consumer3");
            for (int i = 0; i < 2; i++) {
                store2.getOneProduct();
            }
        });

        consumer2.start();
        consumer3.start();
        producer2.start();
//        sleep(1000);
        //endregion Race Conditions




    }
}
