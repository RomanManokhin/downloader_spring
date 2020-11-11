package Locker;

import java.io.*;

public class TheadSearchChet implements Runnable{


    @Override
    public void run() {

        FileInputStream in = null;
        FileOutputStream out = null;

        try {
            in = new FileInputStream(new File("test.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        String fileName = "testChet.txt";
        String fullName = "";
        String dirName = System.getProperty("user.dir");
        fullName = dirName + File.separator + fileName;
        System.out.println("File path : " + fullName);
        File file = new File(fullName);

    }
}
