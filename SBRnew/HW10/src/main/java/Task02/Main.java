package Task02;

public class Main {
    public static void main(String[] args) {

    LambdaInterface<String> sumString = String::concat;
//            (value1, value2) -> value1 + value2;
    LambdaInterface<Integer> sumInteger = Integer::sum;

        System.out.println(sumString.sum("abc", "def"));
        System.out.println(sumInteger.sum(1, 1));

    }
}
