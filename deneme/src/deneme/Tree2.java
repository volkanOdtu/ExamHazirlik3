package deneme;

import java.util.LinkedList;
import java.util.Queue;

class Node{
	int data;
	boolean visited;
	Node[] adjacentNodes;
}

class Graph{
	Node[] nodes;
}

public class Tree2 {
	
	void searchBreadthFirst(Node root){
		Queue<Node> queue = new LinkedList<Node>();
		root.visited = true;
		queue.add(root);
		while(!queue.isEmpty()) {
			Node node = queue.remove();
			System.out.println(node.data);
			for (Node currNode : node.adjacentNodes) {
				queue.add(currNode);
			}
		}
				
				
		if(root == null ) return;
		
		visit(root);
		root.visited = true;
		
		foreach(Node n in root.adjacentNodes)
			searchDepthFirst(n);
	}
	
	void searchDepthFirst(Node root){
		if(root == null ) return;
		
		visit(root);
		root.visited = true;
		
		foreach(Node n in root.adjacentNodes)
			searchDepthFirst(n);
	}
	
	/*
	void inOrder(Node node) {
		if(node != null) {
			inOrder(node.left);
			visit(node);
			inOrder(node.right);
		}
	}
	void preOrder(Node node) {
		if(node != null) {
			visit(node);//root			
			inOrder(node.left);
			inOrder(node.right);
		}
	}
	void postOrder(Node node) {
		if(node != null) {
			inOrder(node.left);
			inOrder(node.right);
			visit(node);//root						
		}
	}*/
}
