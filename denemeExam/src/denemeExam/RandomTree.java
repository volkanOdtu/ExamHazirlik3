package denemeExam;

import java.util.Random;

public class RandomTree {
	int data,size;
	RandomTree leftTree ,rightTree;
	
	public int size() {
		return size;
	}
	public int data() {
		return data;
	}
	public RandomTree getRandomNode() {
		int leftSize= leftTree == null ? 0: leftTree.size();
		Random random = new Random();
		int index = random.nextInt(size());
		
		if(index < leftSize)
			return leftTree.getRandomNode();
		else if( index == leftSize)
			return this;
		else
			return rightTree.getRandomNode();
	}
	public RandomTree getIthNode(int i) {
		int leftSize = leftTree.size;
		
		if(i < leftSize)
			return leftTree.getIthNode(i);
		else if (i == leftSize )
			return this;
		else
			return rightTree.getIthNode(i - (leftSize + 1));
		
	}
	public void insertInOrder(int d) {
		if( d <= data) {
			if(leftTree == null)
				leftTree = new RandomTree();
			else
				leftTree.insertInOrder(d);			
		}else {
			if(rightTree ==null)
				rightTree = new RandomTree();
			else
				rightTree.insertInOrder(d);
		}
		size++;
	}
	public RandomTree find(int d) {
		if(d == data)
			return this;
		else if(d <= data) {
			return leftTree != null ? leftTree.find(d) :null;}
		else if( d > data)
			return rightTree != null ? rightTree.find(d) :null;

		return null;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
