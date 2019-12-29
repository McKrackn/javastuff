package ReadGraph;

import java.util.Scanner;

public class Main { 
	static final double oo = 0; //Double.POSITIVE_INFINITY;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		double graph[][]=new double[n][n];

		while (true) {
			int i=sc.nextInt();
			if (i<0||i>=n) break;
			int j=sc.nextInt();
			graph[i][j]=sc.nextDouble();
		}
		writegraph(graph);
		sc.close();
				
	}
	public static void writegraph(double graph[][]) {
		int i, j;

		System.out.printf("digraph mygraph {\n");
		System.out.printf("node [style = filled, color = black, fontcolor = white]\n");

		for (i = 0; i < graph.length; i++)
			for (j = 0; j < graph[i].length; j++) {
				
			
				if (graph[i][j] != oo)
					System.out.printf("    %c -> %c [label = %.1f]\n", i + 'A', j + 'A', graph[i][j]);
			}
		System.out.printf("}\n");
		

	}

}
