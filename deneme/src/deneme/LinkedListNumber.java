package deneme;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class LinkedListNumber {
	
	LinkedListNode head;
	
	public LinkedListNode AddNode(int nodeVal) {
		LinkedListNode node = new LinkedListNode();
		node.val = nodeVal;
		
		if(head == null) {
			head = node;
			return head;
		}
		
		LinkedListNode temp =head;
		
		while(temp.next != null) {
			temp = temp.next;
		}
		temp.next= node;
		
		return node;
	}
	
	public LinkedListNode AddReverseNode(int nodeVal) {
		LinkedListNode node = new LinkedListNode();
		node.val = nodeVal;
		
		if(head == null) {
			head = node;
			return head;
		}
		
		LinkedListNode temp =head;
		
		while(temp.prev != null) {
			temp = temp.prev;
		}
		temp.prev= node;
		
		return node;
	}
	public void printNodes() {
		LinkedListNode temp= head;
		while(temp != null) {
			System.out.println(temp.val);
			temp = temp.next;
		}
	}
	public boolean isPalindrome() {
		
		LinkedListNode slowNode= head;
		LinkedListNode fastNode= head;
		
		Stack<Integer> firstHalfNodes = new Stack<Integer>();
		
		firstHalfNodes.add(slowNode.val);
		
		while( fastNode!=null && fastNode.next!= null) {			
			slowNode = slowNode.next;
			fastNode = fastNode.next.next;
			firstHalfNodes.add(slowNode.val);
		}
		
		firstHalfNodes.pop();
		
		if(fastNode != null) 
			slowNode= slowNode.next;	
		
		//kaldigimiz yerden devam ,artik stack tekilerle karsilastirabiliriz
		while(!firstHalfNodes.isEmpty()) {
			int currStackItem = firstHalfNodes.pop() ; 
			if( slowNode.val != currStackItem ) 
				return false;
			slowNode = slowNode.next;
		}
		
		return true;
	}
	public int printNodesReverse() {
		//Stack<Integer> stackNumbers = new Stack<Integer>();
		Queue<Integer> queueNumbers = new LinkedList<Integer>();
		
		//Hepsini stack e atalim
		/*LinkedListNode temp= head;
		while(temp != null) {
			stackNumbers.add(temp.val);
			temp = temp.prev;
		}
		*/
		LinkedListNode temp= head;
		while(temp != null) {
			queueNumbers.add(temp.val);
			temp = temp.prev;
		}
		
		
				
		int digit = 1;// stackNumbers.size();
		int total = 0;
		int currentDigit = 0;
		
		while(queueNumbers.size() > 0 ) {		
			currentDigit= queueNumbers.poll(); //stackNumbers.pop();
			currentDigit = currentDigit * digit;
			total = total + currentDigit;
			digit = digit * 10;
			//System.out.println(currentDigit);
		}
		
		//System.out.println(currentDigit);
		return total;
	}
	public static void main(String[] args) {
		/*
		LinkedListNumber numberLinkedlist = new LinkedListNumber();
		
		numberLinkedlist.AddNode(7);
		numberLinkedlist.AddNode(1);
		numberLinkedlist.AddNode(6);
		
		numberLinkedlist.printNodes();
		
		LinkedListNumber numberLinkedlist2 = new LinkedListNumber();
		
		numberLinkedlist2.AddNode(5);
		numberLinkedlist2.AddNode(9);
		numberLinkedlist2.AddNode(2);
		numberLinkedlist2.printNodes();
		
		LinkedListNumber numberLinkedlist = new LinkedListNumber();
		
		numberLinkedlist.AddReverseNode(7);
		numberLinkedlist.AddReverseNode(1);
		numberLinkedlist.AddReverseNode(6);
		
		int resultNo = numberLinkedlist.printNodesReverse();
		System.out.println(resultNo);
		
		LinkedListNumber numberLinkedlist2 = new LinkedListNumber();
		
		numberLinkedlist2.AddReverseNode(5);
		numberLinkedlist2.AddReverseNode(9);
		numberLinkedlist2.AddReverseNode(2);
		
		resultNo = numberLinkedlist2.                                                                                                                                                         printNodesReverse();
		System.out.println(resultNo);
		int resultNo = numberLinkedlist.printNodesReverse();
		
		*/
		
		LinkedListNumber numberLinkedlist = new LinkedListNumber();
		
		numberLinkedlist.AddNode(0);
		numberLinkedlist.AddNode(1);
		numberLinkedlist.AddNode(2);
		numberLinkedlist.AddNode(2);		
		numberLinkedlist.AddNode(1);
		numberLinkedlist.AddNode(0);
		
		numberLinkedlist.isPalindrome();
		
	}
	
	class LinkedListNode{
		public LinkedListNode next;
		public LinkedListNode prev;
		public int val;
			
	}
}
