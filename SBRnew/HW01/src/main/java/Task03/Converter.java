package Task03;

public class Converter {

    public static float fahrenheit(float c){
        return 9 * c / 5 + 32;
    }

    public static float kelvin(float c){
        return c + 273.15f;
    }

    public static float rankineScale(float c){
        return fahrenheit(c) + 459.67f;
    }

}
