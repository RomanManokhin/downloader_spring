package discount;

import bases.Comic;
import bases.ComicBase;
import one.util.streamex.StreamEx;
import serrialization.Serialization;

import java.io.File;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DiscountBase {

    private LinkedHashMap<Integer, Comic> newYear = new LinkedHashMap<>();
    private LinkedHashMap<Integer, Comic> womenDay = new LinkedHashMap<>();
    private LinkedHashMap<Integer, Comic> manDay = new LinkedHashMap<>();
    Serialization serialization = new Serialization();


    public void init(ComicBase comicBase) {

        File DiscountNewYear = new File("DiscountNewYear.txt");
        if (!DiscountNewYear.isFile()) {
            newYear.put(1, comicBase.getComicDB().get(1));
            newYear.put(2, comicBase.getComicDB().get(2));
            newYear.put(3, comicBase.getComicDB().get(3));
            serialization.serialization(newYear, "DiscountNewYear.txt");
        } else {
            newYear = (LinkedHashMap<Integer, Comic>) serialization.deSerialization("DiscountNewYear.txt");
        }

        File DiscountWomenDay = new File("DiscountManDay.txt");
        if (!DiscountWomenDay.isFile()) {
            manDay.put(10, comicBase.getComicDB().get(10));
            manDay.put(11, comicBase.getComicDB().get(11));
            manDay.put(12, comicBase.getComicDB().get(12));
            serialization.serialization(manDay, "DiscountManDay.txt");
        } else {
            manDay = (LinkedHashMap<Integer, Comic>) serialization.deSerialization("DiscountManDay.txt");
        }

        File DiscountManDay = new File("DiscountWomenDay.txt");
        if (!DiscountManDay.isFile()) {
            womenDay.put(5, comicBase.getComicDB().get(5));
            womenDay.put(6, comicBase.getComicDB().get(6));
            womenDay.put(7, comicBase.getComicDB().get(7));
            serialization.serialization(womenDay, "DiscountWomenDay.txt");
        } else {
            womenDay = (LinkedHashMap<Integer, Comic>) serialization.deSerialization("DiscountWomenDay.txt");
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
//                womenDay.get(id).setPriceForSale(womenDay.get(id).getPriceForSale() - womenDay.get(id).getPriceForSale() * 20 / 100);
                serialization.serialization(womenDay, "DiscountWomenDay.txt");
                return true;
            } else {
                manDay.put(id, comicBase.getComicDB().get(id));
//                manDay.get(id).setPriceForSale(manDay.get(id).getPriceForSale() - manDay.get(id).getPriceForSale() * 20 / 100);
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

    public void printDiscountNewYear() {
        for (Map.Entry<Integer, Comic> entry : newYear.entrySet()) {
            System.out.println(entry.getKey() + ": Название комикса - " + entry.getValue().getNameComic() + '\'' +
                    ", имя автора -'" + entry.getValue().getNameAuthor() + '\'' +
                    ", страницы - " + entry.getValue().getNumberOfPages() +
                    ", жанр -'" + entry.getValue().getGenre() + '\'' +
                    ", год выпуска - " + entry.getValue().getYearOfPublishing() +
                    ", цена продажи - " + (entry.getValue().getPriceForSale() - entry.getValue().getPriceForSale() * 20 / 100) +
                    ", вселенная - " + entry.getValue().getComicSeries() + '\'' +
                    ", количество экземпляров - " + entry.getValue().getNumberOfComic());
        }
    }

    public void printDiscountWomenDay() {
        for (Map.Entry<Integer, Comic> entry : womenDay.entrySet()) {
            System.out.println(entry.getKey() + ": Название комикса - " + entry.getValue().getNameComic() + '\'' +
                    ", имя автора -'" + entry.getValue().getNameAuthor() + '\'' +
                    ", страницы - " + entry.getValue().getNumberOfPages() +
                    ", жанр -'" + entry.getValue().getGenre() + '\'' +
                    ", год выпуска - " + entry.getValue().getYearOfPublishing() +
                    ", цена продажи - " + (entry.getValue().getPriceForSale() - entry.getValue().getPriceForSale() * 20 / 100) +
                    ", вселенная - " + entry.getValue().getComicSeries() + '\'' +
                    ", количество экземпляров - " + entry.getValue().getNumberOfComic());
        }
    }


    public void printDiscountManDay() {
        for (Map.Entry<Integer, Comic> entry : manDay.entrySet()) {
            System.out.println(entry.getKey() + ": Название комикса - " + entry.getValue().getNameComic() + '\'' +
                    ", имя автора -'" + entry.getValue().getNameAuthor() + '\'' +
                    ", страницы - " + entry.getValue().getNumberOfPages() +
                    ", жанр -'" + entry.getValue().getGenre() + '\'' +
                    ", год выпуска - " + entry.getValue().getYearOfPublishing() +
                    ", цена продажи - " + (entry.getValue().getPriceForSale() - entry.getValue().getPriceForSale() * 20 / 100) +
                    ", вселенная - " + entry.getValue().getComicSeries() + '\'' +
                    ", количество экземпляров - " + entry.getValue().getNumberOfComic());
        }

    }

    public LinkedHashMap<Integer, Comic> getNewYear() {
        return newYear;
    }

    public void setNewYear(LinkedHashMap<Integer, Comic> newYear) {
        this.newYear = newYear;
    }

    public LinkedHashMap<Integer, Comic> getWomenDay() {
        return womenDay;
    }

    public void setWomenDay(LinkedHashMap<Integer, Comic> womenDay) {
        this.womenDay = womenDay;
    }

    public LinkedHashMap<Integer, Comic> getManDay() {
        return manDay;
    }

    public void setManDay(LinkedHashMap<Integer, Comic> manDay) {
        this.manDay = manDay;
    }


}
