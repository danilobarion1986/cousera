/******************************************************************************
 *  Compilation:  javac Percolation.java
 *  Execution:    java Percolation
 *  Dependencies: StdIn.java StdOut.java StdRandom.java StdStats.java 
 *                WeightedQuickUnionUF.java
 * 
 *  http://coursera.cs.princeton.edu/algs4/assignments/percolation.html
 *  http://coursera.cs.princeton.edu/algs4/checklists/percolation.html
 * 
 ******************************************************************************/
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

/*****************************************************************************
  * API:
  * public Percolation(int n)                // create n-by-n grid, with all sites blocked
  * public    void open(int row, int col)    // open site (row, col) if it is not open already
  * public boolean isOpen(int row, int col)  // is site (row, col) open?
  * public boolean isFull(int row, int col)  // is site (row, col) full?
  * public     int numberOfOpenSites()       // number of open sites
  * public boolean percolates()              // does the system percolate?
  *
  * public static void main(String[] args)   // test client (optional)
  *****************************************************************************/
public class Percolation {
    private int[][] grid;
    private WeightedQuickUnionUF wqu;
    
    /**
     * Create n-by-n grid, with all sites blocked.
     */
    public Percolation(int n) {
        validate(n);
        grid = new int[n][n];
        wqu = new WeightedQuickUnionUF(n);
        
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                grid[row][col] = 0;
            } 
        }
    }
    
    private void validate(int n) {
        if (n <= 0) throw new IllegalArgumentException("'n' must be an positive integer.");
    }
    
    private void printGrid() {
        int n = grid.length;
        
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                System.out.print(grid[row][col] + " ");
            } 
            System.out.println("");
        }
    }
    
    /**
     * Open site (row, col) if it is not open already
     */
    public void open(int row, int col) {
        throw new UnsupportedOperationException();
    }
    
    /**
     * Is site (row, col) open?
     */
    public boolean isOpen(int row, int col) {
        throw new UnsupportedOperationException();
    }
    
    /**
     * Is site (row, col) full?
     */
    public boolean isFull(int row, int col) {
        throw new UnsupportedOperationException();
    }
    
    /**
     * Number of open sites.
     */
    public int numberOfOpenSites() {
        throw new UnsupportedOperationException();
    }
    
    /**
     * Does the system percolate?
     */
    public boolean percolates() {
        throw new UnsupportedOperationException();
    }
    
    /**
     * Test client (optional)
     */
    public static void main(String[] args) {
        Percolation p = new Percolation(10);
        p.printGrid();
    }
}