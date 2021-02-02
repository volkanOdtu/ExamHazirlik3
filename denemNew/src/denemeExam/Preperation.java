package denemeExam;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Node{
	int data;
	List<Node> adjacentNodes;
	boolean visited;
	
	public Node(int data) {
		this.data = data;
		adjacentNodes = new ArrayList<Node>();
	}
}
class Graph{
	List<Node> nodes;
	public List<Node> getNodes(){
		return nodes;
	}
	public Graph() {
		nodes = new ArrayList<Node>();
		
		Node node0 = new Node(0); 		
		Node node1 = new Node(1); 
		Node node2 = new Node(2); 
		Node node3 = new Node(3); 
		Node node4 = new Node(4); 
		Node node5 = new Node(5);
		
		node0.adjacentNodes.add(node1);node0.adjacentNodes.add(node4);node0.adjacentNodes.add(node5);
		node1.adjacentNodes.add(node3);node1.adjacentNodes.add(node4);
		node2.adjacentNodes.add(node1);
		node3.adjacentNodes.add(node2);node3.adjacentNodes.add(node4);
	
		nodes.add(node0);nodes.add(node1);nodes.add(node2);nodes.add(node3);nodes.add(node4);nodes.add(node5);
	}
	
	
}
public class Preperation {

	static boolean search(Graph g, Node start ,Node end){
		if(start == end) return true;
		
		Queue<Node> queueNodes = new LinkedList<Node>();
		
		queueNodes.add(start);
		while(!queueNodes.isEmpty()) {
			Node currentNode = queueNodes.poll();
			
			for(Node node: currentNode.adjacentNodes) {
				if(!node.visited) {
					
					if(node.equals(end))
						return true;
					
					node.visited = true;
					queueNodes.add(node);
				}
			}
		}
		
		return false;
	}
	public static void main(String[] args) {
		Graph g = new Graph();
		Node node0= g.getNodes().get(0);
		Node node3= g.getNodes().get(3);
		
		search(g, node0, node3);

	}

}
