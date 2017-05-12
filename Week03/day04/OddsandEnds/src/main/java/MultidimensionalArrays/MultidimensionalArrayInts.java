package MultidimensionalArrays;

import java.util.Arrays;

public class MultidimensionalArrayInts {

	private static void printgrid(){
		
		int[][] grid = new int[10][10];
		
		for (int i = 0; i < 10; i++) {
			for(int j =0; j < 10; j++) {
				grid [i][j] = (i+1)*(j+1);
			}
		}
		print2dArray(grid);
	}
			
	private static void print2dArray(int[][] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.println(Arrays.toString(array[i]));
		}
	}		
	
	public static void main(String[] args) {
		printgrid();
	}
		
}
