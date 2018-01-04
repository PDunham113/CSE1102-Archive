// Homework 9 - Rhythminator 3
// CSE 1102 Project 09, Spring 2014
// Patrick Dunham
// 2014-05-02
// TA: Asma Farhan
// Section 003
// Instructor: Jeffrey A. Meunier

package model;

public class SoundBank
{

  private Sound[] _sounds;
  
  public SoundBank(Sound[] sounds)
  {
    _sounds = sounds;
  }

  public void play(boolean[] noteValues)
  {
    for(int n=0; n<noteValues.length; n++)
      if(noteValues[n])
      {
        Sound sound = _sounds[n];
        if(sound != null)
          _sounds[n].play();
      }
  }

  public void play(int soundNumber)
  {
    _sounds[soundNumber].play();
  }
  
  public String[] getSounds() {
	  String[] sounds = new String[_sounds.length];
	  for(int i = 0; i < sounds.length; i++) {
		  if(_sounds[i] == null) {
			  sounds[i] = null;
		  }
		  else {
			  sounds[i] = _sounds[i].getName();
		  }
	  }
	  
	  return sounds;
  }

  public void setSound(int soundNumber, Sound sound)
  {
    _sounds[soundNumber] = sound;
  }

}
