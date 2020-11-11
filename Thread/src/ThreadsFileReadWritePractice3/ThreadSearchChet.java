package ThreadsFileReadWritePractice3;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ThreadSearchChet implements Runnable {


    List<Integer> arrayList = new ArrayList<>();

    public ThreadSearchChet(List<Integer> arrayList) {
        this.arrayList = arrayList;
    }

    public List<Integer> getArrayList() {
        return arrayList;
    }

    public void setArrayList(List<Integer> arrayList) {
        this.arrayList = arrayList;
    }

    @Override
    public void run() {
        try {
            FileWriter fw = new FileWriter("testChet.txt");

            for (int i = 0; i < arrayList.size(); i++) {
                if (arrayList.get(i) % 2 == 0) {
                    fw.write(arrayList.get(i) + "\n");

                }
            }
            fw.flush();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}
