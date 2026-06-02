package Assignment;


class Animal{
	void display() {
		System.out.println("Animal makes sound");
	}
}

class Dog extends Animal{
	@Override
	void display() {
		System.out.println("Dog barks");
	}
}

public class Overrideing {

	public static void main(String[] args) {
		Dog D = new Dog();
		
		D.display();

	}

}
