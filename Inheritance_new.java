package Assignment;

class Employee{
	String Employee_name = "Nikhil Suthar";
	
	void display() {
		System.out.println("Employee_Name: " + Employee_name);
	}
}

class Manager extends Employee{
	String Department = "IT Department";
	
	void show() {
		System.out.println("departemt: " + Department);
	}
}

public class Inheritance_new {

	public static void main(String[] args) {
		Manager M = new Manager();
		
		M.display();
		M.show();
		
	}

}
