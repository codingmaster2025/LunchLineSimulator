
class EmptyLineException extends Exception {
	EmptyLineException(String message) {
		super(message);
	}

}

class DeanException extends Exception {
	DeanException(String message) {
		super(message);
	}

}

public class StudentLine implements Cloneable {

	private Student[] space;

	private int studentCount;

	final int CAPACITY = 20;

	/*
	 * 
	 * Postconditions: The array students has been initialized, and studentCount has
	 * been set to 0
	 */

	public StudentLine() {
		space = new Student[CAPACITY];
		studentCount = 0;
	}

	public int numStudents() {
		for (int i = 0; i < CAPACITY; i++) {
			if ((space[i] != null)) {
				studentCount++;
			}
		}
		return studentCount;
	}

	public void addStudent(int index, Student s) throws Exception {
		if (index == -1) {
			for (int i = 0; i < CAPACITY; i++) {
				if (space[i] == null) {
					space[i] = s;
					break;
				}

			}
		}

		else if (index > CAPACITY - 1)
			throw new ArrayIndexOutOfBoundsException("That's an invalid index. The line was not updated.");
		else if (space[19]!=null)
			throw new DeanException("new student will immediately sent to detention, by the Dean, Mr. Mean");
		else {

			Student temp;
			for (int i = numStudents(); i > index - 1; i--) {

				temp = space[i];
				space[i + 1] = temp;

			}
			space[index] = s;
			
			

		}
		
		
		
		
	}

	public String toString() {

		String a = "";
		Student s = null;
		for (int i = 0; i < space.length; i++) {
			s = space[i];
			if (s == null)
				break;

			a = a + (i + 1) + "." + s.toString() + "\n";

		}
		return a;

	}

	public Student removeStudent(int index) throws Exception {

		if (index > CAPACITY)
			throw new ArrayIndexOutOfBoundsException("That's an invalid index. The line was not updated.");

		if (space[index] == null)
			throw new EmptyLineException("That's a empty position:" + (index + 1));

		else {
			for (int i = index; i < CAPACITY - 1; i++) {

				space[i] = null;
				if (space[i + 1] != null)
					space[i] = space[i + 1];

			}

		}
		return null;

	}

	public Student getStudent(int index) throws ArrayIndexOutOfBoundsException {

		if (space[index] == null || (index + 1) > CAPACITY) {
			throw new ArrayIndexOutOfBoundsException("That's an invalid index. The line was not updated.");
		}

		else
			return space[index];

	}

	public boolean equals(Object o) {
		if (o instanceof StudentLine) {

			return (((StudentLine) o).numStudents() == this.numStudents());
		}

		return false;
	}

	public void swapStudent(int s1, int s2) {
		if (s1 > 20 || s2 > 20 || space[s1] == null || space[s2] == null) {
			throw new ArrayIndexOutOfBoundsException("That's an invalid index. The line was not updated.");

		} else {
			Student temp = space[s1];

			space[s1] = space[s2];
			space[s2] = temp;

		}
	}

	public StudentLine clone() throws CloneNotSupportedException {
		StudentLine sl = (StudentLine) (super.clone());
		return sl;

	}

}
