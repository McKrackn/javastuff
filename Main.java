package ArrayWalkerUndoRedo;

import java.util.Arrays;
import java.util.Scanner;



public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char world[][]=new char[10][10];
		int x=0;
		int y=0;
		int a=0;
		int cmd=0;
		int lastcmd=0;
		char cutie='A';
		boolean valid=false;
		
		CustomStack<Integer> turns = new CustomStack<>();
		
		for (int i=0;i<10;i++) {
			Arrays.fill(world[i],'.');
		}
		
		while (cmd!=5) {
			
			if (cmd!=7) {
				world[x][y]=cutie;
				
				if (cutie=='Z') {
					cutie='A';
				} else {
					cutie++;
				}
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
				if (cmd!=7) {
					lastcmd=cmd;	
				}
				cmd=sc.nextInt();
	            System.out.println();
	            
	            if (cmd == 9) {
	            	if (lastcmd==0) {
	            		System.out.printf("Nothing to redo!\n");
	            	}cmd=lastcmd;
				}
	            if (cmd == 8) {
					if(x>0 && world[x-1][y]=='.') {
						x--;
						valid=true;
						turns.push(cmd);
					} else { System.out.printf("You cannot go there!\n"); }
					
				} else if (cmd == 2) {
					if(x<world.length-1 && world[x+1][y]=='.') {
						x++;
						valid=true;
						turns.push(cmd);
					} else { System.out.printf("You cannot go there!\n"); }
					
				} else if (cmd == 4) {
					if(y>0 && world[x][y-1]=='.') {
						y--;
						valid=true;
						turns.push(cmd);
					} else { System.out.printf("You cannot go there!\n"); }
				} else if (cmd == 6) {
					if(y<world.length-1 && world[x][y+1]=='.') {
						y++;
						valid=true;
						turns.push(cmd);
					} else { System.out.printf("You cannot go there!\n"); }
				} else if (cmd == 7) {
					world[x][y]='.';
					if (turns==null) {
						System.out.println("Nothing to undo!");
					} else {
						a=turns.pop();
					}					

					if(a==8) {
						x++;
					} else if (a==2) {
						x--;
					} else if (a==4) {
						y++;
					} else if (a==6) {
						y--;
					}
					valid=true;
					cutie--;
				} 
				else if (cmd == 5) {
					valid=true;
				}
			}
		}
		//System.out.println(turns);

		sc.close();
	}
}
