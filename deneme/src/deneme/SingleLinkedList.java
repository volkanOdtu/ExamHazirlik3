package deneme;

public class SingleLinkedList<T> {
	LinkedListNode<T> head = null;
	
	class LinkedListNode<T>{
		LinkedListNode<T> next;
		T data;
		
		LinkedListNode(T data){
			this.data = data;
		}
	}
	
	public void addLast(T data) {
		LinkedListNode<T> node = new LinkedListNode<T>(data);
		
		if(head == null ) {
			head = node; return; 
		}
		else{
			LinkedListNode<T> currNode = head;
			while( currNode.next != null) {
				currNode = currNode.next;
			}
			currNode.next = node;
		}
			
	}
	
	
	
	public void printAllNodes() {
		LinkedListNode<T> currNode = head;
		while( currNode != null) {
			System.out.println(currNode.data);
			currNode = currNode.next;
		}
		
	}
	public static void main(String[] args) {
		SingleLinkedList<Integer> list = new SingleLinkedList<Integer>();
		list.addLast(1);
		list.addLast(2);
		list.addLast(3);
		list.addLast(4);
		
		list.printAllNodes();
	}
}
