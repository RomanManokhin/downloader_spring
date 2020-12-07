package discount;

import bases.Comic;
import bases.ComicBase;
import serrialization.Serialization;

import java.io.File;
import java.util.*;

public class DiscountBase {

    private SortedMap<Integer, Comic> newYear = new TreeMap<>();
    private SortedMap<Integer, Comic> womenDay = new TreeMap<>();
    private SortedMap<Integer, Comic> manDay = new TreeMap<>();
    Serialization serialization = new Serialization();


    public void init(ComicBase comicBase) {

        File DiscountNewYear = new File("DiscountNewYear.txt");
        if (!DiscountNewYear.isFile()) {
            newYear.put(1, comicBase.getComicDB().get(2));
            newYear.get(1).setPriceForSale(newYear.get(1).getPriceForSale() - (newYear.get(1).getPriceForSale() * 20 / 100));
            newYear.put(2, comicBase.getComicDB().get(3));
            newYear.get(2).setPriceForSale(newYear.get(2).getPriceForSale() - (newYear.get(2).getPriceForSale() * 20 / 100));
            newYear.put(3, comicBase.getComicDB().get(4));
            newYear.get(3).setPriceForSale(newYear.get(3).getPriceForSale() - (newYear.get(3).getPriceForSale() * 20 / 100));
            serialization.serialization(newYear, "DiscountNewYear.txt");
        } else {
            newYear = (SortedMap<Integer, Comic>) serialization.deSerialization("DiscountNewYear.txt");
        }

        File DiscountWomenDay = new File("DiscountManDay.txt");
        if (!DiscountWomenDay.isFile()) {
            manDay.put(10, comicBase.getComicDB().get(5));
            manDay.put(11, comicBase.getComicDB().get(5));
            manDay.put(12, comicBase.getComicDB().get(5));
            serialization.serialization(manDay, "DiscountManDay.txt");
        } else {
            manDay = (SortedMap<Integer, Comic>) serialization.deSerialization("DiscountManDay.txt");
        }

        File DiscountManDay = new File("DiscountWomenDay.txt");
        if (!DiscountManDay.isFile()) {
            womenDay.put(5, comicBase.getComicDB().get(5));
            womenDay.put(6, comicBase.getComicDB().get(5));
            womenDay.put(7, comicBase.getComicDB().get(5));
            serialization.serialization(womenDay, "DiscountWomenDay.txt");
        } else {
            womenDay = (SortedMap<Integer, Comic>) serialization.deSerialization("DiscountWomenDay.txt");
        }
    }

    public boolean addDiscount(int choice, int id, ComicBase comicBase) {

        if (newYear.containsKey(id) || womenDay.containsKey(id) || manDay.containsKey(id)) {
            return false;
        } else {
            if (choice == 1) {
                newYear.put(id, comicBase.getComicDB().get(id));
//                newYear.get(id).setPriceForSale(newYear.get(id).getPriceForSale() - newYear.get(id).getPriceForSale() * 20 / 100);
                serialization.serialization(newYear, "DiscountNewYear.txt");
                return true;
            } else if (choice == 2) {
                womenDay.put(id, comicBase.getComicDB().get(id));
                womenDay.get(id).setPriceForSale(womenDay.get(id).getPriceForSale() - womenDay.get(id).getPriceForSale() * 20 / 100);
                serialization.serialization(womenDay, "DiscountWomenDay.txt");
                return true;
            } else {
                manDay.put(id, comicBase.getComicDB().get(id));
                manDay.get(id).setPriceForSale(manDay.get(id).getPriceForSale() - manDay.get(id).getPriceForSale() * 20 / 100);
                serialization.serialization(manDay, "DiscountManDay.txt");
                return true;
            }
        }
    }

    public boolean deleteDiscount(int choice, int id) {
        if (choice == 1) {
            if (newYear.containsKey(id)) {
                newYear.remove(id);
                serialization.serialization(newYear, "DiscountNewYear.txt");
                return true;
            } else {
                return false;
            }
        } else if (choice == 2) {
            if (womenDay.containsKey(id)) {
                womenDay.remove(id);
                serialization.serialization(womenDay, "DiscountWomenDay.txt");
                return true;
            } else {
                return false;
            }
        } else {
            if (manDay.containsKey(id)) {
                manDay.remove(id);
                serialization.serialization(manDay, "DiscountManDay.txt");
                return true;
            } else {
                return false;
            }
        }
    }

    public SortedMap<Integer, Comic> printDiscountNewYear() {
        Double price = 0d;
        Iterator iterator = newYear.keySet().iterator();
        while (iterator.hasNext()) {
            Integer key = (Integer) iterator.next();
            price = newYear.get(key).getPriceForSale();
            Double newPrice = price - price * 20 / 100;
        }

        return newYear;
    }

    public SortedMap<Integer, Comic> printDiscountWomenDay() {
        SortedMap<Integer, Comic> cache = womenDay;
        for (Map.Entry<Integer, Comic> entry : cache.entrySet()) {
            entry.getValue().setPriceForSale(entry.getValue().getPriceForSale() -
                    (entry.getValue().getPriceForSale() * 20 / 100));
        }
        return womenDay;
    }


    public SortedMap<Integer, Comic> printDiscountManDay() {
        SortedMap<Integer, Comic> cache = manDay;
        for (Map.Entry<Integer, Comic> entry : cache.entrySet()) {
            entry.getValue().setPriceForSale(entry.getValue().getPriceForSale() -
                    (entry.getValue().getPriceForSale() * 20 / 100));

        }
        return manDay;
    }

    public SortedMap<Integer, Comic> getNewYear() {
        return newYear;
    }

    public void setNewYear(SortedMap<Integer, Comic> newYear) {
        this.newYear = newYear;
    }

    public SortedMap<Integer, Comic> getWomenDay() {
        return womenDay;
    }

    public void setWomenDay(SortedMap<Integer, Comic> womenDay) {
        this.womenDay = womenDay;
    }

    public SortedMap<Integer, Comic> getManDay() {
        return manDay;
    }

    public void setManDay(SortedMap<Integer, Comic> manDay) {
        this.manDay = manDay;
    }


}
