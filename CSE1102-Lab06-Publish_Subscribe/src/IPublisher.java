

/****************************************************************************
 * Default <code>Publisher</code> interface. Provides methods to subscribe 
 * and unsubscribe from a publisher.
 *
 ***************************************************************************/
public interface IPublisher {
	
	/************************************************************************
	 * Adds a subscriber.
	 * @param subscriber The subscriber to be added.
	 * 
	 ************************************************************************/
	public void subscribe(ISubscriber subscriber);
	
	/************************************************************************
	 * Deletes a subscriber.
	 * @param subscriber The subscriber to be deleted.
	 * 
	 ************************************************************************/
	public void unsubscribe(ISubscriber subscriber);
}