
public class Robot {
	
	@SuppressWarnings("unused")
	private String  _name;
	@SuppressWarnings("unused")
	private int     _serial;
	private Battery _battery;
	@SuppressWarnings("unused")
	private Gripper _gripper;
	
	public Robot() {
		this._name    = "";
		this._serial  = -1;
		this._battery = new Battery();
		this._gripper = new Gripper();
		
		this._battery.recharge();
	}

	public Robot(String name, int serial, int battMinutes) {
		this._name    = name;
		this._serial  = serial;
		this._battery = new Battery(battMinutes);
		this._gripper = new Gripper();
	}
	
	public int getMinutes() {
		return this._battery.getMinutes();
	}
}
