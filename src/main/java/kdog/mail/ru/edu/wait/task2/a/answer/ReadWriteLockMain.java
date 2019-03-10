package kdog.mail.ru.edu.wait.task2.a.answer;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import static java.lang.Thread.sleep;

public class ReadWriteLockMain {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(20);
        Map<String, String> map = new HashMap<>();
        ReadWriteLock lock = new ReentrantReadWriteLock();



            executor.submit(()->{
                //Блокирует только читающие потоки ТОЛЬКО ВО ВРЕМЯ ЗАПИСИ
                lock.writeLock().lock();
                try {
                    sleep(1);
                    map.put("foo", "bar1");
                } catch (InterruptedException ignored) {
                } finally {
                    lock.writeLock().unlock();
                }
            });


            //Выполнятся одновременно
        for (int i = 0; i < 15; i++) {
            int finalI = i;
            executor.submit(()->{
                lock.readLock().lock();
                try {
                    sleep(1000);
                    System.out.println(map.get("foo"));
                } catch (InterruptedException ignored) {
                } finally {
                    lock.readLock().unlock();
                }
            });
        }


    }
}
