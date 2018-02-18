package by.htp.students.input;

import java.util.Scanner;

public class ConsoleInput {
	
	public int readIntValue() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter int value: 1 - Bubble sort, 2 - Select sort, 3 - Insert sort, 4 - Quick sort");
		int value = sc.nextInt();
		return value;
	}
}
