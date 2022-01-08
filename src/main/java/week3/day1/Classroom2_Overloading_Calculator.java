package week3.day1;

public class Classroom2_Overloading_Calculator {
	
	public void add(int a, int b) {
		int sum = a+b;
		System.out.println("Sum of 2 numbers = "+sum);

	}
	
	public void add(int a, int b, int c) {
		int sum = a+b+c;
		System.out.println("Sum of 3 numbers = "+sum);

	}
	
	public void multiply(int a, int b) {
		int mul = a*b;
		System.out.println("Multiplication of 2 numbers = "+mul);

	}
	
	public void multiply(int a, double b) {
		double mul = a*b;
		System.out.println("Multiplication of 2 numbers = "+mul);

	}
	
	public void subtract(int a, int b) {
		int sub = a-b;
		System.out.println("Subtraction of 2 numbers = "+sub);

	}
	
	public void subtract(double a, double b) {
		double sub = a-b;
		System.out.println("Subtraction of 2 numbers = "+sub);

	}
	
	public void divide(int a, int b) {
		int div = a/b;
		System.out.println("Division of 2 numbers = "+div);

	}
	
	public void divide(int a, double b) {
		double div = a/b;
		System.out.println("Division of 2 numbers = "+div);

	}

	public static void main(String[] args) {
		Classroom2_Overloading_Calculator obj = new Classroom2_Overloading_Calculator();
		obj.add(5, 9);
		obj.add(4, 8, 76);
		obj.multiply(6, 78);
		obj.multiply(76, 134.5);
		obj.subtract(23, 8);
		obj.subtract(34.56, 77.87);
		obj.divide(67, 3);
		obj.divide(655, 7.3);

	}

}
