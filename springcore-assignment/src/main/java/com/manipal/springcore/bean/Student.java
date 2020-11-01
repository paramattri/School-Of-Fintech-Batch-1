package com.manipal.springcore.bean;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class Student {
	
	private List<String> studentNames;
	private Set<Integer> studentRollNo;
	private Map<Integer, String> studentDetails;
	private Properties studentDetailsProps;
	
	public List<String> getStudentNames() {
		return studentNames;
	}
	public void setStudentNames(List<String> studentNames) {
		this.studentNames = studentNames;
	}
	public Set<Integer> getStudentRollNo() {
		return studentRollNo;
	}
	public void setStudentRollNo(Set<Integer> studentRollNo) {
		this.studentRollNo = studentRollNo;
	}
	public Map<Integer, String> getStudentDetails() {
		return studentDetails;
	}
	public void setStudentDetails(Map<Integer, String> studentDetails) {
		this.studentDetails = studentDetails;
	}
	public Properties getStudentDetailsProps() {
		return studentDetailsProps;
	}
	public void setStudentDetailsProps(Properties studentDetailsProps) {
		this.studentDetailsProps = studentDetailsProps;
	}
	
	@Override
	public String toString() {
		return "Student [studentNames=" + studentNames + ", studentRollNo=" + studentRollNo + ", studentDetails="
				+ studentDetails + ", studentDetailsProps=" + studentDetailsProps + "]";
	}
	
}
