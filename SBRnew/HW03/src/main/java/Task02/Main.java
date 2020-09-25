package Task02;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        CollectionUtils collectionUtils = new CollectionUtils();

        List<Integer> list = new ArrayList<Integer>();

        list.add(5);
        list.add(1);
        list.add(2);
        list.add(5);
        list.add(5);
        list.add(5);
        list.add(5);
        list.add(5);
        list.add(5);
        list.add(5);

        System.out.println(list);

        collectionUtils.add(list, 109);
        System.out.println(list);


    }
}

