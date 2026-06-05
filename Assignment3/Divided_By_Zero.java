package Assignment3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Divided_By_Zero{
	
	public static void division(int numerator, int denominator) {
		double result  = numerator/denominator;
		System.out.println("result: " + result);
	}
	
	public  static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			System.out.println("Enter the numerator: ");
			int numerator = sc.nextInt();
			System.out.println("Enter the Demoinator: ");
			int denominator = sc.nextInt();
			
			division(numerator, denominator);
			}catch(ArithmeticException ex){
				System.out.println("worng input plz enter the above zero number");
			}catch(InputMismatchException ex) {
				System.out.println("worng input");
			}
		System.out.println("Programm End successfully");
	}
	
}
