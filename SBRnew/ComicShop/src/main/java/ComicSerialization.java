import java.io.*;

public class ComicSerialization {

    public static void serialize(Object obj, String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))){
            oos.writeObject(obj);
        } catch (FileNotFoundException ex) {
            System.err.println("File not found:");
            ex.printStackTrace();
        } catch (IOException ex) {
            System.err.println("Input/Output error:");
            ex.printStackTrace();
        }
    }
}
