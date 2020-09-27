package Task02;

import java.util.*;


public class CollectionUtils<T> {
    public static <T> void addAll(List<? extends T> source, List<? super T> destination) {
        destination.addAll(source);
    }

    public static <T> List<? extends T> newArrayList() {
        return new ArrayList<>();
    }

    public int indexOf(List<? super T> source, T o) {
        return source.indexOf(o);
    }

    public List<? extends  T> limit(List<? extends T> source, int size) {
        for (int i = 0; i < source.size(); i++) {
            source.remove(size - 1);
        }
        return source;
    }

    public void add(List<? super T> source, T o) {
        source.add(o);
    }

    public void removeAll(List<? super T> removeFrom, List<T> c2) {
        removeFrom.removeAll(c2);
    }

    public boolean containsAll(List<? super T> c1, List<T> c2) {
        return c1.containsAll(c2);
    }

    public boolean containsAny(List<? extends T> c1, List<? extends T> c2) {
        for (T o : c1) {
            if (c2.contains(o)) {
                return true;
            }
        }
        return false;
    }

    public List<T> range(List<? extends T> list, T min, T max) {
        return new ArrayList<T>();
    }

    public List<T> range(List<T> list, T min, T max, Comparator<T> comparator) {
        return new ArrayList<>();
    }

}
