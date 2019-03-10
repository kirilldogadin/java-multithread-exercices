package kdog.mail.ru.edu.wait.task3.b.answer;

import kdog.mail.ru.edu.wait.task3.AbstractStore;

public class Store3 extends AbstractStore {

    /**
     *notiy -> notifyALL
     * @param productCount
     */
    synchronized public void getProduct(int productCount) {

        while (!isCanGet()) {//Если Нельзя выполнить действие, то ждем
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
        notifyAll();
        System.out.println("Статус после Notify. Поток " + Thread.currentThread().getName() + " " + Thread.currentThread().getState());

    }

    /**
     * Недетерменированный результат.
     * Причина - if - проверяет только раз. Race condition между wait/notify
     *
     * @param productCount
     */
    synchronized public void putProduct(int productCount) {
        while (!isCanPut()) {//Если Нельзя выполнить действие, то ждем - ПРОВЕРКА ПОВТОРЯЕТСЯ
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
        notifyAll();
        System.out.println("Статус после Notify. Поток " + Thread.currentThread().getName() + " " + Thread.currentThread().getState());

    }

    synchronized public void putOneProduct() {
        putProduct(1);
    }

    synchronized public void getOneProduct() {
        getProduct(1);
    }


}
