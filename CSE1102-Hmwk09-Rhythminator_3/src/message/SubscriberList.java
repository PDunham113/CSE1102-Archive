// Homework 9 - Rhythminator 3
// CSE 1102 Project 09, Spring 2014
// Patrick Dunham
// 2014-05-02
// TA: Asma Farhan
// Section 003
// Instructor: Jeffrey A. Meunier

package message;

import java.util.ArrayList;

/**
 * This is a convenient class to use to keep track of a list of subscribers. The list
 * of subscribers can grow without bound, so this is easier to use than an array.
 * @author jeff
 */
public class SubscriberList implements IPublisher, ISubscriber
{

  private ArrayList<ISubscriber> _subscribers = new ArrayList<ISubscriber>();
  
  public SubscriberList()
  {
    // nothing to see here
  }

  public int count()
  {
    return _subscribers.size();
  }

  @Override
  public void notify(Message message)
  {
    for(ISubscriber subscriber : _subscribers)
      if(subscriber != null)
        subscriber.notify(message);
  }
  
  public void notify(int subscriberNumber, Message message)
  {
    ISubscriber subscriber = _subscribers.get(subscriberNumber);
    if(subscriber != null) 
      subscriber.notify(message);
  }

  @Override
  public void subscribe(ISubscriber subscriber)
  {
    _subscribers.add(subscriber);
  }

  @Override
  public void unsubscribe(ISubscriber subscriber)
  {
    _subscribers.remove(subscriber);
  }

}
