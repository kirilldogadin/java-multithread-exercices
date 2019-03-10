package kdog.mail.ru.edu.wait.task2;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.lang.Thread.sleep;

public abstract class AbstractLocker {

    ExecutorService executor = Executors.newFixedThreadPool(20);
    Map<String, String> map = new HashMap<>();

    public void init() {
        executor.submit(() ->

        {
            //Блокирует только читающие потоки ТОЛЬКО ВО ВРЕМЯ ЗАПИСИ
            lockOnWrite();
            try {
                sleep(1);
                map.put("foo", "bar1");
            } catch (InterruptedException ignored) {
            } finally {
                unlockWrite();
            }
        });

    }

    public void parallelRead() {
        //Выполнятся одновременно
        for (int i = 0; i < 15; i++) {
            int finalI = i;
            executor.submit(() -> {
                lockOnRead();
                try {
                    sleep(1000);
                    System.out.println(map.get("foo"));
                } catch (InterruptedException ignored) {
                } finally {
                    unlockRead();
                }
            });
        }
    }

    public abstract void lockOnWrite();

    public abstract void lockOnRead();

    public abstract void unlockWrite();

    public abstract void unlockRead();


}
