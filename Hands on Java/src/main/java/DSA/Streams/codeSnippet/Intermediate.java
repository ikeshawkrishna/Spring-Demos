package DSA.Streams.codeSnippet;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import lombok.Data;

public class Intermediate {
	
	public static void main(String[] args) {
		List<Employee> employees = Arrays.asList(
				new Employee(1, "Alice Johnson", 55000, "HR"),
				new Employee(2, "Bob Smith", 62000, "DEV"),
				new Employee(3, "Carol White", 48000, "Testing"),
				new Employee(4, "David Brown", 71000, "DEV"),
				new Employee(5, "Emma Davis", 59000, "HR"),
				new Employee(6, "Frank Miller", 65000, "DEV"),
				new Employee(7, "Grace Lee", 52000, "Testing"),
				new Employee(8, "Henry Wilson", 68000, "DEV"),
				new Employee(9, "Ivy Martinez", 54000, "Testing"),
				new Employee(10, "Jack Taylor", 73000, "HR")
			);
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		List<Object> objects = Arrays.asList("this is String",1,true,false, 12.0);
		List<String> fruits = Arrays.asList("Apple", "Banana", "Avocado", "Mango","Apple", "Banana", "Apple", "Mango");
		
//		sort list of employees by salary
		List<Employee> salarysortedEmployees = employees.stream()
			.sorted(Comparator.comparing(Employee::getSalary).reversed())
			.toList();
		System.out.println(salarysortedEmployees);
		
//		average salary of employee
		Double averageSalary = employees.stream()
			.mapToDouble(emp -> emp.getSalary())
			.average().orElse(0);
		System.out.println(averageSalary);
		
//		partition odd and even numbers
		Map<Boolean, List<Integer>> evenAndOddnumbers = numbers.stream()
			.collect(Collectors.partitioningBy(num -> num % 2 == 0));
		System.out.println(evenAndOddnumbers);
		
//		group the elements by their length
		Map<Integer, List<String>> grouppedByNameLength = employees.stream()
			.map(emp -> emp.getName())
			.collect(Collectors.groupingBy(name -> name.length()));
		System.out.println(grouppedByNameLength);
		
//		Group the elements based on the type
		Map<Object, List<Object>> groupedByClass = objects.stream()
			.collect(Collectors.groupingBy(ele -> ele.getClass().getSimpleName()));
		System.out.println(groupedByClass);

//		count occurrence of each element
		Map<String, Long> occuranceOfFruits = fruits.stream()
			.collect(Collectors.groupingBy(e -> e, Collectors.counting()));
		System.out.println(occuranceOfFruits);
		
//		group employee by department and calculate the average salary
		Map<String, Double> collect = employees.stream()
			.collect(Collectors.groupingBy(
					emp -> emp.getDept(), 
					Collectors.averagingDouble(emp -> emp.getSalary()
					)
			));
		System.out.println(collect);
	}
}

@Data
@AllArgsConstructor
class Employee{
	private int id;
	private String name;
	private double salary;
	private String dept;
}

