import java.io.*;


public class ComicDeSerialization {
    public static Object deserialize(String fileName) {
        FileInputStream fis = null;
        Object obj = null;
        try {
            fis = new FileInputStream(fileName);
            ObjectInputStream ois = new ObjectInputStream(fis);
            obj = ois.readObject();
            ois.close();
        } catch (FileNotFoundException ex) {
            System.err.println("File not found:");
            ex.printStackTrace();
        } catch (IOException ex) {
            System.err.println("Input/Output error:");
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            System.err.println("Class not found:");
            ex.printStackTrace();
        } finally {
            try {
                assert fis != null;
                fis.close();
            } catch (IOException ex) {
                System.err.println("Input/Output error:");
                ex.printStackTrace();
            }
        }
        return obj;
    }
}
