package stackqueue;

import java.util.Random;

public class Subset {
	
	public static void main(String[] args) {
		
		int subsetSize = Integer.parseInt(args[0]);
		Random randomGenerator = new Random();
		
		String input[] = StdIn.readStrings();
		for (int i = 0; i < subsetSize; i++) {
			int randomNum = randomGenerator.nextInt(input.length - i);
			// move the randomly selected string to last
			String temp = input[randomNum];
			input[randomNum] = input[input.length - 1 - i];
			input[input.length - 1 - i] = temp;
		}
		
		// print the random values
		for (int i = 0; i < subsetSize; i++) {
			StdOut.println(input[input.length - 1 - i]);
		}
	} // end method main
} // end class Subset
