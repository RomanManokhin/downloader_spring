package MultiTreading.CloseThread.BaseClose;

public class Main {
    public static void main(String[] args) {

        System.out.println("Main thread started...");
        MyThread myThread = new MyThread();

        new Thread(myThread, "MyThread");
        try {
            Thread.sleep(1100);

            myThread.disable();

            Thread.sleep(1000);

        } catch (InterruptedException e) {
            System.out.println("Thread has been interrupted");
        }
        System.out.println("Main thread finished...");
    }
}
