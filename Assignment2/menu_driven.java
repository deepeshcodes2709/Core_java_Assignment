package assignment2;

import java.util.Scanner;

class StudentDetails{
	int empId;
	String name;
	double Salary;
	
	void acceptData() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Employee ID: ");
		empId = sc.nextInt();
		
		sc.nextLine();
		
		System.out.println("EnterEmployee Name: ");
		name = sc.nextLine();
		
		System.out.println("Enter Salary: ");
		Salary = sc.nextDouble();
	}
	
	void displayData() {
		System.out.println("\n Employee Details");
		System.out.println("Id: "+ empId);
		System.out.println("Name : " + name);
		System.out.println("Salary: "+ Salary);
		
	}
}

public class menu_driven {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		StudentDetails emp = new StudentDetails();
			
		int choice;
			
		do {
			System.out.println("\n=========Employee Menu=======");
			System.out.println("1. Accept Employee Data");
			System.out.println("2. Display Employee Data");
			System.out.println("3. Exit");
			System.out.println("Enter Choice: ");
			
				
			choice = sc.nextInt();
			
			switch(choice) {
				case 1: 
					emp.acceptData();
					break;
					
				case 2:
					emp.displayData();
					break;
				
				case 3:
					System.out.println("Program Exited .....");
				
				default:
					System.out.println("Invalid Choice! ");
			}
			
		}while(choice != 3);	
			
		sc.close();
		
	}
}
