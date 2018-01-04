
public abstract class Robot {
	private String _name;
	
	public Robot(String name) {
		_name = name;
	}

	public void sayName() {
		System.out.println("My name is " + _name);
	}
	
	public String getName() {
		return _name;
	}
	
	public abstract void sayHello();
}
