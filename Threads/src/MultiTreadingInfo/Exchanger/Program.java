package MultiTreadingInfo.Exchanger;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Exchanger;

public class Program {

    public static void main(String[] args) throws InterruptedException {
        //создаём наш класс для буфера
        Exchanger<List<Integer>> ex = new Exchanger<>();
        new Thread(new PutThread(ex)).start();
        new Thread(new GetThread(ex)).start();

    }
}

class PutThread implements Runnable {

    Exchanger<List<Integer>> exchanger;
    List<Integer> message;


    PutThread(Exchanger<List<Integer>> ex) {

        this.exchanger = ex;
        message  = Arrays.asList(1,2,3);
//        message = "Hello Java!";
    }

    public void run() {

        try {
            //вызываем метод который заменяет буферы местами
            message = exchanger.exchange(message);
            System.out.println("PutThread has received: " + message);
        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }
    }
}

class GetThread implements Runnable {

    Exchanger<List<Integer>> exchanger;
    List<Integer> message;

    GetThread(Exchanger<List<Integer>> ex) {

        this.exchanger = ex;
        message  = Arrays.asList(4,5,6);
    }

    public void run() {

        try {
            //вызываем метод который заменяет буферы местами
            message = exchanger.exchange(message);
            System.out.println("GetThread has received: " + message);
        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }
    }
}