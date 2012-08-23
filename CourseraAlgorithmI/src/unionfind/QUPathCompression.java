package unionfind;

public class QUPathCompression {
	
	private int[]	id;
	private int[]	size;
	
	public QUPathCompression(int number) {
		id = new int[number];
		size = new int[number];
		for (int i = 0; i < id.length; i++)
			id[i] = i;
	}
	
	private int root(int i) {
		int node = i;
		while (i != id[i])
			i = id[i];
		id[node] = i;
		return i;
	} // end method root
	
	public boolean connected(int p, int q) {
		return root(p) == root(q);
	} // end method connected
	
	public void union(int p, int q) {
		int i = root(p);
		int j = root(q);
		if (size[i] < size[j]) {
			id[i] = j;
			size[j] += size[i];
		} else {
			id[j] = i;
			size[i] += size[j];
		}
	} // end method union
} // end class QUPathCompression
