// Homework 9 - Rhythminator 3
// CSE 1102 Project 09, Spring 2014
// Patrick Dunham
// 2014-05-02
// TA: Asma Farhan
// Section 003
// Instructor: Jeffrey A. Meunier

package gui;

import java.awt.event.MouseEvent;

public class TextBox extends Box
{

  private String _dialogTitle;
  private String _dialogPrompt;

  private static final long serialVersionUID = 1;

  public TextBox()
  {
    this("Click to enter text");
  }

  public TextBox(String text)
  {
    this(text, "Enter new text");
  }

  public TextBox(String text, String dialogPrompt)
  {
    this(text, dialogPrompt, "Question");
  }
  
  public TextBox(String text, String dialogPrompt, String dialogTitle)
  {
    super(text);
    _dialogPrompt = dialogPrompt;
    _dialogTitle = dialogTitle;
  }

  @Override
  public void mousePressed(MouseEvent mev)
  {
    String initialValue = this.getText();
    String text = Dialog.getString(_dialogTitle, _dialogPrompt, initialValue);
    if(text != null)
      setText(text);
  }

}
