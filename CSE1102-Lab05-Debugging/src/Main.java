
public class Main {
	public static void main(String[] args) {
		Robot r1 = new Robot();
		Robot r2 = new Robot("HAL 9000", 8675309, 25);
		
		System.out.println(r1.getMinutes());
		System.out.println(r2.getMinutes());
	}
}
