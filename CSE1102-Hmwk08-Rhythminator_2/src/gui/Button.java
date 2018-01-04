// Homework 8 - Rythyminator 2
// CSE 1102 Project 08, Spring 2014
// Patrick Dunham
// 2014-04-20
// TA: Asma Farhan
// Section 003
// Instructor: Jeffrey A. Meunier

package gui;

import java.awt.event.MouseEvent;

import controller.Controller;

public class Button extends Box {
	
	private static final long serialVersionUID = 1L;
	private Controller _controller;
	
	public Button(Controller controller, String text) {
		super(text);
		this._controller = controller;
	}
	
	@Override
	public void mousePressed(MouseEvent mev) {
		_controller.buttonPressed(this);
	}
	
	public String toString() {
		return "Button(" + getText() + ")";
	}

}
