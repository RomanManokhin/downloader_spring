package Task02;

import java.util.function.Function;

@FunctionalInterface
public interface LambdaInterface<T> {

    T sum(T value1, T value2);

}
