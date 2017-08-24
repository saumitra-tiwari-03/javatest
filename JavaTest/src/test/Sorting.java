package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Sorting {

	public static void main(String[] args) {
		List<Employee> l = new ArrayList<Employee>();
		
		l.add(new Employee(1, "AD"));
		l.add(new Employee(2, "AC"));
		l.add(new Employee(3, "AA"));
		l.add(new Employee(4, "AB"));
		
		Collections.sort(l);
		System.out.println("====== Normla Iteration ======");
		for(Employee e : l){
			System.out.println(e.getName() +" : "+e.getId());
		}
		System.out.println("===== Using Lambda Exp =======");
		l.forEach(
				(n)->System.out.println(n.getName()+" : "+n.getId())
				);
	
	}
}
