package Util;

public class Util {
	public static int minus (int base, int dec) {
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
		// FIXME : Erreur si n > 12 (too long int)
		int total = 1;
		for(int i = 2 ; i <= n ; i++) {
			total *= i;
		}
		return total;
	}
	
	public static int reverse_facto (int n) {
		// FIXME to not be used with n == 0
		int max_facto = 1;
		int result    = 0;
		int i         = 1;
		while (max_facto < n) {
			result += 1;
			max_facto *= i + 1;
		}
		return result;
	}
}
