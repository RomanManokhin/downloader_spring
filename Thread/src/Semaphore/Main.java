package Semaphore;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class Main extends Thread {
    public static void main(String[] args) {
        //создаём семафор
        Semaphore semaphore = new Semaphore(4);

        // создаём locker для синхронизации
        Object locker = new Object();
        //создаём ссылку на массив
        List<Integer> arrayList = new ArrayList<>();

        //создаём сразу несколько потоков
        for (int i = 0; i < 10; i++) {
            ThreedOne threedOne = new ThreedOne(locker,arrayList, semaphore);
            ThreedTwo threedTwo = new ThreedTwo(locker,arrayList, semaphore);

            threedOne.start();
            threedTwo.start();

        }


//        создаём  потока
        ArrayThread arrayThread = new ArrayThread(locker,arrayList);

        ThreedOne threedOne = new ThreedOne(locker,arrayList);

        ThreedTwo threedTwo = new ThreedTwo(locker,arrayList);

//        старт потоков
        arrayThread.start();

        threedOne.start();

        threedTwo.start();

        try {
            //остановка потоков
            arrayThread.join();
            threedOne.join();
            threedTwo.join();
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }

    }
}
