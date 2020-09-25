package Task01;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {

        CountMap<String> map = new CountMapImpl<>();

        map.add("Привет");
        map.add("Привет");
        map.add("dfcz");
        map.add("Привет");
        map.add("ghas");
        map.add("Привет");

//
//        System.out.println(map);
//
//        System.out.println(map.getCount("Привет"));
////        System.out.println(map.remove(5));
////        System.out.println(map);
//        System.out.println(map.size());

        map.addAll(map);
//        Map<Integer, Integer> x = new HashMap<>();
                map.toMap(new HashMap<>());


//        System.out.println(map.getCount(5));
//        System.out.println(map.remove(5));
//        System.out.println(map);
//        System.out.println("Size = " + map.size());
//        System.out.println(map);

    }
}
