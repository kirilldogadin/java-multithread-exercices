package kdog.mail.ru.edu.wait.task2.a.answer;

import kdog.mail.ru.edu.wait.task2.AbstractLocker;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLock2Main extends AbstractLocker {

    ReadWriteLock lock = new ReentrantReadWriteLock();


    public static void main(String[] args) {

        ReadWriteLock2Main readWriteLockMain = new ReadWriteLock2Main();
        readWriteLockMain.init();
        readWriteLockMain.parallelRead();



    }

    @Override
    public void lockOnWrite() {
        lock.writeLock().lock();
    }

    @Override
    public void lockOnRead() {
        lock.readLock().lock();
    }

    @Override
    public void unlockWrite() {
        lock.writeLock().unlock();
    }

    @Override
    public void unlockRead() {
        lock.readLock().unlock();
    }
}
