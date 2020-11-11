package Locker;

import java.io.File;

public class TheadSearchNeChet implements Runnable {


    @Override
    public void run() {

        String fileName = "testNeChet.txt";
        String fullName = "";
        String dirName = System.getProperty("user.dir");
        fullName = dirName + File.separator + fileName;
        System.out.println("File path : " + fullName);
        File file = new File(fullName);

    }
}
