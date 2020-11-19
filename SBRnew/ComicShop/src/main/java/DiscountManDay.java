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
        comicBase.getComicDB().get(id).setPriceForSale((int) (comicBase.getComicDB().get(id).getPriceForSale() / 100 * 80));
        manDay.put(id, comicBase.getComicDB().get(id));
        Serialization.serializationObject(manDay, "DiscountManDay.txt");
        Serialization.serializationObject(comicBase.getComicDB(),"ComicDB.txt");
    }


    public static boolean deleteManDay(ComicBase comicBase) {
        Scanner in = new Scanner(System.in);
        int id;
        do {
            System.out.print("Введите id для удаления: ");
            while (!in.hasNextInt()) {
                System.out.print("Введите id для удаления: ");
                in.next();
            }
            id = in.nextInt();
            if (manDay.containsKey(id)) {
//                comicBase.getComicDB().get(id).setPriceForSale((comicBase.getComicDB().get(id).getPriceForSale() / 100 * 80));
                manDay.remove(id);
                Serialization.serializationObject(manDay, "DiscountManDay.txt");
                Serialization.serializationObject(comicBase.getComicDB(),"ComicDB.txt");
                return true;
            } else {
                return false;
            }
        } while (id <= -1);
    }


    public static void printManDay() {
        System.out.println("Акции 23 февраля:\n" + DeSerialization.deSerialization("DiscountManDay.txt"));
    }


}
