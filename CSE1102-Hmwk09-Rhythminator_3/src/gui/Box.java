// Homework 9 - Rhythminator 3
// CSE 1102 Project 09, Spring 2014
// Patrick Dunham
// 2014-05-02
// TA: Asma Farhan
// Section 003
// Instructor: Jeffrey A. Meunier

package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class Box extends JPanel implements MouseListener
{

  private String _text = "";

  private static final long serialVersionUID = 1L;

  public Box()
  {
    this("");
  }

  public Box(String text)
  {
    this.setBorder(BorderFactory.createLineBorder(Color.black));
    this.addMouseListener(this);
    _text = text;
  }

  public String getText()
  {
    return _text;
  }

  public void paintComponent(Graphics g)
  {
    super.paintComponent(g);
    g.drawString(_text, 5, 20);
  }

  @Override
  public void mouseClicked(MouseEvent mev)
  {}

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

  public void setText(String text)
  {
    _text = text;
    this.repaint();
  }

  @Override
  public String toString()
  {
    return "Square(" + _text + ")";
  }

}
