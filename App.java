import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.lang.IllegalArgumentException;
import java.util.InputMismatchException;
import java.io.IOException;

public class App {
	
	public static int factorial(int n, FileWriter fw) throws IOException{
		
//		this is the solution using recursion
		
		if (n<0) {
			throw new IllegalArgumentException("Cannot Calculate Factorial of negative number.");
		} else if (n==0) {
//			if input is zero this is the result
			fw.write("0! = 1\n");
			return 1;
	
		} else {
			
            fw.write(n + "! = ");
            int result = 1;
            for (int i = n; i > 1; i--) {
                result *= i;
                fw.write(i + " x ");
            }
            fw.write("1 = " + result + "\n");
            return result;
		}
		
	}

  public static void main(String[] args){
	  
	  try {
//		  activate scanner and the loop
		  Scanner scan = new Scanner(System.in);
		  boolean validInput = false;
		  int n = 0;
		  
//		  make a new file and overwrite the old file
		  File Factorial = new File("FactorialFile");
		  
//		  let the user remind where the solution goes
		  System.out.println("Reminder!\nThe solution is saves in the FactorialFile on your project folder. ");
		  
		  
//		  loop for wrong value input in the scanner
		  while(!validInput) {
			  
			  try {
//				  this is the user input
				  System.out.print("Enter a Valid Number: ");
				  n = scan.nextInt();
				  validInput = true;
				  
//				  for wrong input
			  } catch (InputMismatchException e) {
				  System.out.println("Invalid Input. Please enter a Valid Number");
				  scan.next();
			  }	  
		  }
		  
//		  make filewriter to write to the file
		  try(FileWriter fw = new FileWriter("FactorialFile.txt")){
		  
//		  is help the error java.io.FileWriter@3d075dc0 to remove
		  int result = factorial(n,fw);
	  
		  System.out.println("The Factorial of " + n + " is " + result);
		  
//		  print for the user to know if the file has the result
		  System.out.println("Result saved to factorial.txt");

		  }
		  
		  //possible negative input
	  } catch (IllegalArgumentException e) {
		  System.out.println("Error: " + e.getMessage());
		  	  
//		  IOEXCEPTION
	  } catch (IOException e) {
		  System.out.println("Error: " + e.getMessage());
		  
		  //other exception
	  } catch (Exception e){
		  System.out.println("An error occured.");
		  e.printStackTrace();
	  }
  }
} 
