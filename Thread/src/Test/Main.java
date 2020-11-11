package Test;

import java.io.PrintWriter;

public class Main{
        public static int count;
    public static void main(String[] args) throws InterruptedException {

        Object o = new Object();

        Minus minus = new Minus(o,count);
        Plus plus = new Plus(o, count);


        minus.start();
        plus.start();
        System.out.println(count);
//        try {
//            minus.join();
//            plus.join();
//        } catch (Exception ex){
//
//        }


    }
}
