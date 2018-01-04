

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class FlashingSquare extends Square implements ActionListener {
	
	public FlashingSquare(int x, int y, int size) {
		super(x, y, size);
		Timer timer = new Timer(500, this);
		timer.start();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		mousePressed(null);
		
	}
}