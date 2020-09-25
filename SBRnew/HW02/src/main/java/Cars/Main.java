package Cars;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Car> cars = new ArrayList<>();

        cars.add(new Car("Лада","Седан"));
        cars.add(new Car("Лада","Хэтчбек"));
        cars.add(new Car("Лада","Кроссовер"));
        cars.add(new Car("БМВ","Седан"));
        cars.add(new Car("БМВ","Хэтчбек"));
        cars.add(new Car("БМВ","Кроссовер"));
        cars.add(new Car("Мерседес","Седан"));
        cars.add(new Car("Мерседес","Хэтчбек"));
        cars.add(new Car("Мерседес","Кроссовер"));

        List<Car> carTypeSedan = new ArrayList<>();
        List<Car> carTypeHatchback = new ArrayList<>();
        List<Car> carTypeCrossover = new ArrayList<>();

        for (Car car : cars) {
            if (car.getType().equals("Седан")) {
                carTypeSedan.add(car);
            } else if (car.getType().equals("Хэтчбек")) {
                carTypeHatchback.add(car);
            } else {
                carTypeCrossover.add(car);
            }
        }

        System.out.println(carTypeSedan);
        System.out.println(carTypeHatchback);
        System.out.println(carTypeCrossover);

    }
}

