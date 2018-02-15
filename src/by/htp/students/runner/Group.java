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
		System.out.println("============ Group ============" + "\n");
		for (int i = 0; i < getStudents().length; i++) {
			System.out.println(getStudents()[i].getName() + " " + getStudents()[i].getAge());
		}
		if (this.isGroupComplete() == true) {
			System.out.println("Group complete" + "\n");
		} else {
			System.out.println("Group not complete" + "\n");
		}

	}

	public void averageAge() {
		int tmp = 0;
		for (int i = 0; i < getStudents().length; i++) {
			tmp = tmp + this.getStudents()[i].getYear();
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

	public void bubbleSort() {

		long timestart = System.nanoTime();
		Student tmp = null;
		for (int i = 0; i < getStudents().length - 1; i++) {
			tmp = students[i];
			if (getStudents()[i].getAge() > getStudents()[i + 1].getAge()) {
				students[i] = students[i + 1];
				students[i + 1] = tmp;
			}

		}

		System.out.println("============ Bubble sort group ============" + "\n");
		for (int i = 0; i < getStudents().length; i++) {
			System.out.println(getStudents()[i].getName() + " " + getStudents()[i].getAge());
		}

		long timeend = System.nanoTime();
		System.out.println("Sort time: " + (double) (timeend - timestart) / 1000 + " ìicrosec.");

	}

	public void selectSort() {

		long timestart = System.nanoTime();
		int[] arr = new int[getStudents().length];
		int min = 0;
		int indexMin = 0;

		for (int i = 0; i < arr.length; i++) {
			arr[i] = getStudents()[i].getYear();
		}

		for (int i = 0; i < arr.length; i++) {
			min = arr[i];
			for (int n = i; n < arr.length - 1; n++) {
				if (arr[n + 1] < min) {
					min = arr[n + 1];
					indexMin = n + 1;
				}
			}
			if (indexMin != 0) {
				arr[indexMin] = arr[i];
				arr[i] = min;
				indexMin = 0;
			}
		}

		System.out.println("============ Select sort group ============" + "\n");
		for (int i = 0; i < getStudents().length; i++) {
			System.out.println(getStudents()[i].getName() + " " + getStudents()[i].getAge());
		}

		long timeend = System.nanoTime();
		System.out.println("Sort time: " + (double) (timeend - timestart) / 1000 + " ìicrosec.");

	}

	public void insertSort() {

		long timestart = System.nanoTime();
		int[] arr = new int[getStudents().length];
		int num = 0;
		int indexNum = 0;

		for (int i = 0; i < arr.length; i++) {
			arr[i] = getStudents()[i].getYear();
		}

		for (int i = 1; i < arr.length; i++) {
			num = arr[i];
			for (int n = i; n > 0; n--) {
				if (arr[n - 1] > num) {
					indexNum = n;
				}
			}

			for (int m = i; m >= indexNum; m--) {
				arr[m - 1] = arr[m];
			}
			arr[indexNum] = num;

		}

		System.out.println("============ Insert sort group ============" + "\n");
		for (int i = 0; i < getStudents().length; i++) {
			System.out.println(getStudents()[i].getName() + " " + getStudents()[i].getAge());
		}

		long timeend = System.nanoTime();
		System.out.println("Sort time: " + (double) (timeend - timestart) / 1000 + " ìicrosec.");

	}

}
