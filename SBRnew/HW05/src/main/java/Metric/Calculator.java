package Metric;

public interface Calculator {

    /**
     * Расчет факториала числа.
     * @param number
     */
    @Metric
    int calc (int number);
    @NoMetric
    int calc1 (int number);

}
