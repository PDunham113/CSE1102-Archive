
public class Convertible extends Car {

	public Convertible(String color) {
		super(color);
	}
	
	@Override
	public String toString() {
		return getColor() + " convertible";
	}

}
