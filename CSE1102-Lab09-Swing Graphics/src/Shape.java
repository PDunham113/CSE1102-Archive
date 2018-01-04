
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;

public interface Shape {
	public void paint(Graphics g);
	public void mousePressed(MouseEvent mev);
	public boolean contains(Point p);
}