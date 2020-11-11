package MultiTreading.BaseGenerateThreads.ImplementsRunnable;

public class MyFirstThreadImplements implements Runnable {



    @Override
    public void run() {
        System.out.printf("%s started... \n", Thread.currentThread().getName());
//        System.out.println("I'm thread! my name is " + getName());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("%s finish... \n", Thread.currentThread().getName());

    }

}
