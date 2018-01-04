
// CSE1102 Program 2
// Spring 2014
// Patrick Dunham

package robotGrid;
import robotgrid.*;

/****************************************************************************
 * Runs a robot through a predetermined maze.
 *
 ***************************************************************************/
public class Test {
	
	/************************************************************************
	 * Sets up the maze, and navigates the robot through it.
	 * 
	 ************************************************************************/
	public static void main(String[] args) {
		int counter = 0;
		
		GridServer server = new GridServer();
		Grid grid = server.createGrid("Test", 10, 10 );
		Robot robot1 = new Robot("Robot 1", Heading.East);
		
		grid.placeObject(robot1, 0, 0);
		setup(grid);
		// pause a bit before things start to happen
		Utils.sleep(500);
		
		counter = 8;
		while(counter > 0) {
			robot1.move();
			counter--;
		}
		
		robot1.turnRight();
		
		counter = 3;
		while(counter > 0) {
			robot1.move();
			counter--;
		}
		
		robot1.turnRight();
		
		counter = 3;
		while(counter > 0) {
			robot1.move();
			counter--;
		}
		
		robot1.turnLeft();
		
		counter = 5;
		while(counter > 0) {
			robot1.move();
			counter--;
		}
		
		robot1.turnLeft();
		robot1.turnLeft();
		
		counter = 6;
		while(counter > 0) {
			robot1.move();
			counter--;
		}
		
		robot1.turnLeft();
		
		counter = 4;
		while(counter > 0) {
			robot1.move();
			counter--;
		}
		
	}

	/************************************************************************
	 * Generates the predetermined maze for the robot to navigate.
	 * @param grid The <code>Grid</code> object the maze will be created in.
	 * 
	 ************************************************************************/
	private static void setup(final Grid grid) {
		for(int n=0; n<10; n++) {
			Wall wall = new Wall();
			grid.placeObject(wall, n, 5);
		}
		Layer layer = grid.getLayer(null);
		TriggerCell tc1 = new TriggerCell(layer, 8, 1, "") {
			@Override
			public void activate() {
				grid.removeObject(5, 5);
			}
		};
		layer.setCell(8, 1, tc1);
		TriggerCell tc2 = new TriggerCell(layer, 5, 8, "Checkpoint");
		layer.setCell(5, 8, tc2);
		TriggerCell tc3 = new TriggerCell(layer, 1, 2, "Finished!");
		layer.setCell(1, 2, tc3);
	}
}