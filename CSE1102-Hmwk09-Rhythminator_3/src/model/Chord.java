// Homework 9 - Rhythminator 3
// CSE 1102 Project 09, Spring 2014
// Patrick Dunham
// 2014-05-02
// TA: Asma Farhan
// Section 003
// Instructor: Jeffrey A. Meunier

package model;

import message.ISubscriber;
import message.Message;

public class Chord implements ISubscriber
{

  private SoundBank _soundBank;
  private boolean[] _notes;

  public Chord(SoundBank soundBank, int numNotes)
  {
    _soundBank = soundBank;
    _notes = new boolean[numNotes];
  }

  @Override
  public void notify(Message message)
  {
    this.play();
  }

  public void play()
  {
    _soundBank.play(_notes);
  }

  public void setNote(int noteNumber, boolean noteValue) {
    _notes[noteNumber] = noteValue;
  }
  
  public String getNotes() {
	  String notes = "";
	  for(boolean i : _notes) {
		  if(i) {
			  notes += "1";
		  }
		  else {
			  notes += "0";
		  }
	  }
	  
	  return notes;
  }

}