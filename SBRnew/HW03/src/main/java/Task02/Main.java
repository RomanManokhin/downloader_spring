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
        list.add(2);
        list.add(5);
        list.add(4);
        list.add(2);
        list.add(1);
        list.add(8);

        System.out.println(list);



        System.out.println(collectionUtils.range(list, 2,5 ));
    }
}

