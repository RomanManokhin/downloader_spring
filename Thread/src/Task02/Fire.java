package Task02;

public class Fire implements Runnable {

    BarMan barMan = new BarMan();
    Print print = new Print();
    @Override
    public void run() {
        try {
            wait();
            synchronized (barMan){
                while (true){
                    print.printFire();
                    wait(1000);
                    print.printPaperTabak();
                }
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
