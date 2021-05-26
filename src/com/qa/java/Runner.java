package com.qa.java;

import java.util.Scanner;
import java.util.function.Function;

import com.qa.java.calculator.Calculator;

public class Runner {
	public static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		String result;
		boolean flag = true;
		do {

			System.out.println("Which operation would you like to perform:");
			menu();
			result = scanner.nextLine();
			result = result.equals("") ? "exit" : result;
			double a = 0;
			double b = 0;
			try {
				System.out.println("Enter the first number");
				a = Integer.parseInt(scanner.nextLine());
				System.out.println("Enter the second number");
				b = Integer.parseInt(scanner.nextLine());
			} catch (NumberFormatException nfe) {
				result = "Invalid";
				System.out.println(nfe);
			}

			switch (result) {
			case "1":
				System.out.println(a + " + " + b + " = " + Calculator.add(a, b));
				break;
			case "2":
				System.out.println(a + " - " + b + " = " + Calculator.subtraction(a, b));
				break;
			case "3":
				System.out.println(a + " * " + b + " = " + Calculator.multiplication(a, b));
				break;
			case "4":
				System.out.println(a + " / " + b + " = " + Calculator.division(a, b));
				break;
			case "exit":
				flag = false;
				System.out.println("Exiting App");
				break;

			default:
				System.out.println("Try again");
				break;
			}

		} while (flag);
		scanner.close();
	}

	public static void menu() {
		System.out.println("Operations\n 1. add\n 2. subtract\n 3. multiplication\n 4. division\n");
	}

}
