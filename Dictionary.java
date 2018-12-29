package pa4;


public class Dictionary implements DictionaryInterface {
	//Fields for stuff
	private Node head, tail; //reference to first Node in List
	private int numItems; //numm items in queue
	
	
	//to make a new node
	private class Node{
		String key;
		String value;
		Node next;
		Node prev;
		
		Node(String k, String v){
			key = k;
			value = v;
			next = null;
			prev = null;
		}
	}
	
	//constructor for dictionary 
	public Dictionary() {
		head = null;
		tail = null;
		numItems = 0;
	}
	
	//finds a key
	//temp soultion chane to
	private Node findKey(String k) {
		Node N = head;
		//System.out.println("numItsem" + numItems);
		for (int i = 0; i < numItems; i++) {
			//System.out.println("Print" + N.key);
			if (N.key.equals(k)) {
				return N;
			}
			else {
				N = N.next;
			}
		}
		return null;
	}
	
	@Override
	public boolean isEmpty() {
		if (numItems == 0)
			return true;
		return false;
	}

	@Override
	public int size() {
		return numItems;
	}

	@Override
	public String lookup(String key) {
		if(findKey(key) != null) {
			return findKey(key).value;
		}
		return null;
	}

	@Override
	public void insert(String key, String value) throws DuplicateKeyException {
		if(findKey(key) != null) {
			throw new DuplicateKeyException("cannot insert duplicate keys");
		}
		else {
			Node n = new Node(key,value);
			
			if (head == null) {
				head = n;
				tail = n;
			}
			else {
				tail.next = n;
				n.prev = tail;
				tail = n;
				
			}
			
			numItems++;
		}
		
	}

	@Override
	public void delete(String key) throws KeyNotFoundException {
		if (findKey(key) != null) {
			//if there is only one element in dictionary
			if (findKey(key).equals(head) && findKey(key).equals(tail)) {
				head = null;
				tail = null;
			}
			//if delete first node in dicitonary
			else if (findKey(key).equals(head)) {
				head = head.next;
				head.prev = null;
			}
			//if delete last node in dictionary
			else if (findKey(key).equals(tail)) {
				tail = tail.prev;
				tail.next = null;
			}
			//if delete in middle of dictionary
			else {
				Node p = findKey(key).prev;
				Node n = findKey(key).next;
				p.next = n;
				n.prev = p;
				//findKey(key).prev = p;
				//findKey(key).next = n;
				
				//findKey(key).prev.next = findKey(key).next;
				//findKey(key).next.prev = findKey(key).prev;
			}
			
			numItems--;
		}
		else {
			throw new KeyNotFoundException("cannot delete non-existent key");
			
		}
		
	}

	@Override
	public void makeEmpty() {
		head = null;
		tail = null;
		numItems = 0;
		
	}
	
	public String toString() {
		String s = "";
		Node n = head;
		for (int i = 0; i < numItems; i++) {
			s = s + n.key + " " + n.value + "\n";
			n = n.next;
		}
		
		return s;
	}
	
}
