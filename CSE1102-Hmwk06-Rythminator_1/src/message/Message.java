package message;

/****************************************************************************
 * A basic message to be passed to subscribers by publishers.
 * It contains the name of the publisher.
 *
 ***************************************************************************/
public class Message {
	
	private IPublisher _publisher;

	/************************************************************************
	 * Creates a <code>Message</code> instance.
	 * @param publisher The publisher for this message.
	 * 
	 ************************************************************************/
	public Message(IPublisher publisher) {
		_publisher = publisher;
	}
	
	/************************************************************************
	 * Returns the publisher.
	 * @return The publisher of the message.
	 ************************************************************************/
	public IPublisher getPublisher() {
		return _publisher;
	}
}