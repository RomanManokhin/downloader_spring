package MultiTreadingInfo.CloseThread.BaseClose;

public class MyThread implements Runnable {
    //Проверка потока на жизнь
    private boolean isAlive;

    //метод для выключения потока
    void disable() {
        isAlive = false;
    }

    @Override
    public void run() {
        System.out.printf("%s started... \n", Thread.currentThread().getName());
        int count = 1; //счетчик циклов
        while (isAlive){
            System.out.println("Loop " + count++);
            try {
                Thread.sleep(400);
            } catch (InterruptedException e) {
                System.out.println("Thread has been interrupted");
            }
            System.out.printf("%s finished... \n", Thread.currentThread().getName());
        }
    }
}
