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
    public void InitDiscountWomanDay() {
        File DiscountWomanDay = new File("Discount.DiscountWomanDay.txt");
        if (!DiscountWomanDay.isFile()) {
            serialization.serialization(womanDay, "Discount.DiscountWomanDay.txt");
        } else {
            womanDay = (HashMap<Integer, Comic>) serialization.deSerialization("Discount.DiscountWomanDay.txt");
        }
    }

    public void addWomanDay(int id, ComicBase comicBase) {
        comicBase.getComicDB().get(id).setPriceForSale((int) (comicBase.getComicDB().get(id).getPriceForSale() / 100 * 80));
        womanDay.put(id, comicBase.getComicDB().get(id));
        serialization.serialization(womanDay, "Discount.DiscountWomanDay.txt");
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
                serialization.serialization(womanDay, "Discount.DiscountWomanDay.txt");
                serialization.serialization(comicBase.getComicDB(),"ComicDB.txt");
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
