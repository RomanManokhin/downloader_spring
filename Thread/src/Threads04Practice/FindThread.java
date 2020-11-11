package Threads04Practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FindThread extends Thread{

    List<String> arrayList = new ArrayList();

    public FindThread(List<String> arrayList) {
        this.arrayList = arrayList;
    }

    @Override
    public void run() {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        arrayList.forEach(o -> {
            if(o.equals(s)) System.out.println("Yes");
        });


    }
}
