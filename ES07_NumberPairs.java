package NumberPairs;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.printf(": ");
		int n=sc.nextInt();
		int S[]=new int[n];
		int Score[][]=new int[8][8];
		
        for (int i = 0; i < S.length; i ++) {
        	S[i]=sc.nextInt();
        }
        
        for (int i = 0; i < S.length-1; i ++) {
        	int x=S[i];
        	int y=S[i+1];
        	Score[x][y]=Score[x][y]+1;
        }
		 for (int i = 0; i < Score.length; i++) {
	            for (int j = 0; j < Score.length; j ++) {
	            	if (Score[i][j]>0) {
	            		System.out.printf("(%d,%d): %d\n",i,j,Score[i][j]);
	            	}
	            	}
	            }
		 sc.close();
	}
}
