package Constants.Stats;

import java.util.Random;

public enum DD_Stats {
	FOR,
	DEX,
	INT,
	CON,
	WIS,
	UNA; // Unattributed
	
	public static DD_Stats randomStat (boolean attributableOnly) {
		if (attributableOnly) {
			return randomAttributableStat();
		}
		else {
			return randomNotNecesserilyAttributableStat();
		}
	}
	
	public static DD_Stats randomStat (DD_Stats... choices) {
		DD_Stats[] table = choices;
		int        pick  = new Random().nextInt(table.length);
		return table[pick];
	}
	
	private static DD_Stats randomAttributableStat () {
		Random r    = new Random();
		int    pick = r.nextInt(values().length - 1);
		return values()[pick];
	}
	
	private static DD_Stats randomNotNecesserilyAttributableStat () {
		Random r    = new Random();
		int    pick = r.nextInt(values().length);
		return values()[pick];
	}
}
