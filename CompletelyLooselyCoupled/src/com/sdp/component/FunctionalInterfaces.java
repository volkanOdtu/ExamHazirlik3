package com.sdp.component;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

class Student{
	private int id;
	private String name;
	public Student(int id, String name) {
		this.id = id;
		this.name = name;
	}
	public int getId() { return id; }	 
	public String getName() { return name;}
}	 



public class FunctionalInterfaces {

	private static void printNames(Supplier<String> arg) {
		System.out.println(arg.get());
	}
	private static List<Student> getStudents(List<Student> studentList ,Predicate<Student> pr){
		
		List<Student> resultList = new ArrayList<Student>();
		
		resultList = studentList.stream().filter(pr).collect(Collectors.toList()) ;
		
		return resultList;
	}
	public static void main(String[] args) {
		
		Student s1= new Student(1, "volkan");
		Student s2= new Student(2, "ece");
		
		Predicate<Student> studentsStartingWithV = (s) -> s.getName().startsWith("v");
		Predicate<Student> studentsHavingLength3 = (s) -> {
															int len = s.getName().length();
															if(len == 3) return true;
															
															return false;
														  };
        boolean result = studentsHavingLength3.test(s1);
        
		System.out.println("student1 starts with V: " );
		
		Consumer<Student> fnConsumer = (s) -> System.out.println(s.getId() + " " + s.getName() );
		
		//studentList.forEach(fnConsumer );
		/*
		String[] countries = {"India" ,"Australia" ,"England" ,"Sri lanka"};
		String name = "ali";
		Supplier<String> fnSupplier = () -> {
												 return "Merhaba" + name ;
											};
		
        System.out.println( fnSupplier.get());
		
		
		 
		Function<String[], String>  converter = (all) ->{
												String names = "";
												for(String s:all) {
													names += s ;
												}
												return names;
											};
		System.out.println(converter.apply(countries));  
	*/
	}

}
