// Homework 9 - Rhythminator 3
// CSE 1102 Project 09, Spring 2014
// Patrick Dunham
// 2014-05-02
// TA: Asma Farhan
// Section 003
// Instructor: Jeffrey A. Meunier

package gui;

import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import controller.Controller;

public class NumberSlider extends JPanel implements ChangeListener
{

  private Controller _controller;
  private String _name;
  private JSlider _slider;
  private Box _numberBox;
  private int _value;

  private static final long serialVersionUID = 1L;

  public NumberSlider(Controller controller, String name, int low, int high, int deflt)
  {
    this.setLayout(null);
    _name = name;
    _numberBox = new Box();
    _numberBox.setLocation(0, 0);
    _numberBox.setSize(40, 30);
    _numberBox.setText("" + deflt);
    this.add(_numberBox);
    _slider = new JSlider(JSlider.HORIZONTAL, low, high, deflt);
    _slider.setFocusable(false);
    _slider.addChangeListener(this);
    _slider.setLocation(_numberBox.getWidth(), 0);
    _slider.setSize(200, 30);
    this.add(_slider);
    _value = deflt;
    _controller = controller;
    this.setSize(_slider.getX() + _slider.getWidth(), 100);
  }

  @Override
  public void stateChanged(ChangeEvent ce)
  {
    JSlider slider = (JSlider)ce.getSource();
    _value = slider.getValue();
    _numberBox.setText("" + _value);
    _controller.sliderChange(_name, _value);
  }
  
  public int getValue() {
	  return _value;
  }
  
  public void setValue(int value) {
	  _slider.setValue(value);
  }

}
