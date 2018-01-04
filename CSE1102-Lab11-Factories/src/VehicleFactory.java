
public class VehicleFactory {
	
	private String _color;

	public VehicleFactory() {
		this("white");
	}
	
	public VehicleFactory(String color) {
		_color = color;
	}
	
	public Vehicle create(String type) {
		Vehicle vehicle;
		
		switch(type) {
			case "car":
				vehicle = new Car(_color);
				break;
			case "convertible":
				vehicle = new Convertible(_color);
				break;
			case "boat":
				vehicle = new Boat(_color);
				break;
			default:
				vehicle = new Car("white");
		}
		
		System.out.println("VehicleFactory created a " + vehicle);		
		return vehicle;
	}
}
