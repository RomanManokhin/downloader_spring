import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

public class popularityComic {

    private HashMap<Comic, ArrayList<Calendar>> popular = new HashMap<>();

    void InitPopularity(){
//        popular.put()
    }

    public void addComicToPopular(int id, ComicBase comicBase, Calendar newDate) {
        if (!popular.containsKey(comicBase.getComicDB().get(id))) {
            ArrayList<Calendar> dates = new ArrayList<>();
            dates.add(newDate);
            popular.put(comicBase.getComicDB().get(id), dates);
            return;
        }
        popular.get(comicBase.getComicDB().get(id)).add(newDate);
    }


    public HashMap<Comic, ArrayList<Calendar>> getPopular() {
        return popular;
    }

    public void setPopular(HashMap<Comic, ArrayList<Calendar>> popular) {
        this.popular = popular;
    }
}
