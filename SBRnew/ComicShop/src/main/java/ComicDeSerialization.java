import java.io.*;
import java.util.SortedMap;


public class ComicDeSerialization {
    public static Object deserialize(String fileName) {
        Object obj = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            obj = ois.readObject();
        } catch (FileNotFoundException ex) {
            System.err.println("File not found:");
            ex.printStackTrace();
        } catch (IOException ex) {
            System.err.println("Input/Output error:");
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            System.err.println("Class not found:");
            ex.printStackTrace();
        }
        return obj;
    }
}
