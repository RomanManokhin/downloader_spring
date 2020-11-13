package MultiTreadingInfo.ReentrantLock;

import java.util.concurrent.locks.ReentrantLock;

public class Program {

    public static void main(String[] args) {
        //Создаём общий ресурс
        CommonResource commonResource = new CommonResource();
        // создаем заглушку
        ReentrantLock locker = new ReentrantLock();
        for (int i = 1; i < 6; i++) {
            Thread t = new Thread(new CountThread(commonResource, locker));
            //Устанавливаем имя треда
            t.setName("Thread " + i);
            t.start();
        }
    }
}

//Общий ресурс
class CommonResource {
    int x = 0;
}

class CountThread implements Runnable {

    CommonResource res;
    ReentrantLock locker;

    CountThread(CommonResource res, ReentrantLock locker) {
        this.res = res;
        this.locker = locker;
    }

    public void run() {

        locker.lock(); // устанавливаем блокировку
        try {
            res.x = 1;
            for (int i = 1; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() +   " Значение переменной = " + res.x);
                res.x++;
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        } finally {
            locker.unlock(); // снимаем блокировку
        }
    }
}
