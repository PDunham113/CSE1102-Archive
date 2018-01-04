
import javax.swing.SwingUtilities;

public class Main {
	public static void main(String[] args) {
		// Swing graphics should be done in a concurrently-running
		// thread. This creates just such a thread.
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				// The new thread starts running in this method.
				// All this method does is call the _setup method. 
				_setup();
			}
		});
	}
	
	private static void _setup() {
		GraphicsWindow gw = new GraphicsWindow();
		
		FlashingSquare sq0 = new FlashingSquare(20, 20, 100);
		FlashingSquare sq1 = new FlashingSquare(110, 20, 50);
		Square sq2 = new Square(40, 170, 118);
		gw.addShape(sq0);
		gw.addShape(sq1);
		gw.addShape(sq2);
	}
}