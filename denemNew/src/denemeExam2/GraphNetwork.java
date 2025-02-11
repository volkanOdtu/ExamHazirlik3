package denemeExam2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.TreeSet;

class Graph{
	int v;
	LinkedList<Integer> adj[];
	
	public Graph(int v) {
		this.v = v;
		this.adj = new LinkedList[v];
		for(int i =0; i< v; i++)
			adj[i]= new LinkedList<Integer>();
	}
	
	void addEdge(int v ,int w) {
		adj[v].add(w);
		adj[w].add(v);		
	}
	
	void DepthFirstSearch(int vertexNoStarting) {
		
		boolean[] visitedArr = new boolean[v];
		System.out.println("Depth First traversel starting from vertex:" + vertexNoStarting);
		DFSUtil(vertexNoStarting, visitedArr);
	}
	
	void DFSUtil(int vertexNo ,boolean[] visitedArr) {
		visitedArr[vertexNo] = true;
		System.out.println("vertex no:" + vertexNo);
		 
		Iterator<Integer> iterator = adj[vertexNo].listIterator();
		
		while (iterator.hasNext()) {
			int adjVertexNo = iterator.next();
			if( !visitedArr[adjVertexNo])
				DFSUtil(adjVertexNo, visitedArr); 
		}			
	}
	
	void BreadthFirstSearch(int vertexNoStarting) {
		boolean[] visitedArr = new boolean[v];
		System.out.println("Breadth First traversel starting from vertex:" + vertexNoStarting);		
		BFSUtil( vertexNoStarting , visitedArr);
	}
	
	void BFSUtil(int vertexNo , boolean[] visitedArr) {
		Queue<Integer> queueNodes = new LinkedList<Integer>();
		
		visitedArr[vertexNo] = true;System.out.println("vertex no:" + vertexNo);
		
		queueNodes.add(vertexNo);
		
		while(!queueNodes.isEmpty()) {
			int currVertexNo = queueNodes.poll();			
			
			for(int i=0 ; i< adj[currVertexNo].size() ; i++) {
				int adjVertexNo = adj[currVertexNo].get(i);
						
				if(!visitedArr[adjVertexNo]) {					
					visitedArr[adjVertexNo] = true;
					System.out.println("vertex no:" + adjVertexNo);
					queueNodes.add(adjVertexNo);
				}
			}
			
		}
	}
	 
	void BFSOneStep(Queue<Integer> queue , boolean[] visitedArr ,int[] parentArr ) {
		
			int currVertexNo = queue.poll();			
			 
			if(!visitedArr[currVertexNo]) {
				System.out.println("vertex no:" + currVertexNo); visitedArr[currVertexNo] = true; parentArr[currVertexNo]= currVertexNo;
			}
			
			for(int i=0 ; i< adj[currVertexNo].size() ; i++) {
				int adjVertexNo = adj[currVertexNo].get(i);
						
				if(!visitedArr[adjVertexNo]) {					
					visitedArr[adjVertexNo] = true;  parentArr[adjVertexNo] =currVertexNo;
					System.out.println("vertex no:" + adjVertexNo);
					queue.add(adjVertexNo);
				}
			}		
	}
	public int isIntersecting(boolean[] sourceVisitedNodes ,boolean[] destVisitedNodes) {
		int intersectionNode = -1;
		 
		for(int i =0 ; i< v ; i++) {
			if(sourceVisitedNodes[i] && destVisitedNodes[i])
				return i;
		}
		return -1;
	}
	
	void printPath(int[] sourceParents ,int[] destParents ,int sourceVertex ,int destVertex ,int intersectNode) {
		int intersectIndex = intersectNode;
		ArrayList<Integer> path = new ArrayList<Integer>();		
		
		while(intersectIndex != sourceVertex) {
			path.add(sourceParents[intersectIndex]);
			intersectIndex = sourceParents[intersectIndex];
		}
		
		path.sort((o1 ,o2) -> o1 - o2 );
		path.add(intersectNode);
		intersectIndex = intersectNode;
		
		while(intersectIndex != destVertex) {
			path.add(destParents[intersectIndex]);
			intersectIndex = destParents[intersectIndex];
		}
		
		for (Integer pathNo : path) {
			System.out.println(pathNo);
		}
		
	}
	public int biDirectionalSearch(int sourceVertex ,int destVertex) {
		 
		boolean[] sourceVisiteds = new boolean[v];
		boolean[] destVisiteds = new boolean[v];
		
		int[] sourceParents = new int[v];
		int[] destParents = new int[v];
		
		
		Queue<Integer> sourceQueue = new LinkedList<Integer>();
		Queue<Integer> destQueue = new LinkedList<Integer>();
		
		sourceQueue.add(sourceVertex);
		sourceVisiteds[sourceVertex] = true;
		sourceParents[sourceVertex] = -1;
		
		destQueue.add(destVertex);
		destVisiteds[destVertex] = true;
		destParents[destVertex] = -1;
		
		int intersectNode = -1;
		//sourceQueue ve destQueue her defasinda 1 er adim ilerliyor ve adjacent node lar queue ye atiliyor
		while(!sourceQueue.isEmpty() && !destQueue.isEmpty()) {
			//1 er 1 er visited edilen node lar true ya cekiliyo 
			//parent lar ise hangi node dan gidildiyse o set ediliyor
			BFSOneStep(sourceQueue, sourceVisiteds , sourceParents ); 
			BFSOneStep(destQueue, destVisiteds , destParents ); 
			//tum node larin visited olanlarinin true olarak bulundugu 2 array , ayni index dekiler
			//visited ise intersect edilmiS demektir
			intersectNode = isIntersecting(sourceVisiteds, destVisiteds);
			if(intersectNode != -1) {
				System.out.println("Intersecting node:" + intersectNode);
				printPath(sourceParents, destParents, sourceVertex, destVertex, intersectNode);
				break;
			}
		}
		return -1;
	}
	
}
public class GraphNetwork {

	public static void main(String[] args) {
		Graph g = new Graph(15); //Toplamda 15 vertex var
		
		g.addEdge(0, 4);
	    g.addEdge(1, 4);
	    g.addEdge(2, 5);
	    g.addEdge(3, 5);
	    g.addEdge(4, 6);
	    g.addEdge(5, 6);
	    g.addEdge(6, 7);
	    g.addEdge(7, 8);
	    g.addEdge(8, 9);
	    g.addEdge(8, 10);
	    g.addEdge(9, 11);
	    g.addEdge(9, 12);
	    g.addEdge(10, 13);
	    g.addEdge(10, 14);
		
		//g.DepthFirstSearch(0);
		//g.BreadthFirstSearch(0);
		
		//Queue<Integer> q = new LinkedList<m Integer>();
		//boolean[] visitedArr = new boolean[15];
		//q.add(6);
		
	    //g.BFSOneStep(q, visitedArr);
	    //g.BFSOneStep(q, visitedArr);
	    //g.BFSOneStep(q, visitedArr);
	    //g.BFSOneStep(q, visitedArr);
	    g.biDirectionalSearch(0, 14);
	    
	}

}
