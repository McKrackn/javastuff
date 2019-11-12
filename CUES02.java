package Jahressaldo;


import java.util.Scanner;



public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 
		int month=1;
		double value=0;
		double valuemin;
		double valuemax;
		double sumvalue=0;
		
		System.out.printf("Monat %d: ", month);
		value = sc.nextDouble();
		if (value==0) {
			System.out.printf("Nullsummenspiel.\n");
		}  
		valuemin=value;
		valuemax=value;
		sumvalue=sumvalue+value;
		month=month+1;
		
		while (month<=12) {
			if (value < valuemin) {
				valuemin=value;
					}
			
			if (value > valuemax) {
				valuemax=value;
					}
				
			System.out.printf("Monat %d: ", month);
			value = sc.nextDouble();
			if (value==0) {
				System.out.printf("Nullsummenspiel.\n");
			} 
			month=month+1;
			sumvalue=sumvalue+value;
			
			
		}
		System.out.printf("Jahressaldo: %.2f\n", sumvalue);
		System.out.printf("Groesster Saldo: %.2f\n", valuemax);
		System.out.printf("Niedrigster Saldo: %.2f\n", valuemin);


		sc.close();
	}
}
