package Discount;

import Bases.Comic;
import Bases.ComicBase;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PopularityComic {

    private HashMap<Comic, ArrayList<LocalDate>> popular = new HashMap<>();

    public void initPopularity(ComicBase comicBase) {
        ArrayList<LocalDate> first = new ArrayList<>(
                Arrays.asList(LocalDate.of(2020, 5, 3),
//                        LocalDate.of(2020, 5, 4),
                        LocalDate.of(2020, 5, 5)));

        ArrayList<LocalDate> second = new ArrayList<>(
                Arrays.asList(LocalDate.of(2020, 1, 3),
                        LocalDate.of(2020, 2, 4),
                        LocalDate.of(2020, 3, 5)));

        ArrayList<LocalDate> third = new ArrayList<>(
                Arrays.asList(LocalDate.of(2020, 10, 3),
                        LocalDate.of(2020, 10, 4),
                        LocalDate.of(2020, 10, 5)));


        popular.put(comicBase.getComicDB().get(1), first);
        popular.put(comicBase.getComicDB().get(2), second);
        popular.put(comicBase.getComicDB().get(3), third);
    }

    public void addComicToPopular(int id, ComicBase comicBase, LocalDate newDate) {
        if (!popular.containsKey(comicBase.getComicDB().get(id))) {
            ArrayList<LocalDate> dates = new ArrayList<>();
            dates.add(newDate);
            popular.put(comicBase.getComicDB().get(id), dates);
            return;
        }
        popular.get(comicBase.getComicDB().get(id)).add(newDate);
    }

    public void printYear(){
//        popular.forEach((key, value) -> System.out.println(key + " : " + (long) value.size()));
        for(Map.Entry<Comic, ArrayList<LocalDate>> entry : popular.entrySet()){
            if(entry.getValue().size() >= 50){
                System.out.println(entry.getKey());
            }
        }
    }

    public void printBestOfMonth(ComicBase comicBase) {

//        popular.entrySet().stream();
        for (int i = 0; i < popular.size(); i++) {


         Stream x =  popular.get(comicBase.getComicDB().get(i+1))
                    .stream().collect(Collectors.toSet())
                    .stream().collect((Collectors.groupingBy(LocalDate::getMonth, Collectors.counting())))
                    .entrySet().stream()
                    .filter(k -> k.getValue() >= 2);
//                    .forEach(k -> System.out.println(popular.get(comicBase.getComicDB().get(i+1))+ "" + k.getValue()));

        }

    }


    public HashMap<Comic, ArrayList<LocalDate>> getPopular() {
        return popular;
    }

    public void setPopular(HashMap<Comic, ArrayList<LocalDate>> popular) {
        this.popular = popular;
    }
}
