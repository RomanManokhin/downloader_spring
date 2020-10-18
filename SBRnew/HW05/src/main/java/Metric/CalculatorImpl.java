package Metric;

public class CalculatorImpl implements Calculator{

    @Override
    public int calc(int number) {
        int result = 1;
        for (int i = 1; i <= number; i++) {
            result *= i;
        }
        return result;
    }

    @Override
    public int calc1(int number) {
        int result = 1;
        for (int i = 1; i <= number; i++) {
            result *= i;
        }
        System.out.println("No Annotation metric");
        return result;
    }
}
