import java.util.*;

public class Discount {

    List<Comic> newYear = new ArrayList<>();
    List<Comic> manDay = new ArrayList<>();
    List<Comic> womanDay = new ArrayList<>();

    void addNewYear(int id, ComicBase comicBase){
       newYear.add(comicBase.getComicDB().get(id));
    }

    void addManDay(int id, ComicBase comicBase){
        manDay.add(comicBase.getComicDB().get(id));
    }

    void addWomanDay(int id, ComicBase comicBase){
        womanDay.add(comicBase.getComicDB().get(id));
    }

    void printDiscount(){
        newYear.forEach(System.out::println);
        manDay.forEach(System.out::println);
        womanDay.forEach(System.out::println);
        System.out.println();
    }



}
