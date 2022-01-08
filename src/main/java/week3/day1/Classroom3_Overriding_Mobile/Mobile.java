package week3.day1.Classroom3_Overriding_Mobile;

public class Mobile {
	
	public void sendMsg() {
		System.out.println("Inside sendMsg");
	}
	
	public void makeCall() {
		System.out.println("Inside makeCall");
	}
	
	public void saveContact() {
		System.out.println("Inside saveContact");
	}

	public static void main(String[] args) {
		Mobile mob = new Mobile();
		mob.sendMsg();
		mob.makeCall();
		mob.saveContact();

	}

}
