package deneme;

import java.util.ArrayList;
import java.util.List;

public class LCA {
		Node root;
	 class Node{
		Node left;
		Node right;
		int val;
		Node parent ;
		
		public Node(int data ,Node parent) {
			this.val = data;
			this.parent = parent; 
			if(parent !=null)
				AddNode(this, parent);
		}
	}
	 
	public void createNodes() {
		root = new Node(8,null);
		Node node3 = new Node(3,root);
		
		Node node15 = new Node(15,root);
		Node node1 = new Node(1,node3);
		Node node5 = new Node(5,node3);
		Node node4 = new Node(4,node5);
		Node node7 = new Node(7,node5);
		 
	}
	public Node AddNode(Node node ,Node parent) {
		if(node.val > parent.val)
			parent.right = node;
		else
			parent.left = node;
		return node;
	}
	public Node getNode(int val ,Node node) {
		
		if(val == node.val)
			return node;		
		else if(val > node.val  )
			return getNode(val, node.right);
		else //(val < node.val)
			return getNode(val, node.left);
		
	}
	public int findLowestAncestorNode(Node node1 ,Node node2) {
		
		List<Integer> root1Ancestors = new ArrayList<Integer>();
		List<Integer> root2Ancestors = new ArrayList<Integer>();
		
		Node tempRoot =node1.parent;
		while(tempRoot!= null) {
			root1Ancestors.add(tempRoot.val);
			tempRoot = tempRoot.parent;
		}
			
		tempRoot =node2.parent;
		while(tempRoot!= null) {
			root2Ancestors.add(tempRoot.val);
			tempRoot = tempRoot.parent;
		}	
			
		//lets find the min length array
		List<Integer> minArray= root1Ancestors;
		List<Integer> maxArray= root2Ancestors;
		
		if(minArray.size() > maxArray.size() ) {
			minArray = root1Ancestors;
			maxArray = root2Ancestors;
		}
		
		for(int i:minArray) {
			if(maxArray.contains(i))
				return i;
		}
		
		
		return -1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LCA ex = new LCA();
		ex.createNodes();
		//Node node1 = ex.getNode(1, ex.root);
		//Node node4 = ex.getNode(4, ex.root);
		
		Node node15 = ex.getNode(15, ex.root);
		Node node7 = ex.getNode(7, ex.root);
		
		int lca = ex.findLowestAncestorNode(node15, node7);
		System.out.println(lca);
		
	}

	
}
