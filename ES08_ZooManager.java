package ZooManager;

import java.util.Scanner;

public class Main {

//your code here

	public static void read(float values[]) {
		for (int i=0;i<values.length;i++) {
			System.out.printf("v: ");
			values[i]=sc.nextFloat();
			if (values[i]==0)
				break;
		}
	}

	public static void print(float values[]) {
		System.out.printf("{ ");
		for (int i=0;i<values.length;i++) {
			if (values[i]==0) {
				break;
			}
			System.out.printf("%.2f ",values[i]);
		}
		System.out.printf("}");
	}
	
	public static int count(float values[]) {
		int count=0;
		for (int i=0;i<values.length;i++) {
			if (values[i]==0) {
				break;
			}
			count++;
		}
		return count;
	}
	
	public static void clear(float values[]) {
		for (int i=0;i<values.length;i++) {
			values[i]=0;
		}
	}
	
	public static float avg(float values[]) {
		float sum=0;
		for (int i=0;i<values.length;i++) {
			sum=sum+values[i];
			}
		return sum/count(values);
	}
	
	public static float b_of_max_a(float a[], float b[]) {
		float max=0;
		int idx=0;
		if (a.length==0) {
			return -1;
		} else {
		for (int i=0;i<a.length;i++) {
			if (a[i]>max) {
				max=a[i];
				idx=i;
			}
		}
		if (b[idx]==0) {
			return -1;
		} else {
			return b[idx];
		}
		}
	}

/************* DONT TOUCH THIS *************/

    public static void printMenu() {
        System.out.printf("-------------------------\n");
        System.out.printf("1: Gewicht erfassen\n");
        System.out.printf("2: Groesze erfassen\n");
        System.out.printf("3: Ausgeben\n");
        System.out.printf("4: Angaben pruefen\n");
        System.out.printf("5: Loeschen\n");
        System.out.printf("6: Durchschn. Gewicht\n");
        System.out.printf("7: Durchschn. Groesze\n");
        System.out.printf("8: Groesze des Schwersten\n");
        System.out.printf("9: Gewicht des Groesten\n");
        System.out.printf("0: Beenden\n");
        System.out.printf("-------------------------\n");
    }

    public static int readMenu() {
        int m;
        System.out.printf(": ");
        // scanf("%d", &m);
        m = sc.nextInt();
        return m;
    }

    // #define N 8
    private static final int N = 8;
    private static Scanner sc;

    public static void main(String[] args) {

        sc = new Scanner(System.in);

        float[] weight = new float[N];
        float[] length = new float[N];
        int w, l;

        System.out.printf("ZooManager 2.0\n");
        System.out.printf("==============\n\n");
        printMenu();

        while (true) {
            switch (readMenu()) {
            case 0:
                sc.close();
                return;
            case 1:
                read(weight);
                break;
            case 2:
                read(length);
                break;
            case 3:
                System.out.printf("Gewicht: ");
                print(weight);
                System.out.printf("\nGroesze: ");
                print(length);
                System.out.printf("\n");
                break;
            case 4:
                w = count(weight);
                l = count(length);
                System.out.printf("Anzahl: %d/%d\n", w, l);
                if (w != l) {
                    System.out.printf("Ungueltig\n");
                } else {
                    System.out.printf("OK\n");
                }
                break;
            case 5:
                clear(weight);
                clear(length);
                break;
            case 6:
                System.out.printf("Durchschn. Gewicht: %.2f\n", avg(weight));
                break;
            case 7:
                System.out.printf("Durchschn. Groesze: %.2f\n", avg(length));
                break;
            case 8:
                System.out.printf("Groesze des Schwersten: %.2f\n", b_of_max_a(weight, length));
                break;
            case 9:
                System.out.printf("Gewicht des Groesten: %.2f\n", b_of_max_a(length, weight));
                break;
            }
        }

    }
}
