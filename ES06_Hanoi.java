package Hanoi;

import java.util.Scanner;

public class Main {

	static int move(int n, String from_rod, String to_rod, String temp_rod, int i) {

		if (n == 1) {
			abstand(i);
			System.out.printf("--> Moving disk 1 from rod " + from_rod + " to rod " + to_rod+"\n");
			return 1;
		}
		int count1=towersOfHanoi(n - 1, from_rod, temp_rod, to_rod, i);
		abstand(i);
		System.out.println("--> Moving disk " + n + " from rod " + from_rod + " to rod " + to_rod);
		int count2=towersOfHanoi(n - 1, temp_rod, to_rod, from_rod, i);
		return count1+count2; 
	}
	static int towersOfHanoi(int n, String from_rod, String to_rod, String temp_rod, int i) {
		abstand(i);
		i++;
		System.out.printf("towersOfHanoi(" + n +", " + from_rod+", " + to_rod + ") {\n");
		int count=move(n, from_rod, to_rod, temp_rod, i);
		i--;
		abstand(i);
		System.out.printf("}\n");
		return count;
	}

	public static void abstand (int i) {
		int k = 0;
		while (k < i) {
			System.out.printf("  ");
			k++;
		}
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.printf("discs: ");
		int n = sc.nextInt();
		System.out.println();
		System.out.printf("%d move(s) in total.\n", towersOfHanoi(n, "A", "C", "B", 0)*2-1);
		sc.close();
	}
}
