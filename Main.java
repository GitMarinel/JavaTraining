package ph.com.bpi.oop.Exercise2;

public class Main {

	public static void main(String[] args) {
		
		// Initialize Truck details
        Car car = new Car("Toyota");
        Truck truck = new Truck("Isuzu", 6);

        // Call inherited getters
        System.out.println("Car brand: " + car.getBrand() + ", wheels: " + car.getNumberOfWheels());
        System.out.println("Truck brand: " + truck.getBrand() + ", wheels: " + truck.getNumberOfWheels());

        // Call methods
        car.startEngine();
        car.refuel();

        truck.startEngine();
        truck.refuel();

        destroyVehicle(car);
        destroyVehicle(truck);
    }

    // Destroy method
    public static void destroyVehicle(Vehicle v) {
        v.destroy();
    }


}
