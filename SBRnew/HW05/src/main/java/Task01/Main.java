package Task01;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException {


        /**
         * Вывод всех методов класс, включаея приватные
         */
        try {
            Method[] method = Calculator.class.getMethods();
            for (Method m : method) {
                System.out.println(m);
            }
            Method[] method1 = CalculatorImpl.class.getDeclaredMethods();
            for (Method m1 : method1) {
                System.out.println(m1);
            }
        } catch (Exception e) {
            e.getMessage();
        }

        /**
         * Вывод всех геттеров и сеттеров
         */




    }
}
