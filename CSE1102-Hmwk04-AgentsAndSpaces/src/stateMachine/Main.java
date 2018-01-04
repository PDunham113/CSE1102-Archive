// Homework 04 - Agents
// CSE 1102-Introduction to Object-Oriented Programming
// Patrick Dunham
// Asma Farhan Section 003
// 2014-02-17

package stateMachine;

/****************************************************************************
 * Runs a complete combination of <code>Agents</code>, <code>Spaces</code>,
 * and <code>Portals</code>
 *
 ***************************************************************************/
public class Main {

	/************************************************************************
	 * Runs the state machine.
	 * 
	 ************************************************************************/
	public static void main(String[] args) {		
		Agent player     = new Agent();		 
		
		Space bedroom    = new Space();
		Space bathroom   = new Space();
		Space yard       = new Space();
		
		Portal bathDoor  = new Portal();
		Portal window    = new Portal();
		
		bedroom.setName("bedroom");
		bedroom.setDescription("a spacious master bedroom");
		bedroom.setPortal(bathDoor);
		
		bathroom.setName("bathroom");
		bathroom.setDescription("a very clean bathroom, with a toilet, shower, and tub");
		bathroom.setPortal(window);
		
		yard.setName("yard");
		yard.setDescription("It is pitch black. You are likely to be eaten by a grue.");
		
		bathDoor.setName("door");
		bathDoor.setDirection("out");
		bathDoor.setDestination(bathroom);
		
		window.setName("window");
		window.setDirection("outside");
		window.setDestination(yard);

		player.setName("Pat");
		player.setLocation(bedroom);
		
		CommandInterpreter.run(player);
	}
}