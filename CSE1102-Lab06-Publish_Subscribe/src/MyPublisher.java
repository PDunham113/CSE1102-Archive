
public class MyPublisher implements IPublisher {

	private String        _name;
	private ISubscriber[] _subscribers;
	private int           _numSubscribers;

	public MyPublisher(String name) {
		_name = name;
		_subscribers = new ISubscriber[4];
	}

	@Override
	public void subscribe(ISubscriber subscriber) {
		if(_numSubscribers < _subscribers.length) {
			_subscribers[_numSubscribers] = subscriber;
			_numSubscribers++;
		}
	}

	@Override
	public void unsubscribe(ISubscriber subscriber) {
		for(int i = 0; i < _subscribers.length; i++) {
			if(_subscribers[i] == subscriber) {
				_subscribers[i] = null;
			}
		}

	}

	public void publish() {
		Message msg = new Message(this);

		for(ISubscriber iS : _subscribers) {
			if(iS != null) {
				iS.notify(msg);
			}
		}
	}
	
	public String getName() {
		return _name;
	}
}