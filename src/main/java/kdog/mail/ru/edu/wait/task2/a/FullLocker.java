package kdog.mail.ru.edu.wait.task2.a;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

import static java.lang.Thread.sleep;

public class FullLocker {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(20);
        Map<String, String> map = new HashMap<>();
        ReentrantLock lock = new ReentrantLock();



            executor.submit(()->{
                //Блокирует только читающие потоки ТОЛЬКО ВО ВРЕМЯ ЗАПИСИ
                lock.lock();
                try {
                    sleep(1);
                    map.put("foo", "bar1");
                } catch (InterruptedException ignored) {
                } finally {
                    lock.unlock();
                }
            });


            //Выполнятся одновременно
        for (int i = 0; i < 15; i++) {
            int finalI = i;
            executor.submit(()->{
                lock.lock();
                try {
                    sleep(1000);
                    System.out.println(map.get("foo"));
                } catch (InterruptedException ignored) {
                } finally {
                    lock.unlock();
                }
            });
        }


    }
}
