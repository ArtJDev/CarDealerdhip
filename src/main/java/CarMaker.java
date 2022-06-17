public class CarMaker {
    private final int CREATTIME = 2000;
    private final Buyer buyer = new Buyer();

    public Car sellCar() {
        synchronized (buyer) {
            try {
                System.out.println(Thread.currentThread().getName() + " зашел в автосалон");
                while (buyer.getCars().size() == 0) {
                    System.out.println("Машин нет");
                    buyer.wait();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " уехал на новеньком авто");
            return buyer.getCars().remove(0);
        }
    }

    public synchronized void createCar() {
        try {
            System.out.println(Thread.currentThread().getName() + " выпустил 1 авто");
            Thread.sleep(CREATTIME);
            buyer.getCars().add(new Car());
            notify();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}