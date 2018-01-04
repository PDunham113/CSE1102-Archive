package stateMachine;
import jeff.textconsole.TextConsole;

public class Agent {
	
	private Space  _location;
	private String _name;
	
	public Agent(String name, Space location) {
		_name     = name;
		_location = location;
	}
	
	public Space getLocation() {
		return _location;
	}
	
	public String getName() {
		return _name;
	}
	
	public void setLocation(Space newLocation) {
		_location = newLocation;
	}

	public void setName(String newName) {
		_name = newName;
	}
	
	public String toString() {
		return _name;
	}
	
	public String toStringLong() {
		String print = _name + " is in " + _location.toString();
		
		return print;
	}
	
	public boolean usePortal(TextConsole console) {
		Portal portal = _location.getPortal();
		
		if(portal != null) {
			console.println(_name + " is moving from " + _location + " to " + portal.getDestination());
			
			portal.transport(this);
			
			return true;
		}
		
		return false;
	}
}
