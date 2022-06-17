import java.util.ArrayList;
import java.util.List;

public class Buyer {
    List<Car> cars = new ArrayList<>(10);

    List<Car> getCars() {
        return cars;
    }
}