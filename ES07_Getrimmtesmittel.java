package Getrimmtesmittel;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		double betraege[]=new double[10];
		eingabe(sc, betraege);
		System.out.printf("Untergrenze: ");
		double ug=sc.nextDouble();
		System.out.printf("Obergrenze: ");
		double og=sc.nextDouble(); 

		System.out.printf("Mittel ungetrimmt: %.2f\n",sum(betraege)/10);
		int a=trim(betraege,ug,og);
		System.out.printf("Mittel getrimmt: %.2f\n",sum(betraege)/(10-a));
		sc.close();

	}

	public static void eingabe(Scanner sc, double[] betraege) {
		

		for (int i=0;i<betraege.length;i++) {
			System.out.printf("Zahl %d: ",i+1);
			betraege[i]=sc.nextDouble();
		}
		//sc.close();
	}
	public static double sum(double betraege[]) {
		double sum=0;
		for (int i=0;i<betraege.length;i++) {
			sum=sum+betraege[i];
		}
		return sum;
	}
	public static int trim(double betraege[], double min, double max) {
		int trim=0;
		for (int i=0;i<betraege.length;i++) {
			if (betraege[i]<min||betraege[i]>max) {
				betraege[i]=0;
				trim=trim+1;
			}
		}
		return trim;
	}

}
