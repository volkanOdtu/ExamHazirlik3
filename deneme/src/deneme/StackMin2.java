package deneme;

import java.util.Stack;

public class StackMin2 extends Stack<Integer> {
	Stack<Integer> s2;
	
	public StackMin2() {
		s2 = new Stack<Integer>();
	}
	
	public void push(int value) {
		if( value <= min())
			s2.push(value);
		
		super.push(value);
	}
	public Integer pop() {
		int value = super.pop();
		if( value == min())
			s2.pop();
		
		return value;
	}
	public int min() {
		if(s2.isEmpty())
			return Integer.MAX_VALUE;
		else {
			Integer currentTopItem = s2.peek();
			return currentTopItem;
		}			
	}
	public static void main(String[] args) {
		StackMin2 newStack = new StackMin2();
		newStack.push(5);
		newStack.push(6);
		
		newStack.push(3);
				
		newStack.push(7);
		
		
		newStack.pop();		
		
		newStack.pop();
	}

}
