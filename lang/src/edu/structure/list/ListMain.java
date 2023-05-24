package edu.structure.list;

import java.io.*;
import java.util.*;

public class ListMain {

	public static void main(String[] args) {
		File infile = new File("C:\\sample\\DS_Sample1.txt");

		List<Person> list = new ArrayList<Person>();
		try {
			BufferedReader in = new BufferedReader(new FileReader(infile));
			String s;
			while ((s = in.readLine()) != null) {
				String[] split = s.split(" ");
				Person person = new Person(split[0],
						Integer.parseInt(split[1]), Integer.parseInt(split[2]),
						Integer.parseInt(split[3]));
				list.add(person);
			}
			in.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		boolean isContinue = true;
		PersonComparator<Person> comparator = new PersonComparator<Person>(0);
		Scanner sc = new Scanner(System.in);
        while(isContinue && sc.hasNextLine()){
        	String option = sc.nextLine();
        	switch(option) {
        	case "PRINT":
        		comparator.setOption(0);
        		break;
        	case "KOREAN":
        		comparator.setOption(1);
        		break;
        	case "ENGLISH":
        		comparator.setOption(2);
        		break;
        	case "MATH":
        		comparator.setOption(3);
        		break;
        	case "QUIT":
        		isContinue = false;
        		break;
        	}
    		Collections.sort(list, comparator);
    		print(list);        	
        }    
        sc.close();
	}

	public static void print(List<Person> list) {
		for (Person person : list) {
			System.out.println(person.getName() + "\t" + person.getKorean()
					+ "\t" + person.getEnglish() + "\t" + person.getMath());
		}
	}

}

class Person {
	private String name;
	private Integer korean;
	private Integer english;
	private Integer math;

	public Person() {
		super();
	}

	public Person(String name, int korean, int english, int math) {
		super();
		this.name = name;
		this.korean = korean;
		this.english = english;
		this.math = math;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getKorean() {
		return korean;
	}

	public void setKorean(int korean) {
		this.korean = korean;
	}

	public Integer getEnglish() {
		return english;
	}

	public void setEnglish(int english) {
		this.english = english;
	}

	public Integer getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", korean=" + korean + ", english="
				+ english + ", math=" + math + "]";
	}
}

class PersonComparator<T> implements Comparator<Person> {
	int option = 0;
	
	public PersonComparator(int option) {
		super();
		this.option = option;
	}

	public int getOption() {
		return option;
	}

	public void setOption(int option) {
		this.option = option;
	}

	public int compare(Person o1, Person o2) {
		switch (option) {
		case 1 :
			return (o2.getKorean().compareTo(o1.getKorean()));
		case 2:
			return (o2.getEnglish().compareTo(o1.getEnglish()));
		case 3:
			return (o2.getMath().compareTo(o1.getMath()));
		default:
			return (o1.getName().compareTo(o2.getName()));
		}		
	}
}