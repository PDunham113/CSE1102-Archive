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
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLayout(null);         // layout = null means we want to place things on the screen using absolute coordinates
    this.addWindowListener(this); // set this window to be its own window event listener
    this.addKeyListener(this);    // set this window to be its own key listener
    this.setFocusable(true);      // this is needed to allow key listener to capture events on this frame
    this.setSize(400, 400);       // subclasses will probably set their own size
    this.setBackground(Colors.WINDOW_BG); // sets the window's background color
  }

  /**
   * Call this method to make the application window full-screen.
   * On a Mac this hides the title bar.
   */
  public void fullscreen()
  {
    this.maximize();
    this.setUndecorated(true);
  }

  // The key event and window event methods are not needed, but I put them in here so that you
  // can see how you'd include them in this class.

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
   * On a Mac it's different from full-screen.
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
