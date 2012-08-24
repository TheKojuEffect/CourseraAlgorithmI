package unionfind;

public class WeightedQUQ2 {
	
	public static void main(String[] args) {
		WeightedQuickUnion wqu = new WeightedQuickUnion(10);
		wqu.union(0, 5);
		wqu.display();
		System.out.println();
		
		wqu.union(3, 2);
		wqu.display();
		System.out.println();
		
		wqu.union(9, 1);
		wqu.display();
		System.out.println();
		
		wqu.union(9, 3);
		wqu.display();
		System.out.println();
		
		wqu.union(8, 7);
		wqu.display();
		System.out.println();
		
		wqu.union(8, 5);
		wqu.display();
		System.out.println();
		
		wqu.union(7, 1);
		wqu.display();
		System.out.println();
		
		wqu.union(6, 5);
		wqu.display();
		System.out.println();
		
		wqu.union(3, 4);
		wqu.display();
	} // end method main
}
