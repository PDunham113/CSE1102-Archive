
public class Node {
	public Object key, value;
	public Node   next;

	public Node(Object newKey, Object newValue, Node newNext) {
		key = newKey;
		value = newValue;
		next = newNext;
	}

	public String toString() {
		String s = key.toString() + "=" + value.toString();
		if(next != null) {
			s += ", " + next.toString();
		}

		return s;
	}

	public int hashCode() {
		String s = key.toString();
		int count = 4;
		if(s.length() < 4)
			count = s.length();
		int sum = 0;
		for(int n=0; n<count; n++)
			sum += (int)s.charAt(n);
		int hc = sum + s.length();
		System.out.println("hashCode of " + s + " is " + hc);
		return hc;
	}

	public static void main(String[] args) {
		HashTable ht = new HashTable();
		ht.add("x", 100);
		ht.add("y", 200);
		ht.add("z", 300);
		ht.add("q", 400);
		ht.add("Hello!", 3);
		ht.add("bob", 39);
		ht.dump();	

		System.out.println(ht);
	}
}
