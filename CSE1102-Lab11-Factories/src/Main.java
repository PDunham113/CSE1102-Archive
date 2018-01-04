
public class Main {

	public static void main(String[] args) {
		VehicleFactory[] factory = {new VehicleFactory(), new VehicleFactory("yellow"), new VehicleFactory("blue") };
		
		Vehicle[] vs = {factory[0].create("car"), factory[1].create("boat"), factory[2].create("convertible"), factory[2].create("motorcycle") };
		
		for(Vehicle v : vs)
			System.out.println("main method got a " + v);
	}

}
