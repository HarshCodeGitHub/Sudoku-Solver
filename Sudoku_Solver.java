public class Sudoku_Solver {

	public static void main(String[] args) {
		int[][] grid = { { 0, 0, 0, 8, 3, 9, 0, 0, 0 }, 
						 { 2, 0, 4, 0, 0, 0, 3, 0, 1 }, 
						 { 9, 0, 0, 0, 0, 0, 0, 0, 6 },
						 { 0, 1, 0, 7, 0, 8, 0, 6, 0 }, 
						 { 7, 0, 0, 6, 0, 5, 0, 0, 3 }, 
						 { 0, 9, 0, 1, 0, 3, 0, 8, 0 },
						 { 8, 0, 0, 0, 0, 0, 0, 0, 7 }, 
						 { 4, 0, 6, 0, 0, 0, 9, 0, 5 }, 
						 { 0, 0, 0, 4, 6, 1, 0, 0, 0 } };

		System.out.println("Sudoku Solver\n");
		
		sudokuSolver(grid,0,0);// start row col
	}

	public static void sudokuSolver(int[][] grid, int row, int col) {
		
		if(col == 9) {// go in nxt row
			row++;
			col = 0;
		}
		if(row == 9) {// end of grid
			display(grid);
			return;
		}
		
		
		if(grid[row][col] != 0) {// val is already present 
			sudokuSolver(grid,row,col + 1);
		}
		else {// val in not already present
			for (int val = 1; val <= 9; val++) {
				if(isitPossible(grid,row,col,val) == true) {
					grid[row][col] = val;
					sudokuSolver(grid,row,col + 1);
					grid[row][col] = 0;
				}
			}
		}
	}

	public static boolean isitPossible(int[][] grid, int row, int col, int val) {
		// chk in row
		int c = 0;
		while(c < 9) {
			if(grid[row][c] == val)
				return false;
			c++;
		}
		
		// chk in col
		int r = 0;
		while(r < 9) {
			if(grid[r][col] == val)
				return false;
			r++;
		}
		
		// chk in 3*3 matrix
		r = row - (row % 3);
		c = col - (col % 3);
		
		for (int i = r; i < (r + 3); i++) {
			for (int j = c; j < (c + 3); j++) {
				if(grid[i][j] == val)
					return false;
			}
		}
		
		return true;
	}

	public static void display(int[][] grid) {
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid.length; j++) {
				System.out.print(grid[i][j] + " ");
			}
			System.out.println();
		}
	}

}
