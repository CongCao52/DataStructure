package HW6;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BinarySearchTreeTest {

	@Test
	void testFindNodeE() {
		BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
		bst.add(8);
		bst.add(6);
		bst.add(4);
		bst.add(2);
		bst.add(16);
		bst.add(10);
		bst.add(20);
		bst.add(9);
		bst.add(12);
//		bst.add(15);
//		bst.add(17);
		
		assertNull(bst.findNode(3));
		assertTrue(bst.findNode(8).value == 8);
		assertTrue(bst.findNode(8).leftChild.value == 6);
		assertTrue(bst.findNode(8).rightChild.value == 16);
		assertEquals(bst.findNode(2).value,2);
		assertNull(bst.findNode(2).leftChild);
		assertNull(bst.findNode(4).rightChild);
		
		// null case and non-exist case
		assertNull(bst.findNode(21));
		assertNull(bst.findNode(null));
		
	}

	@Test
	void testDepthE() {
		BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
		bst.add(8);
		bst.add(6);
		bst.add(4);
		bst.add(2);
		bst.add(16);
		bst.add(10);
		bst.add(20);
		bst.add(9);
		bst.add(12);
		
		assertEquals(bst.depth(8),0);
		
		assertEquals(bst.depth(6),1);
		assertEquals(bst.depth(16),1);
		
		assertEquals(bst.depth(4),2);
		assertEquals(bst.depth(10),2);
		assertEquals(bst.depth(20),2);
		
		assertEquals(bst.depth(2),3);
		assertEquals(bst.depth(9),3);
		assertEquals(bst.depth(12),3);
		// null case and non-exist case
		assertEquals(bst.depth(null),-1);
		assertEquals(bst.depth(21),-1);
		
		
		BinarySearchTree<Integer> bst2 = new BinarySearchTree<Integer>();
		bst2.add(9);
		bst2.add(7);
		bst2.add(11);
		bst2.add(6);
		bst2.add(8);
		bst2.add(13);
		
		assertEquals(bst2.depth(9),0);
		assertEquals(bst2.depth(7),1);
		assertEquals(bst2.depth(11),1);
		
		assertEquals(bst2.depth(6),2);
		assertEquals(bst2.depth(8),2);
		assertEquals(bst2.depth(13),2);
	}
	
	@Test
	void testHeightE() {
		BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
		bst.add(8);
		bst.add(6);
		bst.add(4);
		bst.add(2);
		bst.add(16);
		bst.add(10);
		bst.add(20);
		bst.add(9);
		bst.add(12);
		
		assertEquals(bst.height(8),3);
		
		assertEquals(bst.height(6),2);
		assertEquals(bst.height(16),2);
		
		assertEquals(bst.height(4),1);
		assertEquals(bst.height(10),1);
		
		assertEquals(bst.height(20),0);
		assertEquals(bst.height(2),0);
		assertEquals(bst.height(9),0);
		assertEquals(bst.height(12),0);
		// null case and non-exist case
		assertEquals(bst.height(15),-1);
		assertEquals(bst.height(null),-1);
		
		
		BinarySearchTree<Integer> bst2 = new BinarySearchTree<Integer>();
		bst2.add(9);
		bst2.add(7);
		bst2.add(11);
		bst2.add(6);
		bst2.add(8);
		bst2.add(13);
		
		assertEquals(bst2.height(9),2);
		assertEquals(bst2.height(7),1);
		assertEquals(bst2.height(11),1);
		
		assertEquals(bst2.height(6),0);
		assertEquals(bst2.height(8),0);
		assertEquals(bst2.height(13),0);
	}
	
	@Test
	void testIsBalancedNode() {
		BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
		bst.add(8);
		bst.add(6);
		bst.add(4);
		bst.add(2);
		bst.add(16);
		bst.add(10);
		bst.add(20);
		bst.add(9);
		bst.add(12);
		
		assertTrue(bst.isBalanced(bst.findNode(8)));
		
		assertFalse(bst.isBalanced(bst.findNode(6)));
		assertTrue(bst.isBalanced(bst.findNode(16)));
		assertTrue(bst.isBalanced(bst.findNode(4)));
		assertTrue(bst.isBalanced(bst.findNode(2)));
		
		assertTrue(bst.isBalanced(bst.findNode(10)));
		assertTrue(bst.isBalanced(bst.findNode(9)));
		assertTrue(bst.isBalanced(bst.findNode(12)));
		assertTrue(bst.isBalanced(bst.findNode(20)));
		
		
		bst.add(13);

		assertFalse(bst.isBalanced(bst.findNode(16)));
		assertTrue(bst.isBalanced(bst.findNode(10)));
		assertTrue(bst.isBalanced(bst.findNode(12)));
		
		bst.add(14);
		assertFalse(bst.isBalanced(bst.findNode(10)));
		assertFalse(bst.isBalanced(bst.findNode(12)));
		
		// null case and non-exist case
		assertFalse(bst.isBalanced(bst.findNode(22)));
		assertFalse(bst.isBalanced(bst.findNode(null)));
		
		
		
		BinarySearchTree<Integer> bst2 = new BinarySearchTree<Integer>();
		bst2.add(9);
		bst2.add(7);
		bst2.add(11);
		bst2.add(6);
		bst2.add(8);
		bst2.add(13);
		

		assertTrue(bst2.isBalanced(bst2.findNode(9)));
		assertTrue(bst2.isBalanced(bst2.findNode(7)));
		assertTrue(bst2.isBalanced(bst2.findNode(11)));
		
		assertTrue(bst2.isBalanced(bst2.findNode(6)));
		assertTrue(bst2.isBalanced(bst2.findNode(8)));
		assertTrue(bst2.isBalanced(bst2.findNode(13)));
		
		assertFalse(bst2.isBalanced(bst.findNode(20)));
	}
	
	@Test
	void testIsBalanced() {
		
		BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
		
		bst.add(8);
		bst.add(6);
		bst.add(4);
		bst.add(2);
		bst.add(16);
		bst.add(10);
		bst.add(20);
		bst.add(9);
		bst.add(12);

		assertFalse(bst.isBalanced());
		
		BinarySearchTree<Integer> bst2 = new BinarySearchTree<Integer>();
		bst2.add(9);
		bst2.add(7);
		bst2.add(11);
		bst2.add(6);
		bst2.add(8);
		bst2.add(13);
		
		assertTrue(bst2.isBalanced());
		
		
		bst = new BinarySearchTree<Integer>();
		bst.add(2);
		bst.add(3);
		bst.add(7);
		assertFalse(bst.isBalanced());
		/*
		// empty tree
		bst = new BinarySearchTree<Integer>();
		assertTrue(bst.isBalanced());
		*/
	}

}
