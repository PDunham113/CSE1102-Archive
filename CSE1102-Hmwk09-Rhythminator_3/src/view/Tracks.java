// Homework 9 - Rhythminator 3
// CSE 1102 Project 09, Spring 2014
// Patrick Dunham
// 2014-05-02
// TA: Asma Farhan
// Section 003
// Instructor: Jeffrey A. Meunier

package view;

import javax.swing.JPanel;

import controller.Controller;

public class Tracks extends JPanel {

	private static final long serialVersionUID = 1L;
	public static final int  GAP_SIZE = 10;
	private NoteSquare[][] _noteArray;
	
	public Tracks(Controller controller, int numTracks, int numBeats) {
		setLayout(null);
					
		_noteArray = new NoteSquare[numTracks][numBeats];
		
		for(int t = 0; t < numTracks; t++) {
			for(int b = 0; b < numBeats; b++) {
				_noteArray[t][b] = new NoteSquare(controller, t + 1, b + 1); {
					_noteArray[t][b].setLocation((GAP_SIZE + NoteSquare.SIZE) * b, (GAP_SIZE + NoteSquare.SIZE) * t);
					this.add(_noteArray[t][b]);
				}
			}
		}
		
		setSize((GAP_SIZE + NoteSquare.SIZE) * numBeats, (GAP_SIZE + NoteSquare.SIZE)* numTracks);
	}

	public void setNotes(String[] notes) {
		for(int t = 0; t < notes.length; t++) {
			for(int b = 0; b < notes[0].length(); b++) {
				_noteArray[t][b].setValue(notes[t].charAt(b) - 48);
			}
		}
	}
	
}
