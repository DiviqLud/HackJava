package firstUniqueElement;

import java.util.Arrays;
import java.util.Collection;

public class FirstUniqueTest {
	public static void main(String[] args) {
		Collection<Integer> ints = Arrays.asList(1, 2, 3, 4, 5);
		System.out.println(FirstUniqueElement.firstUnique(ints));
	}
}
