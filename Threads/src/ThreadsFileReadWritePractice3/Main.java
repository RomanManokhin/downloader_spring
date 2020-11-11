package ThreadsFileReadWritePractice3;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class Main {
    public static void main(String[] args) throws InterruptedException, IOException {

        FileReader fr = new FileReader("file.txt");


        List<Integer> arrayList = new ArrayList<>();
        Scanner in = new Scanner(fr);
        while (in.hasNextInt()){
            arrayList.add(in.nextInt());
        }


        ThreadSearchChet chet = new ThreadSearchChet(arrayList);
        TheadSearchNeChet neChet = new TheadSearchNeChet(arrayList);
        Thread thread1 = new Thread(chet);
        Thread thread2 = new Thread(neChet);


//        arrayList.forEach(System.out::println);
        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();

        } catch (Exception e){

        }

    }
}
