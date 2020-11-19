import java.io.File;
import java.io.Serializable;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;

public class ComicBase implements Serializable {

    static SortedMap<Integer, Comic> comicDB = new TreeMap<>();

    static {
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

        File file = new File("ComicDB.txt");
        if (!file.isFile()) {
            Serialization.serializationObject(comicDB, "ComicDB.txt");
        } else {
           comicDB = (SortedMap<Integer, Comic>) DeSerialization.deSerialization("ComicDB.txt");
        }
    }

    void addComic() {
//        in.nextLine();
        Scanner in = new Scanner(System.in);
        System.out.println("Введите название комикса: ");
        String nameComic = in.nextLine();

        System.out.println("Введите имя автора: ");
        String nameAuthor = in.nextLine();

        int numberOfPages;
        do {
            System.out.println("Введите количество страниц: ");
            while (!in.hasNextInt()) {
                System.out.println("Введите количество страниц: ");
                in.next();
            }
            numberOfPages = in.nextInt();
        } while (numberOfPages <= 0);

        System.out.println("Введите жанр комикса: ");
        String genre = in.next();

        int yearOfPublishing;
        do {
            System.out.println("Введите год публикации комикса: ");
            while (!in.hasNextInt()) {
                System.out.println("Введите год публикации комикса: ");
                in.next();
            }
            yearOfPublishing = in.nextInt();
        } while (yearOfPublishing <= 0);

        int costPrice;
        do {
            System.out.println("Введите цену закупки: ");
            while (!in.hasNextInt()) {
                System.out.println("Введите цену закупки: ");
                in.next();
            }
            costPrice = in.nextInt();
        } while (costPrice <= 0);

        int priceForSale;
        do {
            System.out.println("Введите цену продажи: ");
            while (!in.hasNextInt()) {
                System.out.println("Введите цену продажи: ");
                in.next();
            }
            priceForSale = in.nextInt();
        } while (priceForSale <= 0);

        in.nextLine();
        System.out.println("Введите название серии комиксов");
        String comicSeries = in.nextLine();

        int numberOfComic;
        do {
            System.out.println("Введите количество экземпляров комикса: ");
            while (!in.hasNextInt()) {
                System.out.println("Введите количество экземпляров комикса: ");
                in.next();
            }
            numberOfComic = in.nextInt();
        } while (numberOfComic <= 0);
        System.out.println("new id = " + (comicDB.lastKey() + 1));
        System.out.println("Комикс " + nameComic + " добавлен");
        comicDB.put(comicDB.lastKey() + 1, new Comic(nameComic, nameAuthor, numberOfPages, genre, yearOfPublishing,
                costPrice, priceForSale, comicSeries, numberOfComic));
        Serialization.serializationObject(comicDB, "ComicDB.txt");
    }

    void deleteComic() {
        Scanner in = new Scanner(System.in);
        printComicDB();
        int id;
        do {
            System.out.print("Введите id для удаления: ");
            while (!in.hasNextInt()) {
                System.out.print("Введите id для удаления: ");
                in.next();
            }
            id = in.nextInt();
            if (!comicDB.containsKey(id)) {
                System.out.println("Такого комикса нет");
            } else {
                comicDB.remove(id);
            }
        } while (id <= 0);
        Serialization.serializationObject(comicDB, "ComicDB.txt");
    }

    void changeComic() {
        Scanner in = new Scanner(System.in);
        printComicDB();
        int id = 0;
        do {
            System.out.print("Введите id для изменения: ");
            try {
                id = in.nextInt();
                if (!comicDB.containsKey(id)){
                    System.out.println("Такого id нет\nВведите корректный id");
                    continue;
                }
            } catch (Exception e){
                System.out.println("Такого id нет\nВведите корректный id ");
                continue;
            }
            System.out.println("Выберите, что необходимо изменить ");
            System.out.println("1. Название комикса");
            System.out.println("2. Имя автора");
            System.out.println("3. Количество страниц");
            System.out.println("4. Жанр");
            System.out.println("5. Год публикации");
            System.out.println("6. Цена закупки");
            System.out.println("7. Цена продажи");
            System.out.println("8. Вселенная");
            System.out.println("9. Количество комиксов в наличии");
            System.out.println("0. Выйти из редактирования");
            boolean isInt1 = in.hasNextInt();
            if (isInt1) {
                int choice1 = in.nextInt();
                switch (choice1) {
                    case 1: {
                        in.nextLine();
                        System.out.println("Введите новое название комикса: ");
                        String nameComic = in.nextLine();
                        comicDB.get(id).setNameComic(nameComic);
                        System.out.println("Название изменено на : " + nameComic);
                        break;
                    }
                    case 2: {
                        in.nextLine();
                        System.out.println("Введите имя автора: ");
                        String nameAuthor = in.nextLine();
                        comicDB.get(id).setNameAuthor(nameAuthor);
                        System.out.println("Название изменено на : " + nameAuthor);
                        break;
                    }
                    case 3: {
                        int numberOfPages;
                        do {
                            System.out.println("Введите количество страниц: ");
                            while (!in.hasNextInt()) {
                                System.out.println("Введите количество страниц: ");
                                in.next();
                            }
                            numberOfPages = in.nextInt();
                            comicDB.get(id).setNumberOfPages(numberOfPages);
                        } while (numberOfPages <= 0);
                        System.out.println("Количество страниц изменено на : " + numberOfPages);
                        break;
                    }
                    case 4: {
                        System.out.println("Введите жанр комикса: ");
                        String genre = in.next();
                        comicDB.get(id).setGenre(genre);
                        System.out.println("Жанр изменён на : " + genre);
                        break;
                    }
                    case 5: {
                        int yearOfPublishing;
                        do {
                            System.out.println("Введите год публикации комикса: ");
                            while (!in.hasNextInt()) {
                                System.out.println("Введите год публикации комикса: ");
                                in.next();
                            }
                            yearOfPublishing = in.nextInt();
                            comicDB.get(id).setYearOfPublishing(yearOfPublishing);
                        } while (yearOfPublishing <= 0);
                        System.out.println("Год публикации изменён на : " + yearOfPublishing);
                        break;
                    }
                    case 6: {
                        int costPrice;
                        do {
                            System.out.println("Введите цену закупки: ");
                            while (!in.hasNextInt()) {
                                System.out.println("Введите цену закупки: ");
                                in.next();
                            }
                            costPrice = in.nextInt();
                            comicDB.get(id).setCostPrice(costPrice);
                        } while (costPrice <= 0);
                        System.out.println("Цена закупки изменан на : " + costPrice);
                        break;
                    }
                    case 7: {
                        double priceForSale;
                        do {
                            System.out.println("Введите цену продажи: ");
                            while (!in.hasNextDouble()) {
                                System.out.println("Введите цену продажи: ");
                                in.next();
                            }
                            priceForSale = in.nextDouble();
                            comicDB.get(id).setPriceForSale(priceForSale);
                        } while (priceForSale <= 0);
                        System.out.println("Цена продажи изменана на : " + priceForSale);
                        break;
                    }
                    case 8: {
                        System.out.println("Введите название серии комиксов");
                        String comicSeries = in.nextLine();
                        comicDB.get(id).setComicSeries(comicSeries);
                        System.out.println("Название серии изменено на : " + comicSeries);
                        break;
                    }
                    case 9: {
                        int numberOfComic;
                        do {
                            System.out.println("Введите количество экземпляров комикса: ");
                            while (!in.hasNextInt()) {
                                System.out.println("Введите количество экземпляров комикса: ");
                                in.next();
                            }
                            numberOfComic = in.nextInt();
                            comicDB.get(id).setNumberOfComic(numberOfComic);
                        } while (numberOfComic <= 0);
                        System.out.println("Количество экземпляров изменено на : " + numberOfComic);
                        break;
                    }
                    case 0:
                        break;
                    default : {
                        System.out.println("Такого пункта меню нет");
                        changeComic();
                    }
                }
            }
        } while (id < 0);
        Serialization.serializationObject(comicDB, "ComicDB.txt");
    }



    void printComicDB() {
        System.out.println("Комиксы в базе");
        System.out.println(DeSerialization.deSerialization("ComicDB.txt"));
    }

    void printComicDBForUser(){
        System.out.println("Комиксы в базе");
        DeSerialization.deSerialization("ComicDB.txt");
        for(Integer key : comicDB.keySet()){
            System.out.println("id " + key + " {" +
                    "Название комикса -'" + comicDB.get(key).getNameComic() + '\'' +
                    ", имя автора -'" + comicDB.get(key).getNameAuthor() + '\'' +
                    ", страницы - " + comicDB.get(key).getNumberOfPages() +
                    ", жанр -'" + comicDB.get(key).getGenre() + '\'' +
                    ", год выпуска - " + comicDB.get(key).getYearOfPublishing() +
                    ", цена продажи - " + comicDB.get(key).getPriceForSale() +
                    ", вселенная - " + comicDB.get(key).getComicSeries() + '\'' +
                    ", количество экземпляров - " + comicDB.get(key).getNumberOfComic() +
                    '}');
        }
    }

    void writeOffComic(){
        Scanner in = new Scanner(System.in);
        printComicDB();
        int id;
        do {
            System.out.println("Какой комикс списываем, введите id ");
            while (!in.hasNextInt()) {
                System.out.print("Введите id для списания: ");
                in.next();
            }
            id = in.nextInt();

            if (comicDB.containsKey(id) && comicDB.get(id).getNumberOfComic() > 0) {
                comicDB.get(id).setNumberOfComic(comicDB.get(id).getNumberOfComic() - 1);
            } else {
                System.out.println("Данный комикс закончился");
            }
        } while (id <= 0);
        Serialization.serializationObject(comicDB, "ComicDB.txt");
    }

    void sellComic(){
        Scanner in = new Scanner(System.in);
        printComicDB();
        int id;
        do {
            System.out.println("Введите id комикса ");
            while (!in.hasNextInt()) {
                System.out.print("Введите id комикса  ");
                in.next();
            }
            id = in.nextInt();

            if (comicDB.containsKey(id) && comicDB.get(id).getNumberOfComic() > 0) {
                comicDB.get(id).setNumberOfComic(comicDB.get(id).getNumberOfComic() - 1);
            } else {
                System.out.println("Данный комикс закончился");
            }
        } while (id <= 0);
        Serialization.serializationObject(comicDB, "ComicDB.txt");
    }


    public SortedMap<Integer, Comic> getComicDB() {
        return comicDB;
    }

}
