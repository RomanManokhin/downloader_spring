package Task01;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException {

        CalculatorImpl calculator = new CalculatorImpl();
        /**
         * Вывод всех методов класс, включаея приватные
         */
        try {
            System.out.println("Parent methods");
            Method[] method1 = Calculator.class.getDeclaredMethods();
            for (Method m : method1) {
                System.out.println(m);
            }
            System.out.println("\nChild methods");
            Method[] method = CalculatorImpl.class.getDeclaredMethods();
            for (Method method2 : method) {
                System.out.println(method2);
            }
        } catch (Exception e) {
            e.getMessage();
        }
        System.out.println("-----------------------------------");

        /**
         * Вывод всех геттеров
         */

        System.out.println("Getters");
        Method method1 = CalculatorImpl.class.getDeclaredMethod("getResult");
        Method method2 = CalculatorImpl.class.getDeclaredMethod("getResult2");
        Method method3 = CalculatorImpl.class.getDeclaredMethod("getText");

        System.out.println(method1.toString());
        System.out.println(method2.toString());
        System.out.println(method3.toString());
        System.out.println("-----------------------------------");

        /**
         * Проверить что все String константы имеют значение их имени
         * public static final String MONDAY = " MONDAY "
         */

        Field[] staticFields = CalculatorImpl.class.getFields(); //получаем имена поля
        Object valueOfField;
        for (Field staticField : staticFields) {
            valueOfField = staticField.get(calculator);

            if(staticField.getName().equals(valueOfField)){
                System.out.println(staticField.getName() + " = " + valueOfField);
            } else {
                System.out.println(staticField.getName() + " != " + valueOfField);
            }
        }

        System.out.println("-----------------------------------\n");

        /**
         * Реализовать кэширующий прокси
         */




    }
}
