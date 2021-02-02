package denemeExam2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


class Person{	
	int id;
	ArrayList<Integer> friends ;
	
	public Person(int id) {
		this.id = id;
		this.friends = new ArrayList<Integer>();
	}
	
	public int getId() {
		return this.id;
	}
	public void addFriend(int id) {
		friends.add(id);
	}
	public ArrayList<Integer> getFriends(){
		return friends;
	}
}
class PathNode{
	private Person  person = null;
	private PathNode previousNode = null;
	public PathNode(Person p ,PathNode previousNode) {
		this.person = p;
		this.previousNode = previousNode;
	}
	public Person getPerson() {
		return this.person;
	}
	
	public LinkedList<Person> collapse(boolean startsWithRoot){
		LinkedList<Person> path = new LinkedList<Person>();
		PathNode node = this;
		while(node != null) {
			if(startsWithRoot)
				path.addLast(node.person);
			else
				path.addFirst(node.person);
			
			node = node.previousNode;
		}
		return path;
	}
}

class BFSData{
	public Queue<PathNode> toVisit = new LinkedList<PathNode>();
	public HashMap<Integer, PathNode> visited = new HashMap<Integer, PathNode>();
	
	public BFSData(Person root) {
		PathNode sourcePath = new PathNode(root, null);
		toVisit.add(sourcePath);
		visited.put(root.getId() ,sourcePath );
	}
	public boolean isFinished() {
		return toVisit.isEmpty();
	}
}
public class SocialNetwork {

	//Search 1 level and return collision if any
	Person searchLevel(HashMap<Integer, Person> people ,BFSData primary ,BFSData secondary) {
		//We only want to search 1 level at a time.Count how many nodes are currently in the primary's level and only do that many 
		//nodes to the end
		int coount = primary.toVisit.size();
		for(int i =0 ; i < coount ;i++) {
			//Pull out the first node
			PathNode pathNode = primary.toVisit.poll();
			int personId = pathNode.getPerson().getId();
			
			//Check if it is already been visited
			if(secondary.visited.containsKey(personId))
				return pathNode.getPerson();
			
			//Add friends to queue
			Person person =pathNode.getPerson();
			ArrayList<Integer> friends = person.getFriends();
			
			for(int friendId:friends) {
				if( !primary.visited.containsKey(friendId)) {
					Person friend = people.get(friendId);
					PathNode next = new PathNode(friend, pathNode);
					primary.visited.put(friendId, next);
				}
			}
		}
		return null;
	}
	
	//Merge paths where searches met at connection
	LinkedList<Person> mergePaths(BFSData bfs1 ,BFSData bfs2 ,int connection){
		PathNode end1 = bfs1.visited.get(connection); //source
		PathNode end2 = bfs1.visited.get(connection); //destination
		
		LinkedList<Person> pathOne = end1.collapse(false);
		LinkedList<Person> pathTwo = end2.collapse(true); // reverse
		
		pathTwo.removeFirst();// remove connection
		pathOne.addAll(pathTwo); // add second path
		
		return pathOne;
	}
	
	LinkedList<Person> findPathBiBFS(HashMap<Integer, Person> people ,int source ,int destination){
		BFSData sourceData = new BFSData(people.get(source));
		BFSData destinationData = new BFSData(people.get(destination));
		
		while( !sourceData.isFinished() && !destinationData.isFinished()) {
			//Search out from source
			Person collision = searchLevel(people, sourceData, destinationData);
			if(collision != null)
				return mergePaths(sourceData, destinationData, collision.getId());
			//Search out from destination
			collision = searchLevel(people, destinationData, sourceData);
			if(collision != null)
				return mergePaths(sourceData, destinationData, collision.getId());
		}
		
		return null;
	}
}
