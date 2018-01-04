package message;

/****************************************************************************
 * Sends a message to individual subscribers in sequence.
 *
 ***************************************************************************/
public class Sequencer implements IPublisher, ISubscriber {
	
	private ISubscriber[] _subscribers;
	private int           _numSubscriber;
	private int           _currentSubscriber = 0;
	
	/************************************************************************
	 * Creates an instance of a <code>Sequencer</code> that can hold up to 
	 * some number of subscribers.
	 * @param maxSubscribers The maximum number of subscribers this 
	 * <code>Sequencer</code> can hold.
	 * 
	 ************************************************************************/
	public Sequencer(int maxSubscribers) {
		_subscribers = new ISubscriber[maxSubscribers];
	}
	
	/************************************************************************
	 * Delivers a message to a single subscriber, in sequence.
	 * @param msg The message delivered each subscriber.
	 * 
	 ************************************************************************/
	@Override
	public void notify(Message msg) {
		if(_currentSubscriber >= _subscribers.length) {
			_currentSubscriber = 0;
		}
		ISubscriber subscriber = _subscribers[_currentSubscriber];
		
		if(subscriber != null) {
			subscriber.notify(msg);
		}
		
		_currentSubscriber++;
	}

	/************************************************************************
	 * Adds a subscriber to the <code>Sequencer</code> instance.
	 * @param subscriber The subscriber to be added.
	 * 
	 ************************************************************************/
	@Override
	public void subscribe(ISubscriber subscriber) {
		if(_numSubscriber <= _subscribers.length - 1) {
			_subscribers[_numSubscriber] = subscriber;

			_numSubscriber++;
		}
	}

	/************************************************************************
	 * Deletes a subscriber from the <code>Sequencer</code> instance.
	 * @param subscriber The subscriber to be deleted.
	 * 
	 ************************************************************************/
	@Override
	public void unsubscribe(ISubscriber subscriber) {

	}
}