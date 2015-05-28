package medianModaMeanRange;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.naming.SizeLimitExceededException;

public class StatisticsImpl implements Statistics {
	private Integer[] ints;
	private int size;
	private int maxSize;

	StatisticsImpl(int maxSize) {
		size = 0;
		this.maxSize = maxSize;
		ints = new Integer[maxSize];
	}

	@Override
	public int getMean() {
		int sum = 0;
		for (int i = 0; i < size; i++) {
			sum += ints[i];
		}
		return sum / size;
	}

	@Override
	public int getMedian() {
		if (size % 2 == 0) {
			return ints[size / 2];
		}
		else {
			return ints[size / 2];
		}
	}

	@Override
	public int getModa() {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < size; i++) {
			if (map.containsKey(ints[i])) {
				map.replace(ints[i], map.get(ints[i]), map.get(ints[i])+ 1);
			}
			else map.put(ints[i], 1);
		}
		int max = 0;
		int moda = 0;
		for (Integer key : map.keySet()) {
			if (map.get(key) > max) {
				max = map.get(key);
				moda = key;
			}
		}
		return moda;
	}

	@Override
	public int getRange() {
		List<Integer> l = new ArrayList<Integer>();
		for (int i = 0; i < size; i++) {
			l.add(ints[i]);
		}
		Collections.sort(l);
		return l.get(l.size()-1 ) - l.get(0);

	}

	@Override
	public void add(int number) {
		if (size < maxSize) {
			ints[size] = number;
			size++;
		} else {
			System.out.println("Cant add anymore");
		}
			
	}
	
	public void printElements() {
		for (int i = 0; i < size; i++) {
			System.out.print(ints[i] + " ");
		}
	}

}
