package denemeExam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

interface IColor{
	int b= 4;
	
	double calculate(int a);
	default double sqrt(int a) {
		return Math.sqrt(a);
	}
	static int add( int a , int b) {
		return a + b;
	}
}

class Person
{
	String name;	
	int age;
	
     Person(String name ,int age){
		this.name = name;
		this.age = age;
	}	
}

class Employee
{
	String name;	
	int age;
	double salary;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	Employee(int age ,String name ,double salary){
		this.name = name;
		this.age = age;
		this.salary = salary;
	}	
}

public class prep {
	
	/*public static double square(double num) {
		return Math.pow(num, 2);
	}
	public static double triple(double num) {
		return Math.pow(num, 3);
	}*/
	public static void main(String[] args) {
		
		List<String> stringsList = new ArrayList<String>();
		stringsList.add("ddd2");
		stringsList.add("aaa2");
		stringsList.add("bbb1");
		stringsList.add("aaa1");
		stringsList.add("bbb3");
		stringsList.add("ccc1");
		stringsList.add("bbb3");

		stringsList.stream()
					.filter(s -> s.startsWith("a"))
					.map(item -> item.toUpperCase())
					.sorted((o1 ,o2) -> o1.compareTo(o2) )
					.forEach(System.out::println);
		
		
		/*
		Function<Double, Double> squareFn = prep::square;
		
		double res = squareFn.apply(23d);
		
		Function<Double, Double> squareLambda= (Double par) -> par * par;
		squareLambda.apply(3d);
		
		List<String> strings = Arrays.asList("a" ,"bb" ,"cc" ,"ddd");
		
		Map<Integer ,Long> stringsGroupedWithCount = strings.
														stream().
														collect(Collectors.groupingBy(i ->  i.toString().length() ,Collectors.counting()));
		
		
		/*
		List<Person> persons = Arrays.asList( new Person("Max", 18) ,
												new Person("Peter", 23),
												new Person("Volkan", 12),
												new Person("Tahir", 12) );

		Map<Integer, List<Person>> groupedPeople = persons.stream().collect(Collectors.groupingBy(p -> p.age));
		
		groupedPeople.entrySet().forEach(p -> System.out.println(p.getKey() + ":" + p.getValue().toString() ));
		
		/*
		List<Integer> intList = Arrays.asList(2 ,5 ,3, 2 ,3 );
		List<Integer> distList = intList.
									stream().
									distinct().collect(Collectors.toList());
		
		/*
		Employee[] employees = {
									new Employee(4,"Jeff Bezos", 100000.0),
									new Employee(1,"Mark Zuckerberg", 200000.0),
									new Employee(3,"Satan Gates", 300000.0),
									new Employee(2,"Volkan Su", 250000.0)									
								};
		
		List<Employee> empList = Arrays.asList(employees);
		
		Optional<Employee> employee = empList.
											stream().
											max(Comparator.comparing(Employee::getSalary) );
		
		employee = empList.
					stream().
					min(Comparator.comparing(Employee::getSalary) );


		if( employee.isPresent())
			System.out.println( employee.get().name + " " +  employee.get().salary);
		
		/*
		Optional<Employee> employeeList = empList.stream().min((o1 ,o2) -> ((int)o1.salary - (int) o2.salary));
		if( employeeList.isPresent())
			System.out.println(employeeList.get().name + " " + employeeList.get().salary);
		
		
		List<Person> persons = Arrays.asList( new Person("Max", 18) ,
												new Person("Peter", 23),
												new Person("Volkan", 12) );
		
		List<Person> personsList = persons.stream().
										filter(p -> p.name.startsWith("P"))
										.collect(Collectors.toList());
		Stream.of("a1" ,"a2" ,"a3")
			.map(s -> s.substring(1))
			.mapToInt(Integer::parseInt)
			.max()
			.ifPresent(item -> System.out.println(item));
		
		
		
		
		List<Integer> ints = new ArrayList<Integer>();
		
		ints.add(2);
		ints.add(4);
		ints.add(6);
		ints.add(8);
		ints.add(10);
		
		List<Integer> intsUpdated = ints.subList(2,4);
		
		List<Integer> intsFiltered = ints.stream().
											skip(3).
											limit(2).
											collect(Collectors.toList());
		
		Collections.copy()
		
		List<String> names = Arrays.asList("ali" ,"veli" ,"kirk" );
		Collections.sort(names);
		Collections.reverse(names);
		Collections.sort(names ,new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				return o2.compareTo(o1);
			}			 
		});
		
		names.forEach(a -> System.out.println(a););
		Map<Integer, Integer> numberMap = new LinkedHashMap<Integer, Integer>();
		
		numberMap.put(1, 100);
		numberMap.put(3, 300);
		
		numberMap.replace(3 ,500);
		numberMap.replace(3 ,numberMap.get(3) + 50 );
		
		
		numberMap.entrySet().stream().forEach(i -> System.out.println(i.getKey() + ":" + i.getValue()));
		*/
	}

}
