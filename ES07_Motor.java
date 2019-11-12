package Motor;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		float input[] = new float[16];
		int count=0;
		int pointer=0;
		
		System.out.printf("Max. 16 Werte eingeben, 0 beendet:\n");
		
		for (int i=0;i<input.length;i++) {
			float x = sc.nextFloat();
			if (x > 0 && x <= 100) {
				input[pointer]=x;
				pointer++;
				count++;
			} else if (x==0 ) {
				i=input.length;
			}
		}
		System.out.printf("Eingelesen: %d\n",count);
		System.out.printf("N: ");
		
		int n=sc.nextInt();
		float sum=0;
		
		if (n>count) {
			System.out.printf("Zu wenige Werte\n");
		} else {
			for (int i=0;i<n;i++) {
				sum=sum+input[i];
			}
			System.out.printf("Wert = %.2f", sum/n);
		}
		
		sc.close();
	}
}
