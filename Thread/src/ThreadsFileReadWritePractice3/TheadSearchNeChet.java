package ThreadsFileReadWritePractice3;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class TheadSearchNeChet implements Runnable {


    List<Integer> arrayList = new ArrayList<>();

    public TheadSearchNeChet(List<Integer> arrayList) {
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
            FileWriter fw = new FileWriter("testNeChet.txt");


            arrayList.forEach(o -> {
                if(o % 2 != 0){
                    try {
                        fw.write(o + "\n");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            });



            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
