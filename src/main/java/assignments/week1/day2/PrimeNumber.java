package assignments.week1.day2;

public class PrimeNumber {

	public static void main(String[] args) {
		int num = 13;
		boolean flag = true;
		
		if(num==1) {
			System.out.println(num+" is not a Prime number");
		}
		
		for(int i=2; i<=num/2; i++) {
			if(num%i==0) {
				flag = false;
				break;
			}
		}
		
		if(flag) {
			System.out.println(num+" is a Prime number");
		}else {
			System.out.println(num+" is not a Prime number");
		}

	}

}
