import java.io.File;
import java.util.HashMap;
import java.util.Scanner;

public class DiscountManDay {

    private static HashMap<Integer, Comic> manDay = new HashMap<>();


    static {

        File DiscountManDay = new File("DiscountManDay.txt");
        if (!DiscountManDay.isFile()) {
            Serialization.serializationObject(manDay, "DiscountManDay.txt");
        } else {
            manDay = (HashMap<Integer, Comic>) DeSerialization.deSerialization("DiscountManDay.txt");
        }

    }


    public static void addManDay(int id, ComicBase comicBase) {
        manDay.put(id, comicBase.getComicDB().get(id));
        Serialization.serializationObject(manDay, "DiscountManDay.txt");
    }


    public static boolean deleteManDay() {
        Scanner in = new Scanner(System.in);
        int id;
        do {
            System.out.print("Введите id для удаления: ");
            while (!in.hasNextInt()) {
                System.out.print("Введите id для удаления: ");
                in.next();
            }
            id = in.nextInt();
            if(manDay.containsKey(id)){
                manDay.remove(id);
                Serialization.serializationObject(manDay, "DiscountManDay.txt");
                return true;
            } else {
                return false;
            }
        } while (id <= -1);
    }


    public static void printManDay() {
        System.out.println(DeSerialization.deSerialization("DiscountManDay.txt"));
    }


}
