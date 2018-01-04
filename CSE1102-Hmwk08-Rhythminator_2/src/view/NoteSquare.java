// Homework 8 - Rythyminator 2
// CSE 1102 Project 08, Spring 2014
// Patrick Dunham
// 2014-04-20
// TA: Asma Farhan
// Section 003
// Instructor: Jeffrey A. Meunier

package view;

import java.awt.event.MouseEvent;

import controller.Controller;
import gui.Box;

public class NoteSquare extends Box {

	private static final long serialVersionUID = 1L;
	public static final int SIZE = 30;

	private Controller _controller;
	private int        _track;
	private int        _beat;
	private int        _value;

	public NoteSquare(Controller controller, int track, int beat) {
		super();

		_controller = controller;
		_beat       = beat;
		_track      = track;
		_value      = 0;

		setSize(SIZE,SIZE);
		setBackground(Colors.NOTESQUARE_OFF);
	}

	public int getBeat() {
		return _beat;
	}

	public int getTrack() {
		return _track;
	}

	public int getValue() {
		return _value;
	}

	public void setValue(int newValue) {
		_value = newValue;
		
		if(getValue() == 1) {
			setBackground(Colors.NOTESQUARE_ON);
		}
		else if(getValue() == 0) {
			setBackground(Colors.NOTESQUARE_OFF);
		}
	}

	@Override
	public void mousePressed(MouseEvent mev) {
		int val = getValue();
		val++;

		if(val > 1) {
			val = 0;
		}

		setValue(val);
		
		_controller._noteSquareClicked(this);
	}
	
	@Override
	public String toString() {
		return "NoteSquare(track = " + getTrack() + ", beat = " + getBeat() + ")";
	}
}