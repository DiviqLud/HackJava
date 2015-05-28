package hashMapToString;

import java.util.HashMap;
import java.util.Map;

public class HashMapToString<F, T>{
	public static <F, T> String printHashMap(Map<F, T> a) {
		StringBuilder result = new StringBuilder();
		for (F key : a.keySet()) {
			result.append("Key: " + key + " Value: " + a.get(key) + "\n");
		}
		return result.toString();
	}
	
	public static void main(String[] args) {
		Map<Integer, Integer> a = new HashMap<Integer, Integer>();
		a.put(5, 6);
		a.put(2, 5);
		a.put(7, 12);
		a.put(1, 23);
		
		System.out.println(HashMapToString.printHashMap(a));
	}
}
