package Util;

import java.util.Scanner;

import static Util.Util.isInt;

public class UtilMenu extends Colors {
	
	private static boolean equiv (String input, String expected) {
		input = input.strip();
		return input.equalsIgnoreCase(expected);
	}
	
	private static boolean equiv (String input, String... possibilities) {
		for(String expected : possibilities) {
			if (equiv(input, expected)) {
				return true;
			}
		}
		return false;
	}
	
	public static String title (String title) {
		String formatted = title.toUpperCase().strip();
		int    length    = formatted.length();
		if (length >= 46) {
			length = 46;
		}
		else if (length % 2 != 0) {
			formatted = formatted + " ";
			length += 1;
		}
		return "=".repeat((48 - length) / 2) + " " + formatted + " " + "=".repeat((48 - length) / 2);
	}
	
	public static void ask (String question) {
		String formatted = question.strip();
		String arrow     = " => ";
		int    length    = formatted.length();
		if (length >= 46) {
			System.out.println(green(formatted + arrow));
		}
		else {
			System.out.println(green(formatted + " ".repeat(46 - length) + arrow));
		}
	}
	
	public static String separate (String left, String right) {
		int totalLength = left.length() + right.length();
		return left + " ".repeat(50 - totalLength) + right;
	}
	
/*	public static String get_answer (String question, Predicate condition) {
		String s = "";
		ask(question);
		
	}*/
	
	public static int get_int_between (String question, int min, int max) {
		Scanner sc = new Scanner(System.in);
		String  input;
		do {
			ask(question);
			input = sc.nextLine().strip();
		} while (!isInt(input) || Integer.parseInt(input) < min || Integer.parseInt(input) > max);
		return Integer.parseInt(input);
	}
}


