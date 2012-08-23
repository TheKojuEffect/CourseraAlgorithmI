package unionfind;

import java.util.Random;

public class PercolationStats {
	
	private double[] pts; // percolate thresholds
	
	public static void main(String[] args) {
		int gridSize = 100; // initialize defaults
		int numExp = 100;
		
		if (args.length == 2) {
			gridSize = Integer.parseInt(args[0]);
			numExp = Integer.parseInt(args[1]);
		}
		try {
			if (gridSize <= 1 || numExp <= 1)
				throw new IllegalArgumentException();
		} catch (Exception ex) {
			System.err.println("Invalid Arguments");
			ex.printStackTrace();
		}
		
		PercolationStats ps = new PercolationStats(gridSize, numExp);
		double mean = ps.mean();
		double stdDev = ps.stdDev();
		double a = mean - (1.96 * stdDev / Math.sqrt(numExp));
		double b = mean + (1.96 * stdDev / Math.sqrt(numExp));
		System.out.println("Mean\t\t\t\t: " + mean);
		System.out.println("Standard Deviation\t\t: " + stdDev);
		System.out.println("95%% Confidence Interval\t: " + a + "," + b);
	} // end method main
	
	public PercolationStats(int gridSize, int numExp) {
		pts = new double[numExp];
		
		for (int expNo = 0; expNo < numExp; expNo++) {
			Percolation p = new Percolation(gridSize);
			Random randomNum = new Random(System.nanoTime());
			int openedSite = 0;
			while (p.percolates() == false) {
				int i = randomNum.nextInt(gridSize);
				int j = randomNum.nextInt(gridSize);
				if (!p.isOpen(i, j)) {
					p.open(i, j);
					openedSite++;
				}
			} // end while
			
			pts[expNo] = (double)openedSite / (gridSize * gridSize);
			
			p = null;
			randomNum = null;
		}
	}
	
	private double mean() {
		double sum = 0;
		for (double pt : pts)
			sum += pt;
		
		return sum / pts.length;
	} // end method mean
	
	private double stdDev() {
		double sumSqrDev = 0;
		double mean = mean();
		for (double pt : pts)
			sumSqrDev += Math.pow((pt - mean), 2);
		
		return sumSqrDev / (pts.length - 1);
	} // end method stdDev
} // end class PercolationStats
