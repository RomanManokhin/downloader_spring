package Metric;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Main {

//    public static void validateStringLength(Object o) throws Exception {
//        Class<?> clazz = o.getClass();
//        for (Field field : clazz.getDeclaredFields()) {
//            if (field.isAnnotationPresent(Metric.class)) {
////                Metric an= field.getAnnotation(Metric.class);
//                CalculatorImpl calculatorImpl = new CalculatorImpl();
//
//                Calculator proxy = (Calculator) Proxy.newProxyInstance(
//                        CalculatorImpl.class.getClassLoader(),
//                        CalculatorImpl.class.getInterfaces(),
//                        new PerformanceProxy(calculatorImpl));
//
//                System.out.println(proxy.calc(5));
//
//            }
//        }
//    }

    public static void main(String[] args) throws Exception {

        CalculatorImpl calculatorImpl = new CalculatorImpl();

        Calculator proxy = (Calculator) Proxy.newProxyInstance(
                CalculatorImpl.class.getClassLoader(),
                CalculatorImpl.class.getInterfaces(),
                new PerformanceProxy(calculatorImpl));

        Method[] method = Calculator.class.getDeclaredMethods();
        for (Method method1 : method) {
            if (method1.isAnnotationPresent(Metric.class)) {
                System.out.println(proxy.calc(5) + "\n");
            } else {
                System.out.println(calculatorImpl.calc1(10) + "\n");
            }
        }
    }
}
