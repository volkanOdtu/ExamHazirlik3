package deneme;

import java.util.Stack;

public class MyQueue<T> {

	Stack<T> stackNewest ,stackOldest;
	public MyQueue() {
		stackNewest = new Stack<T>();
		stackOldest  = new Stack<T>();		
	}
	public int size() {
		return stackNewest.size() + stackOldest.size();
	}
	public void add(T value) {
		stackNewest.push(value);
	}
	private void shiftStacks() {
		if(stackOldest.isEmpty()) {
			while(! stackNewest.isEmpty()) {
				stackOldest.push(stackNewest.pop());
			}
		}
	}
	public T peek() {
		shiftStacks();//Ensure stackOldest has the current elements
		return stackOldest.peek();
	}
	public T remove() {
		shiftStacks();//Ensure stackOldest has the current elements
		return stackOldest.pop();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyQueue<Integer> myQueue = new MyQueue<Integer>();
		myQueue.add(1);
		myQueue.add(2);
		myQueue.add(3);
		myQueue.add(4);
		int popped = myQueue.remove();System.out.println("popped:" + popped);
		popped = myQueue.remove(); System.out.println("popped:" + popped);
		myQueue.add(5);
		myQueue.add(6);
		popped = myQueue.remove(); System.out.println("popped:" + popped);
		
		
	}

}
