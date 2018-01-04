// Homework 9 - Rhythminator 3
// CSE 1102 Project 09, Spring 2014
// Patrick Dunham
// 2014-05-02
// TA: Asma Farhan
// Section 003
// Instructor: Jeffrey A. Meunier

package controller;

import java.io.*;
import java.nio.file.*;
import java.util.Scanner;

import gui.Button;
import gui.Dialog;
import message.ISubscriber;
import message.Message;
import model.Clock;
import model.Model;
import view.NoteSquare;
import view.View;

public class Controller implements ISubscriber
{

	private Model _model;
	private Clock _clock;
	private View  _view;

	public Controller(Clock clock, Model model)
	{
		_model = model;
		_clock = clock;

		_clock.subscribe(this);
	}

	private void _buttonLoad()
	{
		_buttonStop();
		String song = "";
		String fileName = _view.getFileName() + ".txt";

		Path savePath = Paths.get("saves", fileName);
		if(Files.notExists(savePath)) {
			System.out.println("File \"" + fileName + "\" does not exist.");
			return;
		}
		else {
			File saveFile = savePath.toFile();
			
			try(BufferedReader in = new BufferedReader(new FileReader(saveFile))) {
				for(int i = 0; i <= _model.getNumTracks(); i++) {
					song += in.readLine();
					song += "\n";
				}
			} 
			catch (FileNotFoundException e) {
				e.printStackTrace();
			} 
			catch (IOException e) {
				e.printStackTrace();
			}

			boolean success = setSong(song);

			if(success)
				System.out.println("\nLoad successful!");
			else
				System.out.println("\nLoad unsuccessful.");
		}
	}

	private void _buttonPlay() {
		_model.startPlaying();
	}

	private void _buttonQuit()
	{
		if(Dialog.askYesNo("Exiting program", "Really quit?"))
			System.exit(0);
	}

	private void _buttonSave()
	{
		_buttonStop();
		String[] save = getSong();
		String fileName = _view.getFileName();
		PrintWriter out = null;

		try {
			Path filePath = Paths.get("saves", fileName + ".txt");
			if(Files.notExists(filePath))
				Files.createFile(filePath);
			File saveFile = filePath.toFile();

			out = new PrintWriter(new BufferedWriter(new FileWriter(saveFile)));

			for(String line : save) {
				out.println(line);
			}
			out.close();
			System.out.println("Save successful!");
		}
		catch(IOException e) {
			System.out.println(e);
		}
	}

	private void _buttonStop() {
		_view.clearBeatNumbers();
		_model.stopPlaying();
	}

	public void buttonPressed(Button button)
	{
		if(button.getText().equals("Save"))
			_buttonSave();
		else if(button.getText().equals("Load"))
			_buttonLoad();
		else if(button.getText().equals("Play"))
			_buttonPlay();
		else if(button.getText().equals("Stop"))
			_buttonStop();
		else if(button.getText().equals("Quit"))
			_buttonQuit();
		else
			System.out.println("Controller.buttonPressed " + button + " pressed");
	}

	public String[] getSong() {
		String[] notes = _model.getNotes();
		String[] sounds = _model.getSounds();
		String fileName = _view.getFileName();
		String tempo    = Integer.toString(_view.getTempo());
		String[] song = new String[notes.length + 1];

		song[0] = "BEGIN " + fileName + "\t" + tempo;
		for(int i = 0; i < notes.length; i++) {
			song[i + 1] = sounds[i] + "\t" + notes[i];
		}

		return song;
	}

	public void keyPressed(int keyCode)
	{
		System.out.println("Controller.keyPressed " + keyCode);
	}

	public void keyReleased(int keyCode)
	{
		System.out.println("Controller.keyReleased " + keyCode);
	}

	public void keyTyped(char keyChar)
	{
		System.out.println("Controller.keyTyped '" + keyChar + "'");
	}

	public void noteSquareClicked(NoteSquare noteSquare)
	{
		int beat = noteSquare.getBeat();
		int track = noteSquare.getTrack();
		int value = noteSquare.getValue();
		boolean state = false;
		if(value == 1)
			state = true;
		else
			state = false;

		_model.setNote(track, beat, state);		
	}

	@Override
	public void notify(Message message)
	{
		_view.setBeatNumber(_model.getBeatNumber() - 1);
	}

	public boolean setSong(String song) {
		String fileName, input;
		int tempo, numTracks = _model.getNumTracks();
		String[] tracks = new String[numTracks];
		String[] notes  = new String[numTracks];
		Scanner str = new Scanner(song);
		boolean success = false;



		try {
			input = str.next();
			if(input.equals("BEGIN")) {
				fileName = str.next();
				tempo    = str.nextInt();

				for(int i = 0; i < numTracks; i++) {
					tracks[i] = str.next();
					notes[i]  = str.next();
				}

				setSong(fileName, tempo, tracks, notes);
				success = true;
			}
			else {
				System.out.println("This is not a valid rhythm file.");
			}
		} 
		catch (Exception e) {
			throw new RuntimeException("Either the file chosen is not a valid rhythm file or the formatting is incorrect. Please try again.");
		}
		finally {
			str.close();
		}

		return success;
	}

	public void setSong(String fileName, int tempo, String[] tracks, String [] notes) {
		_view.setFileName(fileName);
		_view.setTempo(tempo);
		_view.setNotes(notes);
		_model.setSounds(tracks);
		for(int t = 0; t < tracks.length; t++) {
			if(tracks[t].equals("null"))
				_view.setSoundName(t, "");
			else
				_view.setSoundName(t, tracks[t]);
		}

	}

	public void setSounds(String[] tracks) {

	}

	public void setView(View view)
	{
		_view = view;
	}

	public void sliderChange(String name, int value)
	{
		_clock.setDelay(15000 / value);
	}

	public void soundNameSelected(int trackNumber, String soundName)
	{
		_model.setSoundName(trackNumber, soundName);
		_view.setSoundName(trackNumber, soundName);
	}
}
