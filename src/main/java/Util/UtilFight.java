package Util;

public class UtilFight {
	public static double damageAfterReduction (double damage, double resistance) {
		int r50 = (int) (resistance / 50);
		damage = Util.minus(damage, Util.somme_entiers(r50));
		return damage * 100 / (100 + resistance);
	}
}