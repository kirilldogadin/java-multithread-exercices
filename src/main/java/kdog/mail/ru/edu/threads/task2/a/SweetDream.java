package kdog.mail.ru.edu.threads.task2.a;

public class SweetDream {

    final public static void main(String[]args) throws InterruptedException{
        Thread dream = new Thread(new Dream());
        dream.start();
        Thread.sleep(5000);
        dream.interrupt();
        dream.join();
    }

    static class Dream implements Runnable{

        @Override
        public void run() {
            while(!Thread.currentThread().isInterrupted()){
                System.out.println("Сон начинается");
                sleep2sec();
                System.out.println("Сон закончился\n");
            }
            System.out.println("Завершение работы потока");
        }

        private void sleep2sec(){
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println("Сон прерван");
            }
        }

    }

}