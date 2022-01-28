package week3.day2.Assignment1_Abstraction;

public class Automation extends MultipleLangauge implements Language, TestTool {

	@Override
	public void ruby() {
		System.out.println("I am inside ruby() method");

	}

	public void Selenium() {
		System.out.println("I am inside Selenium() method");

	}

	public void Java() {
		System.out.println("I am inside Java() method");

	}

	public static void main(String[] args) {
		Automation a = new Automation();
		a.Java();
		a.Selenium();
		a.python();
		a.ruby();

	}

}
