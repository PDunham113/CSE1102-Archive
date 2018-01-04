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
