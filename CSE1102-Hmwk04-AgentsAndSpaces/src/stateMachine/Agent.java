package stateMachine;

/****************************************************************************
 * Creates an <code>Agent</code> to navigate the simulation.
 *
 ***************************************************************************/
public class Agent {
	
	private Space  _location;
	private String _name;
	
	/************************************************************************
	 * Returns the <code>Agent</code> location.
	 * 
	 ************************************************************************/
	public Space getLocation() {
		return _location;
	}
	
	/************************************************************************
	 * Returns the <code>Agent</code> name.
	 * 
	 ************************************************************************/
	public String getName() {
		return _name;
	}
	
	/************************************************************************
	 * Sets the <code>Agent</code> location.
	 * @param newLocation The new location.
	 * 
	 ************************************************************************/
	public void setLocation(Space newLocation) {
		_location = newLocation;
	}

	/************************************************************************
	 * Sets the <code>Agent</code> name.
	 * @param newLocation The new name.
	 * 
	 ************************************************************************/
	public void setName(String newName) {
		_name = newName;
	}
	
	/************************************************************************
	 * Returns a short string describing <code>Agent</code>.
	 * 
	 ************************************************************************/
	public String toString() {
		return _name;
	}
	
	/************************************************************************
	 * Returns a long string describing <code>Agent</code>.
	 * 
	 ************************************************************************/
	public String toStringLong() {
		String print = _name + " is in " + _location.toString();
		
		return print;
	}
	
	/************************************************************************
	 * Uses the portal in the current <code>Space</code>.
	 * 
	 ************************************************************************/
	public boolean usePortal() {
		Portal portal = _location.getPortal();
		
		if(portal != null) {
			System.out.println(_name + " is moving from " + _location + " to " + portal.getDestination());
			
			portal.transport(this);
			
			return true;
		}
		
		return false;
	}
}