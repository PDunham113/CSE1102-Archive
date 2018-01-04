
public class Battery {
	private int _minutesLeft;
	
	public Battery() {
		this.recharge();
	}
	
	public Battery(int battMinutes) {
		this._minutesLeft = battMinutes;
	}

	public void recharge() {
		this._minutesLeft = 30;		
	}
	
	public void recharge(int battMinutes) {
		this._minutesLeft = battMinutes;		
	}
	
	public int getMinutes() {
		return this._minutesLeft;
	}
}
