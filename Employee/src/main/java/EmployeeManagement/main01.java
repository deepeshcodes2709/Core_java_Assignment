package EmployeeManagement;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class main01 {
	private static int empId;

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
//		try {
//			EmployeeDAOImpl dao = new EmployeeDAOImpl();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		EmployeeDAOImpl dao = new EmployeeDAOImpl();
		
		
		while (true) {
			System.out.println("\n===== Employee Management System =====");

			System.out.println("1.Add Employee");
			System.out.println("2.Update Employee");
			System.out.println("3.Delete Employee");
			System.out.println("4.Search Employee");
			System.out.println("5.Display All Employees");
			System.out.println("6.Exit");

			int choice = sc.nextInt();

			
			switch (choice) {
			case 1:

				System.out.print("Enter Id : ");
				int id = sc.nextInt();

				sc.nextLine();

				System.out.print("Enter Name : ");
				String name = sc.nextLine();

				System.out.print("Enter Department : ");
				String dept = sc.nextLine();

				System.out.print("Enter Salary : ");
				double sal = sc.nextDouble();

				Employee emp = new Employee(id, name, dept, sal);

				List<Employee>list=new ArrayList<>();
			list.add(emp);
			dao.save(emp);
			
			

				break;
				
			case 2:

			    System.out.print("Enter Employee Id : ");
			    int uid = sc.nextInt();

			    sc.nextLine();

			    System.out.print("Enter New Name : ");
			    String uname = sc.nextLine();

			    System.out.print("Enter New Department : ");
			    String udept = sc.nextLine();

			    System.out.print("Enter New Salary : ");
			    double usal = sc.nextDouble();

			    Employee updateEmp =
			            new Employee(uid, uname, udept, usal);

			    dao.update(updateEmp);

			    break;
 

			 case 3:

			        System.out.print("Enter Employee Id : ");
			        int deleteId = sc.nextInt();

			        dao.delete(deleteId);

			        break;
			        
			 case 4:

				    System.out.print("Enter Employee Id : ");

				    int searchId = sc.nextInt();

				    dao.search(searchId);

				    
				    break;
		    
			 case 5:

				    List<Employee> employees = dao.displayAll();

				    for(Employee e : employees) {

				        System.out.println(
				                e.getempId() + " "
				              + e.getempName() + " "
				              + e.getdepartment() + " "
				              + e.getsalary());
				    }

				    break;
				    
			case 6:
				System.exit(0);
				System.out.println("EXit");
			}

		}

	}

}
