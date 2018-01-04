// Homework 07 - Laser Mirrors
// CSE 1102-Introduction to Object-Oriented Programming
// Patrick Dunham
// Asma Farhan Section 003
// 2014-04-02
package lasers;
import java.util.Scanner;

/****************************************************************************
 * Runs a simulation of a laser beam traversing through a grid of mirrors
 *
 ***************************************************************************/
public class Lazorz {

	static int numRows, numCols;
	static int fire  = -1;
	static final int north = 0, east = 1, south = 2, west = 3;
	
	static String[] initStrings =
		{
		 "...../...\\",
		 "..\\.......",
		 "......./..",
		 "..........",
		 "........\\.",
		 "..........",
		 "..........",
		 ".....\\../.",
		 "..\\....../",
		 ".........."
		};	
	
	static char[][] squares;
	
	/************************************************************************
	 * Runs the simulation. After displaying the mirror grid, it will ask the
	 * user which row they wish the laser to be fired into.
	 * 
	 ************************************************************************/
	public static void main(String[] args) {
		Scanner kbd = new Scanner(System.in);
		
		initialize();
		show();
		
		System.out.println("Enter which row to fire the laser: ");
		fire = kbd.nextInt();
		
		fire();
		show();
		
		kbd.close();
	}
	
	/************************************************************************
	 * Initializes the mirror grid inside the <code>squares</code> array 
	 * based on the contents of the <code>initStrings</code> array.
	 * 
	 ************************************************************************/
	public static void initialize() {
		numRows = initStrings.length;
		numCols = initStrings[0].length();
		
		squares = new char[numCols][numRows];
		
		for(int row = 0; row < numCols; row++) {
			for(int col = 0; col < numRows; col++) {
				char j = initStrings[row].charAt(col); 
				squares[col][row] = j;
			}
		}
	}
	
	/************************************************************************
	 * Prints the <code>squares</code> array to the screen. If the laser has
	 * been fired, it indicates the row it has been fired from.
	 * 
	 ************************************************************************/
	public static void show() {
		for(int row = 0; row < numCols; row++) {
			System.out.print(row);
			if(fire == row) {
				System.out.print(">");
			}
			else {
				System.out.print(" ");
			}
			
			for(int col = 0; col < numRows; col++) {
				System.out.print(squares[col][row]);
			}
			System.out.println();
		}
	}

	/************************************************************************
	 * Simulates the firing of the laser. Draws the path in the <code>squares
	 * </code> array.
	 * 
	 ************************************************************************/
	public static void fire() {
		int laserDir = east;
		int laserCol = 0;
		int laserRow = fire;
		
		boolean inGrid = true;
		char oldChar, newChar = '.';
		
		while(inGrid) {
			oldChar = squares[laserCol][laserRow];
			
			switch(oldChar) {
				case '.':
					switch(laserDir) {
						case north:
						case south:
							newChar = '|';
							break;
						
						case east:
						case west:
							newChar = '-';
							break;
					}
					break;
					
				case '-':
				case '|':
					newChar = '+';
					break;
					
				case '/':
					switch(laserDir) {
						case north:
							laserDir = east;
							break;
							
						case east:
							laserDir = north;
							break;
							
						case south:
							laserDir = west;
							break;
							
						case west:
							laserDir = south;
							break;
					}
					newChar = '/';
					break;
					
				case '\\':
					switch(laserDir) {
						case north:
							laserDir = west;
							break;
							
						case east:
							laserDir = south;
							break;
							
						case south:
							laserDir = east;
							break;
							
						case west:
							laserDir = north;
							break;
					}
					newChar = '\\';
					break;
			}
			squares[laserCol][laserRow] = newChar;
			
			switch(laserDir) {
				case north:
					laserRow--;
					break;
					
				case east:
					laserCol++;
					break;
				
				case south:
					laserRow++;
					break;
				
				case west:
					laserCol--;
					break;
			}
			
			if(laserRow < 0 || laserRow >= numRows || laserCol < 0 || laserCol >= numCols) {
				inGrid = false;
			}
		}
	}
}