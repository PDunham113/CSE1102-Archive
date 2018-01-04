package stateMachine;
// Homework 05 - Agents 2
// CSE 1102-Introduction to Object-Oriented Programming
// Patrick Dunham
// Asma Farhan Section 003
// 2014-03-10

import java.io.File;

import jeff.imagewindow.ImageWindow;
import jeff.textconsole.TextConsole;

public class Main {

	public static void main(String[] args) {
		ImageWindow  window     = new ImageWindow();
		TextConsole  console    = TextConsole.create();
		File         configFile = new File("data", "config.ini");
		
		ConfigLoader cl         = new ConfigLoader(configFile);
		Agent        player     = cl.buildAll();

		CommandInterpreter.run(player, window, console);
	}
}
