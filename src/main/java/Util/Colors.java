package Util;

public class Colors {
	private static final String RESET = "\u001B[0m";
	private static final String R     = "\u001B[31m";
	private static final String G     = "\u001B[32m";
	private static final String Y     = "\u001B[33m";
	private static final String B     = "\u001B[34m";
	private static final String P     = "\u001B[35m";
	private static final String DG    = "\u001B[36m"; // DARK GREEN (supposedly CYAN)
	private static final String BOLD  = "\u001B[1m";
	
	public static String red (String text) {
		return R + text + RESET;
	}
	
	public static String green (String text) {
		return G + text + RESET;
	}
	
	public static String yellow (String text) {
		return Y + text + RESET;
	}
	
	public static String blue (String text) {
		return B + text + RESET;
	}
	
	public static String purple (String text) {
		return P + text + RESET;
	}
	
	public static String bold (String text) {
		return BOLD + text + RESET;
	}
	
	public static String _bold (String text) {
		return BOLD + text;
	}
	
	public static void error (String text) {
		System.out.println(red("/!\\  " + text));
	}
	
	public static void warning (String text) {
		System.out.println(yellow("/!\\  " + text));
	}
}
