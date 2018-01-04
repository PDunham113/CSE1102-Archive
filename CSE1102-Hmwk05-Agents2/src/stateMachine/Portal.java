package stateMachine;
public class Portal {

	private Space  _destination;
	private String _direction;
	private String _name;
	
	public Portal(String name, String direction, Space destination) {
		_name        = name;
		_direction   = direction;
		_destination = destination;
	}
	
	public Space getDestination() {
		return _destination;
	}
	
	public String getDirection() {
		return _direction;
	}
	
	public String getName() {
		return _name;
	}
	
	public void setDestination(Space newDestination) {
		_destination = newDestination;
	}
	
	public void setDirection(String newDirection) {
		_direction = newDirection;
	}
	
	public void setName(String newName) {
		_name = newName;
	}
	
	public String toString() {
		String print = _name + " that goes " + _direction;
		
		return print;
	}
	
	public String toStringLong() {
		String print = _name + " that goes " + _direction + " to " + _destination.getName();
		
		return print;
	}
	
	public void transport(Agent person) {
		person.setLocation(_destination);
	}
}
