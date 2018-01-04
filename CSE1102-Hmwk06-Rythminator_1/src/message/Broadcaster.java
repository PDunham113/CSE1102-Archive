package message;

/****************************************************************************
 * Broadcasts a message to multiple subscribers.
 *
 ***************************************************************************/
public class Broadcaster implements IPublisher, ISubscriber {

	private ISubscriber[] _subscribers;
	private int           _numSubscriber = 0;

	/************************************************************************
	 * Creates an instance of a <code>Broadcaster</code> that can hold up to 
	 * some number of subscribers.
	 * @param maxSubscribers The maximum number of subscribers this 
	 * <code>Broadcaster</code> can hold.
	 * 
	 ************************************************************************/
	public Broadcaster(int maxSubscribers) {
		_subscribers = new ISubscriber[maxSubscribers];
	}

	/************************************************************************
	 * Delivers a message to all subscribers.
	 * @param msg The message delivered to the subscribers.
	 * 
	 ************************************************************************/
	@Override
	public void notify(Message msg) {
		for(ISubscriber subscriber : _subscribers) {
			if(subscriber != null) {
				subscriber.notify(msg);
			} 
		}
	}

	/************************************************************************
	 * Adds a subscriber to the <code>Broadcaster</code> instance.
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
	 * Deletes a subscriber from the <code>Broadcaster</code> instance.
	 * @param subscriber The subscriber to be deleted.
	 * 
	 ************************************************************************/
	@Override
	public void unsubscribe(ISubscriber subscriber) {

	}
}