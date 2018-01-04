package model;

import message.Broadcaster;

/****************************************************************************
 * Plays multiple sounds at once.
 *
 ***************************************************************************/
public class Chord extends Broadcaster {

	/************************************************************************
	 * Notifies a subscriber of a new message.
	 * @param sounds The sounds to be played by the <code>Chord</Chord>.
	 * 
	 ************************************************************************/
	public Chord(Sound[] sounds) {
		super(sounds.length);
		
		for(Sound sound : sounds) {
			SoundPlayer sp = new SoundPlayer(sound);
			
			this.subscribe(sp);
		}
	}
}