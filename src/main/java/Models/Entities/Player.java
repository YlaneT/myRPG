package Models.Entities;

import Constants.Stats.DD_Stats;
import Util.UtilMenu;

import static Constants.Side.ALLY;
import static Constants.Stats.Statistic_name.*;

public class Player extends Character {
	public Player (String name) {
		super(name, ALLY);
	}
	
	
	public Player (String name, int level) {
		super(name, ALLY, level);
	}
	
	public Player (String name, int level, DD_Stats specialization) {
		super(name, ALLY, level, specialization);
	}
	
	public Player (String name, int level, String pattern) {
		super(name, ALLY, level, pattern);
	}
	
	public String toString () {
		StringBuilder sb;
		sb = new StringBuilder();
		sb.append(UtilMenu.title("PLAYER : " + name.toUpperCase())).append("\n");
		sb.append(UtilMenu.separate("Level", getLevel())).append("\n");
		sb.append(UtilMenu.separate("Attack damage", getCurrentStatByName(ATTACK_DAMAGE))).append("\n");
		sb.append(UtilMenu.separate("Ability power", getCurrentStatByName(ABILITY_POWER))).append("\n");
		sb.append(UtilMenu.separate("Max Health", getCurrentStatByName(MAX_HEALTH))).append("\n");
		sb.append(UtilMenu.separate("Armor", getCurrentStatByName(ARMOR))).append("\n");
		sb.append(UtilMenu.separate("Magic resistance", getCurrentStatByName(MAGIC_RESISTANCE))).append("\n");
		sb.append(UtilMenu.separate("Max Mana", getCurrentStatByName(MAX_MANA))).append("\n");
		sb.append("=".repeat(50)).append("\n");
		return sb.toString();
	}
}
