package kdog.mail.ru.edu.threads.task1.c;

public class BaseThread extends Thread {
    final long pause;
    private final String msg;
    private final boolean infinite;

    /**
     * метод выводит в консоль сообщение
     */
    @Override
    public void run() {
        do {
            try {
                sleep(pause);        //Приостанавливает поток на 1 секунду
                System.out.println(msg);
            } catch (InterruptedException ignored) {
            }
        } while (infinite);
    }

    /**
     * @param pause время паузы в млс
     * @param msg задержка исполнения
     */
    public BaseThread(long pause, String msg) {
        this.pause = pause;
        this.msg = msg;
        infinite = false;
    }
    public BaseThread(long pause, String msg, boolean infinite) {
        this.pause = pause;
        this.msg = msg;
        this.infinite = infinite;
    }



}
