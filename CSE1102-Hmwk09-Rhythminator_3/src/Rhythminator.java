// Homework 9 - Rhythminator 3
// CSE 1102 Project 09, Spring 2014
// Patrick Dunham
// 2014-05-02
// TA: Asma Farhan
// Section 003
// Instructor: Jeffrey A. Meunier


import javax.swing.SwingUtilities;

import model.Clock;
import model.Model;
import model.Sound;
import view.View;
import controller.Controller;

public class Rhythminator
{

  private static final int NUM_TRACKS = 6;
  private static final int NUM_BEATS  = 16;

  public static void main(String[] args)
  {
    // In order to use Swing graphics effectively, the program should be started
    // running in a concurrent thread controlled by Swing. This is how you do it:
    SwingUtilities.invokeLater(new Runnable()
    {
        @Override
        public void run()
        {
          Rhythminator._main();
        }
    });
  }

  // I put all the interesting stuff in a separate method here so that you don't
  // have to keep looking at the Swing threading stuff in the main method above.
  private static void _main()
  {
    Sound.scanSoundDir();
    Model model = new Model(NUM_TRACKS, NUM_BEATS);
    Clock clock = model.getClock();
    Controller controller = new Controller(clock, model);
    View view = new View(controller, NUM_TRACKS, NUM_BEATS);
    controller.setView(view);
  }

}
