package Collections;

import java.util.*;

public class Main{
    public static void main(String[] args) {

        String inputText = "Smallest directly families son surprise honoured am an Speaking replying mistress him numerous she" +
                " returned feelings may set day Evening way luckily son exposed get general greatly Zealously prevailed" +
                " be arranging do Set arranging son too dejection september happiness";

        String[] preparedArrayOfStrings = inputText.toLowerCase().split(" ");

        Map<String, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < preparedArrayOfStrings.length; i++) {
            if (!hashMap.containsKey(preparedArrayOfStrings[i]))
                hashMap.put(preparedArrayOfStrings[i], 1);
            else
                hashMap.put(preparedArrayOfStrings[i], hashMap.get(preparedArrayOfStrings[i]) + 1);
        }

        System.out.println("Задание 1 : ");
        Set<String> uniqueStrings = new HashSet<>(Arrays.asList(preparedArrayOfStrings));
        System.out.println(uniqueStrings.size());


        System.out.println("Задание 2 : \n");
        List<String> list = new ArrayList<>(hashMap.keySet());
        list.sort((o1, o2) -> {
            if (o1.length() > o2.length()) {
                return 1;
            } else if (o1.length() < o2.length()) {
                return -1;
            } else {
                return o1.compareTo(o2);
            }
        });
        System.out.println(list);

        System.out.println("\nЗадание 3 : \n");
        for (var entry : hashMap.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        System.out.println("\nЗадание 4 : ");
        List<String> listReverse = new ArrayList<>(Arrays.asList(preparedArrayOfStrings));
        Collections.reverse(listReverse);
        System.out.println(listReverse);


        System.out.println("\nЗадание 5 : ");
        List<String> listForIterator = new ArrayList<>(Arrays.asList(preparedArrayOfStrings));
        StringsIterator wordsIteratorReverse = new StringsIterator(listForIterator);
        while (wordsIteratorReverse.hasNext()) {
            System.out.println(wordsIteratorReverse.next());
        }


        System.out.println("\nЗадание 6 : ");
        Integer[] intMas = {1, 3, 5, 2, 3, 4};
        StringsIterator wordsIteratorPersonChoice = new StringsIterator(listForIterator, intMas);
        while (wordsIteratorPersonChoice.hasNext()) {
            System.out.println(wordsIteratorPersonChoice.next());
        }

    }
}

