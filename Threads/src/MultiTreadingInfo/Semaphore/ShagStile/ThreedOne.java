package MultiTreadingInfo.Semaphore.ShagStile;

import java.util.List;
import java.util.concurrent.Semaphore;

public class ThreedOne extends Thread {
    final Object locker;
    private final List<Integer> array;
    private Semaphore semaphore;

    public ThreedOne(Object locker, List<Integer> array, Semaphore semaphore) {
        this.locker = locker;
        this.semaphore = semaphore;
        this.array = array;
    }
    public ThreedOne(Object locker, List<Integer> array) {
        this.locker = locker;
        this.array = array;
    }

    public void run() {
        try {
            synchronized (locker) {

                locker.wait();
                Thread.sleep(5000);

                // используем семафор
//                semaphore.acquire();
//                System.out.println("Это 1ый поток");
//                System.out.println(Thread.currentThread().getName() + " : имя потока");
//                semaphore.release();
            }
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
    }

}
