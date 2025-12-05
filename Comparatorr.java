package Comparator;


import java.util.*;


class Employee{
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
	
		
}

class SortBySalary implements Comparator<Employee>{
	
	public int compare(Employee e1,Employee e2) {
		return e1.salary-e2.salary;
	}
	
}

class SortByName implements Comparator<Employee>{
	
	public int compare(Employee e1,Employee e2) {
		return e1.name.compareTo(e2.name);
	}
	
}

class SortById implements Comparator<Employee>{
	
	public int compare(Employee e1,Employee e2) {
		return e1.id-e2.id;
	}
	
}

public class Comparatorr {
	public static void main(String []args) {
	ArrayList<Employee>employee=new ArrayList<>();
	
	
	employee.add(new Employee(2,"Prasad","CS",600000));

	employee.add(new Employee(1,"Nitin","IT",500000));

	employee.add(new Employee(3,"Pranav","AIML",700000));
	
	
	System.out.println("ORIGINAL LIST:");
    for (Employee e : employee)
        System.out.println(e);
    
    Collections.sort(employee,new SortById());
    
    System.out.println("\nAFTER comparatorr SORTING (By Salary):");
    for (Employee e : employee)
        System.out.println(e);
    
   }
}


