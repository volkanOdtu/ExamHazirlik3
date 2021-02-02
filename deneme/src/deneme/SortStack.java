package deneme;
import java.util.Stack;

public class SortStack {
 
	
	public static void sort2(Stack<Integer> firstStack) {
		Stack<Integer> secondStack = new Stack<Integer>();
		
		//1.stack top itemi alalim 2.stackin uygun yerine aticaz
		int peekItem2 ;
		int poppedItem1;
		boolean insertedPoppedItem = false;
		
		 
			
		//eger 2.stack bossa direk gom ,yoksa uygun yeri bulana kadar 1.stack e geri atalim itemlari
		while(!firstStack.isEmpty()) {			
			poppedItem1= firstStack.pop() ;
			insertedPoppedItem = false;
			
			
			while(insertedPoppedItem == false || !secondStack.isEmpty()) {
				//peek item ile karsilastiricaz ,eger buyukse pop edilenden ,pop edip 1.stack e push edicez 				
				if(secondStack.isEmpty()) {
					secondStack.push(poppedItem1);
					insertedPoppedItem = true;
					break;
				}
				else 
				{
					peekItem2 = secondStack.peek();
				
					if( peekItem2 < poppedItem1)
						firstStack.push(secondStack.pop());			
					else {
						secondStack.push(poppedItem1);
						insertedPoppedItem = true;
						break;
					}
						
				}
				
			}
		}
		
		firstStack = secondStack;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Stack<Integer> firstStack = new Stack<Integer>();
		firstStack.add(7);
		firstStack.add(10);
		firstStack.add(5);
		firstStack.add(6);
		firstStack.add(1);
		
		sort2(firstStack);
		
	}

}
