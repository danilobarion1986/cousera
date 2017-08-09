/******************************************************************************
 *  Compilation:  javac Percolation.java
 *  Execution:    java Percolation
 *  Dependencies: WeightedQuickUnionUF.java
 * 
 *  http://coursera.cs.princeton.edu/algs4/assignments/percolation.html
 *  http://coursera.cs.princeton.edu/algs4/checklists/percolation.html
 * 
 ******************************************************************************/
package edu.princeton.cs.algs4;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;
import edu.princeton.cs.algs4.StdOut;

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
    private int openSitesCount; 

    /**
     * Create n-by-n grid, with all sites blocked.
     */
    public Percolation(int n) {
        grid = new int[n][n];
        wqu = new WeightedQuickUnionUF(n);
        openSitesCount = 0;

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                grid[row][col] = 0;
            } 
        }
    }
    
    private void validate(int n) {
        if (n <= 0) 
            throw new IllegalArgumentException("n must be bigger than 0!");
    }
    
    public void printGrid() {
        int n = grid.length;
        
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                StdOut.print(grid[row][col] + " ");
            } 
            StdOut.println("");
        }
    }
    
    /**
     * Open site (row, col) if it is not open already
     */
    public void open(int row, int col) {
        if (!isOpen(row, col)) { 
            validate(row);
            validate(col);
            
            grid[row][col] = 1;
            // Unir os adjacentes...
            // Na matriz é fácil, mas como farei usando o array 1D do wqu??
            openSitesCount++;
        }
    }
    
    /**
     * Is site (row, col) open?
     */
    public boolean isOpen(int row, int col) {
        validate(row);
        validate(col);
        return grid[row][col] == 1;
    }
    
    /**
     * Is site (row, col) full?
     */
    public boolean isFull(int row, int col) {
        validate(row);
        validate(col);
        throw new UnsupportedOperationException();
    }
    
    /**
     * Number of open sites.
     */
    public int numberOfOpenSites() {
        return openSitesCount;
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

    }
}