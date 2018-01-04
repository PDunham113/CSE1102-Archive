
public class FrenchRobot extends Robot {

	public FrenchRobot(String name) {
		super(name);
	}

	@Override
	public void sayHello() {
		System.out.print("Bon jour. ");
		this.sayName();
	}
	
	public void sayName() {
		System.out.println("Je m'apple " + this.getName());
	}

}
