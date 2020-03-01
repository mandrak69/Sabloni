package razno;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

class Person05 implements Comparable<Person05>{
	private String firstname;
	private String lastname;
	private int age;
	
	public Person05(String firstname, String lastname, int age) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.age = age;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public boolean equals(Object obj) {
		System.out.println("Call...");
		if (!(obj instanceof Person05)) return false;
		
		Person05 person=(Person05) obj;

		return (person.getFirstname().equals(this.getFirstname() ))
				&& (person.getLastname().equals(this.getLastname())) ;
		
	}
	public String toString() {
		return "Person04 [firstname=" + firstname + ", lastname=" + lastname
				+ ", age=" + age + "]";
	}
	@Override
	public int compareTo(Person05 person) {	
		return this.getAge()-person.getAge();
	}
	
	
}

class SortByAge implements Comparator<Person05>{

	@Override
	public int compare(Person05 arg0, Person05 arg1) {
		return arg0.getAge()-arg1.getAge();
	}
	
}
public class ComparableCompare {

	public static void main(String[] args) {
		List<Person05> list = new ArrayList<Person05>(){
			{
				add(new Person05("Pera", "Peric", 12));
				add(new Person05("Laza", "Lazic", 67));
				add(new Person05("Zika", "Zikic", 12));
				add(new Person05("Dejan", "Denic", 5));
			}
		};
		
		System.out.println(list);
		Person05 person04=new Person05("Ana", "Anic", 24);
		list.add(person04);
		System.out.println(list);
		
		//obrisi osobu: person04
		//list.remove(person04);
		list.remove(new Person05("Ana", "Anic", 24));
		System.out.println("Nakon brisanje Ane..");
		System.out.println(list);
		
		for (Person05 person : list) {
			System.out.println(person);
		}
		//sortiraj listu osoba
		//Collections.sort(list);
		//sortiranje preko komparatatora
		Collections.sort(list,new SortByAge() );
		
		System.out.println("Nakon sortiranja..");
		for (Person05 person : list) {
			System.out.println(person);
		}
		
		
		

	}

}
