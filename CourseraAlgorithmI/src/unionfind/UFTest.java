package unionfind;

import java.util.ArrayList;

public class UFTest {
	
	private final static int	nodes	= 10;
	
	public static void main(String[] args) {
		ArrayList<UnionFind> ufList = new ArrayList<>(4);
		
		ufList.add(new QuickFind(nodes));
		ufList.add(new QuickUnion(nodes));
		ufList.add(new WeightedQuickUnionUF(nodes));
		ufList.add(new QUPathCompression(nodes));
		
		for (int i = 0; i < ufList.size(); i++) {
			UnionFind uf = ufList.get(i);
			System.out.println("For " + uf.getClass().getSimpleName());
			long startTime = System.nanoTime();
			uf.union(5, 6);
			uf.union(5, 0);
			uf.union(2, 7);
			uf.union(1, 7);
			uf.union(3, 4);
			uf.union(3, 8);
			uf.union(4, 9);
			long unionEndTime = System.nanoTime();
			double unionTime = (double) (unionEndTime - startTime) / 1000;
			System.out.println("Union Time : " + unionTime + " us");
			
			System.out.println("0 connected with 9 ? " + uf.connected(0, 9));
			System.out.println("8 connected with 4 ? " + uf.connected(8, 4));
			System.out.println("1 connected with 7 ? " + uf.connected(1, 7));
			long findEndTime = System.nanoTime();
			double findTime = (double) (findEndTime - unionEndTime) / 1000;
			System.out.println("Find Time : " + findTime + " us");
			
		} // end for
		
	} // end method main
} // end class UFTest
