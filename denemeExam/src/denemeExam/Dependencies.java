package denemeExam;

import java.util.ArrayList;
import java.util.HashMap;

class Project{
	private ArrayList<Project> children = new ArrayList<Project>();
	private HashMap<String,Project> map = new HashMap<String, Project>();
	private String name;
	public int dependencies= 0;
	
	public String getName() { return name;}
	public ArrayList<Project> getChildren() { return children;}
	
	public Project(String name) {
		this.name = name;
	}
	public void addNeighbor(Project node) {
		if(! map.containsKey(node.getName() )) {
			children.add(node);
			map.put(node.getName(), node );
			dependencies++;
		}
	}
}
class Graph{
	private ArrayList<Project> nodes = new ArrayList<Project>();
	private HashMap<String , Project> hashMap = new HashMap<String, Project>();
	
	public ArrayList<Project> getNodes(){
		return nodes;
	}
	public Project getOrCreateNode(String name) {
		if(!hashMap.containsKey(name)) {
			Project node = new Project(name);
			nodes.add(node);
			hashMap.put(name, node);
		}
		return hashMap.get(name) ;
	}
	public void addEdge(String startName ,String endName ) {
		Project startNode = getOrCreateNode(startName);
		Project endNode = getOrCreateNode(endName);
		startNode.addNeighbor(endNode);		
	}
}

public class Dependencies {

	Project[] findBuildOrder(String[] projects, String[][] dependencies) {
		Graph graph = buildGraph(projects ,dependencies);
		return orderProjects(graph.getNodes());
	}
	
	Graph buildGraph(String[] projects ,String[][] dependencies) {
		Graph g= new Graph();
		
		for(String projectName: projects){
			g.getOrCreateNode(projectName);
		}
		for(String[] dependeny:dependencies) {
			String first = dependeny[0];
			String second = dependeny[1];
			g.addEdge(first, second);
		}
		return g;
	}
	
	Project[] orderProjects(ArrayList<Project> projects) {
		Project[] orderedProjects = new Project[projects.size()];
		
		int endOfList = addNondependent(orderedProjects, projects, 0);
		
		int i=0;
		while( i < orderedProjects.length) {
			Project currentProj = orderedProjects[i];
			if( currentProj == null) 
				return null;

			//Remove myself as a dependency
			ArrayList<Project> childrenProjects = currentProj.getChildren();
			for(Project childProj:childrenProjects)
				childProj.dependencies--;
			
			//Add children tha have no one depending on them
			
		}
	}
	int addNondependent(Project[] orderedProjects ,ArrayList<Project> projects ,int offset) {
		for(Project project: projects) {
			if(project.dependencies == 0) {
				orderedProjects[offset] = project;
				offset++;
			}
		}
		return offset;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
