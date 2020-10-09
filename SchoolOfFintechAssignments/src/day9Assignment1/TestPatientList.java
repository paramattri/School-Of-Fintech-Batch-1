package day9Assignment1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.TreeSet;

class Patient implements Comparable<Patient>{
	private int patientId;
	private String name;
	private int age;
	
	public Patient(int patientId, String name, int age) {
		super();
		this.patientId = patientId;
		this.name = name;
		this.age = age;
	}
	

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public int compareTo(Patient o) {
		return this.name.compareTo(o.name);
	}
	
	static int getPatientAge(String patientName, TreeSet<Patient> treeSet) {
		int patientAge = 0;
		for(Patient p : treeSet) {
			if(p.name.equals(patientName)) {
				patientAge = p.age;
			}
		}
		return patientAge;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + patientId;
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Patient other = (Patient) obj;
		if (age != other.age)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (patientId != other.patientId)
			return false;
		return true;
	}
	
}

public class TestPatientList {

	public static void main(String[] args) {
		
		Patient p1 = new Patient(1, "Param", 22);
		Patient p2 = new Patient(2, "Milan", 35);
		Patient p3 = new Patient(3, "Prateek", 26);
		ArrayList<Patient> patients = new ArrayList<Patient>();
		patients.add(p1);
		patients.add(p2);
		patients.add(p3);
		
		Collections.sort(patients);
		for(Patient p : patients) {
			System.out.println("Name: "+p.getName()+" ID: "+p.getPatientId()+" Age: "+p.getAge());
		}
		
		Collections.sort(patients, Comparator.comparing(Patient :: getAge));
		
		ListIterator<Patient> iter = patients.listIterator();
		while(iter.hasNext()) {
			Patient p = iter.next();
			System.out.println("Name: "+p.getName()+" ID: "+p.getPatientId()+" Age: "+p.getAge());
		}
		
		TreeSet<Patient> treeSet = new TreeSet<Patient>();
		treeSet.add(p1);
		treeSet.add(p2);
		treeSet.add(p3);
		
		for(Patient p : treeSet) {
			System.out.println("Name: "+p.getName()+" ID: "+p.getPatientId()+" Age: "+p.getAge());
		}
		
		System.out.println("Age: "+Patient.getPatientAge("Param", treeSet));
		
	}

}
