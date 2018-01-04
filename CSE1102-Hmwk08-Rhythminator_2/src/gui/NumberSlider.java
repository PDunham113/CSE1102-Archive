// Homework 8 - Rythyminator 2
// CSE 1102 Project 08, Spring 2014
// Patrick Dunham
// 2014-04-20
// TA: Asma Farhan
// Section 003
// Instructor: Jeffrey A. Meunier

package gui;

import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import controller.Controller;

public class NumberSlider extends JPanel implements ChangeListener{
	
	private static final long serialVersionUID = 1L;
	private String     _name;
	private Controller _controller;
	private Box        _box;
	private JSlider    _slider;
	
	public NumberSlider(Controller controller, String name, int minVal, int maxVal, int defaultVal) {
		setLayout(null);
		
		_name = name;
		_controller = controller;
		_box = new Box(); {
			_box.setLocation(0,0);
			_box.setSize(40,30);
			_box.setText(Integer.toString(defaultVal));
			add(_box);
		}
		_slider = new JSlider(JSlider.HORIZONTAL, minVal, maxVal, defaultVal); {
			_slider.setLocation(_box.getWidth(),0);
			_slider.setSize(200,30);
			_slider.addChangeListener(this);
			add(_slider);
		}
		
		setSize(_box.getWidth() + _slider.getWidth(),30);
		setFocusable(false);
	}

	@Override
	public void stateChanged(ChangeEvent arg0) {
		int newVal = _slider.getValue();
		
		_box.setText(Integer.toString(newVal));
		
		_controller.sliderChange(_name, newVal);
	}
	
}
