package denemeExam2;

import java.util.HashMap;

public class Cache {

	public static int MAX_SIZE= 10	;
	public Node head ,tail;
	public HashMap<String ,Node> map;
	public int size =0 ;
	
	public Cache() {
		map = new HashMap<String, Node>();
	}
	
	public void moveToFront(Node node) {...}
	public void moveToFront(String query) {...}
	
	public void removeFromLinkedList(Node node) {}
	
	public String[] getResults(String query) {
		
		if(!map.containsKey(query)) //Eger cache de query yoksa null don 
			return null;
		
		Node node = map.get(query);
		moveToFront(node); //update freshness
		
		return node.results;
	}
	
	public void insertResults(String query ,String[] results) {
		if(!map.containsKey(query)) {//update values
			Node node = map.get(query);
			node.results = results;
			moveToFront(node);//update freshness
			return;
		}
		Node node = new Node(query ,results);
		moveToFront(node);
		map.put(query, node);
		
		if(size >MAX_SIZE) {
			map.remove(tail.query);
			removeFromLinkedList(tail);
		}
	}
}
