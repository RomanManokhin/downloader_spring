import java.io.File;
import java.util.HashMap;
import java.util.Scanner;

public class DiscountNewYear {

    private static HashMap<Integer, Comic> newYear = new HashMap<>();


    static {
        File DiscountNewYear = new File("DiscountNewYear.txt");

        if (!DiscountNewYear.isFile()) {
            Serialization.serializationObject(newYear, "DiscountNewYear.txt");
        } else {
            newYear = (HashMap<Integer, Comic>) DeSerialization.deSerialization("DiscountNewYear.txt");
        }


    }

    public static void addNewYear(int id, ComicBase comicBase) {
        newYear.put(id, comicBase.getComicDB().get(id));
        comicBase.getComicDB().get(id).setPriceForSale((int) (comicBase.getComicDB().get(id).getPriceForSale() / 100 * 80));
        Serialization.serializationObject(newYear, "DiscountNewYear.txt");
    }


    public static boolean deleteNewYear() {
        Scanner in = new Scanner(System.in);
        int id;
        do {
            System.out.print("Введите id для удаления: ");
            while (!in.hasNextInt()) {
                System.out.print("Введите id для удаления: ");
                in.next();
            }
            id = in.nextInt();
            if(newYear.containsKey(id)){
                newYear.remove(id);
                Serialization.serializationObject(newYear, "DiscountNewYear.txt");
                return true;
            } else {
                return false;
            }
        } while (id <= -1);
    }

    public static void printNewYear(){
        System.out.println(DeSerialization.deSerialization("DiscountNewYear.txt"));
    }







}
