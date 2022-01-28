package week3.day2.Classroom2_AbstractClass;

public class College extends University {

	public void ug() {
		System.out.println("Inside ug method");
	}

	public static void main(String[] args) {
		College college = new College();
		college.pg();
		college.ug();

	}

}
