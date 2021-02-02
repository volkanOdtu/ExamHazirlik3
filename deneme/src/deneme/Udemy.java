package deneme;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Udemy {
	static int pathCount =0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Stack<Node> nodes = new Stack<Node>();
		Node node00 = new Node(0, 0);
		Node node10 = new Node(1, 0);
		Node node20 = new Node(2, 0);
		Node node01 = new Node(0, 1);
		Node node11 = new Node(1 ,1);
		Node node21 = new Node(2, 1);
		Node node02 = new Node(0, 2);
		Node node12 = new Node(1, 2);
		Node node22 = new Node(2, 2);
		
		node00.left = node01; node00.right = node10;
		node01.left = node02; node01.right = node11;
		node02.left = null;   node02.right = node12;
		
		node10.left = node11; node10.right = node20;
		node11.left = node12; node11.right = node21;
		node12.left = null;   node12.right = node22;
		
		node20.left = node21; node20.right = null;
		node21.left = node22; node21.right = null;
		node22.left = null;   node22.right = null;
		
		nodes.add(node00);
		nodes.add(node10);
		nodes.add(node20);
		nodes.add(node01);
		nodes.add(node11);
		nodes.add(node21);
		nodes.add(node02);
		nodes.add(node12);
		nodes.add(node22);
	
		Udemy ex = new Udemy();
		List<Node> nodesInPath = new ArrayList<Udemy.Node>();
		
		ex.findPaths(0, null, node00, nodesInPath);
		nodesInPath.forEach(node -> System.out.println(node.x + "-" + node.y ));
		//ex.findCoordinates(0, nodes, 0, 0);
		//List<Stack<Node>> paths = ex.generatePaths(nodesInPath);
		
		System.out.println(pathCount);
	}
	
	
	
	static class Node{
		Node right;
		Node left;
		int x;
		int y;
		
		Node(int x ,int y){this.x =x ;this.y =y;}		
	}
	
	public List<Stack<Node>> generatePaths(List<Node> nodesInPath) {
		Stack<Node> nodesInStack= new Stack<Udemy.Node>();
		 
		
		Node currNode;
		
		Stack<Node> newNodesInStack = new Stack<Udemy.Node>();
		List<Stack<Node>> listOfNodes = new ArrayList<Stack<Node>>();
		boolean nodePathFirstCreated = false;
				
		for(int i=0; i< nodesInPath.size() ; i++) {
			currNode = nodesInPath.get(i);
			//System.out.println(currNode.x );
			if( nodePathFirstCreated == false ) {
				nodesInStack.add(currNode);
				
				if(currNode.x ==2 && currNode.y == 2) {
					nodePathFirstCreated = true;
					if(newNodesInStack.size() > 0)
						nodesInStack.addAll(newNodesInStack);
					
					Stack<Node> newStack= (Stack<Node>) nodesInStack.clone();
					
					listOfNodes.add(newStack );
				}
			}			
			else{		
				if(currNode.x ==2 && currNode.y == 2) {
					nodesInStack.pop();
					newNodesInStack.add(currNode);
					
					if(newNodesInStack.size() > 0)
						nodesInStack.addAll(newNodesInStack);
					
					Stack<Node> newStack= (Stack<Node>) nodesInStack.clone();
					
					listOfNodes.add(newStack );
				}
				else{
					nodesInStack.pop();
					newNodesInStack.add(currNode);
				}
			}
		}
		return listOfNodes;
	}
	public void findPaths(int edgeNo ,Stack<Node> nodes, Node currNode ,List<Node> nodesInPath) {
		if(currNode == null) return;
		
		nodesInPath.add(currNode);
		if(currNode.x == 2 && currNode.y == 2) {
			pathCount++;
		}
		
		findPaths(edgeNo, nodes, currNode.left, nodesInPath);		
		findPaths(edgeNo, nodes, currNode.right, nodesInPath);
		
	}
	
	public void findCoordinates(int edgeNo ,Stack<Node> nodes, int targetX ,int targetY  ) {
		if(targetX == 3 || targetY == 3 ) return;
		
		//nodesInPath.add(currNode);
		if(targetX == 2 && targetY == 2) {
			pathCount++;			
		}
		
		findCoordinates(edgeNo, nodes, ++targetX ,targetY );		
		findCoordinates(edgeNo, nodes, targetX, ++targetY );
		
	}
}
