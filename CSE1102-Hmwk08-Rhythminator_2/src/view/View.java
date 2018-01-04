// Homework 8 - Rythyminator 2
// CSE 1102 Project 08, Spring 2014
// Patrick Dunham
// 2014-04-20
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

	public View(Controller controller, int numTracks, int numBeats)
	{		
	    Window window = new Window(controller, "Rhythminator");
	    window.setSize(900, 500);
	    
	    Header header = new Header(controller); {
	    	header.setLocation(LEFT_MARGIN, TOP_MARGIN);
	    	window.add(header);
	    }
	    
	    SoundBank sb = new SoundBank(controller, numTracks); {
	    	sb.setLocation(LEFT_MARGIN, TOP_MARGIN + 50);
	    	window.add(sb);
	    }
	    
	    ControlButtons cb = new ControlButtons(controller); {
	    	cb.setLocation(LEFT_MARGIN, TOP_MARGIN + 50 + 40 * numTracks);
	    	window.add(cb);
	    }
	    
	    Tracks ts = new Tracks(controller, numTracks, numBeats); {
	    	ts.setLocation(LEFT_MARGIN + 150, TOP_MARGIN + 50);
	    	window.add(ts);
	    }
	    
	    BeatNumbers bs = new BeatNumbers(numBeats); {
	    	bs.setLocation(LEFT_MARGIN + 150, TOP_MARGIN + 50 + 40 * numTracks);
	    	window.add(bs);
	    }
	    
	    NumberSlider ns = new NumberSlider(controller, "Tempo", 0, 240, 60); {
	    	ns.setLocation(LEFT_MARGIN + 150, TOP_MARGIN + 100 + 40 * numTracks);
	    	window.add(ns);
	    }
	    
		window.setVisible(true);
	}

}
