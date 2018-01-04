
public class Car extends Vehicle {

	public Car(String color) {
		super(color);
	}
	
	@Override
	public String toString() {
		return getColor() + " car";
	}
}
