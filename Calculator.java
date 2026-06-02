package Assignment;

class operation{
	
	void Multiply(int a, int b) {
		System.out.println("Multiply two intiger number: " + (a * b));
	}
	
	void Multiply(int a, int b, int c) {
		System.out.println("Multiply three intiger number: " + (a * b * c));
	}
	
	void Multiply(double a, double b) {
		System.out.println("Multiply double number: " + (a * b));
	}
	
}

public class Calculator {

	public static void main(String[] args) {
		
		operation O = new operation();
		
		O.Multiply(10,20);
		O.Multiply(10,20,30);
		O.Multiply(10,20);
	}
}
