package QuickSort;


import java.util.Random;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] a = testData(sc.nextInt(), sc.nextInt(), sc.nextInt());
        quicksort(a);
        for(int j=0; j<a.length; j++)
            System.out.printf(" %02d  ",a[j]);
            System.out.printf("\n");
        sc.close();
    }



    public static int[] testData(int size, int max, int seed) {
        int[] a = new int[size];
        Random r = new Random(seed);
        for (int i = 0; i < a.length; i++)
            a[i] = r.nextInt(max);
        for(int j=0; j<a.length; j++)
            System.out.printf(" %02d  ",a[j]);
            System.out.printf("\n");
        return a;
    }
    public static void swap(int arr[], int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void quicksort(int numbers[], int left, int right) {
        int i;
        if (right <= left)
            return;
        
        i = partition(numbers, left, right);
        quicksort(numbers, left, i - 1);
        quicksort(numbers, i + 1, right);
    }

    /* driver */
    public static void quicksort(int a[]) {
        quicksort(a, 0, a.length - 1);
    }

    public static int partition(int numbers[], int left, int right) {
        int i = left - 1, j = right, pivot = numbers[right];
        for (;;) {
            while (numbers[++i] < pivot)
                ;
            while (pivot < numbers[--j])
                if (j == left)
                    break;
            if (i >= j)
                break;
            swap(numbers, i, j);
            if (left > 0)
            	for(int k=0; k<left; k++)	
            		System.out.printf("  .  ",numbers[k]);
            for(int k=left; k<= right; k++)
            	if (k == i || k == j)
            		System.out.printf("(%02d) ",numbers[k]);
            		else if (k == right)
            		System.out.printf("[%02d] ",numbers[k]);	
            		else
            		System.out.printf(" %02d  ",numbers[k]);
            if (right < numbers.length)
            for(int k=right+1; k<numbers.length; k++)
            	System.out.printf("  .  ",numbers[k]);
                System.out.printf("\n");
        }
        swap(numbers, i, right);
        if (left > 0)
        	for(int k=0; k<left; k++)	
        		System.out.printf("  .  ",numbers[k]);
        for(int k=left; k<=right; k++)
        	if (k == i || k == right)
        		System.out.printf("<%02d> ",numbers[k]);
        	else
            System.out.printf(" %02d  ",numbers[k]);
        if (right < numbers.length)
        	for(int k=right+1; k<numbers.length; k++)	
        		System.out.printf("  .  ",numbers[k]);
        System.out.printf("\n");
        
        return i;
    }
}
