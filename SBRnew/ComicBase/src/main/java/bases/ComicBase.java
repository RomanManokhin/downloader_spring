package bases;

import serrialization.Serialization;

import java.io.File;
import java.time.LocalDate;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.Stream;

public class ComicBase{

    private SortedMap<Integer, Comic> comicDB;
    Serialization serialization = new Serialization();

    public ComicBase() {
        comicDB = new TreeMap<>();
    }

    public void initDb() {
        comicDB.put(1, new Comic("Star Wars 1", "Lucas", 670, "scienceFiction",
                LocalDate.of(1990,12, 8), 15, 25, "Star Wars", 5));
        comicDB.put(2, new Comic("Star Wars 2", "Lucas", 570, "scienceFiction",
                LocalDate.of(1980,12, 7), 17, 27, "Star Wars", 5));
        comicDB.put(3, new Comic("Star Wars 3", "Lucas", 770, "scienceFiction",
                LocalDate.of(1950,12, 7), 19, 29, "Star Wars", 5));
        comicDB.put(4, new Comic("Star Wars 4", "Lucas", 870, "scienceFiction",
                LocalDate.of(2020,12, 7), 21, 32, "Star Wars", 5));
        comicDB.put(5, new Comic("WarCraft 1", "Blizzard", 450, "fantasy",
                LocalDate.of(1956,12, 7), 21, 35, "WarCraft", 3));
        comicDB.put(6, new Comic("WarCraft 2", "Blizzard", 480, "fantasy",
                LocalDate.of(2020,12, 7), 23, 37, "WarCraft", 3));
        comicDB.put(7, new Comic("WarCraft 3", "Blizzard", 325, "fantasy",
                LocalDate.of(2020,12, 7), 25, 39, "WarCraft", 3));
        comicDB.put(8, new Comic("Batman", "DC Comic", 325, "crime",
                LocalDate.of(2020,12, 7), 12, 39, "Batman", 4));
        comicDB.put(9, new Comic("Batman Forever", "DC Comic", 325, "crime",
                LocalDate.of(2020,12, 7), 13, 41, "Batman", 4));
        comicDB.put(10, new Comic("Batman and Robin", "DC Comic", 325, "crime",
                LocalDate.of(2020,12, 7), 14, 50, "Batman", 4));
        comicDB.put(11, new Comic("The Doomed and The Damned", "DC Comic", 305, "horror",
                LocalDate.of(2020,12, 8), 3, 7, "", 4));
        comicDB.put(12, new Comic("The Light Brigade", "DC Comic", 205, "horror",
                LocalDate.of(2020,12, 7), 5, 8, "", 4));
        comicDB.put(13, new Comic("Wasteland", "DC Comic", 250, "horror",
                LocalDate.of(2020,12, 1), 7, 11, "", 4));
        comicDB.put(14, new Comic("Crimes of Passion", "DC Comic", 150, "romance",
                LocalDate.of(2020,12, 2), 17, 27, "", 2));
        comicDB.put(15, new Comic("Jonah Hex", "DC Comic", 150, "western",
                LocalDate.of(2020,11, 30), 22, 34, "", 2));
        comicDB.put(16, new Comic("The Kents", "DC Comic", 150, "western",
                LocalDate.of(2020,11, 29), 25, 32, "", 2));
    }

    public void loadDb(String dbName) {
        File file = new File(dbName);
        if (!file.exists()) {
            comicDB = new TreeMap<>();
            initDb();
            serialization.serialization(comicDB, dbName);
        } else {
            comicDB = (SortedMap<Integer, Comic>) serialization.deSerialization("ComicDB.txt");
        }
    }

    public void addComic(String nameComic, String nameAuthor, int numberOfPages, String genre, LocalDate yearOfPublishing,
                         int costPrice, double priceForSale, String comicSeries, int numberOfComic) {
        comicDB.put(comicDB.lastKey() + 1, new Comic(nameComic, nameAuthor, numberOfPages, genre, yearOfPublishing,
                costPrice, priceForSale, comicSeries, numberOfComic));
        serialization.serialization(comicDB, "ComicDB.txt");
    }

    public void deleteComic(int id) {
        comicDB.remove(id);
        serialization.serialization(comicDB, "ComicDB.txt");
    }


    public boolean sellComic(int id) {
        if (comicDB.get(id).getNumberOfComic() > 0 && comicDB.containsKey(id)) {
            comicDB.get(id).setNumberOfComic(comicDB.get(id).getNumberOfComic() - 1);
            serialization.serialization(comicDB, "ComicDB.txt");
            return true;
        } else {
            return false;
        }
    }

    public Stream newComic(){
        return comicDB.entrySet().stream().filter(x-> x.getValue().getYearOfPublishing().isAfter(LocalDate.now()));
    }

    public SortedMap<Integer, Comic> getComicDB() {
        return comicDB;
    }



}