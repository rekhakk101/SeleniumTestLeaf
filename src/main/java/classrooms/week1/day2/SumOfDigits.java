package classrooms.week1.day2;

public class SumOfDigits {

	public static void main(String[] args) {
		int num = 5467;
		int actualnum = num;
		int sum = 0;
		
		while(num!=0) {
			int rem = num%10;
			sum = sum + rem;
			num = num/10;
		}
		
		System.out.println("Sum of digits of "+actualnum+" is "+sum);

	}

}
