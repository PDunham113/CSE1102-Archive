// Homework 9 - Rhythminator 3
// CSE 1102 Project 09, Spring 2014
// Patrick Dunham
// 2014-05-02
// TA: Asma Farhan
// Section 003
// Instructor: Jeffrey A. Meunier


package view;

import java.awt.event.KeyEvent;
import controller.Controller;

/**
 * The view.Window extends the gui.Window by notifying the controller
 * when a key event takes place.
 * @author jeff
 */
public class Window extends gui.Window
{

  private Controller _controller;

  private static final long serialVersionUID = 1L;

  public Window(Controller controller, String name)
  {
    super(name);
    _controller = controller;
  }

  @Override
  public void keyPressed(KeyEvent kev)
  {
    _controller.keyPressed(kev.getKeyCode());
  }

  @Override
  public void keyReleased(KeyEvent kev)
  {
    _controller.keyReleased(kev.getKeyCode());
  }

  @Override
  public void keyTyped(KeyEvent kev)
  {
    //System.out.println("Window kev = " + kev);
    _controller.keyTyped(kev.getKeyChar());
  }

}
