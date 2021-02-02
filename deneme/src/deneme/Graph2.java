package deneme;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

enum state {Unvisited ,Visited ,Visiting }

class GraphWithNodes{
	Node_[] nodes;
	
	public GraphWithNodes() {
		nodes = new Node_[6];
		
		Node_ node0 = new Node_(0); nodes[0] = node0;
		Node_ node1 = new Node_(1); nodes[1] = node1;
		Node_ node2 = new Node_(2); nodes[2] = node2;
		Node_ node3 = new Node_(3); nodes[3] = node3;
		Node_ node4 = new Node_(4); nodes[4] = node4;
		Node_ node5 = new Node_(5); nodes[5] = node5;
		
		nodes[0].adjacentNodes.add(node1); nodes[0].adjacentNodes.add(node4); nodes[0].adjacentNodes.add(node5);
		nodes[1].adjacentNodes.add(node3); nodes[1].adjacentNodes.add(node4); 
		nodes[2].adjacentNodes.add(node1);  
		nodes[3].adjacentNodes.add(node2); nodes[3].adjacentNodes.add(node4);  		
	}
	
	Node_[] getNodes() {
		return nodes;
	}
}
class Node_{
	int data;
	public Node_(int data) {
		this.data = data;
		this.adjacentNodes = new ArrayList<Node_>();
	}
	state visited;
	List<Node_> adjacentNodes;
}
public class Graph2 {

	static boolean search(GraphWithNodes g,Node_ start ,Node_ end){
		if(start == end ) return true;
		
		LinkedList<Node_> queue = new LinkedList<Node_>();
		
		for(Node_ currNode: g.getNodes())
			currNode.visited = state.Unvisited;
		
		start.visited = state.Visiting;
		queue.add(start);
		
		Node_ temp;
		while(!queue.isEmpty()) {
			temp = queue.removeFirst();
			if(temp != null)
			{
				for(Node_ n : temp.adjacentNodes) {
					if(n.visited == state.Unvisited) {
						if(n == end)
							return true;
						else {
							n.visited = state.Visiting;
							queue.add(n);
						}
					}
				}
				temp.visited = state.Visited;
			}
		}
		return false;
	}
	public static void main(String[] args) {
		GraphWithNodes g = new GraphWithNodes();
		
		Node_ start = g.getNodes()[0];
		Node_ end = g.getNodes()[3];
		
		boolean connectionExists = search(g, start, end);
		
	}

}
