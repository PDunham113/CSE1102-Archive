// Homework 9 - Rhythminator 3
// CSE 1102 Project 09, Spring 2014
// Patrick Dunham
// 2014-05-02
// TA: Asma Farhan
// Section 003
// Instructor: Jeffrey A. Meunier

package message;

public class Message
{
  private IPublisher _publisher;
  
  public Message(IPublisher publisher)
  {
    _publisher = publisher;
  }

  public IPublisher getPublisher()
  {
    return _publisher;
  }
}
