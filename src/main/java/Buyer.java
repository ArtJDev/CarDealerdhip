import java.util.List;

public class Buyer implements Runnable {
    private final int BUY_TIME = 1000;
    private final List<Car> carList;

    public Buyer(List<Car> carList) {
        this.carList = carList;
    }

    @Override
    public void run() {
        synchronized (carList) {
            try {
                System.out.println(Thread.currentThread().getName() + " зашел в автосалон");
                while (carList.isEmpty()) {
                    System.out.println("Машин нет");
                    carList.wait();
                }
                Thread.sleep(BUY_TIME);
                carList.remove(0);
                System.out.println(Thread.currentThread().getName() + " уехал на новеньком авто");
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
}