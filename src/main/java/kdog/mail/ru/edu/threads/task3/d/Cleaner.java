package kdog.mail.ru.edu.threads.task3.d;

import java.util.concurrent.TimeUnit;

//TODO имплементировать интерфейс для авто-акрытия ресурса
class Cleaner implements Runnable{
 
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
 

  public void close() {

  }
}