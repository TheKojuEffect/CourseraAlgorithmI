package unionfind;

public class QuickUnion implements UnionFind {
	
	private int[]	id;
	
	public QuickUnion(int number) {
		id = new int[number];
		for (int i = 0; i < id.length; i++)
			id[i] = i;
	}
	
	@Override
	public boolean connected(int p, int q) {
		return root(p) == root(q);
	} // end method connected
	
	private int root(int i) {
		while (i != id[i])
			i = id[i];
		return i;
	} // end method root
	
	@Override
	public void union(int p, int q) {
		int i = root(p);
		int j = root(q);
		id[i] = j;
	} // end method union
} // end class QuickUnion