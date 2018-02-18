package by.htp.students.runner;

public class Group {

	private int studentCounter;
	private Student[] students;
	private boolean groupComplete;

	public int getStudentCounter() {
		return studentCounter;
	}

	public void setStudentCounter(int studentCounter) {
		this.studentCounter = studentCounter;
	}

	public Student[] getStudents() {
		return students;
	}

	public void setStudents(Student[] students) {
		this.students = students;
	}

	public boolean isGroupComplete() {
		return groupComplete;
	}

	public void setGroupComplete(boolean groupComplete) {
		this.groupComplete = groupComplete;
	}

	public void addStudent(Student student) {

		if (this.getStudentCounter() >= 15) {
			System.out.println("Group formed. Students count: " + this.getStudentCounter());
			return;
		}

		if (students != null) {
			if (studentCounter < this.students.length) {

				this.students[studentCounter] = student;
				studentCounter++;

			} else {

				Student[] students = new Student[this.students.length + 1];

				for (int i = 0; i < this.students.length; i++) {
					students[i] = this.students[i];
				}

				this.students = students;
				this.students[studentCounter] = student;
				studentCounter++;

			}

		} else {

			this.students = new Student[1];
			this.students[studentCounter] = student;
			studentCounter++;

		}

		if (this.getStudentCounter() >= 5 && this.getStudentCounter() <= 15) {
			this.setGroupComplete(true);
		}
	}

	public void groupStatus() {
		System.out.println("============ Group info ============" + "\n");
		for (int i = 0; i < getStudents().length; i++) {
			System.out.println(
					getStudents()[i].getName() + " " + getStudents()[i].getAge() + " " + getStudents()[i].getYear());
		}
		if (this.isGroupComplete() == true) {
			System.out.println("\n" + "Group complete" + "\n");
		} else {
			System.out.println("\n" + "Group not complete" + "\n");
		}

	}

	public void averageAge() {
		int tmp = 0;
		for (int i = 0; i < getStudents().length; i++) {
			tmp = tmp + this.getStudents()[i].getAge();
		}

		System.out.println("Average age " + tmp / getStudents().length);
	}

	public void group2015() {

		int y = 0;
		for (int i = 0; i < getStudents().length; i++) {
			if (this.getStudents()[i].getYear() == 2015)
				y++;
		}
		System.out.println("2015: " + y + " Students");

	}

	public void groupMaxYear() {
		int[] arr = new int[getStudents().length];
		int countYearMax = 1;
		int countYearTmp = 1;
		int maxIndex = 0;

		for (int i = 0; i < arr.length; i++) {
			arr[i] = this.getStudents()[i].getYear();
		}

		for (int i = 0; i < arr.length; i++) {
			for (int m = i; m < arr.length - 1; m++) {
				if (arr[i] == arr[m + 1]) {
					countYearTmp++;
				}
			}
			if (countYearTmp > countYearMax) {
				countYearMax = countYearTmp;
				maxIndex = i;
			}
			countYearTmp = 1;
		}

		System.out.println("Max. student year - " + this.getStudents()[maxIndex].getYear() + " " + countYearMax
				+ " students" + "\n");
	}

	// ----- Sort ------------

	public void sortOption(int value) {
		switch (value) {
		case 1:
			bubbleSort();
			break;
		case 2:
			selectSort();
			break;
		case 3:
			insertSort();
			break;
		case 4:
			quickSort();
			break;
		}
	}

	// ----- Bubble sort -----

	public void bubbleSort() {

		long timestart = System.nanoTime();
		Student tmp = null;
		for (int i = 0; i < getStudents().length - 1; i++) {
			for (int n = 0; n < getStudents().length - i - 1; n++) {
				tmp = students[n];
				if (getStudents()[n].getAge() > getStudents()[n + 1].getAge()) {
					students[n] = students[n + 1];
					students[n + 1] = tmp;
				}
			}
		}

		System.out.println("============ Bubble sort group ============" + "\n");
		for (int i = 0; i < getStudents().length; i++) {
			System.out.println(
					getStudents()[i].getName() + " " + getStudents()[i].getAge() + " " + getStudents()[i].getYear());
		}

		long timeend = System.nanoTime();
		System.out.println("\n" + "Sort time: " + (double) (timeend - timestart) / 1000 + " ìicrosec.");

	}

	// ----- Select sort -----

	public void selectSort() {

		long timestart = System.nanoTime();
		Student tmp = null;
		int indexMin = 0;

		for (int i = 0; i < getStudents().length; i++) {
			tmp = getStudents()[i];
			for (int n = i; n < getStudents().length - 1; n++) {
				if (getStudents()[i + 1].getAge() < tmp.getAge()) {
					tmp = getStudents()[i + 1];
					indexMin = n + 1;
				}
			}
			if (indexMin != 0) {
				getStudents()[indexMin] = getStudents()[i];
				getStudents()[i] = tmp;
				indexMin = 0;
			}
		}

		System.out.println("============ Select sort group ============" + "\n");
		for (int i = 0; i < getStudents().length; i++) {
			System.out.println(
					getStudents()[i].getName() + " " + getStudents()[i].getAge() + " " + getStudents()[i].getYear());
		}

		long timeend = System.nanoTime();
		System.out.println("\n" + "Sort time: " + (double) (timeend - timestart) / 1000 + " ìicrosec.");

	}

	// ----- Insert sort -----

	public void insertSort() {

		long timestart = System.nanoTime();
		Student tmp = null;
		int indexNum = 0;

		for (int i = 1; i < getStudents().length; i++) {
			tmp = getStudents()[i];
			for (int n = i; n > 0; n--) {
				if (getStudents()[n - 1].getAge() > tmp.getAge()) {
					indexNum = n;
				}
			}

			if (indexNum != 0) {
				for (int m = i; m > indexNum - 1; m--) {
					getStudents()[m] = getStudents()[m - 1];
				}
				getStudents()[indexNum - 1] = tmp;
			}
			indexNum = 0;

		}

		System.out.println("============ Insert sort group ============" + "\n");
		for (int i = 0; i < getStudents().length; i++) {
			System.out.println(
					getStudents()[i].getName() + " " + getStudents()[i].getAge() + " " + getStudents()[i].getYear());
		}

		long timeend = System.nanoTime();
		System.out.println("\n" + "Sort time: " + (double) (timeend - timestart) / 1000 + " ìicrosec.");

	}

	// ----- Quick sort -----

	public void quickSort() {

		long timestart = System.nanoTime();

		int firstIndex = 0;
		int lastIndex = getStudents().length - 1;

		sortArr(students, firstIndex, lastIndex);

		System.out.println("============ Quick sort group ============" + "\n");

		for (int i = 0; i < getStudents().length; i++) {
			System.out.println(
					getStudents()[i].getName() + " " + getStudents()[i].getAge() + " " + getStudents()[i].getYear());
		}

		long timeend = System.nanoTime();
		System.out.println("\n" + "Sort time: " + (double) (timeend - timestart) / 1000 + " ìicrosec.");

	}

	private void sortArr(Student[] students, int firstIndex, int lastIndex) {
		if (lastIndex <= firstIndex) {
			return;
		}

		Student currentElem = students[firstIndex];
		Student pivot = students[lastIndex];
		int wall = firstIndex;

		for (int n = wall; n < lastIndex; n++) {
			currentElem = students[n];
			if (currentElem.getAge() < pivot.getAge()) {
				students[n] = students[wall];
				students[wall] = currentElem;
				wall++;
			}
		}
		students[lastIndex] = students[wall];
		students[wall] = pivot;

		sortArr(students, firstIndex, wall - 1);
		sortArr(students, wall + 1, lastIndex);

	}
}
