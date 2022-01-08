package week3.day1.Assignment1_org.system_SingleInheritance;

public class Desktop extends Computer {
	
	public void desktopSize() {
		System.out.println("Prints Desktop Size");

	}

	public static void main(String[] args) {
		Desktop desk = new Desktop();
		desk.computerModel();
		desk.desktopSize();

	}

}
