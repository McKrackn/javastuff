package GameOfLife;

import java.util.Scanner;

public class Main { 
	public static void main(String[] args) { 
		Scanner sc = new Scanner(System.in);
		int M=34;
		int N=34;
		boolean grid[][]=new boolean[M][N];

		
		for (int i = 0; i < grid.length; i++) 
		{ 
			for (int j = 0; j < grid[0].length; j++) 
			{ 
				grid[i][j] = false; 
			}  
		}
		System.out.printf(": \n");

		int x=sc.nextInt();
		int y=sc.nextInt();
				
		while (x>=0 && y>=0) {
			grid[x][y]=true;
			x=sc.nextInt();
			if (x>=0) {
				y=sc.nextInt();
			}
		}

		for (int i = 1; i < grid.length-1; i++) 
		{ 
			for (int j = 1; j < grid[0].length-1; j++) 
			{ 
				if (grid[i-1][j-1] == false) 
					System.out.printf("."); 
				else
					System.out.printf("X"); 
			} 
			System.out.println(); 
		} 
		
		nextGeneration(grid, M, N, sc);
		 sc.close();

		}
 

	// Function to print next generation 
	static void nextGeneration(boolean grid[][], int M, int N, Scanner sc) 
	{ 
		boolean[][] future = new boolean[M][N]; 
		int turns=0;
		int gens=1;
		while (gens>0) {
		System.out.printf("(%06d): ",turns); 
		gens=sc.nextInt();
		System.out.println();
		
		for (int g=gens;g>0;g--) {
			turns++;


		// Loop through every cell 
		for (int l = 0; l < M ; l++) 
		{ 
			for (int m = 0; m < N ; m++) 
			{ 
				int aliveNeighbours = 0; 
				for (int i = -1; i <= 1; i++) {
					for (int j = -1; j <= 1; j++) { 
						if (l + i >= 0 && m + j < M && l + i < M && m + j >= 0) {
						if (grid[l + i][m + j]==true) {
							aliveNeighbours++;
						}
						}
						
					}
				}
						 

				if (grid[l][m]==true) {
					aliveNeighbours--; 
				}

				// Implementing the Rules of Life 

				// Cell is lonely and dies 
				if ((grid[l][m] == true) && (aliveNeighbours < 2)) 
					future[l][m] = false; 

				// Cell dies due to over population 
				else if ((grid[l][m] == true) && (aliveNeighbours > 3)) 
					future[l][m] = false; 

				// A new cell is born 
				else if ((grid[l][m] == false) && (aliveNeighbours == 3)) 
					future[l][m] = true; 

				// Remains the same 
				else
					future[l][m] = grid[l][m]; 
			} 
		} 
		for (int l = 0; l < M ; l++) 
		{ 
			for (int m = 0; m < N ; m++) 
			{ 
				grid[l][m] = future[l][m];
			}
		}
		
			}
		
		

		for (int i = 1; i < M-1; i++) 
		{ 
			for (int j = 1; j < N-1; j++) 
			{ 
				if (future[i-1][j-1] == true) 
					System.out.print("X"); 
				else
					System.out.print("."); 
			} 
			System.out.println(); 
		}
	}
	}
} 

