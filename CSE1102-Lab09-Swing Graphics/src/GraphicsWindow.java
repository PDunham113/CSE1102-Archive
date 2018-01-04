
import javax.swing.JFrame;

public class GraphicsWindow extends JFrame {
	private static final long serialVersionUID = 1L;
	private DrawingPanel      _drawingPanel;

	public GraphicsWindow() {
		this.setSize(600, 400);
		this.setVisible(true);
		this._drawingPanel = new DrawingPanel(); 
		this.setContentPane(_drawingPanel);
	}

	public void addShape(Shape shape) {
		_drawingPanel.addShape(shape);		
	}
}