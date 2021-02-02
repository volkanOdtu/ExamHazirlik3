package deneme;

public class FixedMultiStack {
	/*
	private int numberOfStacks = 3;
	private int stackCapacity ;
	private int[] values;
	private int[] sizes;
	
	public FixedMultiStack(int stackSize) {
		stackCapacity = stackSize;
		values = new int[stackSize * numberOfStacks];
		sizes =  new int[numberOfStacks];
	}
	public void push(int stackNum ,int value) throws Exception {
		if( isFull(stackNum))
			throw new Exception("Stack full");
		
		sizes[stackNum]++;
		values[indexOfTop(stackNum)] = value;
	}
	public int pop(int stackNum ) throws Exception {
		if( isEmpty(stackNum))
			throw new Exception("Stack Empty");
		
		int topIndex = indexOfTop(stackNum);
		int value = values[topIndex];
		
		values[topIndex] = 0;		
		sizes[stackNum]--;//Shrink
		return value;
	}
	public int peek(int stackNum) throws Exception {
		if( isEmpty(stackNum))
			throw new Exception("Stack Empty");
		return values[indexOfTop(stackNum)];
	}
	public boolean isEmpty(int stackNum) {
		return sizes[stackNum] == 0;
	}
	public boolean isFull(int stackNum) {
		return sizes[stackNum] == stackCapacity;
	}
	private int indexOfTop(int stackNum) {
		int offset = stackNum * stackCapacity;
		int size = sizes[stackNum];
		return offset + size -1;
	} */
	private int stackCapacity;
	private int[] stacksSize;// array de kac item var su an
	private int[] values;// array de kac item var su an
	
	public FixedMultiStack(int stackCapacity) {
		// TODO Auto-generated constructor stub
		this.stackCapacity = stackCapacity;
		stacksSize = new int[3];
		values = new int[3 * stackCapacity];
	}
	
	private boolean isFull(int stackNo) throws Exception {		
		return stacksSize[stackNo] == stackCapacity;
	}
	
	public void push(int stackNo ,int value) throws Exception {
		if(isFull(stackNo)) {
			throw new Exception();
		}
		
		int offSet = stacksSize[stackNo];
		int topIndexInTheCurrStack = stackNo * stackCapacity + offSet ;
		values[topIndexInTheCurrStack] = value;
		stacksSize[stackNo]++;		
	}
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		FixedMultiStack myStack = new FixedMultiStack(5);
		myStack.push(0, 1);
		myStack.push(1, 6);
		myStack.push(2, 11);
		myStack.push(0, 2);
		myStack.push(1, 7);
		myStack.push(2, 12);
		
	}

}
