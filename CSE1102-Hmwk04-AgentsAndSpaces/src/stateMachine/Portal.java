package stateMachine;

/****************************************************************************
 * Creates a portal, to allow travel from one <code>Space</code> to another
 *
 ***************************************************************************/
public class Portal {

	private Space  _destination;
	private String _direction;
	private String _name;
	
	/************************************************************************
	 * Returns the <code>Portal</code> destination.
	 * 
	 ************************************************************************/
	public Space getDestination() {
		return _destination;
	}
	
	/************************************************************************
	 * Returns the <code>Portal</code> direction.
	 * 
	 ************************************************************************/
	public String getDirection() {
		return _direction;
	}
	
	/************************************************************************
	 * Returns the <code>Portal</code> name.
	 * 
	 ************************************************************************/
	public String getName() {
		return _name;
	}
	
	/************************************************************************
	 * Sets the <code>Portal</code> destination.
	 * @param newDestination The new destination.
	 * 
	 ************************************************************************/
	public void setDestination(Space newDestination) {
		_destination = newDestination;
	}
	
	/************************************************************************
	 * Sets the <code>Portal</code> direction.
	 * @param newDirection The new direction.
	 * 
	 ************************************************************************/
	public void setDirection(String newDirection) {
		_direction = newDirection;
	}
	
	/************************************************************************
	 * Sets the <code>Portal</code> name.
	 * @param newName The new name.
	 * 
	 ************************************************************************/
	public void setName(String newName) {
		_name = newName;
	}
	
	/************************************************************************
	 * Returns a short string description of <code>Portal</code>.
	 * 
	 ************************************************************************/
	public String toString() {
		String print = _name + " that goes " + _direction;
		
		return print;
	}
	
	/************************************************************************
	 * Returns a long string description of <code>Portal</code>.
	 * 
	 ************************************************************************/
	public String toStringLong() {
		String print = _name + " that goes " + _direction + " to " + _destination.getName();
		
		return print;
	}
	
	/************************************************************************
	 * Sends the <code>Agent</code> to the connected <code>Space</code>.
	 * @param person The <code>Agent</code> to send.
	 * 
	 ************************************************************************/
	public void transport(Agent person) {
		person.setLocation(_destination);
	}
}