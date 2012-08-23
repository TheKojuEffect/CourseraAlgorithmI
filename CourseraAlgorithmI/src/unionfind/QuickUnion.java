package unionfind;

public class QuickUnion {

	private int[]	id;

	public QuickUnion(int number) {
		id = new int[number];
		for (int i = 0; i < id.length; i++)
			id[i] = i;
	}

	public boolean connected(int p, int q) {
		return root(p) == root(q);
	} // end method connected

	private int root(int i) {
		while (i != id[i])
			i = id[i];
		return i;
	} // end method root

	public void union(int p, int q) {
		int i = root(p);
		int j = root(q);
		id[i] = j;
	} // end method union
} // end class QuickUnion