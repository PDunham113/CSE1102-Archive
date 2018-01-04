public class MySubscriber implements ISubscriber {

	private String _name;
	
	public MySubscriber(String name) {
		_name = name;
	}
	
	@Override
	public void notify(Message msg) {
		System.out.println("notify called on " + _name);
		
		IPublisher pub = msg.getPublisher();
		
		if(pub instanceof MyPublisher) {
			MyPublisher myPub = (MyPublisher) pub;
			String pubName = myPub.getName();
			System.out.println("\tby the publisher " + pubName);
		}
	}
}
