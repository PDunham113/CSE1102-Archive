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

public class SoundNameBox extends Box {
	
	private static final long serialVersionUID = 1L;
	public static final int   WIDTH  = 130;
	public static final int   HEIGHT = 30;
	public Controller         _controller;
	public int                _track;
	
	public SoundNameBox(Controller controller, int track) {
		super();
		_controller = controller;
		_track = track;
		
		setSize(WIDTH, HEIGHT);
	}
	
	@Override
	public void mousePressed(MouseEvent mev) {
		String text = getText();
		SoundChooser.open(_controller, _track, text);
	}
	
	
	
}
