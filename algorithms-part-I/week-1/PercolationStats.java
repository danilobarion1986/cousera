/******************************************************************************
 *  Compilation:  javac PercolationStats.java
 *  Execution:    java PercolationStats
 *  Dependencies: StdOut.java StdRandom.java StdStats.java Percolation.java
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

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.StdOut;

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
    private Percolation p;
    private int gridSitesCount;
    private double[] percolationThresholds;

    public PercolationStats(int n, int trials) {
        validate(n, trials);

        p = new Percolation(n);
        gridSitesCount = n*n;
        percolationThresholds = new double[n];

        for (int i = 0; i < trials; i++) {
            do {
                p.open(StdRandom.uniform(n), StdRandom.uniform(n));
                p.printGrid();
            } while (!p.percolates());

            percolationThresholds[i] = p.numberOfOpenSites() / (double)gridSitesCount;
        }    

        StdOut.printf("mean                    = %f", mean());
        StdOut.printf("stddev                  = %f", stddev());
        StdOut.printf("95% confidence interval = [%f, %f]", confidenceLo(), confidenceHi());
    }
    
    private void validate(int n, int trials) {
        if (n <= 0 || trials <= 0) 
            throw new IllegalArgumentException("n must be between 1 and grid size");
    }

    /**
     * Sample mean of percolation threshold.
     */
    public double mean() {
        return StdStats.mean(percolationThresholds);
    }
    
    /**
     * Sample standard deviation of percolation threshold.
     */
    public double stddev() {
        return StdStats.stddev(percolationThresholds);
    }
    
    /**
     * low  endpoint of 95% confidence interval.
     */
    public double confidenceLo() {
        return mean() - stddev();
    }
    
    /**
     * High endpoint of 95% confidence interval.
     */
    public double confidenceHi() {
        return mean() + stddev();
    }
    
    public static void main(String[] args) {
      
    }
}
