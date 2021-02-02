package deneme;

import java.util.LinkedList;

abstract class Animal{
	private int order;
	protected String name;
	public Animal(String name) {
		this.name = name;
	}
	public void setOrder(int order) {
		this.order = order;
	}
	public int getOrder(){
		return order;
	}
	public boolean isOlderThan(Animal a) {
		return this.order < a.getOrder();
	}
}
class Dog extends Animal{
	public Dog(String name) {
		super(name);		
	}	
}
class Cat extends Animal{
	public Cat(String name) {
		super(name);		
	}	
}
public class AnimalShelter {

	LinkedList<Dog> dogs = new LinkedList<Dog>();
	LinkedList<Cat> cats = new LinkedList<Cat>();
	private int order = 0; // acts as a timestamp
	
	public void enqueue(Animal animal) {
		//Order is used as a sort of timestamp ,so that we can compare the insertion order of a dog to a cat
		animal.setOrder(order);
		order++;
		
		if(animal instanceof Dog ) dogs.addLast( (Dog)animal);
		else if(animal instanceof Cat ) cats.addLast((Cat) animal);
		
	}
	
	public Animal dequeuAny() {
		if( dogs.size() == 0)
			return dequeueCats();
		else if ( cats.size() == 0)
			return dequeueDogs();
		
		Dog dog = dogs.peek();
		Cat cat = cats.peek();
		
		if( dog.isOlderThan(cat))
			return dog;
		else  
			return cat;
	}
	
	public Dog dequeueDogs() {
		return dogs.poll();
	}
	public Cat dequeueCats() {
		return cats.poll();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
