package HW6;


public class BinarySearchTree<E extends Comparable<E>> {
	class Node {
		E value;
		Node leftChild = null;
		Node rightChild = null;

		Node(E value) {
			this.value = value;
		}

		@Override
		public boolean equals(Object obj) {
			if ((obj instanceof BinarySearchTree.Node) == false)
				return false;
			@SuppressWarnings({ "unchecked", "rawtypes" })
			Node other = (BinarySearchTree.Node) obj;
			return other.value.compareTo(value) == 0 && other.leftChild == leftChild && other.rightChild == rightChild;
		}
	}

	protected Node root = null;

	protected void visit(Node n) {
		System.out.println(n.value);
	}

	public boolean contains(E val) {
		return contains(root, val);
	}

	protected boolean contains(Node n, E val) {
		if (n == null)
			return false;

		if (n.value.equals(val)) {
			return true;
		} else if (n.value.compareTo(val) > 0) {
			return contains(n.leftChild, val);
		} else {
			return contains(n.rightChild, val);
		}
	}

	public boolean add(E val) {
		if (val == null) {
			return false;
		}
		if (root == null) {
			root = new Node(val);
			return true;
		}
		return add(root, val);
	}

	protected boolean add(Node n, E val) {
		if (n == null || val == null) {
			return false;
		}
		int cmp = val.compareTo(n.value);
		if (cmp == 0) {
			return false; // this ensures that the same value does not appear more than once
		} else if (cmp < 0) {
			if (n.leftChild == null) {
				n.leftChild = new Node(val);
				return true;
			} else {
				return add(n.leftChild, val);
			}
		} else {
			if (n.rightChild == null) {
				n.rightChild = new Node(val);
				return true;
			} else {
				return add(n.rightChild, val);
			}
		}
	}

	public boolean remove(E val) {
		return remove(root, null, val);
	}

	protected boolean remove(Node n, Node parent, E val) {
		if (n == null)
			return false;

		if (val.compareTo(n.value) < 0) {
			return remove(n.leftChild, n, val);
		} else if (val.compareTo(n.value) > 0) {
			return remove(n.rightChild, n, val);
		} else {
			if (n.leftChild != null && n.rightChild != null) {
				n.value = maxValue(n.leftChild);
				remove(n.leftChild, n, n.value);
			} else if (parent == null) {
				root = n.leftChild != null ? n.leftChild : n.rightChild;
			} else if (parent.leftChild == n) {
				parent.leftChild = n.leftChild != null ? n.leftChild : n.rightChild;
			} else {
				parent.rightChild = n.leftChild != null ? n.leftChild : n.rightChild;
			}
			return true;
		}
	}

	protected E maxValue(Node n) {
		if (n.rightChild == null) {
			return n.value;
		} else {
			return maxValue(n.rightChild);
		}
	}

	/*
	 * Implement the methods below.
	 */

	// Method #1.
	public Node findNode(E val) {
		if (val == null || contains(val)==false) {
			return null;
		}
		else {
		return switchNode(root,val);}
		
	}
	//function for recursion. 
	Node switchNode(Node node, E e) {
		if(node.value.compareTo(e)<0) {return switchNode(node.rightChild,e);}
		else if(node.value.compareTo(e)>0) {return switchNode(node.leftChild,e);}
		else {return node;}
	}
	

	// Method #2
	int d = 0;
	protected int depth(E val){
		if( val ==null||contains(val)==false) {
			return -1; 
		}else {
			int r = getdepth(root,val);
			d = 0;
			return r;
		}
	}
	
	int getdepth(Node node, E e) {
		
		if(node.value.compareTo(e)<0) {
		d++;
		getdepth(node.rightChild,e);}
		else if(node.value.compareTo(e)>0) {
		d++;
		getdepth(node.leftChild,e);}
		
		return d;
	}
	
	
	

	// Method #3.
	protected int height(E val){
		if( val ==null || contains(val)==false) {
			return -1; 
		}else {
		Node node = findNode(val);
		return getheight(node);
		}
	}

	
	int getheight(Node node) {
		if(node ==null) {return -1;}
		else {
			int l = getheight(node.leftChild);
			int r = getheight(node.rightChild);
			if(r>l) {
				return r+1;
			}else {return l+1;}
		}
	}
	
	
	
	// Method #4.
	protected boolean isBalanced(Node n) {
		if( n ==null|| contains(n.value)==false) {
			return false; 
		}else { 
			int left = 0;
			int right =0;
			
			if(n.rightChild==null) {
				right = right-1;
			}else {right = height(n.rightChild.value);}
			
			if(n.leftChild==null) {
				left = left-1;
			}else {left = height(n.leftChild.value);}
			
			int diff = right-left;
			if(diff>1||diff<-1) {return false;}
			else {return true;}			
		}
	}

	// Method #5.
	public boolean isBalanced() {
		
		return getbalanced(root);
	}
	
	
	boolean getbalanced(Node node) {
		if(node ==null) {return true;}
		else if (isBalanced(node)&& isBalanced(node.leftChild)&& isBalanced(node.rightChild)) {
			return true;
		}
		else {
			return false;
		}
		
	}
}