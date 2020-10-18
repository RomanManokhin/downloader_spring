package Task01;


import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        Stream<Integer> integerStream = Stream
                .of(1, 2, 2, 3, 4, 5, 6, 7, 8, 8, 9)
                .filter(i -> i % 2 == 0)
                .map(i -> i * i)
                .distinct();
        integerStream.forEach(System.out::println);

        System.out.println("---------------------------------------------------------");

        StreamLambda streamLambda = new StreamLambda();
        streamLambda.addList(1, 2, 2, 3, 4, 5, 6, 7, 8, 8, 9);
        System.out.println(streamLambda);

    }
}
