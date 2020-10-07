package Task01;

import com.sun.deploy.net.proxy.ProxyUtils;
import test.ValidLength;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Main {

    private static void run(Calculator calculator) {
        System.out.println(calculator.calc(5));
        System.out.println(calculator.calc(4));
        System.out.println(calculator.calc(3));
        System.out.println(calculator.calc(2));

    }

//    public static void annotationMethod(Object object) throws IllegalAccessException {
//        Class<?> clazz = object.getClass();
//        for (Field field : clazz.getDeclaredFields()) {
//            field.setAccessible(true);
//            if(field.isAnnotationPresent(ValidLength.class) && field.getType() == String.class){
//                ValidLength a = field.getAnnotation(ValidLength.class);
//                int min = a.max();
//                int max = a.max();
//                String value = field.get(object).toString();
//                if(value.length() < min || value.length() > max){
//                    throw new IllegalAccessException(field.getName() + " длинна данного поля должна быть в промежутке "
//                            + min + " - " + max);
//                }
//            }
//        }
//    }


    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException {

        Calculator calculator = new CalculatorImpl();
        /**
         * Вывод всех методов класс, включаея приватные
         */
            System.out.println("Parent methods");
            Method[] methods = Calculator.class.getDeclaredMethods();
            for (Method m : methods) {
                System.out.println(m);
            }
            System.out.println("\nChild methods");
            Method[] method = CalculatorImpl.class.getDeclaredMethods();
            for (Method method2 : method) {
                System.out.println(method2);
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

        Field[] staticFields = CalculatorImpl.class.getFields();
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
        Calculator proxy = CacheProxy.factProxy(calculator);
        run(proxy);



    }
}
