package ph.com.bpi.oop.Exercise2;

public abstract class Vehicle {
	
	private int numberOfWheels;
	private String brand;
	
	public Vehicle(int numberOfWheels, String brand) {
		this.setNumberOfWheels(numberOfWheels);
		this.setBrand(brand);
	}
	

	//Getters and Setters
    public int getNumberOfWheels() {
        return numberOfWheels;
    }

    public String getBrand() {
        return brand;
    }
    
    public void setNumberOfWheels(int numberOfWheels) {
        this.numberOfWheels = numberOfWheels;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    // abstract method
    public abstract void startEngine();

    // concrete method
    public void destroy() {
        System.out.println("Destroying " + brand + " vehicle with " + numberOfWheels + " wheels...");
    }


}
