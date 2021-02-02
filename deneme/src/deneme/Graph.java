package deneme;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Graph {

	//LinkedList array i harika, cunku bir kosenin kac kenari olacagini bilmiyoruz 
	//LinkedList<Integer> adj[]; 
	HashMap<Integer, LinkedHashSet<Integer>> allVertexesWithNeighbours = new LinkedHashMap<Integer, LinkedHashSet<Integer>>();
	
	public void addEdge(int v ,int w) {
		if( allVertexesWithNeighbours.containsKey(v))
			allVertexesWithNeighbours.get(v).add(w);
		else {
			LinkedHashSet<Integer> neigbours = new LinkedHashSet<Integer>();
			neigbours.add(w);
			allVertexesWithNeighbours.put(v ,neigbours );			
		}
			
			
	}
	//Directed graph var bu ornekte ,yani her neighbour traverse edilmiyo 
	//Onun icin visit edilmisleri bi LinkedList e atabiliriz
	public void depthFirstSearch(int vertexNo ,List<Integer> visitedNodes) {
		if(! visitedNodes.contains(vertexNo)) {
			visitedNodes.add(vertexNo);
			System.out.println("visiting node: " + vertexNo);			
		}
		else 
			return;
			
		Set<Integer> neighbours = allVertexesWithNeighbours.get(vertexNo);
		
		if( neighbours != null) {		
			for(Integer neighbourNode: neighbours){
				if(! visitedNodes.contains(neighbourNode)) {
					depthFirstSearch(neighbourNode, visitedNodes);
				}			
			}			
		}
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Graph g= new Graph();
		/*
		g.addEdge( 0 ,1);
		g.addEdge( 0 ,2);
		g.addEdge( 1 ,2);
		g.addEdge( 2 ,0);
		g.addEdge( 2 ,3); */
		
		g.addEdge( 4 ,2);
		g.addEdge( 4 ,5);
		g.addEdge( 2 ,1);
		g.addEdge( 2 ,3);
		g.addEdge( 5 ,6);
		/*
		insertNotRecursive(4);
		insertNotRecursive(2);
		insertNotRecursive(1);
		insertNotRecursive(3);
		insertNotRecursive(5);
		insertNotRecursive(6); */
		
		System.out.println("Depth First starting from vertex2");
		
		List<Integer> visitedNodes = new ArrayList<Integer>();
		//g.depthFirstSearch(2, visitedNodes);
		g.depthFirstSearch(4, visitedNodes);
	}

}
