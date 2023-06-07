package HW8;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import java.util.HashSet;
import java.util.Set;
class GraphUtilsTest {

	@Test
	void testMinDistance() {
		Graph ug = GraphBuilder.buildUndirectedGraph("graph_builder_test.txt");
		Graph dg = GraphBuilder.buildDirectedGraph("graph_builder_test2.txt");
		
		// undirected
		
		assertEquals(GraphUtils.minDistance(ug, "0", "6"),3);
		assertEquals(GraphUtils.minDistance(ug, "0", "7"),-1);
		assertEquals(GraphUtils.minDistance(ug, "7", "8"),1);
		
		
		
		// directed
		assertEquals(GraphUtils.minDistance(dg, "A", "D"),1);
		
		assertEquals(GraphUtils.minDistance(dg, "E", "D"),2);
		
		assertEquals(GraphUtils.minDistance(null, "A", "D"),-1);
		assertEquals(GraphUtils.minDistance(dg, null, "D"),-1);
		assertEquals(GraphUtils.minDistance(dg, "A", null),-1);
		
		assertEquals(GraphUtils.minDistance(dg, "A", "1"),-1);
		assertEquals(GraphUtils.minDistance(dg, "Z", "A"),-1);
		
		assertEquals(GraphUtils.minDistance(dg, "D", "B"),3);
	}

	@Test
	void testNodesWithinDistance() {
		Graph ug = GraphBuilder.buildUndirectedGraph("graph_builder_test.txt");
		Graph dg = GraphBuilder.buildDirectedGraph("graph_builder_test2.txt");
		// undirected
        Set<String> set = new HashSet<String>();
        set.add("0");
        set.add("2");
        set.add("5");

		assertEquals(GraphUtils.nodesWithinDistance(ug,"1", 1),set);
		
		set = new HashSet<String>();
        set.add("8");
		assertEquals(GraphUtils.nodesWithinDistance(ug,"7", 3),set);
		
		set = new HashSet<String>();
        set.add("1");
        set.add("2");
        set.add("3");
        set.add("5");
        set.add("4");
        
		assertEquals(GraphUtils.nodesWithinDistance(ug,"0", 2),set);
		
		set.add("6");
		assertEquals(GraphUtils.nodesWithinDistance(ug,"0", 3),set);
		
		// directed
        Set<String> hash_Set = new HashSet<String>();
        
        hash_Set.add("B");
        hash_Set.add("C");
        hash_Set.add("D");
        hash_Set.add("E");
		
		assertEquals(GraphUtils.nodesWithinDistance(dg,"A", 2),hash_Set);
		assertEquals(GraphUtils.nodesWithinDistance(dg,"A", 3),hash_Set);
		
		hash_Set = new HashSet<String>();
		
		hash_Set.add("D");
        hash_Set.add("E");
		assertEquals(GraphUtils.nodesWithinDistance(dg,"C", 2),hash_Set);
		
		
		hash_Set = new HashSet<String>();
		
		hash_Set.add("D");
        hash_Set.add("E");
        hash_Set.add("A");
		assertEquals(GraphUtils.nodesWithinDistance(dg,"C", 3),hash_Set);
		
		// empty set
		hash_Set = new HashSet<String>();
		Graph test2 = GraphBuilder.buildUndirectedGraph("test2.txt");
		assertEquals(GraphUtils.nodesWithinDistance(test2,"A", 3),hash_Set);
	}

	@Test
	void testIsHamiltonianCycle() {
		Graph ug = GraphBuilder.buildUndirectedGraph("graph_builder_test.txt");
		Graph dg = GraphBuilder.buildDirectedGraph("graph_builder_test2.txt");
		// undirectedGraph test
		
		List<String> input = new ArrayList<>(Arrays.asList("0","1", "2", "3", "4", "5", "6","7","8","0"));
		assertFalse(GraphUtils.isHamiltonianCycle(ug, input));
		
		Graph utest1 = GraphBuilder.buildUndirectedGraph("test1.txt");
		
		input = new ArrayList<>(Arrays.asList("A","B","A"));
		assertFalse(GraphUtils.isHamiltonianCycle(utest1, input));
		
		Graph utest3 = GraphBuilder.buildUndirectedGraph("test3.txt");
		
		input = new ArrayList<>(Arrays.asList("A","B","C","A"));
		assertTrue(GraphUtils.isHamiltonianCycle(utest3, input));
		input = new ArrayList<>(Arrays.asList("B","C","A","B"));
		assertTrue(GraphUtils.isHamiltonianCycle(utest3, input));
		input = new ArrayList<>(Arrays.asList("A","B","C","B"));
		assertFalse(GraphUtils.isHamiltonianCycle(utest3, input));
		
		// directed graph test
		input = new ArrayList<>(Arrays.asList("A", "B", "C", "D", "E", "A"));
		assertTrue(GraphUtils.isHamiltonianCycle(dg, input));
		
		input = new ArrayList<>(Arrays.asList("B", "C", "D", "E", "A", "B"));
		assertTrue(GraphUtils.isHamiltonianCycle(dg, input));
		
		input = new ArrayList<>(Arrays.asList("C", "D", "E", "A", "B","C"));
		assertTrue(GraphUtils.isHamiltonianCycle(dg, input));
		
		input = new ArrayList<>(Arrays.asList("D", "E", "A", "B","C", "D"));
		assertTrue(GraphUtils.isHamiltonianCycle(dg, input));
		
		input = new ArrayList<>(Arrays.asList("E", "A", "B","C", "D","E"));
		assertTrue(GraphUtils.isHamiltonianCycle(dg, input));
		
		//false case
		input = new ArrayList<>(Arrays.asList("D", "E", "A", "B", "D"));
		assertFalse(GraphUtils.isHamiltonianCycle(dg, input));
		
		input = new ArrayList<>(Arrays.asList("A", "B", "D", "E", "C","A"));
		assertFalse(GraphUtils.isHamiltonianCycle(dg, input));
		
		input = new ArrayList<>(Arrays.asList("A", "B", "C", "D", "E"));
		assertFalse(GraphUtils.isHamiltonianCycle(dg, input));
		
		input = new ArrayList<>(Arrays.asList("A", "B", "A"));
		assertFalse(GraphUtils.isHamiltonianCycle(dg, input));
		
		
		input = new ArrayList<>(Arrays.asList("A", "B", "C", "D", "E", "A","B"));
		assertFalse(GraphUtils.isHamiltonianCycle(dg, input));
		
		input = new ArrayList<>(Arrays.asList("Z", "B", "C", "D", "E", "A"));
		assertFalse(GraphUtils.isHamiltonianCycle(dg, input));
		
		input = new ArrayList<>(Arrays.asList("C", "D", "E", "C", "D", "E"));
		assertFalse(GraphUtils.isHamiltonianCycle(dg, input));
		
		
		input = new ArrayList<>(Arrays.asList("1", "2", "E", "C", "D", "E"));
		assertFalse(GraphUtils.isHamiltonianCycle(dg, input));
		
		// null case
		assertFalse(GraphUtils.isHamiltonianCycle(null, input));
		
		assertFalse(GraphUtils.isHamiltonianCycle(dg, null));
	}

}