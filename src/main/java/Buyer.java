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
                Thread.sleep(BUY_TIME);
                if (carList.isEmpty()) {
                    System.out.println("Машин нет");
                    carList.wait();
                } else {
                    carList.notify();
                    carList.remove(0);
                    System.out.println(Thread.currentThread().getName() + " уехал на новеньком авто");
                }
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
}