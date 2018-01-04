// Homework 9 - Rhythminator 3
// CSE 1102 Project 09, Spring 2014
// Patrick Dunham
// 2014-05-02
// TA: Asma Farhan
// Section 003
// Instructor: Jeffrey A. Meunier

package model;

import java.util.Timer;
import java.util.TimerTask;

import message.IPublisher;
import message.ISubscriber;
import message.Message;
import message.SubscriberList;

/**
 * A Clock instance is a free-running asynchronous timer. It conforms to the
 * IPublisher interface.
 * @author jeff
 */
public class Clock extends TimerTask implements IPublisher
{

  private SubscriberList _subscribers = new SubscriberList();
  private Message _msg = new Message(this); // create one message to keep re-using
  private Timer   _timer;
  private long    _delay = 250;
  private long    _newDelay = _delay;
  private int     _numTicksLeft = 0;

  public Clock()
  {
    // nothing to see here
  }

  /**
   * This method is called automatically by the timer at each clock tick.
   * If you're thinking about calling this method, don't. Call tick() instead.
   * (Yes, it's like having two doorways that lead into the same room. This
   * doorway is not for you.)
   */
  @Override
  public void run()
  {
    tick();
  }

  /**
   * Sets the delay of this clock. By default, the clock is set to tick
   * once every 250 mS (which is every 1/4 second).
   * @param delay The number of milliseconds to delay between ticks.
   */
  public void setDelay(long delay)
  {
    _newDelay = delay;
  }

  /**
   * Starts the clock running for an unbounded number of ticks.
   * To stop the clock, call the stop() method.
   */
  public void start()
  {
    this.start(-1);
  }

  /**
   * Starts the clock running for a specific number of ticks.
   * @param numTicks
   */
  public void start(int numTicks)
  {
    if(_timer == null)
    {
      _numTicksLeft = numTicks;
      _timer = new Timer();
      ClockTask clockTask = new ClockTask();
      _timer.schedule(clockTask, 0, _delay);
    }
  }

  /**
   * Stops a running clock.
   */
  public void stop()
  {
    if(_timer != null)
    {
      _timer.cancel();
      _timer = null;
    }
  }

  /**
   * Adds a subscriber to the list of subscribers for this clock.
   * Each time the clock ticks, all subscribers will be notified of the clock tick.
   * @param subscriber
   */
  public void subscribe(ISubscriber subscriber)
  {
    _subscribers.subscribe(subscriber);
  }

  /**
   * This method is called by the run() method.
   * You may call this method to test or simulate a single clock tick.
   */
  public void tick()
  {
    if(_numTicksLeft == 0)
      this.stop();
    else
    {
      // you can un-comment this next line if you want to see when the clock ticks
      //System.out.println("Clock.tick(" + _numTicksLeft + ")");
      _subscribers.notify(_msg);
      if(_numTicksLeft > 0)
        _numTicksLeft--;
      if(_newDelay != _delay)
      {
        stop();
        _delay = _newDelay;
        start(_numTicksLeft);
      }
    }
  }

  /**
   * Removes a subscriber from the list of subscribers for this clock.
   * @param subscriber
   */
  public void unsubscribe(ISubscriber subscriber)
  {
    _subscribers.unsubscribe(subscriber);
  }

  /**
   * Every time the timer starts, a new instance of a TimerTask must be given to it.
   * This is a total pain in the rear. So here's a class that I use for that purpose.
   * This is a good example of why you'd want to put a class within a class. This
   * class is used *only* by the Clock class, and furthermore, users of the Clock
   * class should not even know that this auxiliary class is needed to make the Clock
   * work. Thankfully, Java lets me hide the class here inside the Clock class.
   * @author jeff
   */
  private class ClockTask extends TimerTask
  {
    
    @Override
    public void run()
    {
      Clock.this.tick();
    }

  }

}