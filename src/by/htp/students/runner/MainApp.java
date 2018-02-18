package by.htp.students.runner;

import by.htp.students.input.ConsoleInput;

public class MainApp {

	public static void main(String[] args) {

		Student student1 = new Student("Name1", 20, 2016);
		Student student2 = new Student("Name2", 27, 2015);
		Student student3 = new Student("Name3", 22, 2011);
		Student student4 = new Student("Name4", 28, 2013);
		Student student5 = new Student("Name5", 23, 2018);
		Student student6 = new Student("Name6", 22, 2012);
		Student student7 = new Student("Name7", 26, 2018);

		Group grp = new Group();

		grp.addStudent(student1);
		grp.addStudent(student2);
		grp.addStudent(student3);
		grp.addStudent(student4);
		grp.addStudent(student5);
		grp.addStudent(student6);
		grp.addStudent(student7);

		grp.groupStatus();

		grp.averageAge();
		grp.group2015();
		grp.groupMaxYear();

		ConsoleInput input = new ConsoleInput();
		grp.sortOption(input.readIntValue());

	}

}
