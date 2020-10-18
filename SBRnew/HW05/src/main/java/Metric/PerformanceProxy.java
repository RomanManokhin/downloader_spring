package Metric;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class PerformanceProxy implements InvocationHandler{
    private Object obj;

    public PerformanceProxy(Object original) {
        obj = original;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws IllegalAccessException,
            IllegalArgumentException, InvocationTargetException {
        long start = System.nanoTime();
        long finish = System.nanoTime();
        long timeConsumedMillis = finish - start;
        System.out.println(timeConsumedMillis);
        return method.invoke(obj, args);
    }

}
