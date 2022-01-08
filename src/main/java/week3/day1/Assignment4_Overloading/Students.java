package week3.day1.Assignment4_Overloading;

public class Students {
	
	public void getStudentInfo() {
		System.out.println("No arguments");

	}
	public void getStudentInfo(int id) {
		System.out.println("One argument - id");

	}
	public void getStudentInfo(int id, String name) {
		System.out.println("Two arguments - id & name");

	}
	public void getStudentInfo(String email, String phonenumber) {
		System.out.println("Two arguments - email & phonenumber");

	}

	public static void main(String[] args) {
		Students student = new Students();
		student.getStudentInfo();
		student.getStudentInfo(7332);
		student.getStudentInfo(7567, "Rani Manasi");
		student.getStudentInfo("rani.m@gmail.com", "7788765200");

	}

}
