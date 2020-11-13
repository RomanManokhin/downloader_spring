package MultiTreadingInfo.Semaphore.ShagStile;

import java.util.List;
import java.util.concurrent.Semaphore;

public class ThreedTwo extends Thread {
    final Object locker;
    private final List<Integer> array;
    private Semaphore semaphore;

    public ThreedTwo(Object locker, List<Integer> array, Semaphore semaphore) {
        this.locker = locker;
        this.array = array;
        this.semaphore = semaphore;
    }

    public ThreedTwo(Object locker, List<Integer> array) {
        this.locker = locker;
        this.array = array;
    }

    public void run() {
        try {
//            synchronized (locker) {
                semaphore.acquire();
//                locker.wait();
                System.out.println("Это 2ой поток"); // для семафора
            System.out.println(Thread.currentThread().getName() + " : имя потока"); // узнать имя потока
                Thread.sleep(5000);
                semaphore.release();
//            }
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
    }

}
