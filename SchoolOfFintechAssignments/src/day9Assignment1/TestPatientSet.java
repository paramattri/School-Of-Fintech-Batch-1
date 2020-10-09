package day9Assignment1;

import java.util.LinkedHashSet;

public class TestPatientSet {

	public static void main(String[] args) {
		
		Patient p1 = new Patient(1, "Param", 22);
		Patient p2 = new Patient(2, "Milan", 35);
		Patient p3 = new Patient(1, "Param", 22);

		LinkedHashSet<Patient> patients = new LinkedHashSet<Patient>();
		patients.add(p1);
		patients.add(p2);
		patients.add(p3);
		
		System.out.println("Size of the Set: "+patients.size());
		for(Patient p : patients) {
			System.out.println("Name: "+p.getName()+" ID: "+p.getPatientId()+" Age: "+p.getAge());
		}
	}

}
