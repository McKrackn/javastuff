package Eratosthenes;


import java.util.Scanner;



public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 
		System.out.printf(": ");
		int n = sc.nextInt();
		int a[]= new int[n];
		int k = 1;
		for (int i = 0; i < n - 1; i++) {
			a[i] = i+2;
		}
		for (int i = 0; i < n; i++) {
			for ( int j = i+1; j < n; j++) {
				if ( a[i] == 1) 
					continue;
				else {
					if (a[j] % a[i] == 0){
						a[j] = 1;
					}
				}
			}
		}
		for (int i = 0; i < n; i++) {
			if (a[i] != 1) {
				System.out.printf("%d ", a[i]);
				k++;
				if (k == 11) {
					k = 1;
					System.out.printf("\n");
				}
					}
		}
		
		sc.close();
	}
}
