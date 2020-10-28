import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ComicSerialization {

    public static void serialize(Object obj, String fileName) {
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(fileName);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(obj);
            oos.flush();
            fos.close();
        } catch (FileNotFoundException ex) {
            System.err.println("File not found:");
            ex.printStackTrace();
        } catch (IOException ex) {
            System.err.println("Input/Output error:");
            ex.printStackTrace();
        } finally {
            try {
                assert fos != null;
                fos.close();
            } catch (IOException ex) {
                System.err.println("Input/Output error:");
                ex.printStackTrace();
            }
        }

    }
}
