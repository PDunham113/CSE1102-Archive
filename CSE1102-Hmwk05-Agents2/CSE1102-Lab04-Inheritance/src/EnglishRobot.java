
public class EnglishRobot extends Robot {

	public EnglishRobot(String name) {
		super(name);
	}

	@Override
	public void sayHello() {
		System.out.print("Hello, there. ");
		this.sayName();
	}

}
