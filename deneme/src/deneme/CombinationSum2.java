package deneme;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CombinationSum2 {

	public Set<List<Integer>> combinationSum2(int[] num, int target) {
		
		//list1.sort((o1 ,o2) -> {if( o1 > o2) return 1; else return -1; });
		
		Arrays.sort(num);

		Set<List<Integer>> resultList = new HashSet<List<Integer>>();
		List<Integer> sumList ;
		
		for(int i=0 ; i < num.length ; i++) {			
			
			sumList = new ArrayList<Integer>();
			findAll(resultList , sumList, num ,num[i] , i +1 ); //1,1,2,5,6,7,10
		}
		return resultList;
	}
	
	void findAll(Set<List<Integer>> res, List<Integer> sumItems ,int[] num ,int currItem,  int currIndex){
		
		int sumRest = currItem;
		sumItems.add(currItem);
		if(sumRest == 8 ) {
			res.add( sumItems); return;
		}
			 			
		if(currIndex == num.length ) return;
		
		for(int i = currIndex ; i< num.length ;i++) {
			sumRest = sumRest + num[i];
			sumItems.add(num[i]);
			
			if(sumRest > 8 ) {
				sumItems = new ArrayList<Integer>();				
				break;				
			}
				
			if(sumRest == 8 ) {
				List<Integer> copy = new ArrayList<Integer>();
				copy.addAll(sumItems);
				res.add( copy);
				sumItems = new ArrayList<Integer>();				
				break;
			}
		}
		findAll(res, sumItems, num, currItem, ++currIndex);
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CombinationSum2 ex = new CombinationSum2();
		int[] num= {10,1,6,7,2,1,5};
		
		Set<List<Integer>> resultList = new HashSet<List<Integer>>();
		List<Integer> sumlist1 = new ArrayList<Integer>();
		sumlist1.add(1);
		sumlist1.add(2);
		
		List<Integer> sumlist2 = new ArrayList<Integer>();
		sumlist2.add(1);
		sumlist2.add(2);
		
		List<Integer> sumlist3 = new ArrayList<Integer>();
		sumlist3.add(4);
		
		resultList.add(sumlist1);
		resultList.add(sumlist2);
		
		resultList.add(sumlist3);
		
		//ex.combinationSum2(num, 8);
	}

}
