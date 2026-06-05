package Assignment3;

import java.util.Scanner;

class InvalidAgeException extends Exception{
	public InvalidAgeException (String message) {
		super(message);
	}
}

public class Student_E {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		try {
			System.out.println("Enter the Age: ");
			int age = sc.nextInt();		
			
			if(age < 18) {
				throw new InvalidAgeException(" plz enetr the age is less than 18");	
			}
			
			System.out.println("your age : " + age);
		}catch(InvalidAgeException e) {
			System.out.println(e.getMessage());
		}
		
		sc.close();
	}

}
