package Task02;

public class BarMan {

    public static void main(String[] args) {

        Fire fire = new Fire();
        Paper paper = new Paper();
        Tabak tabak = new Tabak();

        Thread thread = new Thread(fire);
        Thread thread1 = new Thread(paper);
        Thread thread2 = new Thread(tabak);

        thread.start();
        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
            thread1.notify();
            thread2.notify();
            thread2.notify();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
