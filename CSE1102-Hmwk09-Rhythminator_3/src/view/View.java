// Homework 9 - Rhythminator 3
// CSE 1102 Project 09, Spring 2014
// Patrick Dunham
// 2014-05-02
// TA: Asma Farhan
// Section 003
// Instructor: Jeffrey A. Meunier


package view;

import gui.NumberSlider;
import controller.Controller;

public class View
{

	public  static final int TRACK_HEIGHT = 40; // this one must be public
	private static final int LEFT_MARGIN  = 20;
	private static final int TOP_MARGIN   = 20;
	private Header         _header;
	private SoundBank      _soundBank;
	private ControlButtons _controlButtons;
	private Tracks         _tracks;
	private BeatNumbers    _beatNumbers;
	private NumberSlider   _numberSlider;


	public View(Controller controller, int numTracks, int numBeats)
	{		
		Window window = new Window(controller, "Rhythminator");
		window.setSize(900, 500);

		_header = new Header(controller); {
			_header.setLocation(LEFT_MARGIN, TOP_MARGIN);
			window.add(_header);
		}

		_soundBank = new SoundBank(controller, numTracks); {
			_soundBank.setLocation(LEFT_MARGIN, TOP_MARGIN + 50);
			window.add(_soundBank);
		}

		_controlButtons = new ControlButtons(controller); {
			_controlButtons.setLocation(LEFT_MARGIN, TOP_MARGIN + 50 + 40 * numTracks);
			window.add(_controlButtons);
		}

		_tracks = new Tracks(controller, numTracks, numBeats); {
			_tracks.setLocation(LEFT_MARGIN + 150, TOP_MARGIN + 50);
			window.add(_tracks);
		}

		_beatNumbers = new BeatNumbers(numBeats); {
			_beatNumbers.setLocation(LEFT_MARGIN + 150, TOP_MARGIN + 50 + 40 * numTracks);
			window.add(_beatNumbers);
		}

		_numberSlider = new NumberSlider(controller, "Tempo", 10, 200, 60); {
			_numberSlider.setLocation(LEFT_MARGIN + 150, TOP_MARGIN + 100 + 40 * numTracks);
			window.add(_numberSlider);
		}

		window.setVisible(true);
	}

	public void clearBeatNumbers() {
		_beatNumbers.clear();
	}

	public String getFileName() {
		return _header.getFileName();
	}

	public int getTempo() {
		return _numberSlider.getValue();
	}

	public void setBeatNumber(int beatNumber) {
		_beatNumbers.setBeatNumber(beatNumber);
	}

	public void setFileName(String fileName) {
		_header.setText(fileName);
	}

	public void setNotes(String[] notes) {
		_tracks.setNotes(notes);
	}

	public void setSoundName(int trackNumber, String soundName) {
		_soundBank.setSoundName(trackNumber, soundName);
	}

	public void setTempo(int tempo) {
		_numberSlider.setValue(tempo);
	}
}
