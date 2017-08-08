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

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

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
  private int t;
  private int gridSize;
  private int gridSitesCount;
  private double[] percolationThresholds;

  public PercolationStats(int n, int trials) {
    validate(n, trials);
    p = new Percolation(n);
    t = trials;
    gridSize = n;
    gridSitesCount = n*n;
    percolationThresholds = new double[n];
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
    for (int i = 0; i < t; i++) {
      do {
        p.open(StdRandom.uniform(gridSize), StdRandom.uniform(gridSize));
        p.printGrid();
      } while (!p.percolates());

      percolationThresholds[i] = p.numberOfOpenSites() / gridSitesCount;
    }    

    StdOut.printf("mean                    = %f", mean());
    StdOut.printf("stddev                  = %f", stddev());
    StdOut.printf("95% confidence interval = [%f, %f]", confidenceLo(), confidenceHi());
  }
}
