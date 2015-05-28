package duplicatesInSets;

import java.util.ArrayList;

public class DuplicatesMain {
	public static void main(String[] args) {
		ArrayList<Integer> A = new ArrayList<Integer>();
		ArrayList<Integer> B = new ArrayList<Integer>();
		ArrayList<Integer> C = new ArrayList<Integer>();
		
		A.add(1);
		A.add(2);
		A.add(3);
		A.add(4);
		A.add(5);
		
		B.add(4);
		B.add(5);
		B.add(6);

		C.add(5);
		C.add(6);
		C.add(7);
		C.add(8);

		
		ArrayList<Integer> result = DuplicatesInSets.duplicates(A, B, C);
		System.out.println(result.toString());
	}
}
