package denemeExam;

import java.util.ArrayList;
import java.util.LinkedList;


public class HashTableDeneme<K,V> {
	//o key in karsisinda bi array list var
	
	private static class LinkedListNode<K,V>{
		public LinkedListNode<K,V> next;
		public LinkedListNode<K,V> prev;
		
		public K key;
		public V value;
		
		public LinkedListNode(K k ,V v) {
			key = k;
			value = v;
		}
	}	
	 private ArrayList<LinkedListNode<K, V>> arr;
	 
	 public HashTableDeneme(int capacity) {
		 arr = new ArrayList<HashTableDeneme.LinkedListNode<K,V>>();
		 for(int i=0 ; i <capacity ; i++)
			 arr.add(null);
	 }
	

	public void put(K key ,V value) {
		LinkedListNode<K,V> node = getNodeForKey(key);
		
		if(node != null) { //already there ,just update the value
			node.value = value;
			return;
		}
		
		node = new LinkedListNode< K, V>(key, value);
		
		int index = getIndexForKey(key);
		
		if(arr.get(index) != null) {
			node.next = arr.get(index);
			node.next.prev = node;
		}
		arr.set(index, node);
	}	
	
	public void remove(K key) {
		LinkedListNode<K,V> node = getNodeForKey(key);
		if(node.prev!= null)
			node.prev.next = node.next;
		else {
			int hashKey = getIndexForKey(key);
			arr.set(hashKey, node.next);
		}
		if(node.next != null)
			node.next.prev = node.prev;
	}
	
	public V get(K key) {
		LinkedListNode<K,V> node = getNodeForKey(key);
		return node == null ? null : node.value;
	}
	private LinkedListNode<K,V> getNodeForKey(K key){
		int index = getIndexForKey(key);
		LinkedListNode<K,V> current = arr.get(index);
		
		while(current != null) {
			if(current.key == key)
				return current;
			current = current.next;
		}
		return null;
	}
	//function to map a key to an index
	public int getIndexForKey(K key) {
		int hashCode = ((String)key ).length(); //  key.hashCode() ;
		int val = Math.abs(hashCode % arr.size() );
		return val;
	}
	
	public static void main(String[] args) {
		
		HashTableDeneme<String, Integer> myHash = new HashTableDeneme<String, Integer>(5);
		
		myHash.put("ali", 1);
		myHash.put("veli", 2);
		myHash.put("celil", 3);
		myHash.put("amina", 4);
		myHash.put("hikmet", 5);
		myHash.put("ttt", 6);
		myHash.put("bbb", 7);
		
		myHash.remove("ttt");
		
		myHash.get("ali");
		myHash.get("amina");
		myHash.get("ttt");
		
	}
/*	LinkedList<V>[] items;
	
	public void put(K key ,V value) {...}
	public V get(K key) {...}
	
	int hashCodeOfKey(K key) {
		return key.toString().length() % items.length;
	}*/
}

