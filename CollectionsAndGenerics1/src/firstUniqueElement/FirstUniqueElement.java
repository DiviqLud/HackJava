package firstUniqueElement;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

public class FirstUniqueElement {
	public static int firstUnique(Collection<Integer> collection) {
		Map<Integer, Integer> map = new LinkedHashMap<Integer, Integer>();
		
		for (Integer element : collection) {
			if (!(map.containsKey(element))) {
				map.put(element, 1);
			}
			else {
				map.replace(element, map.get(element), map.get(element) +1);
			}
		}
		
		for (Integer key : map.keySet()) {
			if (map.get(key) == 1) {
				return key;
			}
		}
		
		return -1;
	}
}
