package edu.structure;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

public class MapMain {

	public static void main(String[] args) {
		File infile = new File("C:\\sample\\DS_Sample2.csv");

		Map<String, Employee> map = new HashMap<String, Employee>();
		try {
			BufferedReader in = new BufferedReader(new FileReader(infile));
			String s;
			while ((s = in.readLine()) != null) {
				String[] split = s.split(",");								
				Employee employee = new Employee(split[1],
						split[2], Double.parseDouble(split[3]),
						Double.parseDouble(split[4]), Double.parseDouble(split[5]));
				
				addMap(map, employee);
			}
			in.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		print(map);
	}
	
	public static void addMap(Map<String, Employee> map, Employee em) {
		if (map.containsKey(em.getNo())) {
			Employee employee = map.get(em.getNo());
			employee.setPjA(employee.getPjA() + em.getPjA());
			employee.setPjB(employee.getPjB() + em.getPjB());
			employee.setPjC(employee.getPjC() + em.getPjC());
		} else {
			map.put(em.getNo(), em);
		}
	}

	public static void print(Map<String, Employee> map) {
		SortedSet<String> keys = new TreeSet<String>(map.keySet());
		for (String key : keys) {
			Employee employee = map.get(key);
			double sum = employee.getPjA() + employee.getPjB() + employee.getPjC();
			System.out.print(employee.getNo() + "\t" + employee.getName() + "\t");
			System.out.format("%.1f \t %.1f \t %.1f \t => \t %.1f\n", employee.getPjA(), employee.getPjB(), employee.getPjC(), sum);
			
		}
	}

}

class Employee {
	private String no;
	private String name;
	private double pjA;
	private double pjB;
	private double pjC;

	public Employee() {
		super();
	}	

	public Employee(String no, String name, double pjA, double pjB, double pjC) {
		super();
		this.no = no;
		this.name = name;
		this.pjA = pjA;
		this.pjB = pjB;
		this.pjC = pjC;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPjA() {
		return pjA;
	}

	public void setPjA(double pjA) {
		this.pjA = pjA;
	}

	public double getPjB() {
		return pjB;
	}

	public void setPjB(double pjB) {
		this.pjB = pjB;
	}

	public double getPjC() {
		return pjC;
	}

	public void setPjC(double pjC) {
		this.pjC = pjC;
	}

	@Override
	public String toString() {
		return "Employee [no=" + no + ", name=" + name + ", pjA=" + pjA
				+ ", pjB=" + pjB + ", pjC=" + pjC + "]";
	}
}