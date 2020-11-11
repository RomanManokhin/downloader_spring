package Task02;

public class Tabak implements Runnable {

    final BarMan barMan = new BarMan();
    Print print = new Print();
    @Override
    public void run() {

        synchronized (barMan){
            while (true){
                print.printTabak();
                try {
                    wait(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                print.printPaperFire();
            }
        }

    }
}
