package deneme;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Booking {

	
	public static List<Integer> meanderingArray(List<Integer> unsorted) {
	    // Write your code here
		
		unsorted.sort((o1 ,o2) -> { if( o1 < o2) return 1; else return -1; });

		List<Integer> largest = new ArrayList<Integer>();
		List<Integer> smallest = new ArrayList<Integer>();
		 
		 
		
		List<Integer> finalList = new ArrayList<Integer>();
		int largestNo ,smallestNo;
		int unsortedSize = unsorted.size();
		int i=0;
		
		while(unsortedSize >0 )
		{
			if( (i%2) == 0)
			{
				largestNo = unsorted.get(0);
				finalList.add(largestNo);
				unsorted.remove((Object)largestNo);
			}else
			{
				smallestNo = unsorted.get(unsortedSize -1);
				finalList.add(smallestNo);
				unsorted.remove((Object)smallestNo);				
			}
			unsortedSize--;	
			i++;
		}
			
		return finalList;
	}
	
	 public static int minSum(List<Integer> num, int k) {
		   
		 int temp;
		 int i =0;
		 
		 for(int j=0 ; j< k ; j++) {
			 
			 if(j % num.size() == 0) {
				 //num.sort((o1 ,o2) -> { if( o1 < o2) return 1; else return -1; });
				 num.sort(Collections.reverseOrder());
				 i =0;
			 }
				 
			 temp = num.get(i);
			 temp = (int) Math.ceil((double)temp / 2);
			
			 num.remove(i);
			 num.add(i, temp); 
			 i++; 
		 }
		 
		 int result= num.stream().reduce(0 ,(a,b) -> a+ b);

		 return result;
	 }
	 
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		
		
		Booking a = new Booking();
		
		List<Integer> b = new ArrayList<Integer>();
		b.add(10);
		b.add(20);
		b.add(7);
		
		b.add(2);
		b.add(3);
		
		a.minSum(b, 1);
		//a.minSum(b, 4);
		
		/*List<Integer> b = new ArrayList<Integer>();
		b.add(-1);
		b.add(1);
		b.add(2);
		b.add(3);
		b.add(-5);
		
		a.meanderingArray(b); */
		
		
	}

}
