package rotation;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class RotateElements {
	public static void rotate(Collection<Integer> collection, int rotateStep) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		Integer putIndex = rotateStep;
		for (Integer element : collection) {
			if (putIndex >= collection.size()) {
				putIndex -= collection.size();
				map.put(putIndex, element);
				putIndex += 1;
			} else if (putIndex >= 0) {
				map.put(putIndex, element);
				putIndex += 1;
			} else {
				map.put(collection.size() + putIndex, element);
				putIndex += 1;
			}
		}
	}
}
