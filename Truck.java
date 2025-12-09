package ph.com.bpi.oop.Exercise2;

public class Truck extends Vehicle implements Refuelable{

    public Truck(String brand, int numberOfWheels) {
        super(numberOfWheels, brand);
    }

    @Override
    public void startEngine() {
        System.out.println(getBrand() + " truck engine started.");
    }

    @Override
    public void refuel() {
        System.out.println("Refueling " + getBrand() + " truck.");
    }

}
