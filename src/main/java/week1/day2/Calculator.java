package week1.day2;

public class Calculator {
	
	public int add(int num1, int num2) {
		return num1+num2;

	}
	
	public int subtract(int num1, int num2) {
		return num1-num2;

	}
	
	public int multiplication(int num1, int num2) {
		return num1*num2;

	}
	
	public double division(int num1, int num2) {
		return num1/num2;

	}

	public static void main(String[] args) {

		Calculator calc = new Calculator();
		int n1 = 97;
		int n2 = 15;
		
		System.out.println("Sum of two numbers is "+calc.add(n1,n2));
		System.out.println("Subtaction of two numbers is "+calc.subtract(n1,n2));
		System.out.println("Multiplication of two numbers is "+calc.multiplication(n1,n2));
		System.out.println("Division of two numbers is "+calc.division(n1,n2));

	}

}
