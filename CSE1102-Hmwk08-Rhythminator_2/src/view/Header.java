// Homework 8 - Rythyminator 2
// CSE 1102 Project 08, Spring 2014
// Patrick Dunham
// 2014-04-20
// TA: Asma Farhan
// Section 003
// Instructor: Jeffrey A. Meunier

package view;

import gui.Button;
import gui.TextBox;

import javax.swing.JPanel;

import controller.Controller;

public class Header extends JPanel {

	private static final long serialVersionUID = 1L;
	private TextBox _textBox;
	
	public Header(Controller controller) {
		setLayout(null);
		
		TextBox _textBox = new TextBox("Unnamed", "Enter a new name: ", "Change name"); {
			_textBox.setSize(200, 30);
			_textBox.setLocation(0, 0);
			this.add(_textBox);
		}
		
		Button load = new Button(controller, "Load"); {
			load.setSize(60, 30);
			load.setLocation(210, 0);
			this.add(load);
		}
		
		Button save = new Button(controller, "Save"); {
			save.setSize(60, 30);
			save.setLocation(280, 0);
			this.add(save);
		}
		
		Button quit = new Button(controller, "Quit"); {
			quit.setSize(60, 30);
			quit.setLocation(380, 0);
			this.add(quit);
		}
		
		setSize(440, 30);
	}
	
	public String getFileName() {
		return _textBox.getText();
	}

}
