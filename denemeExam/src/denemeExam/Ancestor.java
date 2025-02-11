package denemeExam;



class Node{
	int data;
	Node parent ,left ,right;
	int size =0;
	public Node() {}
	public Node(int data) {
		this.data = data;
	}
}


public class Ancestor {

	int depth(Node node) {
		int depth =0 ;
		while(node != null) {
			node = node.parent;
			depth++;
		}
		return depth;
	}
	
	Node findNodeAtTheLevel(Node node ,int depth) {
		while(depth!=0 ) {
			node = node.parent;
			depth--;
		}
		return node;
	}
	
	Node CommonAncestor(Node firstNode ,Node secondNode) {
		int difference = depth(firstNode) - depth(secondNode);
		Node maxNode ,minNode;
		
		if(difference > 0) { maxNode = firstNode;minNode= secondNode ; }
		else {minNode = firstNode;maxNode= secondNode ; }
		
		maxNode= findNodeAtTheLevel(maxNode,difference );
		
		//Simdi esit mesafedeler ,kesistikleri yer common ancestor dir, kesizmezlerse null doneriz
		while(maxNode!= minNode && maxNode != null && minNode!= null ) {
			maxNode = maxNode.parent;
			minNode = minNode.parent;
		}
		if( maxNode == null || minNode == null) return null;
		
		return maxNode;// ya da minNode
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
