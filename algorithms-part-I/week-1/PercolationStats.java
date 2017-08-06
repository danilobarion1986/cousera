/******************************************************************************
 *  Compilation:  javac PercolationStats.java
 *  Execution:    java PercolationStats
 *  Dependencies: StdIn.java StdOut.java StdRandom.java StdStats.java 
 *                WeightedQuickUnionUF.java
 *  
 *  Given 2 integers, n and T, performs T independent computational experiments
 *  on an n-by-n grid, and prints the sample mean, sample standard deviation, 
 *  and the 95% confidence interval for the percolation threshold.
 *
 *  % java PercolationStats 200 100
 *  mean                    = 0.5929934999999997
 *  stddev                  = 0.00876990421552567
 *  95% confidence interval = [0.5912745987737567, 0.5947124012262428]
 * 
 ******************************************************************************/
 
 /*****************************************************************************
  * API:
  * public PercolationStats(int n, int trials)    // perform trials independent experiments on an n-by-n grid
  * public double mean()                          // sample mean of percolation threshold
  * public double stddev()                        // sample standard deviation of percolation threshold
  * public double confidenceLo()                  // low  endpoint of 95% confidence interval
  * public double confidenceHi()                  // high endpoint of 95% confidence interval
  * public static void main(String[] args)        // test client (http://coursera.cs.princeton.edu/algs4/assignments/percolation.html)
  *****************************************************************************/
public class PercolationStats {

    public PercolationStats(int n, int trials) {
        
    }
    
    /**
     * Sample mean of percolation threshold.
     */
    public double mean() {
        throw new UnsupportedOperationException();
    }
    
    /**
     * Sample standard deviation of percolation threshold.
     */
    public double stddev() {
        throw new UnsupportedOperationException();
    }
    
    /**
     * low  endpoint of 95% confidence interval.
     */
    public double confidenceLo() {
        throw new UnsupportedOperationException();
    }
    
    /**
     * High endpoint of 95% confidence interval.
     */
    public double confidenceHi() {
        throw new UnsupportedOperationException();
    }
    
    public static void main(String[] args) {
        
    }
}