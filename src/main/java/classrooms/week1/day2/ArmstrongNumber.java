package classrooms.week1.day2;

public class ArmstrongNumber {

	public static void main(String[] args) {
		int num = 153;
		int actualnum = num;
		int sum = 0;
		
		while(num!=0) {
			int rem = num%10;
			sum = sum + (rem*rem*rem);
			num = num/10;
		}
		
		if(actualnum == sum) {
			System.out.println(actualnum+" is an Armstrong number");
		}
		else{
			System.out.println(actualnum+" is not an Armstrong number");
		}

	}

}
