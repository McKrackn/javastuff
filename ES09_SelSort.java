package SelSort;


import java.util.Arrays;
import java.util.Scanner;



public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 
        int[] elements = new int[10];
    	System.out.printf("Enter numbers: ");
        int a=sc.nextInt();
        int counter=0;
        
        while (a>0) {
        	elements[counter]=a;
        	counter++;
        	a=sc.nextInt();
        	
        	if (counter == elements.length-1) {
                //ensureCapacity(elements);
                elements = Arrays.copyOf(elements, elements.length*2);
            }

        }
        selection_sort(elements,counter);
		sc.close();
	}
	
	public static void ensureCapacity(int elements[]) {
        int newSize = elements.length * 2;
        elements = Arrays.copyOf(elements, newSize);
    }
	
	public static int reverse_addition(int n) {
		if (n<=1) return n;
		int sum=n+reverse_addition(n-1);
		return sum;
	}
	
	public static void selection_sort(int a[], int N){
		int i, j, min, t;
		for (i = 0; i < N - 1; i++) {
			min = i;
			for (j = i + 1; j < N; j++) { // Suche kleinstes El.
				if (a[j] < a[min])
					min = j; // merke Position des kleinsten El.
			}
	    	System.out.printf("\nStep %d: ",i+1);
			for (int y = 0; y < N ; y++) {
				if (y==min && y==i) {System.out.printf("[(%d)] ", a[y]);}
				else if (y==i) {System.out.printf("(%d) ", a[y]);}
				else if (y==min) {System.out.printf("[%d] ", a[y]);}
				else if (a[y]>0) {System.out.printf("%d ", a[y]);}
			}

			t = a[min]; // Tausch
			a[min] = a[i];
			a[i] = t;
		}
		System.out.printf("\nResult: ");
        for (int n : a)
            if (n>0) {System.out.printf("%d ", n);}
        System.out.println();
        System.out.println();
		System.out.printf("Number of comparisons: %d\n",reverse_addition(N-1));
		System.out.printf("Number of swaps: %d",N-1);
	}
}
