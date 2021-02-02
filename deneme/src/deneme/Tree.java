package deneme;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Tree {
	static Node rootNode;

	public static Node insert(Node root ,int data ) {
		if(root == null) {
			Node insertedNode = new Node(data);
			return insertedNode;			
		}
		else {		
			if( data > root.data  ) {
				root.right = insert(root.right, data) ;
			}
			else
				root.left = insert(root.left , data) ;
			
			return root;
		}
	}
	
	public static void printByLevel() {		
		
		Queue<Node> nodesQueue= new LinkedList();
		
		nodesQueue.add(rootNode);
		
		while(!nodesQueue.isEmpty() ) {
			Node currentNode = nodesQueue.poll();
			System.out.println(currentNode.data);
			
			if(currentNode.left != null)
				nodesQueue.add(currentNode.left);
			if(currentNode.right != null)
				nodesQueue.add(currentNode.right);
					
		}			
	}
	public static void printInOrder(Node node) {
		if(node == null)
			return ;
		
		printInOrder(node.left);
		System.out.println(node.data);
		printInOrder(node.right );		
	}
	
	public static void printPreOrder(Node node) {
		if(node == null)
			return ;
		System.out.println(node.data);	
		
		printPreOrder(node.left);
		printPreOrder(node.right );				
	}
	
	public static void insertNotRecursive(int data ) {
		if(rootNode == null) {
			rootNode = new Node(data);
			rootNode.left = null;
			rootNode.right = null;
		}
		else {
		
			Node currNode = rootNode;
			Node tempNodeToBound = rootNode;
			boolean WillNodeBoundToLeft =false;
			
			while( currNode != null ) {
				tempNodeToBound= currNode;
				if( data > currNode.data ) {
					currNode = currNode.right;
					WillNodeBoundToLeft = false;
				}					
				else {
					currNode = currNode.left;
					WillNodeBoundToLeft = true;
				}
					
			}
			//now we found empty node ,so lets return the prev and bind it
			if( WillNodeBoundToLeft )
				tempNodeToBound.left = new Node(data);
			else
				tempNodeToBound.right = new Node(data);
							
		}		
	}
		 
	
	static void printGivenLevel(Node root ,int level) {
		if(root == null) return;
		if( level == 1 )
			System.out.println(root.data + " ");
		else if( level > 1) {
			printGivenLevel(root.left ,level -1);
			printGivenLevel(root.right ,level -1);
			
		}
	}
	public static void main(String[] args) {
		
		/*
		Node root = insert(null ,4 );
		  root = insert(root, 2);
		  root = insert(root, 1);
		  root = insert(root, 3);
		  root = insert(root, 5);
		  root = insert(root, 6);
	*/
		 
		insertNotRecursive(4);
		insertNotRecursive(2);
		insertNotRecursive(1);
		insertNotRecursive(3);
		insertNotRecursive(5);
		insertNotRecursive(6);

		//printInOrder(rootNode);
		//printPreOrder(rootNode);
		
		//printByLevel();
		//printGivenLevel(rootNode, 0);
		printGivenLevel(rootNode, 1);
		printGivenLevel(rootNode, 2);
		printGivenLevel(rootNode, 3);
		
		
		//int result= getHeightOfNode(rootNode);
		
		//System.out.println(result);
	}

	static class Node{
		Node left;
		Node right;
		int data;
		
		public Node(int data) {
			this.data = data;
		}
	}
}
