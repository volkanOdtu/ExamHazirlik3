package deneme;

import java.util.Iterator;
import java.util.LinkedList;

public class GridVisit {

	private int v;
	private LinkedList<Integer> adj[]; //bu guzel array de LinkedList ler var ,farkli size li
	
	//Oncelikle graph in tum vertex leri komsulari arrayList lere atiliyor
	public GridVisit(int v) {
		this.v = v;
		adj = new LinkedList[v];
		for(int i =0 ;i < v ; i++)
			adj[i] = new LinkedList<Integer>();
	}
	//o vertex icin gidebilecegi node lar ekliyoruz
	void addEdge(int v ,int w) {
		adj[v].add(w);
	}
	 
	void DFSUtil(int vertexNo ,boolean visitedArr[]) {
		visitedArr[vertexNo] = true;
		System.out.println(vertexNo + " ");
		
		//bu vertex in adjacent node larini buluyoruz ,tabi visitedArray de yoksa ve iterate ediyoruz
		 Iterator<Integer> iterator = adj[vertexNo].listIterator();

		 while (iterator.hasNext()) {
				int adjVertexNo = iterator.next();
				if( !visitedArr[adjVertexNo])
					DFSUtil(adjVertexNo, visitedArr); 
			}

	}
	//0 dan itibaren diger tum node lar boolean arrayi olarak gonderiliyoriher visit de check edicez cunku
	//ilk birinci node un komsulari ,ardi
	void DFS(int vertexNoStarting) {
		boolean[] visitedArr = new boolean[v]; //by default all false -non visited

		//DFSUtil de 1.node un komsulari arrayList de duruyor ,her cagirdigimizda komsu lari birer birer ayni metoda
		//gonderiyoruz bir node hangi node lara komsu
		DFSUtil(vertexNoStarting, visitedArr);
	}
	public static void main(String[] args) {
		GridVisit g = new GridVisit(9);
		g.addEdge(0, 1); // adj[0] = [1,3]
		g.addEdge(0, 3);
		g.addEdge(1, 2); // adj[1] = [2,4]
		g.addEdge(1 ,4);
		g.addEdge(3, 4);
		g.addEdge(3 ,6);
		g.addEdge(4, 5);
		g.addEdge(4 ,7);
		g.addEdge(6, 7); // adj[6] = [7]
		g.addEdge(7 ,8);
		g.addEdge(2, 5);
		g.addEdge(5 ,8);
		
		System.out.println("Depth First Traversal starting from vertex 2 ");
		//0 dan itibaren ilerlicez
		g.DFS(0);

	}

}
