package Menus;

import Main.Colors;

public class Menu extends Colors {
	
	private static boolean equiv (String input, String expected) {
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
		if (length >= 48) {
			length = 48;
		}
		else if (length % 2 != 0) {
			formatted = formatted + " ";
			length += 1;
		}
		return "=".repeat((50 - length) / 2) + " " + formatted + " " + "=".repeat((50 - length) / 2);
	}
}


