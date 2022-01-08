package week3.day1.Classroom1_MultilevelInheritance;

public class SmartPhone extends Mobile {
	
	public void accessWhatsApp() {
		System.out.println("Inside accessWhatsApp");
	}

	public static void main(String[] args) {
		SmartPhone sph = new SmartPhone();
		sph.sendMsg();
		sph.makeCall();
		sph.saveContact();
		sph.accessWhatsApp();

	}

}
