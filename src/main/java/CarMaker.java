import java.util.List;

public class CarMaker implements Runnable {
    private final int CREATE_TIME = 1000;
    private final List<Car> carList;

    public CarMaker(List<Car> carList) {
        this.carList = carList;
    }

    @Override
    public void run() {
        Car car = new Car();
        try {
            Thread.sleep(CREATE_TIME);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        synchronized (carList) {
            carList.add(car);
            carList.notify();
            System.out.println(Thread.currentThread().getName() + " выпустил 1 авто");
        }
    }
}