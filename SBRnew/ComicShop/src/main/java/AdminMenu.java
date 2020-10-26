import java.util.*;

public class AdminMenu {

    static void printAdminMenu(String login, ComicBase comicBase, Discount discount) {
        Scanner in = new Scanner(System.in);
        System.out.println("Добро пожаловать: " + login);
        System.out.println("Выберите что необходимо сделать: ");
        System.out.println("1. Добавить комикс");
        System.out.println("2. Удалить комикс");
        System.out.println("3. Изменить коммикс");
        System.out.println("4. Продать комикс");
        System.out.println("5. Списать комикс");
        System.out.println("6. Добавить комикс к акции");
        System.out.println("7. Показать акционные комиксы");
        System.out.println("8. Отложить комикс определенному покупателю");
        System.out.println("9. Показать комиксы в наличии");
        System.out.println("0. Выход");

        boolean isInt = in.hasNextInt();

        if (isInt) {
            int choice = in.nextInt();
            switch (choice) {
                case 1: {
                    in.nextLine();
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
                    System.out.println("new id = " + (comicBase.getComicDB().lastKey() + 1));
                    comicBase.addComic((comicBase.getComicDB().lastKey() + 1), nameComic, nameAuthor, numberOfPages, genre,
                            yearOfPublishing, costPrice, priceForSale, comicSeries, numberOfComic);
                    System.out.println("Комикс " + nameComic + " добавлен");
                    System.out.println("----------------------------------------");
                    printAdminMenu(login, comicBase, discount);
                    break;
                }
                case 2: {
                    comicBase.printComicDB();
                    int id;
                    do {
                        System.out.print("Введите id для удаления: ");
                        while (!in.hasNextInt()) {
                            System.out.print("Введите id для удаления: ");
                            in.next();
                        }
                        id = in.nextInt();
                        comicBase.getComicDB().remove(id);
                    } while (id <= 0);
                    printAdminMenu(login, comicBase, discount);
                    break;
                }
                case 3: {
                    comicBase.printComicDB();
                    int id;
                    do {
                        System.out.print("Введите id для изменения: ");
                        while (!in.hasNextInt()) {
                            System.out.print("Введите id для изменения: ");
                            in.next();
                        }
                        id = in.nextInt();
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
                                    comicBase.getComicDB().get(id).setNameComic(nameComic);
                                    System.out.println("Название изменено на : " + nameComic);
                                    break;
                                }
                                case 2: {
                                    in.nextLine();
                                    System.out.println("Введите имя автора: ");
                                    String nameAuthor = in.nextLine();
                                    comicBase.getComicDB().get(id).setNameAuthor(nameAuthor);
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
                                        comicBase.getComicDB().get(id).setNumberOfPages(numberOfPages);
                                    } while (numberOfPages <= 0);
                                    System.out.println("Количество страниц изменено на : " + numberOfPages);
                                    break;
                                }
                                case 4: {
                                    System.out.println("Введите жанр комикса: ");
                                    String genre = in.next();
                                    comicBase.getComicDB().get(id).setGenre(genre);
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
                                        comicBase.getComicDB().get(id).setYearOfPublishing(yearOfPublishing);
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
                                        comicBase.getComicDB().get(id).setCostPrice(costPrice);
                                    } while (costPrice <= 0);
                                    System.out.println("Цена закупки изменан на : " + costPrice);
                                    break;
                                }
                                case 7: {
                                    int priceForSale;
                                    do {
                                        System.out.println("Введите цену продажи: ");
                                        while (!in.hasNextInt()) {
                                            System.out.println("Введите цену продажи: ");
                                            in.next();
                                        }
                                        priceForSale = in.nextInt();
                                        comicBase.getComicDB().get(id).setPriceForSale(priceForSale);
                                    } while (priceForSale <= 0);
                                    System.out.println("Цена продажи изменана на : " + priceForSale);
                                    break;
                                }
                                case 8: {
                                    System.out.println("Введите название серии комиксов");
                                    String comicSeries = in.nextLine();
                                    comicBase.getComicDB().get(id).setComicSeries(comicSeries);
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
                                        comicBase.getComicDB().get(id).setNumberOfComic(numberOfComic);
                                    } while (numberOfComic <= 0);
                                    System.out.println("Количество экземпляров изменено на : " + numberOfComic);
                                    break;
                                }
                                case 0:
                                    printAdminMenu(login, comicBase, discount);
                                    break;
                            }

                        }

                    } while (id <= 0);
                    printAdminMenu(login, comicBase, discount);
                    break;
                }
                case 4: {
                    comicBase.printComicDB();
                    System.out.println("Какой комикс продаём, введите id ");
                    int id = in.nextInt();
                    if (comicBase.getComicDB().get(id).getNumberOfComic() > 0) {
                        comicBase.getComicDB().get(id).setNumberOfComic(comicBase.getComicDB().get(id).getNumberOfComic() - 1);
                    } else {
                        System.out.println("Данный комикс закончился");
                        printAdminMenu(login, comicBase, discount);
                    }
                }
                case 5: {
                    comicBase.printComicDB();
                    System.out.println("Какой комикс списываем, введите id ");
                    int id = in.nextInt();
                    if (comicBase.getComicDB().get(id).getNumberOfComic() > 0) {
                        comicBase.getComicDB().get(id).setNumberOfComic(comicBase.getComicDB().get(id).getNumberOfComic() - 1);
                    } else {
                        System.out.println("Данный комикс закончился");
                        printAdminMenu(login, comicBase, discount);
                    }
                }
                case 6: {
                    comicBase.printComicDB();
                    System.out.println("Выберие к какой акции необходимо добавить комикс\n1. Новый год\n 2. Мужской день\n3. Женский день");
                    int choice1;
                    do {
                        while (!in.hasNextInt()) {
                            System.out.println("Выберие к какой акции необходимо добавить комикс\n1. Новый год\n2. Мужской день\n3. Женский день");
                            in.next();
                        }
                        choice1 = in.nextInt();
                    } while (choice1 <= 0);

                    System.out.println("Какой комикс нужно добавить к акции, введите id");
                    int id;
                    do {
                        while (!in.hasNextInt()) {
                            System.out.println("Какой комикс нужно добавить к акции, введите id");
                            in.next();
                        }
                        id = in.nextInt();
                    } while (id <= 0);

                    switch (choice1) {
                        case 1: {
                            discount.addNewYear(id, comicBase);
                            System.out.println("Комикс добавлен к акции");
                            break;
                        }
                        case 2: {
                            discount.addManDay(id, comicBase);
                            System.out.println("Комикс добавлен к акции");
                            break;
                        }
                        case 3: {
                            discount.addWomanDay(id, comicBase);
                            System.out.println("Комикс добавлен к акции");
                            break;
                        }
                    }
                    printAdminMenu(login, comicBase, discount);
                }
                case 7: {
                    System.out.println("Доступные акции: ");
                    discount.printDiscount();
                    printAdminMenu(login, comicBase, discount);
                }
                case 8: {

                }
                case 9: {
                    System.out.println("Комиксы в базе");
                    comicBase.printComicDB();
                    printAdminMenu(login, comicBase, discount);
                    break;
                }
                case 0: {
                    StartProgram.start();
                    break;
                }
            }
        } else {
            System.out.println("Выберите один из предложенных вариантов\n");
            printAdminMenu(login, comicBase, discount);
        }

    }
}
