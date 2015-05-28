package studentSort;

public class Student implements Comparable<Student> {
	private String name;
	private int grade;

	public Student(String name, int grade) {
		super();
		setName(name);
		setGrade(grade);
	}

	public String getName() {
		return name;
	}

	public int getGrade() {
		return grade;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", grade=" + grade + "]";
	}

	@Override
	public int compareTo(Student s) {
		if (grade < s.grade) {
			return 1;
		} else if (grade > s.grade) {
			return -1;
		} else {
			if (name.compareTo(s.name) > 0) {
				return 1;
			} else
				return -1;
		}
	}
}
