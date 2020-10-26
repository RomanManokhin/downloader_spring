import java.util.Date;

public class Comic {


    private String nameComic; //название комикса
    private String nameAuthor; //имя автора
    private int numberOfPages; //количество страниц
    private String genre; //жанр
    private int yearOfPublishing; //год публикации
    private int costPrice; //базовая цена
    private int priceForSale; //цена продажи
    private String comicSeries; //продолжение?
    private int numberOfComic; //количество комиксов в наличии
    private boolean bestOfSale; //популярный?
    private boolean bestAuthor; //популярность автора?
    private boolean bestOfGenreOnDay; //популярность жанра день
    private boolean bestOfGenreOnMonth; //популярность жанра месяц
    private boolean bestOfGenreOnYear; //популярность жанра год


    public Comic(String nameComic, String nameAuthor, int numberOfPages, String genre, int yearOfPublishing,
                 int costPrice, int priceForSale, String comicSeries, int numberOfComic) {
        this.nameComic = nameComic;
        this.nameAuthor = nameAuthor;
        this.numberOfPages = numberOfPages;
        this.genre = genre;
        this.yearOfPublishing = yearOfPublishing;
        this.costPrice = costPrice;
        this.priceForSale = priceForSale;
        this.comicSeries = comicSeries;
        this.numberOfComic = numberOfComic;
    }


    public String getNameComic() {
        return nameComic;
    }

    public void setNameComic(String nameComic) {
        this.nameComic = nameComic;
    }

    public String getNameAuthor() {
        return nameAuthor;
    }

    public void setNameAuthor(String nameAuthor) {
        this.nameAuthor = nameAuthor;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getYearOfPublishing() {
        return yearOfPublishing;
    }

    public void setYearOfPublishing(int yearOfPublishing) {
        this.yearOfPublishing = yearOfPublishing;
    }

    public double getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(int costPrice) {
        this.costPrice = costPrice;
    }

    public double getPriceForSale() {
        return priceForSale;
    }

    public void setPriceForSale(int priceForSale) {
        this.priceForSale = priceForSale;
    }

    public String getComicSeries() {
        return comicSeries;
    }

    public void setComicSeries(String comicSeries) {
        this.comicSeries = comicSeries;
    }

    public int getNumberOfComic() {
        return numberOfComic;
    }

    public void setNumberOfComic(int numberOfComic) {
        this.numberOfComic = numberOfComic;
    }

    @Override
    public String toString() {
        return "Comic{" +
                "Название комикса ='" + nameComic + '\'' +
                ", имя автора ='" + nameAuthor + '\'' +
                ", количество страниц =" + numberOfPages +
                ", жанр ='" + genre + '\'' +
                ", год выпуска =" + yearOfPublishing +
                ", себестоимость =" + costPrice +
                ", цена продажи =" + priceForSale +
                ", вселенная ='" + comicSeries + '\'' +
                ", количество штук в наличии =" + numberOfComic +
                '}';
    }


}
