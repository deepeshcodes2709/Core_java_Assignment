package Assignment3;
import java.util.Scanner;

class ExceptionLineTooLong extends Exception{
	public ExceptionLineTooLong(String message) {
		super(message);
	}
}

public class Program04_E {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		try {
			System.out.println("Enter the string : ");
			String str = sc.nextLine();
			
			int length = str.length();
			
			if(length > 80) {
				throw new ExceptionLineTooLong("The string is too Long");
			}
			
			System.out.println("Length: " + length);
		}catch(ExceptionLineTooLong ex) {
			System.out.println(ex.getMessage());
		}
		sc.close();
		
	}

}
