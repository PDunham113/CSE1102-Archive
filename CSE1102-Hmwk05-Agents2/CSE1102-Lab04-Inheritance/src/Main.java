
public class Main {

	public static void main(String[] args) {
		Robot rE = new EnglishRobot("Marvin");
		Robot rF = new FrenchRobot("Remy");
		Robot rG = new GermanRobot("Hans");
		
		
		rE.sayHello();
		rF.sayHello();
		rG.sayHello();

	}

}
