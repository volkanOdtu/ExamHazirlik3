package deneme;

public class MinimalTree {

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
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 0 , 1 , 2, 3 ,4 ,5 ,6 };
		MinimalTree tree = new MinimalTree();
		Node result = tree.createMinimalBSTTree(arr);
	}

}
