import java.io.File;
import java.util.HashMap;
import java.util.Scanner;

public class DiscountWomanDay {


    private HashMap<Integer, Comic> womanDay = new HashMap<>();
    Serialization serialization = new Serialization();
    DeSerialization deSerialization = new DeSerialization();
    void InitDiscountWomanDay() {
        File DiscountWomanDay = new File("DiscountWomanDay.txt");
        if (!DiscountWomanDay.isFile()) {
            serialization.serialization(womanDay, "DiscountWomanDay.txt");
        } else {
            womanDay = (HashMap<Integer, Comic>) deSerialization.deSerialization("DiscountWomanDay.txt");
        }
    }

    public void addWomanDay(int id, ComicBase comicBase) {
        comicBase.getComicDB().get(id).setPriceForSale((int) (comicBase.getComicDB().get(id).getPriceForSale() / 100 * 80));
        womanDay.put(id, comicBase.getComicDB().get(id));
        serialization.serialization(womanDay, "DiscountWomanDay.txt");
        serialization.serialization(comicBase.getComicDB(), "ComicDB.txt");
    }

    public boolean deleteWomanDay(ComicBase comicBase) {
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
                serialization.serialization(womanDay, "DiscountWomanDay.txt");
                serialization.serialization(comicBase.getComicDB(),"ComicDB.txt");
                return true;
            } else {
                return false;
            }
        } while (id <= -1);
    }

    public void printWomanDay() {
        System.out.println("Акция к 8 марта:\n" + deSerialization.deSerialization("DiscountWomanDay.txt"));
    }

}
