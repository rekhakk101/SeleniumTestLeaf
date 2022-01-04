package week1.day2;

import java.util.Scanner;

public class NegativeToPositiveConversion {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter a Negative number");
		
		int num = scan.nextInt();
		
		if(num<0) {
			int result = num + (num*(-2));
			System.out.println("The number "+num+" is converted to "+result);
		}else if(num==0){
			System.out.println(num+" is neither Positive nor Negative");
		}else {
			System.out.println(num+" is a Positive number. Please enter a Negative number");
		}

	}

}
