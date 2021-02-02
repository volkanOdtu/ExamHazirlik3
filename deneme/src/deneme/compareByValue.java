package deneme;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import static java.util.Comparator.comparing;
public class compareByValue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Employee> employees = new ArrayList<Employee>();
	
		employees.add(new Employee(1, "Peter Gibbons"));
		employees.add(new Employee(2, "Samir Nazim"));
		employees.add(new Employee(3, "Michael Bolto"));
		employees.add(new Employee(4, "Milton Waddams"));
		
		Map<Integer, String> employeeMap = employees.stream().collect(Collectors.toMap(Employee::getId, Employee::getName));
		Map<Integer, Employee> employeeMap2 = employees.stream().collect(Collectors.toMap(Employee::getId, Function.identity() ));
		
		
		Map<Integer, Employee> employeeMapSortedByValue = employeeMap2.
				entrySet().
				stream()
				.sorted(Map.Entry.comparingByValue(comparing(Employee::getName).reversed()))				
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue ,(o1 ,o2) -> o1, LinkedHashMap::new ));

		
		//Id ye gore sorted
		Map<Integer , String>  employeeMapSorted = employeeMap.
													entrySet().
													stream()
													.sorted(Map.Entry.comparingByKey())
													.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue ,(o1 ,o2) -> o1, LinkedHashMap::new ));
		
		 employeeMapSorted.entrySet().forEach(item -> System.out.println(item.getKey() + ":" + item.getValue() ) );
		 
		 employeeMapSorted = employeeMap.
				entrySet().
				stream()
				.sorted(Map.Entry.comparingByValue())
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue ,(o1 ,o2) -> o1, LinkedHashMap::new ));

		 employeeMapSorted.entrySet().forEach(item -> System.out.println(item.getKey() + ":" + item.getValue() ) );
		 
	}

}

class Employee{
	private int id;
	private String name;
	double salary;

	public Employee(int id ,String name) {
		this.id = id;
		this.name = name;				
	}
	public Employee(int id ,String name ,double salary) {
		this.id = id;
		this.name = name;				
		this.salary= salary;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return this.name;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
}
