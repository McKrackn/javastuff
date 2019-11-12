package PartyHandshake;

import java.util.Scanner;

public class Main {
	static Scanner sc;
	public static void main(String[] args) {

		sc = new Scanner(System.in); 
		System.out.printf(": ");
		int n = sc.nextInt();
		String[] names = readNames(sc, n);
		String[] handshakes = handShakes(names);
		print(handshakes);
		sc.close();
	}
	public static String[] readNames(Scanner sc, int n) {
		String names[]=new String[n];
		for (int i=0;i<n;i++) {
			names[i]=sc.next();
		}
		return names;
	}
	
	public static String[] handShakes(String[] names) {
		String handshakes[]=new String[add(names.length)];
		int k=0;

		 for (int i = 0; i < names.length; i++) {
	            for (int j = i; j < names.length; j ++) {
	            	if (i!=j) {
	            		handshakes[k]=names[i]+" -> "+names[j];
	            		k++;
	            		//System.out.printf("\ni: %d, j: %d, test: %d    "+names[i]+" -> "+names[j], i,j-1,i*(names.length-1)+(j-1));
	            	}
	            }
	        }
		 return handshakes;
	}
	
	public static void print(String[] stra) {
		for (int i=0;i<stra.length;i++) {
			System.out.println(stra[i]);
		}
	}
	
	public static int add(int value){
		return (value * (value - 1)) / 2;
	}
}