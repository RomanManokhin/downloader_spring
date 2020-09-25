package Task01;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        int[] array = {1, 3, 2, 5, 4, 7, 6};

        boolean sort = false;
        int buffer;

        while (!sort) {
            sort = true;

            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    sort = false;

                    buffer = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = buffer;
                }
            }
        }
        System.out.println(Arrays.toString(array));
    }
}
