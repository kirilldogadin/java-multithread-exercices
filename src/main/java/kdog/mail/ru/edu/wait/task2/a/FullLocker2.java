package kdog.mail.ru.edu.wait.task2.a;

import kdog.mail.ru.edu.wait.task2.AbstractLocker;

import java.util.concurrent.locks.ReentrantLock;

public class FullLocker2 extends AbstractLocker {

    ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {

        FullLocker2 fullLocker = new FullLocker2();

        fullLocker.init();

        fullLocker.parallelRead();

    }

    @Override
    public void lockOnWrite() {
        lock.lock();
    }

    @Override
    public void lockOnRead() {
        lock.lock();
    }

    @Override
    public void unlockWrite() {
        lock.unlock();
    }

    @Override
    public void unlockRead() {
        lock.unlock();
    }
}
