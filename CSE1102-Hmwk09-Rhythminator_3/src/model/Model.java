// Homework 9 - Rhythminator 3
// CSE 1102 Project 09, Spring 2014
// Patrick Dunham
// 2014-05-02
// TA: Asma Farhan
// Section 003
// Instructor: Jeffrey A. Meunier

package model;

import message.Sequencer;

public class Model
{

	public int _numTracks;
	public int _numBeats;
	private SoundBank _soundBank;
	private Sequencer _sequencer;
	private Chord[] _chords;
	private Clock _clock;

	/**
	 * The model sets up the clock.
	 * Most of the work of running the application happens in the clock.
	 * @param numTracks
	 * @param numBeats
	 */
	public Model(int numTracks, int numBeats)
	{
		_numTracks = numTracks;
		_numBeats  = numBeats;
		_soundBank = new SoundBank(new Sound[_numTracks]);
		_sequencer = new Sequencer(_numBeats);
		_chords    = new Chord[_numBeats]; {
			for(int i = 0; i < _chords.length; i++) {
				_chords[i] = new Chord(_soundBank, _numTracks);
				_sequencer.subscribe(_chords[i]);
			}
		}
		_clock  = new Clock(); {
			_clock.subscribe(_sequencer);
		}


	}

	public int getBeatNumber()
	{
		return _sequencer.getStepNumber();
	}

	public Clock getClock()
	{
		return _clock;
	}
	
	public String[] getNotes() {
		char[][] notesArrayChar = new char[_numTracks][_numBeats];
		String[] notesArrayStr  = new String[_numTracks];
		
		for(int i = 0; i < notesArrayStr.length; i++) {
			notesArrayStr[i] = "";
		}
		
		for(int b = 0; b < _numBeats; b++) {
			String chord = _chords[b].getNotes();
			
			for(int t = 0; t < _numTracks; t++) {
				notesArrayChar[t][b] = chord.charAt(t);
			}
		}
		
		
		for(int t = 0; t < _numTracks; t++) {
			for(int b = 0; b < _numBeats; b++) {
				notesArrayStr[t] += notesArrayChar[t][b];
			}
		}
		
		return notesArrayStr;
	}
	
	public int getNumTracks() {
		return _numTracks;
	}
	
	public String[] getSounds() {
		return _soundBank.getSounds();
	}
	
	public void startPlaying()
	{
		_clock.start();
	}
;
	public void stopPlaying()
	{
		_sequencer.reset();
		_clock.stop();
	}

	public void setNote(int trackNum, int beatNum, boolean value)
	{
		_chords[beatNum - 1].setNote(trackNum - 1, value);
	}

	public void setSounds(String[] sounds) {
		for(int t = 0; t < sounds.length; t++) {
			sounds[t] = sounds[t].replace(".aiff", "");
				setSoundName(t, sounds[t]);
		}
	}
	
	public void setSoundName(int trackNum, String soundName)
	{
		try {
			Sound sound = new Sound(soundName);
			_soundBank.setSound(trackNum, sound);
		}
		catch(RuntimeException e) {
			_soundBank.setSound(trackNum, null);
		}
	}

}
