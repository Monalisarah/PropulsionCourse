package MultidimensionalArrays;

import java.util.Arrays;

public class MultidimensionalArrayStrings {
	
	private static void fillthegrid(String [][] grid){
		for (int i=0; i<grid.length; i++){
			
			for (int j=0; j<grid[i].length; j++){
				grid[i][j] = "(" + (i+1) + "," +(j+1) + ")";
			}

		}
	}
	
	private static void print2dArray(String[][] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.println(Arrays.toString(array[i]));
		}
	}
	public static void main(String[] args) {
		String [][] grid = new String [4][5];
		
		fillthegrid(grid);
		print2dArray(grid);
		
		
	}
}
