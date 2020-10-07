package Task01;

public class CalculatorImpl implements Calculator {
    int result;
    private int result2;
    String text;
    public static final String MONDAY = "MONDAY";
    public static final String SUNDAY = "SUNDAY1";

    @Override
    public int calc(int number) {
        result = 1;
        for (int i = 1; i <= number; i++) {
            result *= i;
        }
        return result;
    }

    private int calc2(int number){
        result = 1;
        for (int i = 1; i <= number; i++) {
            result *= i;
        }
        return result;
    }

    public int getResult() {
        return result;
    }
    
    public void setResult(int result) {
        this.result = result;
    }

    public int getResult2() {
        return result2;
    }

    public void setResult2(int result2) {
        this.result2 = result2;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }


}
