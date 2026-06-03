package assignment2;

import java.util.Scanner;

public class GenerateBill {

	public static void main(String[] args) {
		int qty;
		int Bill;
		double TotalBill = 0;

		
		Scanner sc = new Scanner(System.in);
		
		int choice;
		
		do {
			System.out.println("\n ======= Generated Bill =====");
			System.out.println("1. Dosa Price   ----  30 " );
			System.out.println("2. Samosa Price ----  20");
			System.out.println("3. Idli price   ----  30");
			System.out.println("4.Generate bill..");
			System.out.println("Enter choice: ");
			
			choice = sc.nextInt();
			
			switch (choice) {
			case 1:
				System.out.println("Dosa price 30 rupees enter quantity: ");
				qty = sc.nextInt();
				Bill=qty*30;
				TotalBill+=Bill;
				break;
				
			case 2:
				System.out.println("Samosa price 20 rupees enter quantity: ");
				qty = sc.nextInt();
				Bill=qty*20;
				TotalBill+=Bill;

				break;
				
			case 3:
				System.out.println("Idli price 30 rupess enter quantity: ");
				qty = sc.nextInt();
				Bill=qty*30;
				TotalBill+=Bill;

				break;
				
				
			case 4: 
				System.out.println("Generated Bill: " +TotalBill);
				break;
			}	
		}while(choice != 3);
		
		sc.close();
		}

}
