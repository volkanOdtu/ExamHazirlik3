package denemeExam;

import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class Priority {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Queue<Integer> maxQueue = new PriorityQueue<Integer>(Collections.reverseOrder());
		
		maxQueue.add(1);
		maxQueue.add(3);
		maxQueue.add(2);
		
		while(!maxQueue.isEmpty()) {
			System.out.println(maxQueue.remove());
		}
		
		
	}

}
