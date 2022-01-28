package week3.day2.Classroom1_Inheritance;

public class Desktop implements Software {

	public void hardwareResources() {
		System.out.println("Inside hardwareResources");
	}

	public void softwareResources() {
		System.out.println("Inside softwareResources");
	}

	public static void main(String[] args) {
		Desktop desktop = new Desktop();
		desktop.hardwareResources();
		desktop.softwareResources();
	}

}
