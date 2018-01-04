package model;

/****************************************************************************
 * Holds a selection of sounds. Used to easily create multiple <code>Chords
 * </code> from a single selection of sounds.
 *
 ***************************************************************************/
public class SoundBank {
	
	public Sound[]  _sounds;
	
	/************************************************************************
	 * Notifies a subscriber of a new message.
	 * @param sounds The list of sounds to be encompassed by the 
	 * <code>SoundBank</code>.
	 * 
	 ************************************************************************/
	public SoundBank(Sound[] sounds) {
		_sounds = sounds;
	}
	
	/************************************************************************
	 * Creates a <code>Chord</code> based on a boolean masking array.
	 * @param soundFlags The masking array. Must be as long as the array of
	 * sounds. Set to 'true' to include the sound.
	 * @return The <code>Chord</code> with the specified sounds.
	 * 
	 ************************************************************************/
	public Chord chord(boolean[] soundFlags) {
		int counter = 0;
		
		for(boolean flag : soundFlags) {
			if(flag) {
				counter++;
			}
		}
		
		Sound[] newSounds = new Sound[counter];
		
		counter = 0;
		
		for(int i = 0; i <= soundFlags.length - 1; i++) {
			if(soundFlags[i] == true) {
				newSounds[counter] = _sounds[i];
				counter++;
			}
		}
		
		Chord newChord = new Chord(newSounds);
		
		return newChord;		
	}
	
	/************************************************************************
	 * Creates a <code>Chord</code> based on an array of integers.
	 * @param soundNums The array locations of sounds to be included.
	 * @return The <code>Chord</code> with the specified sounds.
	 * 
	 ************************************************************************/
	public Chord chord(int[] soundNums) {
		
		Sound[] newSounds = new Sound[soundNums.length];
		int counter = 0;
		
		for(int i : soundNums) {
			newSounds[counter] = _sounds[i];
			counter++;
		}
		
		Chord newChord = new Chord(newSounds);
		
		return newChord;	
	}
}