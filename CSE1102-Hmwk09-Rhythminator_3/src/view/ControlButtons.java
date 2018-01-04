// Homework 9 - Rhythminator 3
// CSE 1102 Project 09, Spring 2014
// Patrick Dunham
// 2014-05-02
// TA: Asma Farhan
// Section 003
// Instructor: Jeffrey A. Meunier

package view;

import gui.Button;

import javax.swing.JPanel;

import controller.Controller;

public class ControlButtons extends JPanel {

	private static final long serialVersionUID = 1L;
	
	
	public ControlButtons(Controller controller) {
		setLayout(null);
		
		Button play = new Button(controller, "Play"); {
			play.setSize(60, 30);
			play.setLocation(0, 0);
			this.add(play);
		}
		Button stop = new Button(controller, "Stop"); {
			stop.setSize(60, 30);
			stop.setLocation(70, 0);
			this.add(stop);
		}
		
		setSize(130, 30);
	}

}
