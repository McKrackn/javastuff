package SortIndex;


import java.util.Random;
import java.util.Scanner;



public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int[] a = testData(sc.nextInt(), sc.nextInt(), sc.nextInt());

        print(a);
        int[] idx = sort(a);
        print(a);
        print(idx);
        sc.close();

    }

    public static void print(int[] a) {
        System.out.print("[");
        for (int n : a)
            System.out.printf("%d ", n);
        System.out.println("]\n");
    }

    public static int[] testData(int size, int max, int seed) {
        int[] a = new int[size];
        Random r = new Random(seed);
        for (int i = 0; i < a.length; i++)
            a[i] = r.nextInt(max);
        return a;
    }
    public static int[] sort(int numbers[]) {
		int tmp=0;
		int[] index=new int[numbers.length];
		int[] numbers_old=new int[numbers.length];
		for (int i = 0; i < numbers.length; i++) {
			numbers_old[i]=numbers[i];
		}
		/* i is the first idx of unsorted partition */
		for (int i = 1; i < numbers.length; i++) {
			int j = i;
			/* tmp holds value of next element to insert */
			tmp = numbers[i];

			/* find correct position for tmp */
			while (j > 0 && tmp < numbers[j - 1]) {
				/* on the way there shift right */
				numbers[j] = numbers[j - 1];		
				j--;
			}
			numbers[j] = tmp;
		}

		for (int i = 0; i < numbers.length; i++) {
			for (int j = 0; j < numbers_old.length; j++) {
			if (numbers_old[j]==numbers[i]) {
				index[i]=j;
				numbers_old[j]=-1;
				j=numbers_old.length;
				}
			}
		}
		return index;
	}

}
