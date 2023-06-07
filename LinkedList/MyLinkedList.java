import java.lang.String;

public class MyLinkedList {

	static class Node {
		String value;
		Node next;

		Node(String value, Node next) {
			this.value = value;
			this.next = next;
		}

		Node(String value) {
			this(value, null);
		}
	}

	protected Node head = null;
	protected Node tail = null;
	protected int size = 0;
	String value;
	MyLinkedList next;
	


	public void addFirst(String value) {
		Node newNode = new Node(value);
		newNode.next = head;
		head = newNode;
		if (newNode.next == null) {
			tail = newNode;
		}
		size++;
	}

	public void addLast(String value) {
		Node newNode = new Node(value);
		if (tail == null) {
			head = newNode;
		} else {
			tail.next = newNode;
		}
		tail = newNode;
		size++;
	}

	public void add(int index, String value) {
		if (index < 0 || index > size)
			throw new IndexOutOfBoundsException();
		if (index == 0) {
			addFirst(value);
		} else {
			Node newNode = new Node(value);
			Node current = head;
			for (int i = 0; i < index - 1; i++) {
				current = current.next;
			}
			if (current.next == null) {
				tail = newNode;
			}
			newNode.next = current.next;
			current.next = newNode;
			size++;
		}
	}

	public String get(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		} else {
			Node current = head;
			for (int i = 0; i < index; i++) {
				current = current.next;
			}
			return current.value;
		}
	}

	public boolean contains(String value) {
		Node current = head;
		while (current != null) {
			if (current.value.equals(value)) {
				return true;
			}
			current = current.next;
		}
		return false;
	}

	public void removeFirst() {
		if (head != null) {
			head = head.next;
		} else {
			return;
		}
		if (head == null) {
			tail = null;
		}
		if (size > 0)
			size--;
	}

	public void removeLast() {
		if (head == null) { // empty list
			return;
		} else if (head == tail) {
			// single element list
			head = null;
			tail = null;
		} else {
			Node current = head;
			while (current.next != tail) {
				current = current.next;
			}
			tail = current;
			current.next = null;
		}
		size--;
	}

	public void remove(int index) {
		if (index < 0 || index >= size)
			throw new IndexOutOfBoundsException();
		else if (index == 0)
			removeFirst();
		else {
			Node current = head;
			for (int i = 0; i < index - 1; i++) {
				current = current.next;
			}
			current.next = current.next.next;
			if (current.next == null) {
				tail = current;
			}
			size--;
		}
	}

	/*
	 * Implement the methods below. Please do not change their signatures!
	 */

	public void reverse() {
		/* IMPLEMENT THIS METHOD! */
		if(head ==null) {
			return;    //empty list
		}
		Node pre = null;
		Node cur = head;
		while(cur !=null) {
			Node next =cur.next;
			cur.next = pre;
			pre =cur;
			cur =next;
		}

		head = pre;
	}

	public void removeMaximumValues(int N) {
		/* IMPLEMENT THIS METHOD! */
		if(head ==null||head.next ==null || N<=0) {return;}
		
		for(int n = N; n > 0 ; n--) {
		Node largest, cur;
		largest = head; 
		cur = head.next;
		while(cur != null) {
			if(cur.value.compareTo(largest.value)>0){
				largest = cur;
			}
			cur =cur.next;	
		}
		//print(largest);
		Node pre1, cur1;
		pre1 = head;
		cur1 = head.next;
		while(cur1 != null) {
			if(cur1.value.equals(largest.value)) {
				if(head == largest) {head = head.next;}
				else {
					pre1.next = cur1.next;
				}
				size--;
			}
			pre1 = cur1;
			cur1=cur1.next;
		}
		head = pre1;
		}
		
	}

	public Boolean containsSubsequence(MyLinkedList two) {
		/* IMPLEMENT THIS METHOD! */
		if(two ==null) {return true;}
		Node n1 = head;
		while(n1 !=null) {
			
			MyLinkedList t = two;
			Node n2 =t.head;
			
			while(n2 !=null) {
				
				if (n1.value.equals(n2.value)) {
					n1 = n1.next;
					n2 = n2.next;
						
				}
				else {
					break;
				}	
			}
			if(n2==null) {return true;}
			n1 = n1.next;
			}
	return false; 	
}

	
	
	
	
	
	
	
	
}
