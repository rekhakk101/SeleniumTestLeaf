package week3.day1.Assignment3_Overriding;

public class AxisBank extends BankInfo{
	
	public void deposit() {
		System.out.println("Inside deposit_AxisBank");

	}

	public static void main(String[] args) {
		AxisBank axis = new AxisBank();
		axis.saving();
		axis.fixed();
		axis.deposit();

	}

}
