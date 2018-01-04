package controller;

import view.NoteSquare;
import gui.Button;


public class Controller
{

	public Controller()
	{
	}

	public void keyPressed(int keyCode)
	{
		//System.out.println("Controller.keyPressed " + keyCode);
	}

	public void keyReleased(int keyCode)
	{
		//System.out.println("Controller.keyReleased " + keyCode);
	}

	public void keyTyped(char keyChar)
	{
		//System.out.println("Controller.keyTyped '" + keyChar + "'");
	}

	public void soundNameSelected(int trackNumber, String soundName)
	{
		System.out.println("Sound " + soundName + " selected for track " + trackNumber);
	}

	public void buttonPressed(Button button) {
		System.out.println(button + "has been pressed.");
	}

	public void sliderChange(String sliderName, int newVal) {
		System.out.println("Slider " + sliderName + " changed to " + newVal);
	}

	public void _noteSquareClicked(NoteSquare noteSquare) {
		System.out.println(noteSquare + " was pressed.");		
	}

}
