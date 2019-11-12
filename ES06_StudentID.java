package StudentID;


import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
	

	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("enter studentID (wi**b***): ");
		String studID = sc.next();
		System.out.printf("ID valid: %s\n", validate(studID));
		System.out.printf("graduation in: %d\n", graduation(studID));
		sc.close();
	}

	public static boolean validate(String studID) {
		boolean val = Pattern.matches("wi[0-9]{2}b[0-9]{3}", studID);
		return val;
	}
	
	public static int graduation(String studID) {
		int year;
		if (Pattern.matches("wi[0-9]{2}b[0-9]{3}", studID) == false) {
			year=-1;
		} else {
			year=Integer.parseInt(studID.substring(2,4))+2003;
		}
		return year;
	}
}