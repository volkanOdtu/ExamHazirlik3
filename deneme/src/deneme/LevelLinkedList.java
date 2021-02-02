package deneme;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import deneme.MinimalTree.Node;

public class LevelLinkedList {

	class Node{
		int data;
		public Node(int data) {
			this.data = data;
		}
		Node left,right;
	}
	Node createMinimalBSTTree(int[] array) {
		return createMinimalBSTTree(array ,0 , array.length -1 );
	}
	
	Node createMinimalBSTTree(int[] array, int start ,int end) {
		if(end < start )
			return null;
		
		int mid = (start + end ) / 2;
		Node n = new Node(array[mid]);
		n.left = createMinimalBSTTree(array, start, mid -1);
		n.right = createMinimalBSTTree(array, mid + 1, end);
		
		return n;
	}
	void createLevelLinkedList(Node root ,ArrayList<LinkedList<Node>> lists ,int level) {
		if( root == null )
			return ;
		
		LinkedList<Node> list = null;
		
		//ilk defa level e geliniyosa ,LinkedList olusturucaz ,ama sag taraf process edlince mevcut linked list e eklicez		
		if(lists.size() == level ) { 
			list = new LinkedList<Node>();
			lists.add(list);
		}
		else
			list = lists.get(level);
		
		list.add(root);
		
		createLevelLinkedList(root.left, lists, level + 1 );
		createLevelLinkedList(root.right , lists, level + 1 );		
	}
	
	ArrayList<LinkedList<Node>> createLevelLinkedList(Node root){
		ArrayList<LinkedList<Node>> lists = new ArrayList<LinkedList<Node>>();
		createLevelLinkedList(root, lists, 0);
		return lists;
	}
	
	
	ArrayList<LinkedList<Node>> getNodes(Node root , ArrayList<LinkedList<Node>> nodesAtLevel ){
	
		getNodesByLevel(root ,nodesAtLevel ,0);
		return nodesAtLevel;
		
	}
	void getNodesByLevel(Node node, ArrayList<LinkedList<Node>> nodesAtLevel ,int level){
	
		if(node == null)
			return;
		
		if(nodesAtLevel.size() == level) {
			nodesAtLevel.add( new LinkedList<Node>());
		}
			
		nodesAtLevel.get(level).addLast(node);
		
		getNodesByLevel(node.left, nodesAtLevel, level + 1);
		getNodesByLevel(node.right , nodesAtLevel, level + 1);
		
	}
	int getRecursiveHeight(Node node) {
		if(node == null ) return 0;
		
		return 1 + Math.max( getRecursiveHeight(node.left), getRecursiveHeight(node.right)) ;
	}
	
	int getHeight(Node node) {
		int result =0 , resultLeft =0 ,resultRight = 0;
		
		if(node == null ) return 0;
		
		resultLeft = 1 + getHeight(node.left);
		resultRight = 1 + getHeight(node.right);
		
		result = resultLeft;
		
		if(resultRight != resultLeft ) 
			result = resultRight;
		
		return result;
	}
	boolean isBalanced(Node root) {
		
		return true;
		
		
		/*if(Math.abs(heightDiff) > 1 )
			return false;
		else
			return isBalanced(root.left) && isBalanced(root.right);*/
		
		
	}
	
	
	int index = 0;
	
	void copyBST(Node node ,List<Integer> items) {
		if(node == null ) return;
		
		copyBST(node.left, items);
		items.add(node.data);			
		copyBST(node.right, items);
	}
	
	boolean checkBST(Node root) {
		List<Integer> items = new ArrayList<Integer>();
		
		copyBST(root, items);
		
		for(int i=1 ;i < items.size() ;i++)
			if(items.get(i) <= items.get(i - 1)) return false;
		
		return true;
	}
	int lastData=-1;
	
	boolean checkIfBST(Node node  ) {
		if(node == null ) return true;
		
		checkIfBST(node.left);
		if(lastData != -1 && lastData > node.data)
			return false;
		
		lastData = node.data;			
		checkIfBST(node.right);
		return true;
	}
	
	boolean checkMinMax(Node node) {
		return checkMinMax(node ,null ,null ); 
	}
	
	boolean checkMinMax(Node node ,Integer min ,Integer max) {
		if(node == null)
			return true;
		if( (min != null && node.data <= min ) || (max != null && node.data > max ))
			return false;
		
		if( !checkMinMax(node.left, min, node.data) || checkMinMax(node.right, node.data, max) )
			return false;
		
		return true; 
	}
	
	//sol tarafa max deger sabit gidecek ,sag tarafta ise min deger sabit gidecek
	//sol tarafta  currentNode datasi 
	boolean checkMax(Node node ,Integer min ,Integer max) {
		if(node == null )
			return true;
		
		if( max!= null &&  node.data > max) 
			return false;
		
		if( !checkMax(node.left, min , node.data ) || !checkMax(node.right, node.data ,max))
			return false;
				 
		return true;		
	}
	boolean checkMin(Node node, Integer min  ) {
		if(node == null )
			return true;
		
		if( min!= null && node.data <= min ) 
			return false;
		
		if( !checkMin(node.right, node.data ))
			return false;
					
		return true;		
	}
	
	public static void main(String[] args) {
		int[] arr = { 0 , 1 , 2, 3 ,4 ,5 ,6 ,7 };
		//int[] arr = { 10 ,25 ,20 ,30} ;
		LevelLinkedList obj = new LevelLinkedList();
		
		Node root = obj.createMinimalBSTTree(arr);
		
		//boolean result = obj.checkBST(root);
		//boolean res = obj.checkIfBST(root);
		
		//boolean res = obj.checkMax(root, null, null);
		boolean res = obj.checkMinMax(root, null, null);
		
		//int heightLeft = obj.getRecursiveHeight(root.left)  ;
		//int heightRight = obj.getRecursiveHeight(root.right) ;
		
		//int height = obj.getHeight(root) - 1;
		
		//obj.createLevelLinkedList(root);
		/*
		ArrayList<LinkedList<Node>> nodesAtLevel = new ArrayList<LinkedList<Node>>();
		
		 obj.getNodes(root, nodesAtLevel);
		 
		 nodesAtLevel.forEach(items -> {			 							
		 								items.forEach(linkedListItem -> System.out.println(linkedListItem.data));			 							
		 							});
		 							*/
		
	}

}
