import java.io.File;
import java.util.HashMap;
import java.util.Scanner;

public class DiscountManDay {

    private HashMap<Integer, Comic> manDay = new HashMap<>();
    Serialization serialization = new Serialization();
    DeSerialization deSerialization = new DeSerialization();

    void InitDiscountManDay(){
        File DiscountManDay = new File("DiscountManDay.txt");
        if (!DiscountManDay.isFile()) {
           serialization.serialization(manDay, "DiscountManDay.txt");
        } else {
            manDay = (HashMap<Integer, Comic>) deSerialization.deSerialization("DiscountManDay.txt");
        }
    }

    public void addManDay(int id, ComicBase comicBase) {
        comicBase.getComicDB().get(id).setPriceForSale((int) (comicBase.getComicDB().get(id).getPriceForSale() / 100 * 80));
        manDay.put(id, comicBase.getComicDB().get(id));
        serialization.serialization(manDay, "DiscountManDay.txt");
        serialization.serialization(comicBase.getComicDB(),"ComicDB.txt");
    }

    public boolean deleteManDay(ComicBase comicBase) {
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
                serialization.serialization(manDay, "DiscountManDay.txt");
                serialization.serialization(comicBase.getComicDB(),"ComicDB.txt");
                return true;
            } else {
                return false;
            }
        } while (id <= -1);
    }


    public void printManDay() {
        System.out.println("Акции 23 февраля:\n" + deSerialization.deSerialization("DiscountManDay.txt"));
    }


}
