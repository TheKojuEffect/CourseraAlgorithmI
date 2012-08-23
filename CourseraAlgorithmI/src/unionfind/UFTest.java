package unionfind;

import java.util.ArrayList;

public class UFTest {
	
	private final static int	nodes	= 10;
	public static void main(String[] args) {
		ArrayList<UnionFind> ufList = new ArrayList<>(4);
		
		ufList.add(new QuickFind(nodes));
		ufList.add(new QuickUnion(nodes));
		ufList.add(new WeightedQuickUnion(nodes));
		ufList.add(new QUPathCompression(nodes));
		
		for (int i = 0; i < ufList.size(); i++) {
			UnionFind uf = ufList.get(i);
			System.out.println("For " + uf.getClass().getSimpleName());
			uf.union(5, 6);
			uf.union(5, 0);
			uf.union(2, 7);
			uf.union(1, 7);
			uf.union(3, 4);
			uf.union(3, 8);
			uf.union(4, 9);
			
		} // end for
		
		System.out.println("Union Successful");
	} // end method main
} // end class UFTest
