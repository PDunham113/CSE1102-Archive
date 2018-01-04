// Homework 8 - Rythyminator 2
// CSE 1102 Project 08, Spring 2014
// Patrick Dunham
// 2014-04-20
// TA: Asma Farhan
// Section 003
// Instructor: Jeffrey A. Meunier

package view;

import gui.Box;

public class BeatNumberSquare extends Box {

	private static final long serialVersionUID = 1L;
	private int     _beatNumber;
	private boolean _state;
	
	public BeatNumberSquare(int beatNumber) {
		super();
		
		_beatNumber = beatNumber;
		_state      = false;
		
		setText(Integer.toString(_beatNumber));
		
		setForeground(Colors.BEATNUMBER_OFF_FG);
		setBackground(Colors.BEATNUMBER_OFF_BG);
		
		setSize(NoteSquare.SIZE, NoteSquare.SIZE);
	}
	
	public void setState(boolean newState) {
		_state = newState;
		
		if(_state) {
			setForeground(Colors.BEATNUMBER_ON_FG);
			setBackground(Colors.BEATNUMBER_ON_BG);
		}
		else {
			setForeground(Colors.BEATNUMBER_OFF_FG);
			setBackground(Colors.BEATNUMBER_OFF_BG);			
		}
		
		invalidate();
	}

}
