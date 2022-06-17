public class Main {
    public static void main(String[] args) {
        final CarMaker carMaker = new CarMaker();

        new Thread(null, carMaker::sellCar, "Покупатель 1").start();
        new Thread(null, carMaker::sellCar, "Покупатель 2").start();
        new Thread(null, carMaker::sellCar, "Покупатель 3").start();

        for (int i = 0; i < 5; i++) {
            new Thread(null, carMaker::createCar, "Производитель BMW").start();
        }
    }
}