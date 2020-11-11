package Threads04Practice;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, InterruptedException {

        List<String> arrayList = new ArrayList<>();

        FileReader fr = new FileReader("file.txt");
        Scanner in = new Scanner(fr);

        while (in.hasNext()){
            arrayList.add(in.next());
        }
        in.close();
//        System.out.println(arrayList.get(0));
        FindThread findThread = new FindThread(arrayList);

        findThread.start();

        findThread.join();
    }

}
