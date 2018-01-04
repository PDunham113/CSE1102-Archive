package model;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import message.IPublisher;
import message.ISubscriber;
import message.Message;

/**
 * A Clock instance is a free-running asynchronous timer. It conforms to the
 * IPublisher interface.
 * @author jeff
 */
public class Clock extends TimerTask implements IPublisher
{

  private ArrayList<ISubscriber> _subscribers = new ArrayList<ISubscriber>();
  private Timer   _timer = new Timer();
  private long    _delay = 500;
  private int     _numTicksLeft = 0;
  private Message _msg = new Message(this); // create one message to keep re-using

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
   * once every 500 mS (which is every 1/2 second).
   * @param delay The number of milliseconds to delay between ticks.
   */
  public void setDelay(long delay)
  {
    _delay = delay;
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
    _numTicksLeft = numTicks;
    _timer.schedule(this, 0, _delay);
  }

  /**
   * Stops a running clock.
   */
  public void stop()
  {
    _timer.cancel();
  }

  /**
   * Adds a subscriber to the list of subscribers for this clock.
   * Each time the clock ticks, all subscribers will be notified of the clock tick.
   * @param subscriber
   */
  public void subscribe(ISubscriber subscriber)
  {
    _subscribers.add(subscriber);
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
      for(ISubscriber subscriber : _subscribers)
        subscriber.notify(_msg);
      if(_numTicksLeft > 0)
        _numTicksLeft--;
    }
  }

  /**
   * Removes a subscriber from the list of subscribers for this clock.
   * @param subscriber
   */
  public void unsubscribe(ISubscriber subscriber)
  {
    _subscribers.remove(subscriber);
  }
}