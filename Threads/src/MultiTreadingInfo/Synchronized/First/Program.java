package MultiTreadingInfo.Synchronized.First;

public class Program {

    public static void main(String[] args) {

        CommonResource commonResource = new CommonResource();
        for (int i = 1; i < 6; i++) {

            Thread t = new Thread(new CountThread(commonResource));
            t.setName("Thread " + i);
            t.start();
        }
    }
}

//Здесь определен класс CommonResource, который представляет
//общий ресурс и в котором определено одно целочисленное поле x.
class CommonResource {
    int x = 0;
}

class CountThread implements Runnable {

    CommonResource res;

    CountThread(CommonResource res) {
        this.res = res;
    }

    public void run() {
        //производим синхронизацию через обеъект res, что бы 5 потоков не мешали друг другу
        synchronized (res) {
            //Этот ресурс используется классом потока CountThread.
            // Этот класс просто увеличивает в цикле значение x на единицу.
            // Причем при входе в поток значение x=1:
            res.x = 1;
            for (int i = 1; i < 5; i++) {
                System.out.printf("%s %d \n", Thread.currentThread().getName(), res.x);
                res.x++;
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                }
            }
        }
    }
}
