package MultiTreadingInfo.Semaphore.ShagStile;

import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Semaphore;

public class ArrayThread extends Thread {
    //создаём поля Locker для иснхронизации и поле для массива
    final Object locker;
    private final List<Integer> array;
    //конструктор
    public ArrayThread(Object locker, List<Integer> array, Semaphore semaphore) {
        this.locker = locker;
        this.array = array;
    }

    public ArrayThread(Object locker, List<Integer> array) {
        this.locker = locker;
        this.array = array;
    }

    public void run() {

        Scanner in = new Scanner(System.in);
//        List<Integer> array = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            array.add(in.nextInt());
        }
        //синхронизируем через locker
        synchronized (locker) {
            //разрешаем брать всем потокам, что получилось после отработки потока на основании locker
            locker.notifyAll();

//            locker.notify(); -- для первого потока
        }
    }
}


