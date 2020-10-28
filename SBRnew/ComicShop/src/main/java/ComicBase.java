import java.io.Serializable;
import java.util.SortedMap;
import java.util.TreeMap;


public class ComicBase implements Serializable {

        private SortedMap<Integer,Comic> comicDB = new TreeMap<>();


    public void comicFactory() {
        comicDB.put(1, new Comic("Star Wars 1", "Lucas", 670, "scienceFiction",
                1985, 15, 25, "Star Wars", 5));
        comicDB.put(2, new Comic("Star Wars 2", "Lucas", 570, "scienceFiction",
                1987, 17, 27, "Star Wars", 5));
        comicDB.put(3, new Comic("Star Wars 3", "Lucas", 770, "scienceFiction",
                1990, 19, 29, "Star Wars", 5));
        comicDB.put(4, new Comic("Star Wars 4", "Lucas", 870, "scienceFiction",
                1996, 21, 32, "Star Wars", 5));
        comicDB.put(5, new Comic("WarCraft 1", "Blizzard", 450, "fantasy",
                2004, 21, 35, "WarCraft", 3));
        comicDB.put(6, new Comic("WarCraft 2", "Blizzard", 480, "fantasy",
                2004, 23, 37, "WarCraft", 3));
        comicDB.put(7, new Comic("WarCraft 3", "Blizzard", 325, "fantasy",
                2004, 25, 39, "WarCraft", 3));
        comicDB.put(8, new Comic("Batman", "DC Comic", 325, "crime",
                1964, 12, 39, "Batman", 4));
        comicDB.put(9, new Comic("Batman Forever", "DC Comic", 325, "crime",
                1966, 13, 41, "Batman", 4));
        comicDB.put(10, new Comic("Batman and Robin", "DC Comic", 325, "crime",
                1969, 14, 50, "Batman", 4));
        comicDB.put(11, new Comic("The Doomed and The Damned", "DC Comic", 305, "horror",
                2005, 3, 7, "", 4));
        comicDB.put(12, new Comic("The Light Brigade", "DC Comic", 205, "horror",
                2015, 5, 8, "", 4));
        comicDB.put(13, new Comic("Wasteland", "DC Comic", 250, "horror",
                2018, 7, 11, "", 4));
        comicDB.put(14, new Comic("Crimes of Passion", "DC Comic", 150, "romance",
                2020, 17, 27, "", 2));
        comicDB.put(15, new Comic("Jonah Hex", "DC Comic", 150, "western",
                2006, 22, 34, "", 2));
        comicDB.put(16, new Comic("The Kents", "DC Comic", 150, "western",
                2012, 25, 32, "", 2));

//        ComicBaseSerialization.serialize(comicDB, "ComicDB.txt");


    }

    void addComic(int id, String nameComic, String nameAuthor, int numberOfPages, String genre, int yearOfPublishing,
                  int costPrice, int priceForSale, String comicSeries, int numberOfComic){
        comicDB.put(id, new Comic(nameComic, nameAuthor, numberOfPages, genre, yearOfPublishing,
                costPrice, priceForSale, comicSeries, numberOfComic));

        ComicSerialization.serialize(comicDB.get(id), "ComicDB.txt");
    }

    void printComicDB(){
        comicDB.forEach((k,v) -> System.out.println("id = " + k + " : " + v));
    }


    public SortedMap<Integer, Comic> getComicDB() {
        return comicDB;
    }


}
