package by.htp.students.runner;

public class Student {

	private String name;
	private int age;
	private int year;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public Student(String name, int age, int year) {
		this.setName(name);
		this.setAge(age);
		this.setYear(year);
	}

}
