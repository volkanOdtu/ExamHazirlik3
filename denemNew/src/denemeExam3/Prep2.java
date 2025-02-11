package denemeExam3;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.Stream;
 
class Node{
	Node left ,right;
	int data;
	public Node(int data) {
		this.data = data;
		
	}
} 

class Student{
	private String name;
    private int score;
    
    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }
    
    public int getScore() {
        return score;
    }
    
    public String getName() {
        return name;
    }
}

class Robot{
	IDirection currDirection;
	int x ,y;
	
	public void move() {
		if(currDirection instanceof Up)
			y = y + 1;
	}
	public void applyCommand(String command) {
		if( command.equals("G"))
			move();
	}
	
}
interface IDirection{
	void moveRight(Robot robot);
	void moveLeft(Robot robot);	
}
class Up implements IDirection{

	@Override
	public void moveRight(Robot robot) {
		robot.currDirection = new Right();
	}

	@Override
	public void moveLeft(Robot robot) {
		// TODO Auto-generated method stub
		
	}	
}

class Right implements IDirection{

	@Override
	public void moveRight(Robot robot) {
		// TODO Auto-generated method stub
		robot.currDirection = new Up();
	}

	@Override
	public void moveLeft(Robot robot) {
		// TODO Auto-generated method stub
		
	}
	
}
public class Prep2 {
	static Node root;
	public static void insertNotRecursive(int data) {
		if(root == null) {
			root = new Node(data);
			root.left = null;
			root.right = null;
		}
		else {
			Node currNode =  root;
			Node tempNodeToBound = root;
			boolean willNodeBoundToLeft = false;
			
			while(currNode != null) {
				tempNodeToBound = currNode;
				if( data > root.data) {
					currNode =currNode.right;
					willNodeBoundToLeft = false;
				}
				else {
					currNode = currNode.left;
					willNodeBoundToLeft =true;
				}
			}
			if(willNodeBoundToLeft)
				tempNodeToBound.left = new Node(data);
			else
				tempNodeToBound.right = new Node(data);
		}
	}
	
	public static void printByLevel() {
		Queue<Node> nodesQqueue = new LinkedList<Node>();
		
		nodesQqueue.add(root);
		
		while(!nodesQqueue.isEmpty()) {
			Node currNode = nodesQqueue.poll();
			System.out.println(currNode.data);
			
			if(currNode.left != null)
				nodesQqueue.add(currNode.left);
			if(currNode.right != null)
				nodesQqueue.add(currNode.right);
		}
	}
	public static int findOccurrenceOfSubStr(String s ,String searchedStr) {
		String newStr = "";
		int newStartIndex =0;
		
		while(s.length() > 0) {
			if(s.indexOf(searchedStr) >=0) {
				newStartIndex = s.indexOf(searchedStr);
				newStartIndex = newStartIndex + searchedStr.length();
				newStr = s.substring(newStartIndex);
				return 1 + findOccurrenceOfSubStr(newStr, searchedStr);
				
			}
			else 
				return 0;
		}
		
		return 0;
	}
	
	public static List<Student> studentsThatPass(Stream<Student> students ,int passingScore){
		
		List<Student> studentsOrdered = students.filter(a -> a.getScore() > passingScore)
										.collect(Collectors.toList());
		
		studentsOrdered.sort((o1 ,o2) ->o1.getScore() - o2.getScore());
		studentsOrdered.forEach(s -> System.out.println(s.getName()));
		
		return studentsOrdered;
	}
	public static void main(String[] args) {
		insertNotRecursive(4);
		insertNotRecursive(2);
		
	}
}
