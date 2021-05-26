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
			double a = getUserNumberInput();
			double b = getUserNumberInput();

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
				try {
					if(b == 0) {
						throw new ArithmeticException("You called this method inappropriately");
					}
				} catch(ArithmeticException e) {
					System.out.println(e);
					System.out.println("Invalid operation. Please Try Again");
					break;
				}
				System.out.println(a + " / " + b + " = " + Calculator.division(a, b));
				break;
			case "exit":
				flag = false;
				System.out.println("Exiting App");
				break;

			default:
				System.out.println("Invalid operation, try again.");
				break;
			}

		} while (flag);
		scanner.close();
	}

	public static void menu() {
		System.out.println("Operations\n 1. add\n 2. subtract\n 3. multiplication\n 4. division\n");
	}

	public static int getUserNumberInput() {
		int num = 0;
		boolean flag = true;
		while (flag) {
			System.out.println("Type a number");
			try {
				num = Integer.parseInt(scanner.nextLine());
				flag = false;
			} catch (NumberFormatException NFE) {
				System.out.println("Try again");
			}
		}
		return num;
	}

}
