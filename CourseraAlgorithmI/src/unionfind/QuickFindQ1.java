package unionfind;

public class QuickFindQ1 {
	public static void main(String[] args) {
		QuickFind qf = new QuickFind(10);
		qf.union(0, 4);
		qf.union(9, 5);
		qf.union(0, 3);
		qf.union(9, 2);
		qf.union(7, 2);
		qf.union(8, 3);
		qf.display();
	} // end method main
} // end class QuickFindQ1
