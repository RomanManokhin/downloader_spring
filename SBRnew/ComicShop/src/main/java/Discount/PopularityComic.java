package Discount;

import Bases.Comic;
import Bases.ComicBase;

import java.time.*;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class PopularityComic {

    private LinkedHashMap<Comic, ArrayList<LocalDate>> popular = new LinkedHashMap<>();


    public void initPopularity(ComicBase comicBase) {
        ArrayList<LocalDate> yearTest = new ArrayList<>(
                Arrays.asList(LocalDate.of(2020, 10, 3),
                        LocalDate.of(2020, 11, 22),
                        LocalDate.of(2020, 12, 22),
                        LocalDate.of(2020, 3, 22),
                        LocalDate.of(2020, 1, 22),
                        LocalDate.of(2020, 1, 22),
                        LocalDate.of(2020, 1, 22),
                        LocalDate.of(2020, 1, 22),
                        LocalDate.of(2020, 6, 22),
                        LocalDate.of(2020, 7, 4),
                        LocalDate.of(2020, 5, 4),
                        LocalDate.of(2020, 5, 4),
                        LocalDate.of(2020, 12, 5)));

        ArrayList<LocalDate> monthTest = new ArrayList<>(
                Arrays.asList(LocalDate.of(2020, LocalDate.now().getMonth(), 3),
                        LocalDate.of(2020, LocalDate.now().getMonth(), 4),
                        LocalDate.of(2020, LocalDate.now().getMonth(), 4),
                        LocalDate.of(2020, LocalDate.now().getMonth(), 4),
                        LocalDate.of(2020, LocalDate.now().getMonth(), 5)));

        ArrayList<LocalDate> dayTest = new ArrayList<>(
                Arrays.asList(LocalDate.now(), LocalDate.now(), LocalDate.now(), LocalDate.now(), LocalDate.now(),
                        LocalDate.of(2020, 11, 5)));

        ArrayList<LocalDate> allTest = new ArrayList<>(
                Arrays.asList(LocalDate.of(2021, 11, 5),
                        LocalDate.of(2022, 11, 5),
                        LocalDate.of(2023, 11, 5),
                        LocalDate.of(2020, 11, 5)));

        ArrayList<LocalDate> bestTest = new ArrayList<>(
                Arrays.asList(LocalDate.of(2020, 11, 22),
                        LocalDate.of(2020, 12, 22),
                        LocalDate.of(2020, 3, 22),
                        LocalDate.of(2020, 1, 22),
                        LocalDate.of(2020, 1, 22),
                        LocalDate.of(2020, 1, 22),
                        LocalDate.of(2020, 1, 22),
                        LocalDate.of(2020, 6, 22),
                        LocalDate.of(2020, 7, 4),
                        LocalDate.of(2020, 5, 4),
                        LocalDate.of(2020, 5, 4),
                        LocalDate.of(2020, 11, 22),
                        LocalDate.of(2020, 12, 22),
                        LocalDate.of(2020, 3, 22),
                        LocalDate.of(2020, 1, 22),
                        LocalDate.of(2020, 1, 22),
                        LocalDate.of(2020, 1, 22),
                        LocalDate.of(2020, 1, 22),
                        LocalDate.of(2020, 6, 22),
                        LocalDate.of(2020, 7, 4),
                        LocalDate.of(2020, 5, 4),
                        LocalDate.of(2020, 5, 4)));

        popular.put(comicBase.getComicDB().get(1), yearTest);
        popular.put(comicBase.getComicDB().get(4), monthTest);
        popular.put(comicBase.getComicDB().get(6), dayTest);
        popular.put(comicBase.getComicDB().get(7), allTest);
        popular.put(comicBase.getComicDB().get(10), bestTest);
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

    public void printBestOfYear() {
        System.out.println("---------------------------------------");
        System.out.println("Список самых популярных комиксов за год");
        System.out.println("---------------------------------------");

        Map<Comic, List<LocalDate>> mp = new HashMap<>(popular);

        mp.replaceAll((k, v) -> v.stream()
                .filter(y -> y.getYear() == Year.now().getValue()).collect(Collectors.toList()));

        mp.entrySet().stream().filter(x -> x.getValue().size() > 12).forEach(x -> System.out.println(x.getKey()));


    }

    public void printBestOfMonth() {
        System.out.println("-----------------------------------------");
        System.out.println("Список самых популярных комиксов за месяц");
        System.out.println("-----------------------------------------");

        Map<Comic, List<LocalDate>> mp = new HashMap<>(popular);

        mp.replaceAll((k, v) -> v.stream()
                .filter(y -> y.getYear() == Year.now().getValue() && y.getMonthValue() == LocalDate.now().getMonthValue())
                .collect(Collectors.toList()));

        mp.entrySet()
                .stream()
                .sorted(Comparator.comparing(x -> ((Map.Entry<Comic, ArrayList<LocalDate>>) x).getValue().size()).reversed())
                .limit(3)
                .filter(x -> !x.getValue().isEmpty() && x.getValue().size() > 3)
                .forEach(x -> System.out.println(x.getKey()));


    }

    public void printBestOfDay() {
        System.out.println("----------------------------------------");
        System.out.println("Список самых популярных комиксов за день");
        System.out.println("----------------------------------------");

        Map<Comic, List<LocalDate>> mp = new HashMap<>(popular);

        mp.replaceAll((k, v) -> v.stream()
                .filter(x -> x.getDayOfMonth() == LocalDate.now().getDayOfMonth())
                .collect(Collectors.toList()));

        mp.entrySet().stream()
                .filter(x -> !x.getValue().isEmpty()).forEach(x -> System.out.println(x.getKey()));

    }

    public void printBestOfTheBest() {
        System.out.println("---------------------------------");
        System.out.println("Список самых продаваемых комиксов");
        System.out.println("---------------------------------");

        popular.entrySet().stream().filter(x -> x.getValue().size() > 20).forEach(y -> System.out.println(y.getKey()));

    }

    public void printBestAuthor() {
        System.out.println("-------------------------------");
        System.out.println("Список самых популярных авторов");
        System.out.println("-------------------------------");


        HashMap<String, Integer> hm = new HashMap<>();

        for (Map.Entry<Comic, ArrayList<LocalDate>> entry : popular.entrySet()) {
            String curAuthor = entry.getKey().getNameAuthor();
            if (!hm.containsKey(curAuthor)) {
                hm.put(curAuthor, entry.getValue().size());
            } else {
                hm.put(curAuthor, hm.get(curAuthor) + entry.getValue().size());
            }
        }
        hm.forEach((key, value) -> System.out.println(key));

//        HashMap<String, Integer> zds =  mp.entrySet().stream().map((x -> new AbstractMap.SimpleEntry<String, Integer>(x.getKey().getNameAuthor(), x.getValue().size()))).collect(Collectors.toMap());
        //mp.replaceAll((k,v) -> k.getNameAuthor() )
//                /.filter(y -> y.getYear() == Year.now().getValue() && y.getMonthValue() == LocalDate.now().getMonthValue())
//                .collect(Collectors.toList()));

//        popular.entrySet()
//                .stream()
//                .sorted(Comparator.comparing(x -> ((Map.Entry<Comic, ArrayList<LocalDate>>)x).getValue().size()).reversed())
//
//                //.filter(x -> !x.getValue().isEmpty() && x.getValue().size() > 3)
//                .forEach(x -> System.out.println(x.getKey()));

//
//        Map<Comic, List<LocalDate>> mp = new HashMap<>(popular);
//
//        mp.replaceAll((k, v) -> v.stream()
//                .filter(y -> y.getYear() == Year.now().getValue() && y.getMonthValue() == LocalDate.now().getMonthValue())
//                .collect(Collectors.toList()));

//        mp.entrySet()
//                .stream()
//                .filter(x -> !x.getValue().isEmpty() && x.getValue().size() > 3)
//                .forEach(x -> System.out.println(x.getKey()));

    }

    public LinkedHashMap<Comic, ArrayList<LocalDate>> getPopular() {
        return popular;
    }

    public void setPopular(LinkedHashMap<Comic, ArrayList<LocalDate>> popular) {
        this.popular = popular;
    }
}
