package ArrayWalker;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char world[][]=new char[10][10];
		int x=0;
		int y=0;
		int cmd=0;
		char cutie='A';
		boolean valid=false;
		
		for (int i=0;i<10;i++) {
			Arrays.fill(world[i],'.');
		}
		
		while (cmd!=5) {
			
			world[x][y]=cutie;
			
			if (cutie=='Z') {
				cutie='A';
			} else {
				cutie++;
			}
			
			for (int i = 0; i < world.length; i++) {
	            for (int j = 0; j < world.length; j ++) {
	            		System.out.print(world[i][j]);
	            	}
	            System.out.println();
	            }
			valid=false;
	            
			while (valid == false) {
				
				System.out.printf("Enter direction command: ");
				cmd=sc.nextInt();
	            System.out.println();

				if (cmd == 8) {
					if(x>0 && world[x-1][y]=='.') {
						x--;
						valid=true;
					} else { System.out.printf("You cannot go there!\n"); }
					
				} else if (cmd == 2) {
					if(x<world.length && world[x+1][y]=='.') {
						x++;
						valid=true;
					} else { System.out.printf("You cannot go there!\n"); }
					
				} else if (cmd == 4) {
					if(y>0 && world[x][y-1]=='.') {
						y--;
						valid=true;
					} else { System.out.printf("You cannot go there!\n"); }
				} else if (cmd == 6) {
					if(y<world.length && world[x][y+1]=='.') {
						y++;
						valid=true;
					} else { System.out.printf("You cannot go there!\n"); }
				}
				else if (cmd == 5) {
					valid=true;
				}
			}
		}
		
		
		sc.close();
	}
}
