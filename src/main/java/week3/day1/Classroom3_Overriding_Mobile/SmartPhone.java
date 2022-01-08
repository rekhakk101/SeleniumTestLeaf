package week3.day1.Classroom3_Overriding_Mobile;

public class SmartPhone extends Mobile {
	
	public void accessWhatsApp() {
		System.out.println("Inside accessWhatsApp");
	}
	
	public void takeVideo() {
		System.out.println("Inside takeVideo_SmartPhone class");
	}

	public static void main(String[] args) {
		SmartPhone sph = new SmartPhone();
		sph.sendMsg();
		sph.makeCall();
		sph.saveContact();
		sph.accessWhatsApp();

	}

}
