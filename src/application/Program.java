package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Employee;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.println("How many employee will be registered? ");
		int n = sc.nextInt();

		List<Employee> employeeList = new ArrayList<>(n);

		for (int i = 0; i < n; i++) {

			System.out.println("Employee #" + (i + 1) + ":");

			System.out.print("Id: ");
			int id = sc.nextInt();

			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Salary: ");
			double salary = sc.nextDouble();
			System.out.println();

			Employee employee = new Employee(id, name, salary);
			employeeList.add(employee);

		}
		System.out.print("Enter the employee id that will have salary inclease : ");
		int entryId = sc.nextInt();

		Employee employee = employeeList.stream().filter(x -> x.getId() == entryId).findFirst().orElse(null);

		if (employee == null) {

			System.out.println("This id does not exist!");
		}

		else {
			System.out.println("Enter the percentage: ");
			double percentage = sc.nextDouble();
			employee.incleaseSalary(percentage);

		}
		System.out.println();
		System.out.println("List of employee: ");
		for (Employee emp : employeeList) {
			System.out.println(emp);
		}
	}

}
