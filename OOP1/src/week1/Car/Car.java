package week1.Car;

public class Car {
	public String model;
	public int mileage;
	
	Car (String model, int mileage)
	{
		this.model = model;
		this.mileage = mileage;
	}

	public int getMileage() {
		return mileage;
	}

	public void setMileage(int mileage) {
		this.mileage = mileage;
	}
	
	
}
