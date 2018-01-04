package model;

/****************************************************************************
 * Plays a sound when notified of a message.
 *
 ***************************************************************************/
import message.ISubscriber;
import message.Message;

public class SoundPlayer implements ISubscriber {
	
	private Sound _sound;
	
	/************************************************************************
	 * Creates an instance of the sound class.
	 * @param soundName The name of the sound file to be played.
	 * 
	 ************************************************************************/
	public SoundPlayer(String soundName) {
		_sound = new Sound(soundName);
	}
	
	/************************************************************************
	 * Creates an instance of the sound class.
	 * @param sound The sound class containing the file to be played.
	 * 
	 ************************************************************************/
	public SoundPlayer(Sound sound) {
		_sound = sound;
	}

	
	/************************************************************************
	 * Plays the sound when notified of an incoming message.
	 * @param msg The incoming message. **UNUSED**
	 * 
	 ************************************************************************/
	@Override
	public void notify(Message msg) {
		_sound.play();
	}
}