package HW8;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Queue;
import java.util.HashMap;

import java.util.ArrayList;
import java.util.Arrays;

public class GraphUtils {
	
	/*
	 * Implement the following methods.
	 */

	public static int minDistance(Graph graph, String src, String dest) {
	/* minDistance: Given a Graph, this method returns the shortest distance (in terms of number of
edges) from the node labeled src to the node labeled dest. The method should return -1 for any
invalid inputs, including: null values for the Graph, src, or dest; there is no node labeled src or
dest in the graph; there is no path from src to dest. Keep in mind that this method does not just
return the distance of any path from src to dest, it must be the shortest path.*/
		if(graph==null||src==null ||dest==null|| !graph.containsNode(src)||!graph.containsNode(dest)) {
			return -1;
		}else {
			if (src.equals(dest)) {
				return 0;
			}
			
			Set<String> marked = new HashSet<>();
			marked.add(src);
			Queue<String> toExplore = new LinkedList<>();
			toExplore.add(src);
			HashMap<String, Integer> distance = new HashMap<>();
			distance.put(src, 0);
			
			while (!toExplore.isEmpty()) {
				String n = toExplore.remove();
				for (String neighbor : graph.getNodeNeighbors(n)) {
					if (!marked.contains(neighbor)) {
							distance.put(neighbor, distance.get(n)+1);
						if (neighbor.equals(dest)) {
							 return distance.get(neighbor);
						}
						marked.add(neighbor);
						toExplore.add(neighbor);
					}
				}
			}
			return -1;
			}
	}
	
public static Set<String> nodesWithinDistance(Graph graph, String src, int distance) {
	/*
nodesWithinDistance: Given a Graph, this method returns a Set of the values of all nodes
within the specified distance (in terms of number of edges) of the node labeled src, i.e. for which
the minimum number of edges from src to that node is less than or equal to the specified
distance. The value of the node itself should not be in the Set, even if there is an edge from the
node to itself. The method should return null for any invalid inputs, including: null values for the
Graph or src; there is no node labeled src in the graph; distance less than 1. However, if
distance is greater than or equal to 1 and there are no nodes within that distance (meaning: src
is the only node in the graph), the method should return an empty Set.
*/
  
		if (graph == null || src == null || !graph.containsNode(src) ||
				distance < 1) {
			return null;}
		
		Set<String> output = new HashSet<>();
		
		for (String node : graph.adjacencySets.keySet()) {
			int len = minDistance(graph, src, node);
			if ( len <= distance && len != -1) {
				output.add(node);
			}
		}
		
		output.remove(src);
		
		return output;
	}
	
	
	
	
	public static boolean isHamiltonianCycle(Graph g, List<String> values) {
		/* isHamiltonianCycle: Given a Graph, this method indicates whether the List of node values
represents a Hamiltonian Cycle. A Hamiltonian Cycle is a valid path through the graph in which
every node in the graph is visited exactly once, except for the start and end nodes, which are
the same, so that it is a cycle. If the values in the input List represent a Hamiltonian Cycle given
the order in which they appear in the List, the method should return true, but the method should
return false otherwise, e.g. if the path is not a cycle, if some nodes are not visited, if some
nodes are visited more than once, if some values do not have corresponding nodes in the
graph, if the input is not a valid path (i.e., there is a sequence of nodes in the List that are not
connected by an edge), etc. For this exercise, a cycle must contain at least 3 nodes, the method
should return false if the graph has fewer nodes. The method should also return false if the input
Graph or List is null.
		 */
		if (g == null || values == null||values.size()<=3) {

			return false;
		}
		//don't have that elements
		for (String n : g.adjacencySets.keySet()) {
			if (values.contains(n)==false) {
				return false;
			}
		}
		// the first and last node are not the same
		if(values.get(0)!=values.get(values.size()-1)) 
		{return false;}
		
		
		Set<String> nodes = new HashSet<>();
		for (int i = 0; i < values.size(); i++) {
			String node = values.get(i);
			// repeats nodes
			if((nodes.contains(node) && i!=(values.size()-1))||g.containsNode(node)==false) {
				return false;	
			}else {nodes.add(node);}
			
			if(i<values.size()-1) {
				// if neighbors is the same, return false. 
				if(g.getNodeNeighbors(node).contains(values.get(i+1))==false) {
					return false; 
				}
			}
			
		}
		

		return true;
	}
	
	
	public static void main(String[] args) {
		Graph gg = GraphBuilder.buildUndirectedGraph("graph_builder_test.txt");
		
		
		System.out.println(GraphUtils.minDistance(gg, "0", "6"));
		
		
		
		List<String> input = new ArrayList<>(Arrays.asList("A", "B", "C", "D", "E", "A"));

		System.out.println(GraphUtils.isHamiltonianCycle(gg, input));
		System.out.println(gg.adjacencySets.keySet());
		System.out.println(gg.adjacencySets.get("0"));
	}	
}