package Test;

public class Minus extends Thread {


    private Object o = new Object();
    private int count;

    public Minus(Object o, int count) {
        this.o = o;
        this.count = count;
    }


    public void run() {
        for (int i = 0; i < 1000_000; i++) {
            synchronized (o){
            Main.count++;

            }
        }

    }


    public Object getO() {
        return o;
    }

    public int getCount() {
        return this.count;
    }
}
