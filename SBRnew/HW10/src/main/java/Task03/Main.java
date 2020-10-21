package Task03;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {


        Stream.iterate(new long[]{0, 0, 1}, p -> new long[]{p[2], p[0], p[0] + p[1] + p[2]})
                .limit(10)
                .forEach(p -> System.out.println(p[0]));


    }
}
