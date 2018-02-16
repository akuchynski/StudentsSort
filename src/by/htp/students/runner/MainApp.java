package by.htp.students.runner;

public class MainApp {

	public static void main(String[] args) {

		Student student1 = new Student("Name1", 29, 2012);
		Student student2 = new Student("Name2", 25, 2011);
		Student student3 = new Student("Name3", 24, 2015);
		Student student4 = new Student("Name4", 20, 2011);
		Student student5 = new Student("Name5", 31, 2013);
		Student student6 = new Student("Name6", 21, 2011);

		Group grp = new Group();

		grp.addStudent(student1);
		grp.addStudent(student2);
		grp.addStudent(student3);
		grp.addStudent(student4);
		grp.addStudent(student5);
		grp.addStudent(student6);

		
		grp.groupStatus();

		grp.averageAge();

		grp.group2015();

		grp.groupMaxYear();

		//grp.bubbleSort();

		//grp.selectSort();

		grp.insertSort();

	}

}
