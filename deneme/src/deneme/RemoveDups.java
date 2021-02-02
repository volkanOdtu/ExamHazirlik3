package deneme;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;

import deneme.SingleLinkedList.LinkedListNode;

public class RemoveDups<T>{

	LinkedListNode<T> head = null;
	LinkedListNode<T> tail= null;
	int size =0 ;
	
	private class LinkedListNode<T>{
		LinkedListNode<T> prev;
		LinkedListNode<T> next;
		T data;
		
		public LinkedListNode(T data) {
			this.data = data;
		}		
	}
	
	T peekLast() {
		if(size == 0)
			throw new RuntimeException("Empty List");
		
		return tail.data;
	}
	T peekFirst() {
		if(size == 0)
			throw new RuntimeException("Empty List");
		
		return head.data;
	}
	T removeFirst() {
		if(size == 0)
			throw new RuntimeException("Empty List");
		
		T data = head.data;
		
		if(head == tail) {
			head = null; tail = null;
		}else {
			head = head.next;
			head.prev = null;
		}
		size--;
		
		return data;
	}
	T removeLast() {
		if(size == 0)
			throw new RuntimeException("Empty List");
		
		T data = tail.data;
		
		if(head == tail) {
			head = null; tail = null;
		}
		else {
			tail = tail.prev;
			tail.next =null;
		}
		
		size--;
		
		return data;
	}
	
	boolean remove(T data) {
		boolean result =false;
		
		if(head.data == data) { removeFirst();return true; }
		if(tail.data == data) { removeLast() ;return true; }
		
		LinkedListNode<T> tempNode = head;
		
		while(tempNode != null) {
			if(tempNode.data == data) {
				(tempNode.prev).next = tempNode.next;
				(tempNode.next).prev = tempNode.prev;
				size--;
				result = true;
				break;				
			}
			tempNode = tempNode.next;
		}
		return result;
	}
	
	
	//Burda istenen verilen data nin aynisi varsa remove edilmesi degil ,node veriliyo, iteration baslamasi icin
	//BU data degil yani remove edilmek istenen ,tum duplicate value lar
	void removeDuplicates(LinkedListNode<T> node) {
		
		LinkedHashSet<T> set = new LinkedHashSet<T>();
		
		while(node!= null) {
			if(!set.contains(node.data)) {
				set.add(node.data);
			}			
			else 
			{
				(node.prev).next = node.next;
				node.next.prev = node.prev;
			}
			node = node.next;			
		}		
	}
	
	void deleteDups(LinkedListNode<T> head) {
		LinkedListNode<T> current = head;
		
		while(current != null) {
			LinkedListNode<T> runner = current;
			while( runner.next != null ) {
				if(runner.next.data == current.data )
					runner.next = runner.next.next;
				else
					runner = runner.next;
			}
			current = current.next;
		}
	}
	
	List<LinkedListNode<T>> findFromKtoLastNode(int k){
		LinkedListNode<T> current = head;
		
		List<LinkedListNode<T>> resultList = new ArrayList<RemoveDups<T>.LinkedListNode<T>>();
		int i=0;
		
		while(current != null) {
			i++;
			if( i< k) {
				current = current.next;
				continue;
			}
			resultList.add(current);
			current = current.next;
		}
		
		return resultList;
	}
	
	LinkedListNode<T> findNthToLast(LinkedListNode<T> head ,int k) {
		LinkedListNode<T> p1 = head;
		LinkedListNode<T> p2 = head;
		
		for(int i=0; i< k; i++) {
			if( p1 == null ) return null; //out of bounds
			p1 = p1.next;
		}
		//Simdi p2 den link sonuna kadar gittigimizde istedigimiz 
		while(p1 != null ) {
			p1= p1.next;
			p2= p2.next;
		}
		return p2;
	}
	
	boolean deleteNode(LinkedListNode<T> middleNode ) {
		if(middleNode ==  null  ||  middleNode.next == null) {
			return false;
		}
			
		LinkedListNode<T> next = middleNode.next;
		
		middleNode.data = next.data;
		middleNode.next = next;
		size--;
		return true;
	}
	
	void printKthToLast(LinkedListNode<T> head , int k) {
		if(head == null || k == 0)
			return ;
		//int index = printKthToLast(head.next , k) + 1;
		
		//if(index <= k) System.out.println(k + " th to the last node is " + head.data );
		System.out.println(head.data ); 
		printKthToLast(head.next, --k );
		
		//return index;
	}
	
	//T int ,string olabilir
	void addLast(T data) {
		LinkedListNode<T> newNode = new LinkedListNode<T>(data);
		if(head == null)
			head= tail = newNode;
		else {
			tail.next =  newNode;
			newNode.prev = tail;
			newNode.next = null;
			tail = newNode;
		}
	}
	void addFirst(T data) {
		LinkedListNode<T> newNode = new LinkedListNode<T>(data);
		if(head == null)
			head= tail = newNode;
		else {
			newNode.next =  head;
			head.prev = newNode;
			newNode.prev= null;
			head = newNode;
		}
	}
	LinkedListNode<T> partitionDoubleList(LinkedListNode<T> node ,int x){

		head = node;
		tail = node;
		
		while(node != null) {
			LinkedListNode<T> temp = node.next;
			if(  (int)node.data < x ) {
				node.next = head;
				head = node;
			}else {
				tail.next = node;
				tail = node;
			}
			node = temp;
		}
		tail.next = null;
		//head has changed so lets return it to user
		return head;
	}
	LinkedListNode<Integer> partition(LinkedListNode<Integer> node ,int x){
		LinkedListNode<Integer> leftSideHead= null; LinkedListNode<Integer> leftSideTail = null;
		LinkedListNode<Integer> rightSideHead = null; LinkedListNode<Integer> rightSideEnd = null;
		
		while( node != null) {
			LinkedListNode<Integer> next = node.next;
			node.next = null;
			
			if( node.data < x ) { // 3 -> 2 -> 1
				//Insert node into the end
				if( leftSideHead == null) {
					leftSideHead = node;
					leftSideTail = leftSideHead;
				}
				else {
					leftSideTail.next = node;
					leftSideTail = node;
				}
			}
			else {  //5 -> 8 -> 5 -> 10
				//insert node into end of after list
				if( rightSideHead == null ) {
					rightSideHead = node;
					rightSideEnd = rightSideHead;
				}
				else {
					rightSideEnd.next = node;
					rightSideEnd = node;
				}
			}
			node = next;
		}
		
		if( leftSideHead == null)
			return rightSideHead;
		
		//merger before list and after list
		leftSideTail.next = rightSideHead;
		
		return leftSideHead;
	}
	
	public String toString() {
		LinkedListNode<T> temp = head;
		
		StringBuilder res = new StringBuilder(); 
		
		while(temp != null) {
			res.append(temp.data);
			res.append(",");
			temp = temp.next;
		}
		return res.toString();
	}
	public String toStringFromTail() {
		LinkedListNode<T> temp = tail;
		
		StringBuilder res = new StringBuilder(); 
		
		while(temp != null) {
			res.append(temp.data);
			res.append(",");
			temp = temp.prev;
		}
		return res.toString();
	}
	
	public static void main(String[] args) {
		RemoveDups<Integer> ex =  new RemoveDups<Integer>();
		ex.addLast(3);
		ex.addLast(5);		
		ex.addLast(8);
		ex.addLast(5);
		ex.addLast(10);
		ex.addLast(2);
		ex.addLast(1);
		//ex.partition(ex.head, 5);
		ex.partitionDoubleList(ex.head, 5);
		//ex.partitionDoubleList(ex.head, 5);
		
		System.out.println(ex.toString()); 
		System.out.println(ex.toStringFromTail()); 
		
		
/*		RemoveDups<String>.LinkedListNode<String>  foundNode = ex.findNthToLast(ex.head,4);
				
		//Burda foundNode hala point ettigi icin foundNode = null set edilse bile remove olmuyor
		while(foundNode != null ) {
			if( ex.deleteNode(foundNode) == false) 
			{ break;}
			
			foundNode = foundNode.next ;
		}
		
		ex.removeLast();*/
			
		//ex.remove(4);
		//ex.removeDuplicates(ex.head);
		//ex.deleteDups(ex.head);
		//List<RemoveDups<Integer>.LinkedListNode<Integer>> result = ex.findFromKtoLastNode(3);
		
		//ex.printKthToLast(ex.head ,3);
		
		//System.out.println(  ex.toString());
		
	}

}
