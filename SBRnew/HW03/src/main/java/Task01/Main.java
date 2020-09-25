package Task01;
/*
CountMap<Integer> map = new CountMapImpl<>();

map.add(10);
map.add(10);
map.add(5);
map.add(6);
map.add(5);
map.add(10);

// int count = map.getCout(5);  // 2
// int count = map.getCout(6);  // 1
// int count = map.getCout(10); // 3

 */

public class Main {
    public static void main(String[] args) {

        CountMap<Integer> map = new CountMapImpl<>();

        map.add(10);
        map.add(10);
        map.add(5);
        map.add(5);

        System.out.println(map);
        System.out.println(map.getCount(5));
        System.out.println(map.remove(5));
        System.out.println(map);
        System.out.println("Size = " + map.size());
        System.out.println(map);

    }
}
