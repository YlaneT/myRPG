package Util;

public class Util {
	
	static final int MAXFACTO = 12;
	
	public static int minus (int base, int dec) {
		return Math.max(0, base - dec);
	}
	
	public static double minus (double base, double dec) {
		return Math.max(0, base - dec);
	}
	
	public static int fibo (int n) {
		if (n < 2) {
			return n;
		}
		return fibo(n - 1) + fibo(n - 2);
	}
	
	public static int somme_entiers (int n) {
		return n * (n + 1) / 2;
	}
	
	public static int facto (int n) {
		int total = 1;
		if (n > MAXFACTO) {
			System.err.println("Util.facto() called with n > " + MAXFACTO + " (" + n + ")");
			n = MAXFACTO;
		}
		for(int i = 2 ; i <= n ; i++) {
			total *= i;
		}
		return total;
	}
	
	public static int reverse_facto (int n) {
		if (n == 0) {
			return 1;
		}
		int facto = 1;
		for(int i = 1 ; i <= MAXFACTO ; i++) {
			facto = facto * i;
			if (facto == n) {
				return i;
			}
			else if (facto > n) {
				return i - 1;
			}
		}
		return MAXFACTO;
	}
	
	public static boolean isInt (String txt) {
		if (txt == null) {
			return false;
		}
		try {
			int n = Integer.parseInt(txt);
		} catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}
	
	public static boolean isDouble (String txt) {
		if (txt == null) {
			return false;
		}
		try {
			double n = Double.parseDouble(txt);
		} catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}
}
