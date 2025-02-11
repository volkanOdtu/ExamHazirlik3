package denemeExam;

import java.util.HashMap;

public class RunningSum {

	Node root;
	 
	//int countPathsWithSum(Node root ,int target) {
	//	return countPathsWithSum(root ,target ,0 ,new HashMap<Integer, Integer>());
	//}
	int countPathsWithSum(Node node,int target ,int runningSum ,HashMap<Integer, Integer> pathCountHashMap) {

		if(node == null) 
			return 0;
		
		runningSum += node.data;
		int sum = runningSum - target;
		int totalPaths = pathCountHashMap.getOrDefault(sum, 0);
		
		//Eger runningSum equals target ,then 1 additional path starts at root
		if(runningSum == target)
			totalPaths++;
		
		//increment pathCountHashMap ,recurse ,then decrement pathCountHashMap 
		incrementHashTable(pathCountHashMap, runningSum, 1); //Increment pathCount
		totalPaths += countPathsWithSum(node.left, target ,runningSum ,pathCountHashMap);
		totalPaths += countPathsWithSum(node.right, target ,runningSum ,pathCountHashMap);
		incrementHashTable(pathCountHashMap, runningSum, -1); //Decrement pathCount
		
		return totalPaths;
	}
	void incrementHashTable(HashMap<Integer, Integer> hashMap ,int key ,int delta) {
		int newCount = hashMap.getOrDefault(key, 0) + delta;
		if( newCount == 0 )
			hashMap.remove(key);
		else
			hashMap.put(key, newCount);
	}
	Node addNode(int i ,Node node) {
		if(node == null ) {
			Node newNode = new Node(i);
			return newNode;
		}
		if(i < node.data ) {
			node.left = addNode(i ,node.left);		
		}else {
			node.right = addNode(i ,node.right);
		}
		return node ;
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
	
	int countPathsWithSum(Node root ,int target) {
		if(root == null) return 0;
		
		int pathsFromRoot = countPathsWithSumFromNode(root ,target ,0);
		int pathsLeft = countPathsWithSum(root.left ,target );
		int pathsRight = countPathsWithSum(root.left ,target );
		
		return pathsFromRoot + pathsLeft + pathsRight;
	}
	int countPathsWithSumFromNode(Node node ,int target ,int currentSum) {
		if(node == null) return 0;
		
		currentSum += node.data;
		int totalPaths = 0;
		if(currentSum == target) totalPaths++;
		
		totalPaths += countPathsWithSumFromNode(node.left, target, currentSum);
		totalPaths += countPathsWithSumFromNode(node.right, target, currentSum);
		
		return totalPaths;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RunningSum tree = new RunningSum();
		
		Node insertedNode = tree.addNodeSequentially(10, null, false);
		Node leftNode = tree.addNodeSequentially(5, insertedNode ,true);
		Node rightNode = tree.addNodeSequentially(-3, insertedNode ,false);
		tree.addNodeSequentially(11, rightNode ,false);
		
		Node leftestNode =tree.addNodeSequentially(3, leftNode ,true);
		rightNode= tree.addNodeSequentially(2, leftNode ,false);
		tree.addNodeSequentially(1, rightNode ,false);
		
		tree.addNodeSequentially(3, leftestNode ,true);
		tree.addNodeSequentially(-2, leftestNode ,false);		
		
		
		int count =tree.countPathsWithSum(insertedNode, 8);
		 
		
	}

}
