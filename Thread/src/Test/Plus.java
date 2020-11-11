package Test;

public class Plus extends Thread{

    private Object o = new Object();
    int count;

    public Plus(Object o, int count) {
        this.o = o;
        this.count = count;
    }


    public void run() {
        for (int i = 1000_000; i > 0; i--) {
            synchronized (o) {
                Main.count--;

            }

        }
    }


    public Object getO() {
        return o;
    }
}
