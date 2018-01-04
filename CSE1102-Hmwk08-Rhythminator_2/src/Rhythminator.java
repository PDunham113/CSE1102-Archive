// Homework 8 - Rhythminator 2
// CSE 1102 Project 08, Spring 2014
// Patrick Dunham
// 2014-04-20
// TA: Asma Farhan
// Section 003
// Instructor: Jeffrey A. Meunier


import javax.swing.SwingUtilities;

import model.Sound;
import view.View;
import controller.Controller;

public class Rhythminator
{

  private static final int NUM_TRACKS = 6;
  private static final int NUM_BEATS  = 16;

  // I put all the interesting stuff in a separate method here so that you don't
  // have to keep looking at the Swing threading stuff in the main method below.
private static void _main()
  {
	Sound.scanSoundDir();
    Controller controller = new Controller();
    @SuppressWarnings("unused")
	View view = new View(controller, NUM_TRACKS, NUM_BEATS);
    // we don't use the view variable yet, but we will
  }

  public static void main(String[] args)
  {
    // In order to use Swing graphics effectively, the program should be started
    // running in a concurrent thread controlled by Swing. This is how you do it:
    SwingUtilities.invokeLater(new Runnable()
    {
      // the main part of a program that uses Swing graphics should appear inside this run method
      @Override
      public void run()
      {
        _main();
      }
    });
  }

}
