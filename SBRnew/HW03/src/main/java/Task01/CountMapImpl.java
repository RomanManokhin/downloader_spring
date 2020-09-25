package Task01;

import java.util.HashMap;
import java.util.Map;

public class CountMapImpl<T> implements CountMap<T> {

    private Map<T, Integer> map;
    private int count;

    public CountMapImpl() {
        map = new HashMap<>();
    }

    // добавляет элемент в этот контейнер.

    public void add(T o) {
        if (map.containsKey(o)) {
            map.put(o, (map.get(o) + 1));
        } else {
            map.put(o, 1);
        }
    }


    //Возвращает количество добавлений данного элемента
    @Override
    public int getCount(T o) {
        return map.get(o);
    }

    //Удаляет элемент из контейнера и возвращает количество его добавлений(до удаления)
    @Override
    public int remove(T o) {
        count = map.get(o);
        map.remove(o);
        return count;
    }

    //количество разных элементов
    @Override
    public int size() {
        return map.size();
    }

    //Добавить все элементы из source в текущий контейнер,
    // при совпадении ключей,     суммировать значения
    @Override
    public void addAll(CountMap<T> source) {
        source.toMap().forEach((key, value) -> {
            if (map.containsKey(key)) {
                map.put(key, (map.get(key) + value));
            } else {
                map.put(key, value);
            }
        });
    }

    //Вернуть java.util.Map. ключ - добавленный элемент,
    // значение - количество его добавлений
    @Override
    public Map<T, Integer> toMap() {
        return map;
    }

    //Тот же самый контракт как и toMap(), только всю информацию записать в destination
    @Override
    public void toMap(Map<T, Integer> destination) {
        destination = map;
        System.out.println(destination);
    }

    @Override
    public String toString() {
        return "CountMapImpl{" +
                "map=" + map +
                '}';
    }
}
