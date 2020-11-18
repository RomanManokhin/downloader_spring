import java.io.File;
import java.util.HashMap;
import java.util.Scanner;

public class DiscountWomanDay {


    private static HashMap<Integer, Comic> womanDay = new HashMap<>();



    static {

        File DiscountWomanDay = new File("DiscountWomanDay.txt");
        if (!DiscountWomanDay.isFile()) {
            Serialization.serializationObject(womanDay, "DiscountWomanDay.txt");
        } else {
            womanDay = (HashMap<Integer, Comic>) DeSerialization.deSerialization("DiscountWomanDay.txt");
        }
    }

    public static void addWomanDay(int id, ComicBase comicBase) {
        womanDay.put(id, comicBase.getComicDB().get(id));
        Serialization.serializationObject(womanDay, "DiscountWomanDay.txt");
    }

    public static boolean deleteWomanDay() {
        Scanner in = new Scanner(System.in);
        int id;
        do {
            System.out.print("Введите id для удаления: ");
            while (!in.hasNextInt()) {
                System.out.print("Введите id для удаления: ");
                in.next();
            }
            id = in.nextInt();
            if(womanDay.containsKey(id)){
                womanDay.remove(id);
                Serialization.serializationObject(womanDay, "DiscountWomanDay.txt");
                return true;
            } else {
                return false;
            }
        } while (id <= -1);
    }

    public static void printWomanDay() {
        System.out.println(DeSerialization.deSerialization("DiscountWomanDay.txt"));
    }

}
