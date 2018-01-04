// Homework 8 - Rythyminator 2
// CSE 1102 Project 08, Spring 2014
// Patrick Dunham
// 2014-04-20
// TA: Asma Farhan
// Section 003
// Instructor: Jeffrey A. Meunier

package view;

import javax.swing.JPanel;

import controller.Controller;

public class Tracks extends JPanel {

	private static final long serialVersionUID = 1L;
	public static final int  GAP_SIZE = 10;
	
	public Tracks(Controller controller, int numTracks, int numBeats) {
		setLayout(null);
						
		for(int i = 0; i < numTracks; i++) {
			for(int j = 0; j < numBeats; j++) {
				NoteSquare squares = new NoteSquare(controller, i + 1, j + 1); {
					squares.setLocation((GAP_SIZE + NoteSquare.SIZE) * j, (GAP_SIZE + NoteSquare.SIZE) * i);
					this.add(squares);
				}
			}
		}
		
		setSize((GAP_SIZE + NoteSquare.SIZE) * numBeats, (GAP_SIZE + NoteSquare.SIZE)* numTracks);
	}

}
