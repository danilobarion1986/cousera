/******************************************************************************
 *  Compilation:  javac Percolation.java
 *  Execution:    java Percolation
 *  Dependencies: WeightedQuickUnionUF.java
 * 
 *  http://coursera.cs.princeton.edu/algs4/assignments/percolation.html
 *  http://coursera.cs.princeton.edu/algs4/checklists/percolation.html
 * 
 ******************************************************************************/

https://github.com/ISchwarz23/Algorithms-Part1---Assignments/blob/master/Week%201%20-%20Percolation/src/Percolation.java

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
    private int gridSize;
    private int gridColumnsCount;
    private int openSitesCount; 
    private int virtualTopSite;
    private int virtualBottomSite;
    private WeightedQuickUnionUF weightedQuickUnion;
    
    /**
     * Create n-by-n grid, with all sites blocked.
     */
    public Percolation(int n) {
        grid = new int[n][n];
        gridSize = n * n;
        gridColumnsCount = grid[0].length;
        openSitesCount = 0;
        virtualTopSite = 0;
        virtualBottomSite = gridSize + 1;
        weightedQuickUnion = new WeightedQuickUnionUF(gridSize + 2);

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                grid[row][col] = 0;
            } 
        }
    }
    
    private int mapIndexFromMatrixToArray(int row, int col) {
        return (row * gridColumnsCount) + col;
    }

    private void connectAdjacentSite(int currentSiteArrayIndex, int row, int col) {
        if (isOpen(row, col)) {
            int adjacentSiteArrayIndex = mapIndexFromMatrixToArray(row, col);
            weightedQuickUnion.union(currentSiteArrayIndex, adjacentSiteArrayIndex);
        }
    }

    private void validate(int row, int col) {
        if (row <= 0 || col <= 0) 
            throw new IllegalArgumentException("row and column must be bigger than 0!");
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
            validate(row, col);
                        
            // Open site
            grid[row - 1][col - 1] = 1; 
            
            // Get correct index for Weighted Quick Union
            int currentSiteArrayIndex = mapIndexFromMatrixToArray(row, col);

            if (row == 1) {
                weightedQuickUnion.union(virtualTopSite, currentSiteArrayIndex);
            }
            if (row == gridColumnsCount) {
                weightedQuickUnion.union(virtualBottomSite, currentSiteArrayIndex);
            }
            
            connectAdjacentSite(currentSiteArrayIndex, row, col - 1);     // Left
            connectAdjacentSite(currentSiteArrayIndex, row, col + 1);     // Right
            connectAdjacentSite(currentSiteArrayIndex, row + 1, col);     // Down
            connectAdjacentSite(currentSiteArrayIndex, row - 1, col + 1); // Up

            openSitesCount++;
        }
    }

    /**
     * Is site (row, col) open?
     */
    public boolean isOpen(int row, int col) {
        validate(row, col);
        return grid[row - 1][col - 1] == 1;
    }
    
    /**
     * Is site (row, col) full?
     */
    public boolean isFull(int row, int col) {
        validate(row, col);
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
        return weightedQuickUnion.connected(virtualTopSite, virtualBottomSite);
    }
    
    /**
     * Test client (optional)
     */
    public static void main(String[] args) {

    }
}