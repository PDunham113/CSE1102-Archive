// Homework 9 - Rhythminator 3
// CSE 1102 Project 09, Spring 2014
// Patrick Dunham
// 2014-05-02
// TA: Asma Farhan
// Section 003
// Instructor: Jeffrey A. Meunier

package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import model.Sound;
import controller.Controller;

public class SoundChooser extends JDialog implements ActionListener, KeyListener, MouseListener
{

  private JButton _play, _ok, _cancel;
  @SuppressWarnings("rawtypes")
  private JList _soundNames;
  private Controller _controller;
  private int _trackNumber;

  private static SoundChooser _theSoundChooser = null;
  private static final long serialVersionUID = 1L;

  public static void open(Controller controller, int trackNumber, String initialValue)
  {
    if(_theSoundChooser == null)
      _theSoundChooser = new SoundChooser(controller, trackNumber);
    else
      _theSoundChooser._trackNumber = trackNumber;
    _theSoundChooser._setInitialValue(initialValue);
    _theSoundChooser.setVisible(true);
  }

  @SuppressWarnings({ "unchecked", "rawtypes" })
private SoundChooser(Controller controller, int trackNumber)
  {
    this.setTitle("Sound chooser");
    this.setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
    this.setModal(true);
    _controller = controller;
    _trackNumber = trackNumber;
    this.setLayout(new BorderLayout());
    String[] soundNames = Sound.getAllSoundFileNames();
    _soundNames = new JList(soundNames);
    _soundNames.addKeyListener(this);
    _soundNames.addMouseListener(this);
    JScrollPane scrollPane = new JScrollPane(_soundNames);
    this.add(scrollPane, BorderLayout.CENTER);
    JPanel buttonPanel = new JPanel();
    buttonPanel.setLayout(new GridLayout(1, 3));
    _ok = new JButton("Use this sound");
    _play = new JButton("Play");
    _cancel = new JButton("Cancel");
    _play.addActionListener(this);
    _ok.addActionListener(this);
    _cancel.addActionListener(this);
    buttonPanel.add(_ok);
    buttonPanel.add(_play);
    buttonPanel.add(_cancel);
    this.add(buttonPanel, BorderLayout.SOUTH);
    this.setSize(400, 400);
    this.setLocationRelativeTo(null);
  }

  @Override
  public void actionPerformed(ActionEvent aev)
  {
    Object source = aev.getSource();
    if(source == _play)
      _play();
    else if(source == _ok)
      _select();
    else
      _cancel();
  }

  @Override
  public void keyPressed(KeyEvent kev)
  {
    int keyCode = kev.getKeyCode();
    switch(keyCode)
    {
      case 10: // enter
        _select();
        break;
      case 27: // escape
        _cancel();
        break;
      case 32: // space
        _play();
        break;
    }
  }

  @Override
  public void keyReleased(KeyEvent kev)
  {}

  @Override
  public void keyTyped(KeyEvent kev)
  {}

  private void _cancel()
  {
    this.setVisible(false);
  }

  private void _play()
  {
    String soundName = (String)_soundNames.getSelectedValue();
    if(soundName != null && !soundName.equals("(none)"))
    {
      Sound s = new Sound(soundName);
      s.play();
    }
  }
  
  @Override
  public void mouseClicked(MouseEvent mev)
  {
    if(mev.getButton() == MouseEvent.BUTTON1 && mev.getClickCount() == 2)
      _select();
  }

  @Override
  public void mouseEntered(MouseEvent mev)
  {}

  @Override
  public void mouseExited(MouseEvent mev)
  {}

  @Override
  public void mousePressed(MouseEvent mev)
  {}

  @Override
  public void mouseReleased(MouseEvent mev)
  {}

  private void _select()
  {
    if(_controller != null)
    {
      String soundName = (String)_soundNames.getSelectedValue();
      _controller.soundNameSelected(_trackNumber, soundName);
    }
    this.setVisible(false);
  }

  private void _setInitialValue(String initialValue)
  {
    if(initialValue == null || initialValue.length() == 0)
      _soundNames.setSelectedIndex(0);
    else
      _soundNames.setSelectedValue(initialValue, true);
  }

}
