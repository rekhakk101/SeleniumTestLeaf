package week3.day1.Assignment2_org.student;

import week3.day1.Assignment2_org.department.Department;

public class Student extends Department {
	
	public void studentName() {
		System.out.println("Inside studentName");

	}
	public void studentDept() {
		System.out.println("Inside studentDept");

	}
	public void studentId() {
		System.out.println("Inside studentId");

	}

	public static void main(String[] args) {
		Student student = new Student();
		student.collegeName();
		student.collegeCode();
		student.collegeRank();
		student.deptName();
		student.studentName();
		student.studentDept();
		student.studentId();

	}

}
