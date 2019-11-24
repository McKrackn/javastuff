package InsertionSort;


import java.util.Random;
import java.util.Scanner;



public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] a = testData(sc.nextInt(), sc.nextInt(), sc.nextInt());
		//int[] a = testData(8,99,0);
		for (int i = 0; i < a.length; i++) {
			System.out.printf(" %02d  ", a[i]); }
		System.out.println();
		insertion(a);
		for (int i = 0; i < a.length; i++) {
			System.out.printf(" %02d  ", a[i]); }
		System.out.println();
		sc.close();
	}
	
	public static int[] testData(int size, int max, int seed) {
		int[] a = new int[size];
		Random r = new Random(seed);
		for (int i = 0; i < a.length; i++)
			a[i] = r.nextInt(max);
		return a;
	}
	
	public static void insertion(int numbers[]) {
		int tmp=0;
		/* i is the first idx of unsorted partition */
		for (int i = 1; i < numbers.length; i++) {
			int j = i;
			/* tmp holds value of next element to insert */
			int oldtmp=tmp;
			tmp = numbers[i];
			
			for (int y = 0; y < numbers.length; y++) {
				
				 if (y==i-1) {
					 	System.out.printf(" %02d| ", numbers[y]); 
					 } else if (numbers[y] == oldtmp &&y<i && numbers[y] != numbers[y+1]){
						 System.out.printf("(%02d) ", numbers[y]); 
					 } else if (y>i){
						 System.out.printf("  .  ");
					 } else if (y==i){
						 System.out.printf(" %02d  ", numbers[j]);
					 } else {
						 System.out.printf(" %02d  ", numbers[y]); }				
			}
			
			/* find correct position for tmp */
			while (j > 0 && tmp < numbers[j - 1]) {
				/* on the way there shift right */
				numbers[j] = numbers[j - 1];

				j--;
			}
			numbers[j] = tmp;
			System.out.println();
			
			if (i == numbers.length - 1) {
				for (int y = 0; y < numbers.length; y++) {
					if (y == numbers.length - 1) {
						System.out.printf(" %02d| ", numbers[y]);
					} else if (y == j && y < i) {
						System.out.printf("(%02d) ", numbers[y]);
					} else if (y > i) {
						System.out.printf("  .  ");
					} else {
						System.out.printf(" %02d  ", numbers[y]);
					}
				}
				System.out.println();
			}
		}
	}

}
