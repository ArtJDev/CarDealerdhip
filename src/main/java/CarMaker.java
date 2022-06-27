import java.util.List;

public class CarMaker implements Runnable {
    private final int CREATE_TIME = 1500;
    private final List<Car> carList;

    public CarMaker(List<Car> carList) {
        this.carList = carList;
    }

    @Override
    public void run() {
        synchronized (carList) {
            try {
                carList.add(new Car());
                Thread.sleep(CREATE_TIME);
                carList.notify();
                System.out.println(Thread.currentThread().getName() + " выпустил 1 авто");
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
}