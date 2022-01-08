package week3.day1.Classroom3_Overriding_Mobile;

public class AndroidPhone extends SmartPhone {
	
	public void takeVideo() {
		System.out.println("Inside takeVideo");
	}

	public static void main(String[] args) {
		AndroidPhone aph = new AndroidPhone();
		aph.sendMsg();
		aph.makeCall();
		aph.saveContact();
		aph.accessWhatsApp();
		aph.takeVideo();
		
		//to fetch parent takeVideo() method in SmartPhone class
		SmartPhone sph = new SmartPhone();
		sph.takeVideo();

	}

}
