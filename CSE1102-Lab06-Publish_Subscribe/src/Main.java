public class Main {

	public static void main(String[] args) {
		MyPublisher  pub1 = new MyPublisher("pub1");
		MyPublisher  pub2 = new MyPublisher("pub2");
		MySubscriber sub1 = new MySubscriber("sub1");
		MySubscriber sub2 = new MySubscriber("sub2");
		MySubscriber sub3 = new MySubscriber("sub3");
		
		pub1.subscribe(sub1);
		pub1.subscribe(sub2);
		pub1.subscribe(sub3);
		
		pub2.subscribe(sub1);
		pub2.subscribe(sub2);
		
		pub1.publish();
		pub2.publish();
	}
}