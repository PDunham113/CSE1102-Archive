package gui;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

public class Dialog
{

  public static boolean askYesNo(String title, String question)
  {
    final String YES = "Yes";
    final String NO  = "No";
    JOptionPane pane = new JOptionPane(question);
    Object[] options = new String[] {NO, YES};
    pane.setOptions(options);
    JDialog dialog = pane.createDialog(null, title);
    dialog.setVisible(true);
    Object obj = pane.getValue();
    if(obj != null && obj.toString().equals(YES))
      return true;
    return false;
  }

  public static String getString(String title, String prompt, String initialValue)
  {
    Object value = JOptionPane.showInputDialog(null, prompt, title, JOptionPane.PLAIN_MESSAGE, null, null, initialValue);
    if(value != null)
      return value.toString();
    return null;
  }

  public static String selectOption(String title, String prompt, String[] options)
  {
    Object value = JOptionPane.showInputDialog(null, prompt, title, JOptionPane.PLAIN_MESSAGE, null, options, null);
    if(value != null)
      return value.toString();
    return null;
  }

}
