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

public class SoundBank extends JPanel {

	private static final long serialVersionUID = 1L;
	SoundNameBox[] _boxes;

	public SoundBank(Controller controller, int numTracks) {
		setLayout(null);
		
		_boxes = new SoundNameBox[numTracks];
		for(int i = 0; i < numTracks; i++) {
			_boxes[i] = new SoundNameBox(controller, i); {
				_boxes[i].setLocation(0, (SoundNameBox.HEIGHT + Tracks.GAP_SIZE) * i);
				this.add(_boxes[i]);
			}
		}
		
		this.setSize(SoundNameBox.WIDTH, (SoundNameBox.HEIGHT + Tracks.GAP_SIZE)* numTracks);
	}

	public void setSoundName(int track, String soundName) {
		_boxes[track].setText(soundName);
	}
}
