package Task02;

public class Paper implements Runnable {

    BarMan barMan = new BarMan();
    Print print = new Print();
    @Override
    public void run() {

        synchronized (barMan){
            while (true){
                print.printPaper();
                try {
                    wait(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                print.printFireTabak();
            }
        }

    }
}
