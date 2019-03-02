package kdog.mail.ru.edu.threads.task3.d.answer;

import java.util.concurrent.TimeUnit;

class Cleaner implements Runnable, AutoCloseable {
 
  private final Thread cleanerThread;
 
  Cleaner() {
    cleanerThread = new Thread(this, "Cleaner");
    cleanerThread.start();
  }
 
  @Override
  public void run() {
    try {
      while (true) {
        //метод
        TimeUnit.SECONDS.sleep(1);
      }
    } catch (InterruptedException ignored) {
      //must be log.debug("Interrupted, closing"); instead sout
    }
  }
 
  //...   
 
  @Override
  public void close() {
    cleanerThread.interrupt();
  }
}