Реализовать таск который реализует AutoCloseable


что-то вроде:


class Cleaner implements Runnable, AutoCloseable {
 /*
 ...
 */
  @Override
  public void close() {
    cleanerThread.interrupt();
  }
}