package Discount;

import Bases.Comic;
import Bases.ComicBase;

import java.time.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PopularityComic {

    private HashMap<Comic, ArrayList<LocalDate>> popular = new LinkedHashMap<>();


    public void initPopularity(ComicBase comicBase) {
//        ArrayList<LocalDate> first = new ArrayList<>(
//                Arrays.asList(LocalDate.of(2020, 11, 3),
//                        LocalDate.of(2020, 11, 22),
//                        LocalDate.of(2021, 11, 22),
//                        LocalDate.of(2022, 3, 22),
////                        LocalDate.of(2020, 11, 22),
////                        LocalDate.of(2020, 11, 22),
////                        LocalDate.of(2020, 12, 4),
////                        LocalDate.of(2020, 5, 4),
////                        LocalDate.of(2020, 5, 4),
////                        LocalDate.of(2020, 2, 4),
////                        LocalDate.of(2020, 5, 4),
////                        LocalDate.of(2020, 2, 5),
////                        LocalDate.of(2020, 5, 4),
////                        LocalDate.of(2020, 5, 2),
////                        LocalDate.of(2020, 6, 4),
////                        LocalDate.of(2020, 5, 4),
////                        LocalDate.of(2020, 5, 4),
////                        LocalDate.of(2020, 5, 4),
//                        LocalDate.of(2020, 12, 5)));
//
        ArrayList<LocalDate> second = new ArrayList<>(
                Arrays.asList(LocalDate.of(2020, 11, 3),
                        LocalDate.of(2020, 11, 4),
                        LocalDate.of(2020, 11, 5)));

        ArrayList<LocalDate> third = new ArrayList<>(
                Arrays.asList(LocalDate.of(2023, 11, 3),
                        LocalDate.of(2021, 11, 4),
                        LocalDate.of(2022, 11, 5)));


//        popular.put(comicBase.getComicDB().get(1), first);
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

    public void printBestOfYear() {
        System.out.println("Список самых популярных комиксов за год");
        for (Map.Entry<Comic, ArrayList<LocalDate>> entry : popular.entrySet()) {
            if (entry.getValue().size() >= 12) {
                System.out.println(entry.getKey());
            }
        }
    }

    public void printBestOfMonth() {
        System.out.println("Популярные комиксы в этом месяце");
//        LocalDate ld = LocalDate.now();
//        int year = Year.now().getValue();
//        System.out.println(year);
//        System.out.println();

//        popular.entrySet().stream().peek(x -> x.getKey().setNameComic("123")).forEach(System.out::println);
        Map<Comic, List<LocalDate>> mp = new HashMap<>(popular);

//        mp.forEach((r,v) -> System.out.println(r + " " + v));


        mp.replaceAll((k,v) -> v.stream()
                .filter(y -> y.getYear() == Year.now().getValue() && y.getMonth() == LocalDate.now().getMonth()).collect(Collectors.toList()));

        mp.forEach((r,v) -> System.out.println(r + " " + v));

//        mp.entrySet().stream().peek(x -> x.getValue().stream()
//                .filter(y -> y.getYear() == Year.now().getValue() && y.getMonth() == LocalDate.now().getMonth()));
//                .filter(x -> x.getValue().size() >= 3);

//        mp.forEach(System.out::println);


//        for (Map.Entry<Comic, ArrayList<LocalDate>> entry : popular.entrySet()) {
////            Map<Month, Long> month = entry.getValue()
////                    .stream().collect((Collectors.groupingBy(LocalDate::getMonth, Collectors.counting())));
//
//            Stream<LocalDate> year = entry.getValue()
//            .stream().filter(x -> x.getYear() == Year.now().getValue()).filter(x -> x.getMonth() == LocalDate.now().getMonth());
//            //.stream().collect(Collectors.groupingBy(LocalDate::getYear));


//            year1.forEach((x,y) -> System.out.println(x + " "  + y));
//            System.out.println(Year.now().getValue() + "CERAFA");
//            for (Map.Entry<Integer, List<LocalDate>> entry1 : year.entrySet()) {
//                for (int i = 0; i < entry1.getValue().size(); i++) {
//
//                    for (Map.Entry<Month, Long> entry2 : month.entrySet()) {
//                        if (entry2.getValue() >= 3) {
//                            System.out.println(entry.getKey());
//
//                        }
//                    }
//
//                }
    }

//            System.out.println(LocalDate.now().withDayOfMonth(1));
//            for (Map.Entry<Month, Long> entry1 : month.entrySet()) {
//                if (entry1.getValue() >= 3 ) {
//                    System.out.println(entry.getKey());
//
//                }
//            }
//        }

    public void printBestOfDay() {
        System.out.println("Популярные комиксы сегодня");
        LocalDate ld = LocalDate.now();

        for (Map.Entry<Comic, ArrayList<LocalDate>> entry : popular.entrySet()) {
//            System.out.println(entry.getValue());
//            System.out.println("-----");
//            System.out.println(ld);

//            Map<DayOfWeek, Long> day = entry.getValue().stream().collect((Collectors.groupingBy(LocalDate.now(), Collectors.counting())));

//            for (Map.Entry<DayOfWeek, Long> entry1: day.entrySet()) {
////                if(entry1.getValue().equals(ld)){
////
////                }
//                System.out.println(entry1.getKey() + " : " + entry1.getValue() );
//                System.out.println("____-_____");
//            }

//            if(entry.getValue().equals(ld)){
//                System.out.println(entry.getKey());
//            }

        }

    }

    public HashMap<Comic, ArrayList<LocalDate>> getPopular() {
        return popular;
    }

    public void setPopular(HashMap<Comic, ArrayList<LocalDate>> popular) {
        this.popular = popular;
    }
}
