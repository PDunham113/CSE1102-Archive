// Homework 9 - Rhythminator 3
// CSE 1102 Project 09, Spring 2014
// Patrick Dunham
// 2014-05-02
// TA: Asma Farhan
// Section 003
// Instructor: Jeffrey A. Meunier

package gui;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;

public class Window extends JFrame implements KeyListener, WindowListener
{

  private static final long serialVersionUID = 1L;

  public Window(String name)
  {
    super(name);
    this.setLayout(null);
    this.addWindowListener(this);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.addKeyListener(this);
    this.setFocusable(true); // allows key listener to capture events on this frame
    this.setSize(400, 400);
    this.setBackground(Colors.WINDOW_BG);
  }

  /**
   * Call this method to make the application window full-screen.
   * This hides the title bar.
   */
  public void fullscreen()
  {
    this.maximize();
    this.setUndecorated(true);
  }

  @Override
  public void keyPressed(KeyEvent kev)
  {}

  @Override
  public void keyReleased(KeyEvent kev)
  {}

  @Override
  public void keyTyped(KeyEvent kev)
  {}

  /**
   * Call this method to maximize the application window.
   * It's different from full-screen.
   */
  public void maximize()
  {
    this.setSize(-1, -1);
  }

  @Override
  public void windowActivated(final WindowEvent wev)
  {}

  @Override
  public void windowClosed(final WindowEvent wev)
  {}

  @Override
  public void windowClosing(final WindowEvent wev)
  {
    //System.exit(0); // not needed if JFrame.EXIT_ON_CLOSE is used in the constructor
  }

  @Override
  public void windowDeactivated(final WindowEvent wev)
  {}

  @Override
  public void windowDeiconified(final WindowEvent wev)
  {}

  @Override
  public void windowIconified(final WindowEvent wev)
  {}

  @Override
  public void windowOpened(final WindowEvent wev)
  {}

}
