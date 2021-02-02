package deneme;

import deneme.LevelLinkedList.Node;

public class Successor {

	class Node{
		int data;
		
		public Node(int data ,Node parent) {
			this.data = data;
			this.parent = parent;
		}
		Node left,right ,parent;
	}
	
	Node leftMostChild(Node node) {
		if(node == null)
			return null;
		
		while(node.left != null)
			node = node.left;
		
		return node;
	}
	
	Node inOrderSuccess(Node node) {
	
		if(node == null) return null;
		
		if(node.right != null )
			return leftMostChild(node.right);
		else {
			Node q = node;
			Node x = q.parent;
			//Go up untill we're on left instead of right
			while(x != null && x.left != q) {
				q= x;
				x = x.parent;
			}
			return x;
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
