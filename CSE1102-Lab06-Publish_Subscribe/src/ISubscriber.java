

/****************************************************************************
 * Default <code>Subscriber</code> interface. Provides a method to notify the
 * subscriber.
 *
 ***************************************************************************/
public interface ISubscriber {
	
	/************************************************************************
	 * Notifies a subscriber of a new message.
	 * @param msg The message passed to the subscriber.
	 * 
	 ************************************************************************/
	public void notify(Message msg);
}