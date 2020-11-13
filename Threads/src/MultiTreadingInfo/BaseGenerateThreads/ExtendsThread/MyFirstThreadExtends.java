package MultiTreadingInfo.BaseGenerateThreads.ExtendsThread;

public class MyFirstThreadExtends implements Runnable{



    public void run(){
        System.out.printf("%s started... \n", Thread.currentThread().getName());

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("%s finish... \n", Thread.currentThread().getName());

    }

}
