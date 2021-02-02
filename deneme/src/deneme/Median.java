package deneme;

import java.util.TreeSet;

public class Median {

	static double[] runningMedian(int[] a) {
		double[] newArr = new double[a.length];
		
		TreeSet<Double> sortedSetItems = new TreeSet<Double>();
		
		for( int i =0; i < newArr.length ; i++) {
			sortedSetItems.add(Double.valueOf(a[i]));
		}
		
		return null;
	}
	
	static double findMedian(TreeSet<Double> treeSet) {
		int medianIndex;
		return 0;
		//if(treeSet.size()==1) 
		//	return treeSet. ;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] a= new int[6];
		
		a[0] = 12;
		a[1] = 4;
		a[2] = 3;
		a[3] = 5;
		a[4] = 8;
		a[5] = 7;
		
		double[] result = runningMedian(a);
		
	}

}
