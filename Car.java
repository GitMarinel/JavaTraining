package ph.com.bpi.oop.Exercise2;

public class Car extends Vehicle implements Refuelable {

	 public Car(String brand) {
	        super(4, brand); // Cars have 4 wheels
	    }

	    @Override
	    public void startEngine() {
	        System.out.println(getBrand() + " car engine started.");
	    }

	    @Override
	    public void refuel() {
	        System.out.println("Refueling " + getBrand() + " car.");
	    }

}
