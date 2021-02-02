package denemeExam2;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;


class Node{
	int data;
	Node left ,right ,parent;
	public Node(int data) {
		this.data = data;
	}
	
}

public class MinimalBinaryTree {

	Node createMinimalBSTTree(int[] array ,int start ,int end) {
		 
		//Arrays.sort(array);
		//List<Integer> arr = Arrays.stream(array).boxed().collect(Collectors.toList());
		if(end < start) 
			return null;
		
		int mid = (start + end) / 2;
		
		Node root = new Node(array[mid]);
		root.left = createMinimalBSTTree(array, start, mid -1 );
		root.right = createMinimalBSTTree(array, mid+1, end);
		
		return root;
	}
	ArrayList<LinkedList<Node>> getNodes(Node root , ArrayList<LinkedList<Node>> nodesAtLevel ){
		
		getNodesByLevel(root, nodesAtLevel ,0);
		return nodesAtLevel;
		
	}
	void getNodesByLevel(Node node, ArrayList<LinkedList<Node>> nodesAtLevel ,int level){
		
		if(node == null)
			return;
		
		if(nodesAtLevel.size() == level) //ilk bu level a giriyorsak new lemeliyiz
			nodesAtLevel.add(new LinkedList<Node>());
		
		nodesAtLevel.get(level).add(node);
		
		getNodesByLevel(node.left, nodesAtLevel ,level + 1);
		getNodesByLevel(node.right , nodesAtLevel ,level + 1);
		
	}
	
	int getRecursiveHeight(Node node) {		
		if(node == null)
			return -1;
		
		return 1 + Math.max(getRecursiveHeight(node.left) ,getRecursiveHeight(node.right))  ;		
	}
	boolean isBalanced(Node root) {
		if(root == null) return true;
		
		int diff= getRecursiveHeight(root.left) - getRecursiveHeight(root.right);
		if( Math.abs(diff) > 1)
			return false;
		else
			return isBalanced(root.left) && isBalanced(root.right);
	}
	
	void copyTreeItemsToCollection(Node node ,List<Node> allItemsInTree){
		if(node == null) return ;
		copyTreeItemsToCollection(node.left, allItemsInTree);
		allItemsInTree.add(node);
		copyTreeItemsToCollection(node.right, allItemsInTree);
		
	}
	//En soldan itibaren Arraylist e tum node lari atiyoruz ve eger tum node lar sirali ise true doneriz 
	boolean checkBinarySearchTree(Node root) {
		List<Node> allItemsInTree = new ArrayList<Node>();
		copyTreeItemsToCollection(root, allItemsInTree);
		
		for(int i=0 ; i < allItemsInTree.size() ;i++)
			if(allItemsInTree.get(i).data < allItemsInTree.get(i -1).data) return false;
		
		return true;
	}
	
	int lastData = -1;
	//BU implementation da yine global bi degisken tutmaliyiz ,yoksa false bile alsak islemler devam ediyor
	boolean checkIfBST(Node node) {
		if(node == null) return true;
		
		checkIfBST(node.left);
		
		if(lastData!= -1 && lastData > node.data)
			return false;
		
		lastData = node.data;
		checkIfBST(node.right);
		return true;
	}
	Node addNodeSequentially(int i ,Node node ,boolean putLeft ) 
	{		
		Node newNode = new Node(i);

		if(node == null) return newNode;
		
		if(putLeft)
			node.left = newNode;		
		else
			node.right = newNode;
		
		return newNode;
	} 
	
	Node leftMostChild(Node node) {
		if(node == null)
			return null;
		
		while(node.left != null)
			node = node.left;
		
		return node;
	}

	Node inOrderSuccessor(Node node) {
		if( node == null ) return null;
		
		if(node.right != null )
			return leftMostChild(node.right);
		else {
			Node currentNode =node;
			Node parentNode = currentNode.parent;
			
			while( parentNode!= null && parentNode.left != currentNode ) {
				currentNode = parentNode;
				parentNode= parentNode.parent;
			}
			return parentNode;
		}
	}
	
	Node getAncestorOfNodes(Node root ,Node first ,Node second) {
		if(root == null || first == root || second == root)
			return root;
		
		boolean firstNodeExistInLeft =  existsnodeInThisRoot(root.left, first);
		boolean secondNodeExistInLeft =  existsnodeInThisRoot(root.left, second);
		
		boolean searchLeft = false;
		if( firstNodeExistInLeft != secondNodeExistInLeft) //demek ki henuz common roota  gelmedik
			return root;
		
		if(firstNodeExistInLeft ==true) //demek ki left den devam edicez bu node lari aramaya
			return getAncestorOfNodes(root.left, first, second);
		else
			return getAncestorOfNodes(root.right , first, second);
		
	}
	boolean existsnodeInThisRoot(Node root ,Node node) {
		if(root == null ) return false;
		if(root== node) return true;
		
		return existsnodeInThisRoot(root.left, node) || existsnodeInThisRoot(root.right, node); 
	}
	//Tum tree yi bir String e atip var mi/yok mu kontrolu yaptik
	boolean containsTree(Node root1 ,Node root2) {
		StringBuilder tree1Str = new StringBuilder();
		StringBuilder tree2Str = new StringBuilder();
		
		getTreeAsString(root1, tree1Str);
		getTreeAsString(root2, tree2Str);
		
		return tree1Str.indexOf(tree2Str.toString()) != -1;
	}
	void getTreeAsString(Node node ,StringBuilder strBuilder) {
		if(node == null) {
			strBuilder.append("X");
			return;
		}
		strBuilder.append(node.data );
		getTreeAsString(node.left, strBuilder);
		getTreeAsString(node.right , strBuilder);
		
	}
	
	boolean contains(Node node1 ,Node node2) {
		return subTree(node1 ,node2);
	}
	boolean subTree(Node root1 ,Node root2) {
		if(root1 == null) return false;

		//deeper check ,diger tum node lar left ve right lari kontrol edilmeli
		if(root1.data == root2.data && matchTree(root1, root2) )
			return true;
		else 
			return subTree(root1.left, root2) || subTree(root1.right, root2);
	}
	
	boolean matchTree(Node node1 ,Node node2) {
		if(node1 == null && node2 == null)
			return true;
		else if (node1== null || node2 ==  null)
			return false;
		else if(node1.data!= node2.data)
			return false;
		else
			return matchTree(node1.left, node2.left) && matchTree(node1.right, node2.right);
	}
	
	int countPathsWithSum(Node root ,int target) {
		
		return countPathsWithSumFromNode(root, target, 0);
		
	}
	int countPathsWithSumFromNode(Node node ,int target ,int currentSum) {
		
		if(node == null ) 
			return 0;
		
		currentSum+= node.data;
		int totalPaths = 0;
		
		if(currentSum == target) 
			totalPaths++;
		
		totalPaths += countPathsWithSumFromNode(node.left, target, currentSum);
		totalPaths += countPathsWithSumFromNode(node.right, target, currentSum);
		
		return totalPaths;
	}
	public static void main(String[] args) {
		int[] arr = { 0 ,5, 6 ,4,1,3,2 };
		
		MinimalBinaryTree tree = new MinimalBinaryTree();
		
		//Arrays.sort(arr);
		//Node root = tree.createMinimalBSTTree(arr ,0 ,arr.length -1);
		
		Node insertedNode = tree.addNodeSequentially(10, null, false);
		Node leftNode = tree.addNodeSequentially(5, insertedNode ,true);
		Node rightNode = tree.addNodeSequentially(-3, insertedNode ,false);
		tree.addNodeSequentially(11, rightNode ,false);
		
		Node leftestNode =tree.addNodeSequentially(3, leftNode ,true);
		rightNode= tree.addNodeSequentially(2, leftNode ,false);
		tree.addNodeSequentially(1, rightNode ,false);
		
		tree.addNodeSequentially(3, leftestNode ,true);
		tree.addNodeSequentially(-2, leftestNode ,false);	

		
		
		/*ArrayList<LinkedList<Node>> nodesAtLevel = new ArrayList<LinkedList<Node>>();
		
		tree.getNodes(root ,nodesAtLevel);
		
		nodesAtLevel.forEach(items -> {	
            items.forEach(linkedListItem -> System.out.println(linkedListItem.data));	
				}); */
		boolean result =tree.checkIfBST(insertedNode);
		System.out.println(result);
		
	}

}
