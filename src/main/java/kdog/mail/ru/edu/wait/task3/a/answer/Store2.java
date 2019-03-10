package kdog.mail.ru.edu.wait.task3.a.answer;

import kdog.mail.ru.edu.wait.task3.AbstractStore;

public class Store2 extends AbstractStore {

    /**
     * Недетерменированный результат.
     * Причина - if - проверяет только раз. Race condition между wait/notify
     *notiy -> notifyALL
     * @param productCount
     */
    synchronized public void getProduct(int productCount) {

        if (!isCanGet()) {//Если Нельзя выполнить действие, то ждем
            try {
                System.out.println("Статус до WAIT. Поток " + Thread.currentThread().getName() + " " + Thread.currentThread().getState());
                wait(); // выполнение потока остановится в этом месте
                System.out.println("Статус после WAIT. Поток " + Thread.currentThread().getName() + " " + Thread.currentThread().getState());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.productCount -= productCount;
        System.out.println("КУПЛЕНО. Осталось товаров " + this.productCount);
        System.out.println("Статус до Notify. Поток " + Thread.currentThread().getName() + " " + Thread.currentThread().getState());
        notify();
        System.out.println("Статус после Notify. Поток " + Thread.currentThread().getName() + " " + Thread.currentThread().getState());

    }

    /**
     * Недетерменированный результат.
     * Причина - if - проверяет только раз. Race condition между wait/notify
     *
     * @param productCount
     */
    synchronized public void putProduct(int productCount) {
        if (!isCanPut()) {//Если Нельзя выполнить действие, то ждем
            try {
                System.out.println("Статус до WAIT. Поток " + Thread.currentThread().getName() + " " + Thread.currentThread().getState());
                wait();
                System.out.println("Статус после WAIT. Поток " + Thread.currentThread().getName() + " " + Thread.currentThread().getState());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.productCount += productCount;
        System.out.println("ПРОИЗВЕДЕНО. Осталось товаров " + this.productCount);
        System.out.println("Статус до Notify. Поток " + Thread.currentThread().getName() + " " + Thread.currentThread().getState());
        notify();
        System.out.println("Статус после Notify. Поток " + Thread.currentThread().getName() + " " + Thread.currentThread().getState());

    }




}
