package studentSort;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class SortStudents {
	public static void main(String[] args) {
		List<Student> l = new ArrayList<Student>();

		Student a = new Student("Kiro", 5);
		Student b = new Student("Kari", 5);
		Student c = new Student("Kiril", 6);

		l.add(a);
		l.add(b);
		l.add(c);

		Map<Student, Integer> map = new TreeMap<Student, Integer>();
		for (int i = 0; i < l.size(); i++) {
			map.put(l.get(i), i);

		}

		for (Student s : map.keySet()) {
			System.out.print(s + " ");
		}

	}

}
