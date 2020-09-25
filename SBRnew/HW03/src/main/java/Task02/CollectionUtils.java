package Task02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CollectionUtils {
    public static <T> void addAll(List<? extends T> source, List<? super T> destination) {
        destination.addAll(source);
    }

    public static <T> List<T> newArrayList() {
        return new ArrayList<T>();
    }

    public static int indexOf(List source, Object o) {
        return source.indexOf(o);
    }

//    public static List limit(List source, int size) {
//
//
//    }

    public static void add(List source, Object o) {
        source.add(o);
    }

    public static void removeAll(List removeFrom, List c2) {

    }

    public static boolean containsAll(List c1, List c2) {
        if (c1.containsAll(c2)) {
            return true;
        } else
            return true;
    }

    public static boolean containsAny(List c1, List c2) {
        for (int i = 0; i < c1.size(); i++) {
            if (c2.contains(c1.get(i))) {
                return true;
            }
        }
        return false;
    }

//    public static List range(List list, Object min, Object max) {
//
//    }

//    public static List range(List list, Object min, Object max, Comparator comparator) { }

}
