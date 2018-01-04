// Homework 8 - Rythyminator 2
// CSE 1102 Project 08, Spring 2014
// Patrick Dunham
// 2014-04-20
// TA: Asma Farhan
// Section 003
// Instructor: Jeffrey A. Meunier

package view;

import javax.swing.JPanel;

public class BeatNumbers extends JPanel {

	private static final long serialVersionUID = 1L;
	private BeatNumberSquare[] _beatSquares;
	private int _lastBeat = -1;

	public BeatNumbers(int numBeats) {
		setLayout(null);
		_beatSquares = new BeatNumberSquare[numBeats];

		for(int i = 0; i < numBeats; i++) {
			_beatSquares[i] = new BeatNumberSquare(i + 1); {
				_beatSquares[i].setLocation((Tracks.GAP_SIZE + NoteSquare.SIZE) * i, 0);
				this.add(_beatSquares[i]);
			}
		}

		setSize((Tracks.GAP_SIZE + NoteSquare.SIZE) * numBeats, Tracks.GAP_SIZE + NoteSquare.SIZE); 
	}

	public void setBeatNumber(int beat) {
		if(_lastBeat != -1) {
			_beatSquares[_lastBeat].setState(false);
		}
		_beatSquares[beat].setState(true);
		_lastBeat = beat;
	}

	public void clear() {
		_beatSquares[_lastBeat].setState(false);
		_lastBeat = -1;
	}
}