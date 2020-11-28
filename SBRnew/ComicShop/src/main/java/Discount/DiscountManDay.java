package Discount;


import Bases.Comic;
import Bases.ComicBase;
import Serrialization.Serialization;

import java.io.File;
import java.util.HashMap;
import java.util.Scanner;

public class DiscountManDay {

    private HashMap<Integer, Comic> manDay = new HashMap<>();
    Serialization serialization = new Serialization();

    public void InitDiscountManDay(ComicBase comicBase){
        File DiscountManDay = new File("Discount.DiscountManDay.txt");
        if (!DiscountManDay.isFile()) {
            manDay.put(7, comicBase.getComicDB().get(7));
            manDay.put(6, comicBase.getComicDB().get(6));
            manDay.put(9, comicBase.getComicDB().get(9));
           serialization.serialization(manDay, "Discount.DiscountManDay.txt");
        } else {
            manDay = (HashMap<Integer, Comic>) serialization.deSerialization("Discount.DiscountManDay.txt");
        }
    }

    public void addManDay(int id, ComicBase comicBase) {
        manDay.put(id, comicBase.getComicDB().get(id));
        serialization.serialization(manDay, "Discount.DiscountManDay.txt");
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
                manDay.remove(id);
                serialization.serialization(manDay, "Discount.DiscountManDay.txt");
                return true;
            } else {
                return false;
            }
        } while (id <= -1);
    }


    public void printManDay() {
        System.out.println("Акции 23 февраля:\n" + serialization.deSerialization("Discount.DiscountManDay.txt"));
    }
}
