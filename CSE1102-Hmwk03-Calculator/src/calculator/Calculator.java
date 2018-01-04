// Homework 03 - Calculator
// CSE 1102-Introduction to Object-Oriented Programming
// Patrick Dunham
// Asma Farhan Section 003
// 2014-02-08

package calculator;
import java.util.Scanner;

/****************************************************************************
 * Creates a basic console-based calculator supporting addition, subtraction,
 * multiplication, division, and square roots.
 *
 ***************************************************************************/
public class Calculator {

	/************************************************************************
	 * Runs the <code>Calculator</code> instance.
	 ***********************************************************************/
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner kbd         = new Scanner(System.in);
		
		double  accumulator = 0.0;
		double  input       = 0.0;
		
		boolean contin      = true;
		
		while(contin) {
			int choice;
			
			System.out.println("Accumulator = " + accumulator);
			System.out.println("Please choose one of the following options:");
			System.out.println("0) Exit");
			System.out.println("1) Addition");
			System.out.println("2) Subtraction");
			System.out.println("3) Multiplication");
			System.out.println("4) Division");
			System.out.println("5) Square root");
			System.out.println("6) Clear");
			System.out.print("What is your choice?: ");
			choice = kbd.nextInt();
			
			if(choice == 0) {
				// exit calculator
				contin = false;
			}
			else if(choice == 1) {
				// do addition
				System.out.print("Enter a number: ");
				input = kbd.nextDouble();
				
				accumulator += input;
			}
			else if(choice == 2) {
				// do subtraction
				System.out.print("Enter a number: ");
				input = kbd.nextDouble();
				
				accumulator -= input;
			}
			else if(choice == 3) {
				// do multiplication
				System.out.print("Enter a number: ");
				input = kbd.nextDouble();
				
				accumulator *= input;
			}
			else if(choice == 4) {
				// do division
				System.out.print("Enter a number: ");
				input = kbd.nextDouble();
				
				accumulator /= input;
			}
			else if(choice == 5) {
				// do square root
				accumulator = Math.sqrt(accumulator);
			}
			else if(choice == 6) {
				// clear accumulator
				accumulator = 0.0;
			}
			else {
				System.out.println("Illegal operation: " + choice);
			}
		}
	}
}