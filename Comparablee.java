package Comparable;
import java.util.*;


class Employee implements Comparable<Employee>{
	int id;
	String name;
	String dept;
	int salary;
	
	public Employee(int id,String name,String dept,int salary) {
		this.id=id;
		this.name=name;
		this.dept=dept;
		this.salary=salary;
	}
	
	@Override
	public String toString() {
		return id+" "+name+" "+" "+dept+" "+salary+" ";
	}
	
	public int compareTo(Employee e) {
		return this.salary-e.salary;
	}
	
}

public class Comparablee {
	public static void main(String []args) {
	ArrayList<Employee>employee=new ArrayList<>();
	
	
	employee.add(new Employee(2,"Prasad","CS",600000));

	employee.add(new Employee(1,"Nitin","IT",500000));

	employee.add(new Employee(3,"Pranav","AIML",700000));
	
	
	System.out.println("ORIGINAL LIST:");
    for (Employee e : employee)
        System.out.println(e);
    
    Collections.sort(employee);
    
    System.out.println("\nAFTER NATURAL SORTING (By Salary):");
    for (Employee e : employee)
        System.out.println(e);
    
}
}
