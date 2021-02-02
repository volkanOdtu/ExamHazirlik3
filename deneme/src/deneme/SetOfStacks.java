package deneme;

import java.util.ArrayList;
import java.util.EmptyStackException;
 
//Stack item lari node gibi b data structure ile tutulacak
//her node prev ,next gibi bi yapiyla kurulacak ,top ve bottom node lar olucak ,double linked list gibi
class Stack{
	int capacity ;
	Node top ,bottom;
	int size =0 ;
	
	public Stack(int capacity) {
		this.capacity = capacity;
	}
	public boolean isFull() {
		return capacity == size;
	}
	public boolean isEmpty() {
		return size == 0;
	}
	public int removeBottom() {
		Node b = bottom;
		bottom = bottom.above;
		if( bottom!= null )
			bottom.below = null;
		size--;
		return b.value;
	}
	public boolean push(int v) {
		if(size >= capacity ) 
			return false;
		
		size++;
		Node node = new Node(v);
		
		//yeni item her zaman top olucak 
		if( size == 1) {
			bottom = node;
			top = node;
			return true;
		}
		
		top.above = node;
		node.below = top;		
		top = node;
		
		return true;
	}
	//Ustten cikicak 
	public int pop() {
		Node t = top;
		top = top.below;
		size--;
		return t.value;
	}
}

class Node{
	int value;
	public Node(int value) {
		this.value = value;
	}
	Node above;
	Node below;	
}

public class SetOfStacks {

	ArrayList<Stack> stacks = new ArrayList<Stack>();
	public int capacity;
	
	public SetOfStacks(int capacity) {
		this.capacity = capacity;
	}
	public Stack getLastStack() {
		if( stacks.size()==0 ) return null;
		return stacks.get(stacks.size() -1 );
	}
	//En son stack bulunup ona ekliyoruz, eger ki tum stack ler doluysa yeni bi stak olusturuyoruz ve stack lere ekliyoruz
	public void push(int v) {
		Stack last = getLastStack();
				
		if(last != null && !last.isFull()) { //add to last Stack
			last.push(v);
		}else {
			Stack stack = new Stack(capacity);
			stack.push(v);
			stacks.add(stack);
		}			
	}
	//Eger son item cikinca stack bossa stacks arrayList inden  remove ederiz
	public int pop() {
		Stack lastStack= getLastStack();
		
		if(lastStack == null)
			throw new EmptyStackException();
		
		int v = lastStack.pop();
		if(lastStack.size == 0)
			stacks.remove(stacks.size() - 1);
		
		return v;
				
	}
	//Belli bi index deki stack den cikaricaz itemi ,sirayla bi ust stack deki item in bottom itemi ,cikarilan stack e eklenmeli
	public int popAt(int index) {
		//By default stack ten item lar hep ustten cikarilir ,ama en sondaki stack den cikarmazsak item lari ,diger stack teki
		//item larin bottom elemanlarini push ederiz bi onceki stack e ,sadece 1 item bottom dan sileriz
		return popFromTheStack(index ,true);
	}
	//Belirlenen index deki Stack ten item i ya top tan ,ya da bottom dan cikariyoruz
	//Mevcut stack in top indan bi item cikardiktan sonra 
	//bir onceki stack in  Bottom indan cikaridigimiz itemi ,mevcut stack e atiyoruz ve bi onceki stackde kendinden onceki stack in
	//bottom indaki item i kendine insert ediyor(top ina)
	public int popFromTheStack(int stackIndex ,boolean removeTop) {
		Stack stack = stacks.get(stackIndex);
		int removedItem;
		
		if(removeTop)
			removedItem = stack.pop();
		else
			removedItem = stack.removeBottom();
		
		//Once en son stackin bottomin daki (mesela 3.stack) item i bi sonrakine(2.ye) atiyoruz ,ardindan 2.stack in bottom indakine 
		//1.stack e ,boylece bitiyo recursive olarak
		if(stack.isEmpty()) // stack te hic item kalmadi ucuruyoruz arrayList den
			stacks.remove(stackIndex);
		else if( stacks.size() > stackIndex + 1 ) { //BURASI COK ONEMLI!!!! 
			int v = popFromTheStack(stackIndex + 1, false);
			stack.push(v);
		}
		return removedItem;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SetOfStacks stacksList = new SetOfStacks(5);
		//1.stack
		stacksList.push(1);
		stacksList.push(2);
		stacksList.push(3);
		stacksList.push(4);
		stacksList.push(5);
		//2.stack
		stacksList.push(6);
		stacksList.push(7);
		stacksList.push(8);
		stacksList.push(9);
		stacksList.push(10);
		
		//3.stack
		stacksList.push(11);
		stacksList.push(12);
		stacksList.push(13);
		stacksList.push(14);
		stacksList.push(15);
		

		//4.stack
		stacksList.push(16);
		stacksList.push(17);
		stacksList.push(18);
		stacksList.push(19);
		stacksList.push(20);
		
		int removedItem;
		
		removedItem = stacksList.pop(); System.out.println("popped out:" + removedItem);
		removedItem = stacksList.pop(); System.out.println("popped out:" + removedItem);
		removedItem = stacksList.pop(); System.out.println("popped out:" + removedItem);
		removedItem = stacksList.pop(); System.out.println("popped out:" + removedItem);
		removedItem = stacksList.pop(); System.out.println("popped out:" + removedItem);
		
		removedItem = stacksList.pop(); System.out.println("popped out:" + removedItem); 
		
		removedItem = stacksList.popAt(1); System.out.println("popped out:" + removedItem);
		removedItem = stacksList.popAt(1); System.out.println("popped out:" + removedItem);
		
	}

}
