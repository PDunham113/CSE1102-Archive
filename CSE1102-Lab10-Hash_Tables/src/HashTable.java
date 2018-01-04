
public class HashTable {
	private int    _numBuckets = 7;
	private Node[] _buckets = new Node[_numBuckets];
	private int    _count = 0;
	private double _loadFactor = 0.0;
	private double _maxLoadFactor = 0.7;
	private int    _bucketNum;

	public void add(Object key, Object value) {
		Node location = _locate(key);
		_bucketNum = key.hashCode() % _numBuckets;

		if(location == null) {
			Node newNode = new Node(key, value, _buckets[_bucketNum]);
			_buckets[_bucketNum] = newNode;
			_count++;
			_loadFactor = (double)_count / (double)_numBuckets;
			if(_loadFactor > _maxLoadFactor)
				_increaseTableSize();
		}
		else {
			location.value = value;
		}
	}

	private void _increaseTableSize() {
		_numBuckets = _numBuckets * 2 + 1;
		_count      = 0;
		_loadFactor = 0;
		Node[] newBuckets = new Node[_numBuckets];
		Node[] buffer = _buckets;
		_buckets = newBuckets;
		newBuckets = buffer;

		for(Node i : newBuckets) {
			if(i != null) {
				Node bufferNode = i;
				while(bufferNode != null) {
					add(bufferNode.key, bufferNode.value);
					bufferNode = bufferNode.next;
				}
			}
		}

	}

	private Node _locate(Object key) {
		int hashCode = key.hashCode();
		_bucketNum = hashCode % _numBuckets;

		return _locate(key, _bucketNum);
	}

	private Node _locate(Object key, int bucketNum) {
		Node bucketList = _buckets[bucketNum];

		while(bucketList != null) {
			if(bucketList.key == key) {
				break;
			}
			else {
				bucketList = bucketList.next;
			}
		}

		return bucketList;
	}

	public void dump() {
		for(int n = 0; n < _numBuckets; n++) {
			System.out.println(n + ": " + _buckets[n]);
		}
	}

	public Object get(Object key) {
		Node location = _locate(key);

		if(location != null)
			return location.value;
		else
			return null;
	}

	@Override
	public String toString()
	{
		String s = "{";
		boolean first = true;
		for(int n=0; n<_numBuckets; n++)
		{
			Node node = _buckets[n];
			if(node != null)
			{
				if(first)
					first = false;
				else
					s += ", ";
				s += node.toString();
			}
		}
		s += "}";
		return s;
	}
}
