package unionfind;

public class Percolation {
	
	private boolean[][] grid;
	private int size; // grid size
	private WeightedQuickUnion uf;
	
	public Percolation(int size) {
		this.size = size;
		grid = new boolean[size][size];
		uf = new WeightedQuickUnion(size * size);
	}
	
	public boolean isFull(int i, int j) {
		boolean full = false;
		for (int jIndex = 0; jIndex < grid[i].length && full == false; jIndex++) {
			full = uf.connected(i * size + j, jIndex);
		}
		return full;
	} // end method isFull // end method open
	
	public boolean isOpen(int i, int j) {
		return grid[i][j];
	} // end method isOpen
	
	public void open(int i, int j) {
		if (grid[i][j])
			return;
		
		grid[i][j] = true;
		if (i != 0 && isOpen(i - 1, j)) // top of the node
			uf.union(i * size + j, (i - 1) * size + j);
		
		if (i < size-1 && isOpen(i + 1, j)) // bottom of the node
			uf.union(i * size + j, (i + 1) * size + j);
		
		if (j != 0 && isOpen(i, j - 1)) // left of the node
			uf.union(i * size + j, i * size + j - 1);
		
		if (j != size - 1 && isOpen(i, j + 1)) // right of the node
			uf.union(i * size + j, i * size + j + 1);
	} // end method open
	
	public boolean percolates() {
		boolean percolate = false;
		for (int jIndex = 0; jIndex < grid[0].length && percolate == false; jIndex++) {
			percolate = isFull(size - 1, jIndex);
		}
		return percolate;
	} // end method percolates
} // end class Percolation
