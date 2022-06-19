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
                if (carList.isEmpty()) {
                    carList.add(new Car());
                    carList.notify();
                    Thread.sleep(CREATE_TIME);
                    System.out.println(Thread.currentThread().getName() + " выпустил 1 авто");
                } else {
                    carList.wait();
                }
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
}