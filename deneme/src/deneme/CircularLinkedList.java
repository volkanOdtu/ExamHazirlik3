package deneme;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CircularLinkedList {

	LinkedListC head;
	
	class LinkedListC{
		LinkedListC next;
		String data;
		public LinkedListC(String data) {
			this.data = data;
		}
	}
	LinkedListC AddToList(String data) {
		LinkedListC newNode = new LinkedListC(data);
		
		if(head == null) {
			head = newNode;
			return head;
		}
		else {
			LinkedListC temp =head;
			while( temp.next != null) {
				temp = temp.next;
			}
			temp.next = newNode; 
		}
		return newNode;							
	}
	
	void printNodes() {
		LinkedListC tempNode = head;
		while( tempNode != null) {
			System.out.println(tempNode.data);
			tempNode = tempNode.next;
		}
	}
	boolean checkNodesRepeat(LinkedListC startNode ,List<LinkedListHashMap>  wholeNodesHashMap ) {
		LinkedListC tempNode = startNode;
		String startNodeData = startNode.data;
		 
		
		List<LinkedListHashMap>  filteredList= wholeNodesHashMap.stream().filter(a -> a.key.equals(startNodeData)).collect(Collectors.toList());
		
		for (LinkedListHashMap tempItemInFilteredList : filteredList) {
			
				while(tempNode.next.data.equals(tempItemInFilteredList.nextNode.data )) {
					tempNode = tempNode.next;
					tempItemInFilteredList.nextNode = tempItemInFilteredList.nextNode.next;
					if(tempNode.data.equals(startNodeData)) {// Demek ki zincir basa dondu
						System.out.println("Repeating start node: " +  startNodeData);
						return true;
					}
				}
				
			
		}
		 
		
		
		return false;
			
	}
	boolean isCircleExist(LinkedListC head) {
		
		LinkedListC temp = head;
		
		List<LinkedListHashMap> listWithNextItem = new ArrayList<CircularLinkedList.LinkedListHashMap>();
		
		
		boolean isCircleExist = false;
		
		while(temp!= null) {
			
			//if( listWithNextItem.contains(temp)) {
			isCircleExist= checkNodesRepeat( temp,listWithNextItem);
			if(isCircleExist) 
					return true;
			//}
			LinkedListHashMap newItem = new LinkedListHashMap();
			newItem.key = temp.data;
			newItem.nextNode = temp.next;
			listWithNextItem.add(newItem);	
			temp = temp.next;
		}
		
		
		return false;
	}
	
	class LinkedListHashMap{
		String key ;
		LinkedListC nextNode;		
	}
	
	class LinkedListNode{
		String key;
		LinkedListNode next;
	}
	
	LinkedListC FindBeginning(LinkedListC head) {
		LinkedListC slow = head;
		LinkedListC fast = head;
		
		while(fast!= null && fast.next !=null ) {
			slow = slow.next;
			fast = fast.next.next;
			if(slow.data == fast.data )
				break;
		}
		
		if(fast!= null && fast.next !=null ) return null;
		
		slow = head;
		while(slow != fast) {
			slow = slow.next;
			fast = fast.next;
		}
		return fast; // ya da slow farketmez
				
	}
	public static void main(String[] args) {
		 
		CircularLinkedList linkListCircular = new CircularLinkedList();
		
		linkListCircular.AddToList("A");
		linkListCircular.AddToList("B");
		linkListCircular.AddToList("C");
		linkListCircular.AddToList("D");
		linkListCircular.AddToList("E"); 
		linkListCircular.AddToList("C");//Aslinda burda  yeni bir node ekliyoruz ,ama circular yapmadik ,3.node u point etmeliyiz
		linkListCircular.AddToList("D");//yoksa bunlar ayri node lar oluyor
		linkListCircular.AddToList("E");
		linkListCircular.AddToList("C");
		
		/*
		linkListCircular.AddToList("A");
		linkListCircular.AddToList("B");
		linkListCircular.AddToList("C");
		linkListCircular.AddToList("D");
		linkListCircular.AddToList("K");
		linkListCircular.AddToList("C");
		linkListCircular.AddToList("M");
		linkListCircular.AddToList("D");
		linkListCircular.AddToList("K");
		linkListCircular.AddToList("C");
		linkListCircular.AddToList("M");
		linkListCircular.AddToList("D");*/
		
		linkListCircular.printNodes();
		//linkListCircular.isCircleExist(linkListCircular.head);
		LinkedListC node = linkListCircular.FindBeginning(linkListCircular.head);
		System.out.println(node.data);
		
	}
}
