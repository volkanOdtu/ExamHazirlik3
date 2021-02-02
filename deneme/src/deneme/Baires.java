package deneme;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

public class Baires {

	static double averagePlaneDistance(double x1, double y1, double x2, double y2, double x3, double y3) {

	    double dist1 =  Math.sqrt( (x2 - x1) *  (x2 - x1)  + (y2 -y1) *  (y2 -y1) );
	    double dist2 =  Math.sqrt( (x3 - x2) *  (x3 - x2)  + (y3 -y2) *  (y3 -y2) );
	    double dist3 =  Math.sqrt( (x3 - x1) *  (x3 - x1)  + (y3 -y1) *  (y3 -y1) );
		    
	    double res = (dist1 + dist2 + dist3) /3;
	    return res;
	}
	
	static int count(int[] numbers ,int n) {
		int count =0;
		for(int i=0 ; i <numbers.length ;i++) {
			if(n == numbers[i])
				++count;
		}
		return count;
	}
	
	static int mostPopularNumber(int[] numbers) {

		HashMap<Integer, Integer> totalCounts = new LinkedHashMap<Integer, Integer>();
		int activeCount =0, minOfMaxs =0;
		
		for(int i =0 ; i< numbers.length ;i++)
		{
			if( totalCounts.containsKey(numbers[i] )) {
				activeCount = totalCounts.get(numbers[i]);
				totalCounts.replace(numbers[i], ++activeCount);
			}else
				totalCounts.put(numbers[i], 1);
		}
		
		Optional<Map.Entry<Integer ,Integer>> maxValMap = totalCounts.entrySet().stream().max(Map.Entry.comparingByValue());
	 
		if( maxValMap.isPresent()) {
			int maxDeger =maxValMap.get().getValue();
			Optional<Map.Entry<Integer ,Integer>> minInMax =totalCounts.entrySet().stream().
															filter(a -> a.getValue() == maxDeger).sorted(Map.Entry.comparingByKey()).findFirst();
			if(minInMax.isPresent())
				minOfMaxs = minInMax.get().getValue();
		}
		return minOfMaxs;
	}
	public static void main(String[] args) {
		int[] nums = { 34, 31, 34, 77, 82};
		
		mostPopularNumber(nums);
		
		//int[] nums = { 2, 3,4,2,3,1};
		
		//int res =count(nums, 3);
		
		//averagePlaneDistance(1,1,3,4,5,6);
	}

}
