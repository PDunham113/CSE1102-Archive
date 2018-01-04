
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;

public class Square implements Shape {

	private Color[] _colors = {Color.BLACK, Color.GREEN, Color.RED, Color.BLUE};
	private int _x, _y, _size, _currentColor;

	public Square(int x, int y, int size) {
		_x = x;
		_y = y;
		_size = size;
		_currentColor = 0;
	}

	@Override
	public void paint(Graphics g) {
		g.setColor(_colors[_currentColor]);
		g.drawRect(_x, _y, _size, _size);
	}

	@Override
	public void mousePressed(MouseEvent mev) {
		if(mev != null) {
			_x = mev.getX() - (_size / 2);
			_y = mev.getY() - (_size / 2);
			if(mev.getButton() == MouseEvent.BUTTON1)
				_currentColor++;
			else
				_currentColor--;
			if(_currentColor >= _colors.length)
				_currentColor = 0;
			else if(_currentColor < 0)
				_currentColor = _colors.length - 1;
			
		}
		else {
			_currentColor++;
			if(_currentColor >= _colors.length)
				_currentColor = 0;
		}
	}

	@Override
	public boolean contains(Point p) {
		return p.x >= _x && p.x < _x+_size && p.y >= _y && p.y < _y+_size;
	}
}