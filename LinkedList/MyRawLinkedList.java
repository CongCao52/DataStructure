//import MyLinkedList.Node;
import java.lang.String;
public class MyRawLinkedList {

	static class Node {
		String value;
		Node next = null;

		Node(String value, Node next) {
			this.value = value;
			this.next = next;
		}

		Node(String value) {
			this(value, null);
		}
	}

	/*
	 * These methods included as examples for how to use Node as a linked list.
	 */
	public static String listToString(Node head) {
		String ret = "";
		while (head != null) {
			ret += "\"" + head.value + (head.next == null ? "\" " : "\", ");
			head = head.next;
		}
		return "[ " + ret + "]";
	}

	public static void print(Node head) {
		System.out.println(listToString(head));
	}

	public static void main(String[] args) {
		Node list1 = new Node("One", new Node("Two", new Node("Three", null)));
		print(list1);

		Node args_as_list = null;
		for (int i = args.length - 1; i >= 0; i--)
			args_as_list = new Node(args[i], args_as_list);

		print(args_as_list);

		Node list2 = null;
		list2 = new Node("a", list2);
		list2 = new Node("b", list2);
		list2 = new Node("c", list2);
		print(list2);
		// Some example usage
		print(reverse(list1));
		
		print(removeMaximumValues(list2, 2));
		
		System.out.println(containsSubsequence(list1, list2));
		
		Node list3 = null;
		Node list4 =null; 
		list3 = new Node("a", list3);
		list3 = new Node("b", list3);
		list3 = new Node("c", list3);
		list4 = new Node("d", list4);
		list4 = new Node("e", list4);
		list4 = new Node("f", list4);
		print(list3);
		print(list4);
		System.out.println(containsSubsequence(list3, list4));

		
		Node list5 = null;
		Node list6 =null; 
		list5 = new Node("a", list5);
		list5 = new Node("b", list5);
		list5 = new Node("c", list5);
		list5 = new Node("d", list5);
		list6 = new Node("b", list6);
		list6 = new Node("c", list6);
		print(list5);
		print(list6);
		System.out.println(containsSubsequence(list5, list6));
		
		
		Node list7 = null;
		list7 = new Node("kangaroo",list7);
		list7 = new Node("platypus",list7);
		list7 = new Node("aardvark",list7);
		list7 = new Node("kangaroo",list7);
		list7 = new Node("donkey",list7);
		list7 = new Node("coyote",list7);
		print(list7);
		print(removeMaximumValues(list7, 2));
		
		Node list8 = null;
		Node list9 =null; 
		list8 = new Node("C", list8);
		list8 = new Node("B", list8);
		list8 = new Node("B", list8);
		list8 = new Node("B", list8);
		list8 = new Node("A", list8);
		list9 = new Node("C", list9);
		list9 = new Node("A", list9);
		System.out.println(containsSubsequence(list8, list9));
		
		Node list10 =null; 
		list10 = new Node("B", list10);
		list10 = new Node("A", list10);
		list10 = new Node("A", list10);
		System.out.println(containsSubsequence(list8, list10));
		//System.out.println(containsSubsequence(list8, list8));
		Node list11 =null;
		System.out.println(containsSubsequence(list11, list10 ));
		
		Node list12 = null; 
		list12 = new Node("B", list12);
		list12 = new Node(null, list12);
		list12 = new Node("A", list12);
		System.out.println(containsSubsequence(list8, list12 ));
		
		
		
		Node list13 = null;
		list13 = new Node("elephant", list13);
		list13 = new Node("gorilla", list13);
		list13 = new Node("dog", list13);
		list13 = new Node("cat", list13);
		print(list13);
		// Some example usa
		
		print(removeMaximumValues(list13, 2));
		
		
		
	}

	/*
	 * Implement the methods below. Please do not change their signatures!
	 */

	public static Node reverse(Node head) {
		/* IMPLEMENT THIS METHOD! */
		if(head ==null) {
			return null;    //empty list
		}
		Node pre = null;
		Node cur = head;
		while(cur !=null) {
			Node next =cur.next;
			cur.next = pre;
			pre =cur;
			cur =next;
		}

		return pre;
	}

	public static Node removeMaximumValues(Node head, int N) {
		/* IMPLEMENT THIS METHOD! */
		if(head ==null||head.next ==null || N<=0) {return null;}
		
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
			}
			pre1 = cur1;
			cur1=cur1.next;
		}
		}
		return head;
	}
	
	public static boolean containsSubsequence(Node head, Node other) {
		/* IMPLEMENT THIS METHOD! */
		if(other ==null) {return true;}
		Node n1 = head;
		while(n1 !=null) {
			Node n2 = other;
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