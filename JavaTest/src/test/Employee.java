package test;

import java.util.Comparator;

public class Employee implements Comparable<Employee>,Comparator<Employee> {
	
	private int id;
	private String name;
	
	public Employee(int id,String name){
		this.id = id;
		this.name = name;
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
	public int compareTo(Employee o) {
		return name.compareToIgnoreCase(o.name);
	}

	@Override
	public int compare(Employee o1, Employee o2) {
		
		return 0;
	}
	
	

}
