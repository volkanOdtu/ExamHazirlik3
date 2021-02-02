package denemeExam;

  

public class AncestorNoParent {
	
	Node createMinimalBSTTree(int[] array) {
		return createMinimalBSTTree(array ,0 , array.length -1 );
	}
	
	Node createMinimalBSTTree(int[] array, int start ,int end) {
		if(end < start )
			return null;
		
		int mid = (start + end ) / 2;
		Node n = new Node(); n.data =array[mid];
		n.left = createMinimalBSTTree(array, start, mid -1);
		n.right = createMinimalBSTTree(array, mid + 1, end);
		
		return n;
	}
	Node getNode(Node node ,int data) {
		if(node.data ==  data) 
			return node;
		
		if( data > node.data)
			return getNode(node.right, data);
		else
			return getNode(node.left, data);
	}
	
	Node getAncestorOfNodes(Node root ,Node first ,Node  second) {
		if(root == null || root == first || root == second )
			return root;
	
		//root ve 2 node a bakiliyor ,her 2 si de root un left in de mi kontrolediyoruz ,degilse 
		//demek ki bu root un biri left de digeri right da ,o zaman root kesisme yerleri
		boolean firstNodeOnLeft =existsNodeInThisRoot(root.left, first);
		boolean secondNodeOnLeft =existsNodeInThisRoot(root.left, second);
		
		if(firstNodeOnLeft != secondNodeOnLeft) //nodes are on different sides ,so result is root
			return root;

		//Eger left de root lar yoksa ,childNode olarak root.right i root seceriz ,tekrar root lara bakariz
		Node childSideNode =firstNodeOnLeft ? root.left :root.right;
		
		return getAncestorOfNodes(childSideNode, first, second);
	}
	//Verilen root un altinda bu node var mi kontrol ediyor
	boolean existsNodeInThisRoot(Node root ,Node node) {
		if( root == null ) return false;
		if( root == node ) return true;
		
		return existsNodeInThisRoot(root.left , node) ||  existsNodeInThisRoot(root.right, node);
	}
	
	boolean containsTree(Node root1 ,Node root2 ) {
		StringBuilder tree1Str= new StringBuilder();
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
		//add root data
		strBuilder.append(node.data + " ");
		getTreeAsString(node.left, strBuilder);
		getTreeAsString(node.right, strBuilder);
		
	}
	
	boolean contains(Node root1 ,Node root2) {
		return subTree(root1 ,root2);
	}
	boolean subTree(Node root1 ,Node root2) {
		if(root1 == null)
			return false; //1st tree empty so false
		else if (root1.data == root2.data )
			return true;
		
		return subTree(root1.left, root2) || subTree(root1.right, root2) ;
	}
	
	boolean matchTree(Node root1 ,Node root2) {
		if( root1 == null && root2 == null ) //BU kabul sarti 
			return true;
		else if(root1 == null || root2 == null ) //exactly one of trees empty ,so no match
			return false;
		else if( root1.data != root2.data) // data doesnt match
			return false;
		else {
			return matchTree(root1.left, root2.left) && matchTree(root1.right, root2.right);
		}
	}
	
	public static void main(String[] args) {
		int[] arr = { 0 , 1 , 2, 3 ,4 ,5 ,6 ,7 };
		
		AncestorNoParent obj = new AncestorNoParent();
		
		Node root = obj.createMinimalBSTTree(arr);
		Node firstNode = obj.getNode(root, 4);
		Node secondNode = obj.getNode(root, 5);
		 
		Node ancestor = obj.getAncestorOfNodes(root, firstNode, secondNode);
		
		System.out.println(ancestor.data);
	}

}
