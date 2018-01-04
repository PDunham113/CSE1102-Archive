// Homework 07 - Laser Mirrors
// CSE 1102-Introduction to Object-Oriented Programming
// Patrick Dunham
// Asma Farhan Section 003
// 2014-03-11

import message.*;
import model.*;

/****************************************************************************
 * The main class. Contains the main method.
 *
 ***************************************************************************/
public class Main {
	
	/************************************************************************
	 * Plays a 32-beat long selection of pre-recorded sounds. Will later be 
	 * modified to include user interaction.
	 * 
	 ************************************************************************/
	public static void main(String[] args) {
		Sound.scanSoundDir();
		Sound s1 = new Sound("Tom1");
		Sound s2 = new Sound("Fizz");
		Sound s3 = new Sound("NintendoCore1");
		Sound s4 = new Sound("NintendoCore2");
		Sound s5 = new Sound("Snare4");
		Sound s6 = new Sound("KickDrum5");
		SoundBank sb = new SoundBank(new Sound[]{s1, s2, s3, s4, s5, s6});
		Sequencer seq = new Sequencer(16); {
			seq.subscribe(sb.chord(new int[]{2, 5})); // 1
			seq.subscribe(sb.chord(new int[]{5})); // 2
			seq.subscribe(sb.chord(new int[]{4})); // 3
			seq.subscribe(sb.chord(new int[]{1})); // 4
			seq.subscribe(sb.chord(new int[]{2, 4})); // 5
			seq.subscribe(sb.chord(new int[]{0})); // 6
			seq.subscribe(sb.chord(new int[]{4})); // 7
			seq.subscribe(sb.chord(new int[]{0, 5})); // 8
			seq.subscribe(sb.chord(new int[]{3, 5})); // 9
			seq.subscribe(sb.chord(new int[]{4})); // 10
			seq.subscribe(sb.chord(new int[]{1})); // 11
			seq.subscribe(sb.chord(new int[]{4})); // 12
			seq.subscribe(sb.chord(new int[]{0, 3, 4})); // 13
			seq.subscribe(sb.chord(new int[]{0})); // 14
			seq.subscribe(sb.chord(new int[]{4})); // 15
			seq.subscribe(sb.chord(new int[]{0, 1})); // 16
		}
		Clock c = new Clock(); {
			c.setDelay(250);
			c.subscribe(seq);
		}
		
		c.start(32);
	}
}