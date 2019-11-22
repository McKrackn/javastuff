package HundredDoors;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        System.out.printf(": ");
		int a=sc.nextInt();
		boolean doors[]=new boolean[a+1];
				
		 for (int i = 1; i < doors.length; i++) {
	            for (int j = i; j < doors.length; j += i) {
	                doors[j] = !doors[j];
	            }
	        }
	 
	        for (int i = 0; i < doors.length; i++) {
	            if (doors[i]) {
	                System.out.printf("\n%d "+doors[i], i);
	            }
	        }
			sc.close();

		}

	}


