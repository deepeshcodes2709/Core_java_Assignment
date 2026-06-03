package assignment2;

import java.util.Scanner;

class Student{
	int rollNo;
	String name;
	double marks;
	
	void acceptData(){
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter Roll_no: ");
		rollNo = sc.nextInt();
		
		sc.nextLine();
		
		System.out.println("Enter Name: ");
		name = sc.nextLine();
		
		System.out.println("Enter marks: ");
		marks = sc.nextDouble();
	}
	
	void displayData(){
		System.out.println("\n ======Student Details ========");
		System.out.println("rollNumber : " +rollNo);
		System.out.println("Name: " + name);
		System.out.println("marks: "+ marks);	
		
		
	}
	
	void calculateGrade() {
		if(marks >= 70) {
			System.out.println("Grade A");
		}else if(marks >= 60 && marks <= 74){
			System.out.println("Grade B");
		}else if(marks >= 50 && marks <= 59){
			System.out.println("Grade c");
		}else{
			System.out.println("FAIL");
		}
	}
}
	
	
public class menu_deiven_marksheet{
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Student S = new Student();
		
		int choice;
		
		do {
			System.out.println("\n ======Student Deatils =========");
			System.out.println("1. Accept Student Details");
			System.out.println("2. Display Student details");
			System.out.println("3. Student marks calculate Grade");
			System.out.println("4. Exit");
			System.out.println("Enter choice: ");
			
			choice = sc.nextInt();
			
			switch(choice) {
			case 1:
				S.acceptData();
				break;
				
			case 2:
				S.displayData();
				break;
				
			case 3:
				S.calculateGrade();
				break;
				
			case 4: 
				System.out.println("Program Exited....");
				
			default:
				System.out.println("Invalid Choice!");
			}
			
		}while (choice != 4);
		
		sc.close();
	}

}
