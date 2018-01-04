
public class Boat extends Vehicle {

	public Boat(String color) {
		super(color);
	}
	
	@Override
	public String toString() {
		return getColor() + " boat";
	}

}
