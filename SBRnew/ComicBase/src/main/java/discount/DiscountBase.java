package discount;

import Bases.Comic;
import Bases.ComicBase;
import Serrialization.Serialization;

import java.io.File;
import java.util.SortedMap;
import java.util.TreeMap;

public class DiscountBase {

    private SortedMap<Integer, Comic> newYear = new TreeMap<>();
    private SortedMap<Integer, Comic> womenDay = new TreeMap<>();
    private SortedMap<Integer, Comic> manDay = new TreeMap<>();

    Serialization serialization = new Serialization();

    public void init(ComicBase comicBase) {

        File DiscountNewYear = new File("DiscountNewYear.txt");
        if (!DiscountNewYear.isFile()) {
            newYear.put(1, comicBase.getComicDB().get(2));
            newYear.put(2, comicBase.getComicDB().get(3));
            newYear.put(3, comicBase.getComicDB().get(4));
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
                serialization.serialization(newYear, "DiscountNewYear.txt");
                return true;
            } else if (choice == 2) {
                womenDay.put(id, comicBase.getComicDB().get(id));
                serialization.serialization(womenDay, "DiscountWomenDay.txt");
                return true;
            } else {
                manDay.put(id, comicBase.getComicDB().get(id));
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

    void printDiscount() {
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("Акции: ");
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("Новый год:");
        System.out.println(serialization.deSerialization("DiscountNewYear.txt"));
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("8 Марта:");
        System.out.println(serialization.deSerialization("DiscountWomenDay.txt"));
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("23 Февраля:");
        System.out.println(serialization.deSerialization("DiscountManDay.txt"));
        System.out.println("------------------------------------------------------------------------------------");
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
