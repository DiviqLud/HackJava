package duplicatesInSets;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DuplicatesInSets {
	public static ArrayList<Integer> duplicates(ArrayList<Integer>... arrays) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		ArrayList<Integer> result = new ArrayList<Integer>();
		for (ArrayList<Integer> arr : arrays) {
			for (int i = 0; i < arr.size(); i++) {
				if (!(map.containsKey(arr.get(i)))) {
					map.put(arr.get(i), 1);
				}
				else {
					map.replace(arr.get(i), map.get(arr.get(i)), map.get(arr.get(i))+1);
				}
			}
		}
		
		for (Integer key : map.keySet()) {
			if (map.get(key) == arrays.length) {
				result.add(key);
			}
		}
		
		return result;
		
	}
}
