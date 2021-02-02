package deneme;

import java.util.Stack;

class NodeWithMin{
	int value;
	int min;
	public NodeWithMin(int value ,int min) {
		this.value = value;
		this.min = min;
	}
}

public class StackMin extends Stack<NodeWithMin> {	
	
	public void push(int value) {
		int min = Math.min(value, min());
		super.push(new NodeWithMin(value, min));
	}
	public NodeWithMin pop() {
		return super.pop();
	}
	public int min() {
		if(this.isEmpty())
			return Integer.MAX_VALUE;
		else {
			NodeWithMin currentTopItem = peek();
			return currentTopItem.min;
		}			
	}
	public static void main(String[] args) {

		int min =0;
		
		StackMin newStack = new StackMin();
		newStack.push(5);
		newStack.push(6);
		min = newStack.min();
		newStack.push(3);
		min = newStack.min();		
		newStack.push(7);
		min = newStack.min();
		
		NodeWithMin poppedItem = newStack.pop();
		min = newStack.min();
		
		newStack.pop();
		min = newStack.min();
		
	}

}
