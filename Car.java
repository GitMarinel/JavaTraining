package ph.com.bpi.oop.Exercise1;

public class Car {
	private String brand;
	private String color;
	private int carNum;
	
	//No Arg
	public Car() {
		this.brand = "Toyota";
		this.color = "Blue";
		this.carNum = 1;
	}
	//With Arg
	public Car(String brand, String color, int carNum) {
		this.setBrand(brand);
		this.setColor(color);
		this.setCarNum(carNum);
	}
	
	//Get Details
	public String getColor() {
		return this.color;
	}
	public String getBrand() {
		return this.brand;
	}
	public int getCarNum() {
		return this.carNum;
	}
	
	//Set Details
	public void setColor(String color) {
		this.color = color;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public void setCarNum(int carNum) {
		this.carNum = carNum;
	}
	
	//Method to Show
	public void Show() {
		System.out.println("The car" + getCarNum() + " is a " + getBrand() + " in color " + getColor() + ".");
	}
}
