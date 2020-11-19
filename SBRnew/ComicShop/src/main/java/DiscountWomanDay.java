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
        comicBase.getComicDB().get(id).setPriceForSale((int) (comicBase.getComicDB().get(id).getPriceForSale() / 100 * 80));
        womanDay.put(id, comicBase.getComicDB().get(id));
        Serialization.serializationObject(womanDay, "DiscountWomanDay.txt");
        Serialization.serializationObject(comicBase.getComicDB(), "ComicDB.txt");
    }

    public static boolean deleteWomanDay(ComicBase comicBase) {
        Scanner in = new Scanner(System.in);
        int id;
        do {
            System.out.print("Введите id для удаления: ");
            while (!in.hasNextInt()) {
                System.out.print("Введите id для удаления: ");
                in.next();
            }
            id = in.nextInt();
            if (womanDay.containsKey(id)) {
//                comicBase.getComicDB().get(id).setPriceForSale((int) (comicBase.getComicDB().get(id).getPriceForSale() / 100 * 80));
                womanDay.remove(id);
                Serialization.serializationObject(womanDay, "DiscountWomanDay.txt");
                Serialization.serializationObject(comicBase.getComicDB(),"ComicDB.txt");
                return true;
            } else {
                return false;
            }
        } while (id <= -1);
    }

    public static void printWomanDay() {
        System.out.println("Акция к 8 марта:\n" + DeSerialization.deSerialization("DiscountWomanDay.txt"));
    }

}
