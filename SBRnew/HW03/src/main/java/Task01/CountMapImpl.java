package Task01;

import java.util.HashMap;
import java.util.Map;

public class CountMapImpl<T> implements CountMap {

    private Map<T, Integer> map;
    private int count;

    public CountMapImpl() {
        map = new HashMap<>();
    }

    // добавляет элемент в этот контейнер.
    @Override
    public void add(Object o) {
        if (map.containsKey(o)) {
            map.put((T) o, (map.get(o) + 1));
        } else {
            map.put((T) o, 1);
        }
    }

    //Возвращает количество добавлений данного элемента
    @Override
    public int getCount(Object o) {
        return map.get(o);
    }

    //Удаляет элемент из контейнера и возвращает количество его добавлений(до удаления)
    @Override
    public int remove(Object o) {
        count = map.get(o);
        map.remove(o);
        return count;
    }

    //количество разных элементов
    @Override
    public int size() {
        count = 0;
        for(Object i : map.keySet()){
            if(map.keySet().contains(i)){
                count++;
            }
        }
        return count;
    }

    //Добавить все элементы из source в текущий контейнер,
    // при совпадении ключей,     суммировать значения
    @Override
    public void addAll(CountMap source) {

    }

    //Вернуть java.util.Map. ключ - добавленный элемент,
    // значение - количество его добавлений
    @Override
    public java.util.Map toMap() {
        return null;
    }

    //Тот же самый контракт как и toMap(), только всю информацию записать в destination
    @Override
    public void toMap(java.util.Map destination) {

    }

    @Override
    public String toString() {
        return "CountMapImpl{" +
                "map=" + map.keySet() + map.values() +
                '}';
    }
}
