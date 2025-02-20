package com.samit.java8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Test {

	public static void main(String[] args) {
		List<Employee> employeeList = new ArrayList<Employee>();
		//Jiy
		employeeList.add(new Employee(111, "Jiy", 32, "Female", "HR", 2011, 25000.0));
		employeeList.add(new Employee(122, "Paul Niksui", 25, "Male", "Sales And Marketing", 2015, 13500.0));
		employeeList.add(new Employee(133, "Martin Theron", 29, "Male", "Infrastructure", 2012, 18000.0));
		employeeList.add(new Employee(144, "Murali Gowda", 28, "Male", "Product Development", 2014, 32500.0));
		employeeList.add(new Employee(155, "Nima Roy", 27, "Female", "HR", 2013, 22700.0));
		employeeList.add(new Employee(166, "Iqbal Hussain", 43, "Male", "Security And Transport", 2016, 10500.0));
		employeeList.add(new Employee(177, "Manu Sharma", 35, "Male", "Account And Finance", 2010, 27000.0));
		employeeList.add(new Employee(188, "Wang Liu", 31, "Male", "Product Development", 2015, 34500.0));
		employeeList.add(new Employee(199, "Amelia Zoe", 24, "Female", "Sales And Marketing", 2016, 11500.0));
		employeeList.add(new Employee(200, "Jaden Dough", 38, "Male", "Security And Transport", 2015, 11000.5));
		employeeList.add(new Employee(211, "Jasna Kaur", 27, "Female", "Infrastructure", 2014, 15700.0));
		employeeList.add(new Employee(222, "Nitin Joshi", 25, "Male", "Product Development", 2016, 28200.0));
		employeeList.add(new Employee(233, "Jyothi Reddy", 27, "Female", "Account And Finance", 2013, 21300.0));
		employeeList.add(new Employee(244, "Nicolus Den", 24, "Male", "Sales And Marketing", 2017, 10700.5));
		employeeList.add(new Employee(255, "Ali Baig", 23, "Male", "Infrastructure", 2018, 12700.0));
		employeeList.add(new Employee(266, "Sanvi Pandey", 26, "Female", "Product Development", 2015, 28900.0));
		employeeList.add(new Employee(277, "Anuj Chettiar", 31, "Male", "Product Development", 2012, 35700.0));

		// Find out the count of male and female employees present in the organization?
		Map<String, Long> maleFemaleCount = employeeList.stream()
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
		System.out.println(maleFemaleCount);

		System.out.println("--------------------------\n");
		// 2. Write a program to print the names of all departments in the organization.
		employeeList.stream().map(e -> e.getName()).distinct().collect(Collectors.toList())
				.forEach(System.out::println);

		System.out.println("--------------------------\n");
		// 3. Find the average age of Male and Female Employees.
		Map<String, Double> averageAgeOfMaleandFemale = employeeList.stream()
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingDouble(Employee::getSalary)));
		averageAgeOfMaleandFemale.entrySet().stream().forEach(System.out::println);
		System.out.println("--------------------------\n");

		// 4. Get the Names of employees who joined after 2015.
		long noOfEmployeeWhojoinedafter2015 = employeeList.stream().filter(e -> e.getYearOfJoining() > 2015)
				.map(e -> e.getYearOfJoining()).count();
		System.out.println(noOfEmployeeWhojoinedafter2015);
		System.out.println("--------------------------\n");

		// 7. Find out the oldest employee, his/her age and department?
		List<Employee> oldestEmployee = employeeList.stream().sorted(Comparator.comparingInt(Employee::getAge))
				.collect(Collectors.toList());
		System.out.println(oldestEmployee.get(oldestEmployee.size() - 1));

		System.out.println("--------------------------\n");
		// 9. List down the employees of each department.
		Map<String, List<Employee>> employeesOfEachDepartment = employeeList.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment));
		System.out.println(employeesOfEachDepartment);

		System.out.println("---------------------8888---------\n");
		List<Employee> listOfEmp = employeeList.stream().filter((e) -> {
			String s1 = e.getName();
			String s2 = e.getGender();
			if (s1.length()>s2.length()) {
				return true;
			} else {
				return false;
			}
		}).collect(Collectors.toList());
		System.out.println(listOfEmp);

	}
}
