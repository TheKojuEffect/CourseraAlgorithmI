package unionfind;

public class QuickFind {

	private int[]	id;

	public QuickFind(int number) {
		id = new int[number];
		for (int i = 0; i < id.length; i++)
			id[i] = i;
	}

	public boolean connected(int p, int q) {
		return id[p] == id[q];
	} // end method connected

	public void union(int p, int q) {
		if (id[p] == id[q])
			return;

		int pid = id[p];
		int qid = id[q];
		for (int i = 0; i < id.length; i++)
			if (id[i] == pid)
				id[i] = qid;
	} // end method union
} // end class QuickFind
