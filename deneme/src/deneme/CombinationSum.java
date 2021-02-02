package deneme;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CombinationSum {

	/*
	public List<List<Integer>> combinationSum2(int[] num, int target) {
		
		List<Integer> list1 = new ArrayList<Integer>();
		
		list1.sort((o1 ,o2) -> {if( o1 > o2) return 1; else return -1; });
		
		for(int combCount=1 ; combCount< num.length ; combCount++) {
			
			for(int j =0 ; j< combCount; j++) {
				while( j < combCount) { //once 
					sum=
				}
				if( num[j] + num[j+1] == target )
			}
		}
		
		List<List<Integer>> resultList = new ArrayList<List<Integer>>();
		
	} */
	public List<List<Integer>> combinationSum2(int[] num, int target) {
        Set<List<Integer>> result = new HashSet<>();
        Arrays.sort(num);
        
        for (int i = 0; i < num.length; i++) {
            List<Integer> buffer = new ArrayList<>();
            buffer.add(num[i]);
            search(result, buffer, num, target - num[i], i);
        }
        return new ArrayList<>(result);

    }
	private void search(Set<List<Integer>> result, List<Integer> buffer, int[] num, int target, int level) {
        if (target < 0) return;
        if (target == 0) {
            result.add(buffer);
            return;
        }

        for (int i = level + 1; i < num.length; i++) {
            List<Integer> copy = new ArrayList<>(buffer);
            copy.add(num[i]);
            search(result, copy, num, target - num[i], i);
        }
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		CombinationSum a = new CombinationSum();
		int[] num= {10,1,6,7,2,1,5};
		
		int target = 8;
		
		a.combinationSum2(num, target);
		
	}

}
