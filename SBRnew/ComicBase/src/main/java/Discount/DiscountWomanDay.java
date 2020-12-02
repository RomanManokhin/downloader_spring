package Discount;

import Bases.Comic;
import Bases.ComicBase;
import Serrialization.Serialization;

import java.io.File;
import java.util.HashMap;
import java.util.Scanner;

public class DiscountWomanDay {


    private HashMap<Integer, Comic> womanDay = new HashMap<>();
    Serialization serialization = new Serialization();
    public void InitDiscountWomanDay(ComicBase comicBase) {
        File DiscountWomanDay = new File("Discount.DiscountWomanDay.txt");
        if (!DiscountWomanDay.isFile()) {
            womanDay.put(13, comicBase.getComicDB().get(13));
            womanDay.put(12, comicBase.getComicDB().get(12));
            womanDay.put(11, comicBase.getComicDB().get(11));
            serialization.serialization(womanDay, "Discount.DiscountWomanDay.txt");
        } else {
            womanDay = (HashMap<Integer, Comic>) serialization.deSerialization("Discount.DiscountWomanDay.txt");
        }
    }

    public void addWomanDay(int id, ComicBase comicBase) {
        womanDay.put(id, comicBase.getComicDB().get(id));
        serialization.serialization(womanDay, "Discount.DiscountWomanDay.txt");
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
                womanDay.remove(id);
                serialization.serialization(womanDay, "Discount.DiscountWomanDay.txt");
                return true;
            } else {
                return false;
            }
        } while (id <= -1);
    }

    public void printWomanDay() {
        System.out.println("Акция к 8 марта:\n" + serialization.deSerialization("Discount.DiscountWomanDay.txt"));
    }

}
