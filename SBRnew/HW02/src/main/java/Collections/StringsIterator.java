package Collections;

import java.util.List;

public class StringsIterator implements java.util.Iterator {

    private List<String> list;
    private Integer index;
    private Integer[] personTake;


    public StringsIterator(List<String> list, Integer[] personTake) {
        this.list = list;
        this.personTake = personTake;
        index = -1;
    }

    public StringsIterator(List<String> list) {
        this.list = list;
        index = list.size();
    }

    @Override
    public boolean hasNext() {
        if (personTake != null) return !list.isEmpty() && index < personTake.length - 1;
        return !list.isEmpty() && index > 0;
    }

    @Override
    public String next() {
        if (personTake != null) return list.get(personTake[++index]);
        return list.get(--index);
    }


}
