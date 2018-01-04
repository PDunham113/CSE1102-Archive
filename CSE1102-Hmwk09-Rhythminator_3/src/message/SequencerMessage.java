// Homework 9 - Rhythminator 3
// CSE 1102 Project 09, Spring 2014
// Patrick Dunham
// 2014-05-02
// TA: Asma Farhan
// Section 003
// Instructor: Jeffrey A. Meunier

package message;

public class SequencerMessage extends Message
{

  private int _stepNumber;

  public SequencerMessage(IPublisher publisher, int stepNumber)
  {
    super(publisher);
    _stepNumber = stepNumber;
  }

  public int getStepNumber()
  {
    return _stepNumber;
  }

}
