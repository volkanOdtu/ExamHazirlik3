package deneme;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.concurrent.Callable;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import static java.util.Comparator.comparing;
import static java.util.Comparator.comparingInt;



interface ICalculate{
	double calculate(int a);
	default double sqrt(int a) {
		return a*a;
	}
	static int add(int a ,int b) {
		return a + b;
	}
}

class BlueColor implements ICalculate{

	@Override
	public double calculate(int a) {
		return a * 4;
	}
	
}
class Employe{
	Integer id; 
	String name ;
	Double salary;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public Employe(Integer id, String name ,Double salary){
		this.id = id; this.name = name; this.salary = salary;
	}
	
}

class Person{
	int age ;
	String name;
	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Person(String name, int age) {
		this.age = age;
		this.name = name;
	}
}
 class Book {

	private String name;
	private int releaseYear;
	private String isbn;
	
	public Book(String name ,int releaseYear ,String isbn) {
		this.name = name;
		this.releaseYear = releaseYear;
		this.isbn = isbn;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getReleaseYear() {
		return releaseYear;
	}
	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}	
}

public class ExamPrep2 {

	
	public static double sayNumber() {
		return Math.random();
	}
	public static double square(double num) {
		return Math.pow(num, 2);
	}
	
	public static double sum(List<? extends Number> argList) {
		double sum = 0.0;

		for(Number n:argList)
			sum += n.doubleValue();
		
		return sum;
	}
	
	public static void main(String[] args) {
		
        List<String> strings = Arrays.asList("a" ,"bb" ,"cc" ,"ddd" ,"fff" ,"g" );
		
        Map<Integer ,List<String>> stringsGrouped = strings.stream().collect(Collectors.groupingBy(String::length) );
		
        
        stringsGrouped.
        	entrySet().
        	stream().
        	flatMap(i ->i.getValue().stream()).
        	map(i ->i.toUpperCase()).forEach(i ->System.out.println(i));
        
        /*
		LinkedHashMap upperCasedMap =		 
								stringsGrouped.entrySet()
									.stream()
									.collect(Collectors.toMap(i -> i.getKey() ,
									i -> {
										List<String> resultList = new ArrayList();			
										i.getValue().forEach(item ->{							
																resultList.add(item.toUpperCase());
															});
										i.setValue(resultList);
															return resultList;
														    },   
										(o1 ,o2) ->o1 , LinkedHashMap::new));


        
        /*
        List<String> strList = allStrMap.values().
        							stream().
        							flatMap(i -> i.stream()).
        							filter( m -> m.length() > 2).
        							collect(Collectors.toList());
        
        strList.forEach(a -> System.out.println(a));
		/*
		
		Employe[] employees = { new Employe(1,"Jeff Bezos", 100000d),
				new Employe(2,"Satan Gates", 200000d),
				new Employe(3,"Mark Chinese", 300000d)								
				}; 

		List<Employe> empList = Arrays.asList(employees);
		
		Optional<Employe> foundEmp = empList.
										stream()
										.max(comparing(Employe::getId));
										//.max(comparingInt(Employe::getId));
										//.max((e1,e2) -> e1.getId() -e2.getId());
		
		Map<Integer ,Employe> empMap = empList.
										stream().
										collect(Collectors.toMap(Employe::getId, Function.identity() ));
		/*
		empMap.
			entrySet().
			stream().
			sorted(Map.Entry.comparingByKey())
			.forEach(i -> System.out.println(i.getKey() + ":" + i.getValue().getName())); 
			
		empMap
			.entrySet()
			.stream()
			.sorted(Map.Entry.comparingByValue(comparing(Employe::getName)))
			.forEach(i -> System.out.println(i.getKey() + ":" + i.getValue().getName()));
		
		//if(foundEmp.isPresent())
		//	System.out.println( "Id:" + foundEmp.get().getId() );
								
	
		/*
		OptionalDouble result = Arrays.stream(new double[] { 1.0 ,2.5 ,3.0 })
				//.map(n -> 2 * n + 1)
				.average();

		Arrays.stream(new int[] {1 ,2, 3}).map(a -> a*2).average();
		
		/*
		List<Book> bookList = new ArrayList<Book>();
		bookList.add(new Book("kitap1", 1954,"0395489318"));
		bookList.add(new Book("kitap2", 1954,"0345339711"));
		bookList.add(new Book("kitap3", 1955,"0618129111"));
		
 		bookList.stream().map(i ->i.getReleaseYear()).reduce(0 ,(b1 ,b2) -> b1+ b2 );
		bookList.stream().map(i ->i.getReleaseYear()).a
		
		/*
		List<Integer> list1 = Arrays.asList(4 ,5 ,6 ,7);
		List<Double>  list2 = Arrays.asList(4.1 ,5.1 ,6.1 ,7.1 );
		
		
		sum(list1 );
		sum(list2 );
		
		
		Map<Integer ,ArrayList<String>> mHashMap = new HashMap<Integer, ArrayList<String>>();
		
		ArrayList<String> list1 = new ArrayList<String>();
		ArrayList<String> list2 = new ArrayList<String>();
		ArrayList<String> list3 = new ArrayList<String>();
		
		list1.add("r1");
		list1.add("r2");
		
		list2.add("r3");
		list2.add("r4");
		list2.add("r5");
		
		list3.add("r6");
		list3.add("r7");
		list3.add("r8");
		
		mHashMap.put(1,list1);
		mHashMap.put(2,list2);
		mHashMap.put(3,list3);
		
		Optional<Map.Entry<Integer ,ArrayList<String>>> mHashMapFiltered = mHashMap.entrySet().
																	stream().filter(i -> i.getKey()== 1).findFirst();
		
		/*
		
		List<Book> bookList = new ArrayList<Book>();
		
		bookList.add(new Book("kitap1", 1954,"0395489318"));
		bookList.add(new Book("kitap2", 1954,"0345339711"));
		bookList.add(new Book("kitap3", 1955,"0618129111"));
		
		
		//Map<String, String> booksMap = bookList.stream()
		//								.collect(Collectors.toMap(Book::getIsbn, Book::getName));
		

		Map<String, Book> booksMap = bookList.stream()
										.collect(Collectors.toMap(Book::getIsbn, Function.identity()));
		
		booksMap.entrySet().forEach(b -> System.out.println( b.getKey() + ":" + b.getValue() ));
		
		/*
		List<Person> personsList1 = new ArrayList<Person>();
		personsList1.add(new Person("ali", 12));
		personsList1.add(new Person("veli", 15));
		personsList1.add(new Person("ahmet", 18));
		
		
		personsList1.sort((o1,o2) -> o1.getAge()- o2.getAge()) ;
		personsList1.forEach(a -> System.out.println( a.getName()));
		/*
		List<Person> personsList2 = new ArrayList<Person>();
		personsList2.add(new Person("eda", 22));
		personsList2.add(new Person("sevil", 16));
		personsList2.add(new Person("tarik", 17));
		
		List<List<Person>> allPeople = new ArrayList<List<Person>>();
		allPeople.add(personsList1);
		allPeople.add(personsList2);
		
		allPeople.stream()
					.flatMap(i -> i.stream().filter(p -> p.age > 16))
					.forEach(p -> System.out.println(p.getAge() + ":" + p.getName()));
						
		
		/*List<Person> persons = Arrays.asList(new Person("ali", 15) ,new Person("veli",30));
		
		int total = persons.stream().map(a ->a.getAge()).reduce(0 ,(a,b) -> a +b);
		
		
		/*
		List<Integer> intList = new ArrayList<Integer>();
		
		intList.add(2);
		intList.add(4);
		intList.add(6);
		intList.add(8);
		intList.add(10);
		
		int res = intList.stream().reduce(10 ,(a,b) -> a + b);
		int res2 = intList.stream().reduce(10 ,Integer::sum );
		
		System.out.println(res);
		/*
		List<String> strlist = new ArrayList<String>();
		
		strlist.add("ddd1");
		strlist.add("aaa2");
		strlist.add("bbb1");
		strlist.add("aaa1");
		
		strlist.
			stream().
			filter(s ->s.startsWith("a")).sorted((o1 ,o2) -> o1.compareTo(o2));
			
		
		
		
		/*ExamPrep2 ex = new ExamPrep2();
		
		Callable<Double> sonuc= ExamPrep2::sayNumber;
		
		sonuc.call();
		//Function<Double, Double> squareFn = ExamPrep2::square;
		Function<Double, Double> squareFn = (Double x) -> x *x;

		System.out.println( squareFn.apply(5d));
		
		/*
		List<Person> persons = new ArrayList<Person>();
		persons.add(new Person("Max" ,18));
		persons.add(new Person("Peter" ,23));
		persons.add(new Person("Pamela" ,23));
		persons.add(new Person("David" ,12));
		
		//Map<Integer,Long> groupedPeople= 
				
		Map<Integer, List<Person>> groupedPeople2=	persons.
													  stream().
													  collect(Collectors.groupingBy(item -> item.getAge()));
													  //collect(Collectors.groupingBy(item -> item.getAge(),Collectors.counting()));
		
		
		
		Employe[] employees = { new Employe(1,"Jeff Bezos", 100000d),
								new Employe(2,"Satan Gates", 200000d),
								new Employe(3,"Mark Chinese", 300000d)								
								}; 

		List<Employe> empList = Arrays.asList(employees);
		
		
		
		
		/*
		Optional<Employe> empMinById = empList
							.stream()
							.min((e1 ,e2) -> e1.getId() - e2.getId());
		
						
		if(empMinById.isPresent())
			System.out.println(empMinById.get().getName());
			
		Optional<Employe> empMaxSalary= empList
										.stream()
										.max((o1 ,o2)-> o1.getSalary().intValue() - o2.getSalary().intValue())
										.max(Comparator.comparing(Employe::getSalary).reversed() );
		

		
		
		
		/*
		OptionalInt max =
				Stream.of("a1" ,"a2" ,"a3")
				.map(a ->a.substring(1))
				.mapToInt(Integer::parseInt)
				.max();
		if( max.isPresent())
			max.getAsInt();
		 
		
		
		/*
		
		List<Integer> intList = new ArrayList<Integer>();
		
		intList.add(2);
		intList.add(4);
		intList.add(6);
		intList.add(8);
		intList.add(10);
		
		Collections.copy(dest, src);
		
		List<Integer> intList2 = intList.
								stream()
								.skip(3)
								.limit(2)
								.collect(Collectors.toList());

		System.out.println(intList2);
		
		/*
		Employe[] employees = { new Employe(1,"Jeff Bezos", 100000d),
								new Employe(2,"Satan Gates", 200000d),
								new Employe(3,"Mark Chinese", 300000d)								
								}; 
		
		List<Employe> empList = Arrays.asList(employees);
		empList.
			stream().
			forEach(e -> e.setSalary(e.getSalary() + 500));
		
		int peopleWithHighhSalary = (int)empList.
											stream()
											.filter(e -> e.getSalary() > 150000)
											.count();
		
		List<Employe> resList = empList.
								stream()
								.filter(e -> e.getSalary() > 150000).collect(Collectors.toList());
								
								
		/*
		List<String> names= Arrays.asList("ali" ,"veli" ,"ahmet");
		
		Collections.sort(names);
		System.out.println(names);
		Collections.reverse(names);
		System.out.println(names);
		
		//ICalculate myCalc = new BlueColor();
		 
		/*
		 Map<Integer, Integer> numberMap = new LinkedHashMap<Integer, Integer>();
		 numberMap.put(1, 100);
		 numberMap.put(2, 200);
		 numberMap.put(3, 200);
	
		 numberMap.
		 	entrySet()
		 	.forEach(i -> System.out.println(i.getKey() + i.getValue() ));
		 	
		 ExamPrep2 p = new ExamPrep2();
		 p = null;
		 System.gc(); */
	}
	
	@Override
	protected void finalize() throws Throwable {
		System.out.println(  " successfully garbage collected"); 
	}

}
