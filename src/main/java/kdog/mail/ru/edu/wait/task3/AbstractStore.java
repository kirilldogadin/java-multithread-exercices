package kdog.mail.ru.edu.wait.task3;

public abstract class AbstractStore {

    final int MIN_COUNT = 0;
    final int MAX_COUNT = 5;

    protected volatile int productCount = 0;

    abstract public void getProduct(int productCount);

    /**
     *
     * @param productCount
     */

    abstract public void putProduct(int productCount);

    synchronized public void putOneProduct() {
        putProduct(1);
    }

    synchronized public void getOneProduct() {
        getProduct(1);
    }

    protected boolean isCanGet() {
        return productCount > MIN_COUNT;
    }

    protected boolean isCanPut() {
        return productCount < MAX_COUNT;
    }



}
