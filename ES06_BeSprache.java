package BeSprache;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 
		String a=sc.nextLine();
		String aLower=a.toLowerCase();
		String aBe=aLower.replaceAll("([aeiouäöü])", "$1b$1");

		System.out.printf("%s\n", aLower);
		System.out.printf("%s\n", aBe);

		sc.close();
	}
}
