package Task01;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import static java.lang.ClassLoader.getSystemClassLoader;

public class CacheProxy implements InvocationHandler {

    private final Object delegate;


    public CacheProxy(Object delegate) {
        this.delegate = delegate;
    }

    public static<T> T factProxy(Object delegate){
        return (T) Proxy.newProxyInstance(getSystemClassLoader(),
                delegate.getClass().getInterfaces(),
                new CacheProxy(delegate));
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(delegate, args);
    }


}
