package week1.day1;

public class Mobile {
	
	//Global Variables
	String mobileModel = "Samsung";
	int mobileWeight = 100;
	boolean isFullCharge = true;
	double mobileCost = 35900.77; 

	private void makeCall() {
		System.out.println("Inside makeCall() method");

	}
	
	private void sendMsg() {
		System.out.println("Inside sendMsg() method");

	}

	public static void main(String[] args) {
		Mobile obj = new Mobile();
		
		obj.makeCall();
		obj.sendMsg();
		
		System.out.println("Mobile Model: "+obj.mobileModel);
		System.out.println("Mobile Weight: "+obj.mobileWeight);
		System.out.println("Fully Charged: "+obj.isFullCharge);
		System.out.println("Mobile Cost: "+obj.mobileCost);

	}

}
