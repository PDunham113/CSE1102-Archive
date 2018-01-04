package stateMachine;

/****************************************************************************
 * Creates a <code>Space</code> for an <code>Agent</code> to exist in.
 *
 ***************************************************************************/
public class Space {
	
	private String _description;
	private String _name;
	private Portal _portal;
	
	/************************************************************************
	 * Returns the <code>Space</code> description.
	 * 
	 ************************************************************************/
	public String getDescription() {
		return _description;
	}
	
	/************************************************************************
	 * Returns the <code>Space</code> name.
	 * 
	 ************************************************************************/
	public String getName() {
		return _name;
	}
	
	/************************************************************************
	 * Returns the <code>Portal</code> connected to <code>Space</code>.
	 * 
	 ************************************************************************/
	public Portal getPortal() {
		return _portal;
	}
	
	/************************************************************************
	 * Sets the <code>Space</code> description.
	 * @param newDescription The new description.
	 * 
	 ************************************************************************/
	public void setDescription(String newDescription) {
		_description = newDescription;
	}
	
	/************************************************************************
	 * Sets the <code>Space</code> name.
	 * @param newName The new name.
	 * 
	 ************************************************************************/
	public void setName(String newName) {
		_name = newName;
	}
	
	/************************************************************************
	 * Sets the <code>Portal</code> connected to <code>Space</code>.
	 * @param newPortal The new <code>Portal</code>
	 * 
	 ************************************************************************/
	public void setPortal(Portal newPortal) {
		_portal = newPortal;
	}
	
	/************************************************************************
	 * Returns a short string describing <code>Space</code>.
	 * 
	 ************************************************************************/
	public String toString() {
		return _name;
	}
	
	/************************************************************************
	 * Returns a long string describing <code>Space</code>.
	 * 
	 ************************************************************************/
	public String toStringLong() {
		String print = _name + ": " + _description;
		
		if(_portal != null) {
			print += " with a " + _portal.toStringLong();
		}
		
		return print;
	}
}