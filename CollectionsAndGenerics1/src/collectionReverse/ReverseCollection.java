package collectionReverse;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ReverseCollection {
	public static void main(String[] args) {
		List<Integer> l = new ArrayList<Integer>();
		l.add(5);
		l.add(12);
		l.add(24);
		System.out.println(l.toString());
		reverse(l);
		System.out.println(l.toString());
	}
	static void reverse(Collection<Integer> collection) {
		Integer[] help = new Integer[collection.size()];
		help = collection.toArray(help);
		collection.clear();
		for (int i = 0; i < help.length; i++) {
			collection.add(help[help.length - i -1]);
		}
		
	}
}
