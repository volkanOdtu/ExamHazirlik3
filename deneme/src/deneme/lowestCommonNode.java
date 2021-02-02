package deneme;

import java.util.ArrayList;
import java.util.List;

public class lowestCommonNode {

	class Node{
		Node left;
		Node right;
		Node parent;
		
		int data;
		public Node(int data ,Node parent ) {
			this.data = data;
			this.parent = parent;
		}
	}
	
	Node rootNode = null;
	
	List<Node> getParentNodes(Node node1 ){
		
		Node temp = node1;
		List<Node> parentNodes = new ArrayList<Node>();
		
		while(temp != null) {
			parentNodes.add(temp);
			temp = temp.parent; 
		}
		
		return parentNodes; 
	}
	
	public Node findLowestAncestor( Node node1 ,Node node2 ) {
		
		List<Node> parentNodes1	= getParentNodes(node1);
		List<Node> parentNodes2	= getParentNodes(node1);
		
		List<Node> minList =parentNodes1;
		List<Node> maxList =parentNodes2;
		
		//int minSize = parentNodes1.size();
		if(parentNodes2.size() < parentNodes1.size() ) {
			minList = parentNodes2;
			maxList = parentNodes1; 
		}
			 
		
		for(int i = minList.size(); i >= 0  ;i-- ) {
			for(int j =maxList.size() ; j >= 0 ;j--) {
				if(minList.get(i).equals(maxList.get(j) ))
						return minList.get(i); 
			}
			 
		}
		
		return null;
	}
	
	public void createTree(Node root ) {
		Node node1 = new Node(1 ,null);
		Node node2 = new Node(2 ,node1);
		Node node3 = new Node(3 ,node1);
		Node node4 = new Node(4 ,node2);
		Node node5 = new Node(5 ,node2);
		Node node6 = new Node(6 ,node3);
		Node node7 = new Node(7 ,node3);
		Node node8 = new Node(8 ,node4);
		Node node9 = new Node(9 ,node4);
		Node node10 = new Node(10 ,node5);
		
		node1.left = node2;
		node1.right = node3;
		
		node2.left = node4;
		node2.right= node5;
		
		node3.left = node6;
		node3.right= node7;
		
		node4.left = node8;
		node4.right= node9;
		
		node5.left = node10;
	
		rootNode = node1;
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
