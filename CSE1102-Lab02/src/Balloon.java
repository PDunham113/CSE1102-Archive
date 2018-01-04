import java.util.Scanner;


public class Balloon {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner kbd = new Scanner(System.in);
		
		double startTime = 0;
		double endTime   = 0;
		double sampleInt = 0;
		
		System.out.print("Please enter the start time: ");
		startTime = kbd.nextDouble();
		
		System.out.print("Please enter the end time: ");
		endTime = kbd.nextDouble();
		
		System.out.print("Please enter the sample interval: ");
		sampleInt = kbd.nextDouble();
		
		double altT;
		double velT;
		
		for(double t = startTime; t <= endTime; t += sampleInt) {
			altT = altitude(t);
			velT = velocity(t) / 3600;
			
			System.out.println(t + "\t" + altT + "\t" + velT);		
		}
		
	}
	
	public static double altitude(double t) {
		double alt = -0.12 * Math.pow(t, 4) + 12 * Math.pow(t,  3) - 380 * Math.pow(t,  2) + 4100 * t + 220;
		return alt;
	}

	public static double velocity(double t) {
		double vel = -0.48 * Math.pow(t,  3) + 36 * Math.pow(t,  2) - 760 * t + 4100;
		return vel;
	}
}
