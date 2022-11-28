package Models.Entities;

import Constants.Side;
import Util.UtilMenu;

import static Constants.Stats.Statistic_name.*;

public class Player extends Character {
	public Player (String name) {
		super(name, Side.ALLY);
	}
	
	
	public String toString () {
		StringBuilder sb;
		sb = new StringBuilder();
		sb.append(UtilMenu.title("PLAYER : " + name.toUpperCase())).append("\n");
		sb.append(UtilMenu.separate("Level", getLevel())).append("\n");
		sb.append(UtilMenu.separate("Attack damage", getCurrentStatByName(ATTACK_DAMAGE))).append("\n");
		sb.append(UtilMenu.separate("Ability power", getCurrentStatByName(ABILITY_POWER))).append("\n");
		sb.append(UtilMenu.separate("Health", getCurrentStatByName(HEALTH))).append("\n");
		sb.append(UtilMenu.separate("Armor", getCurrentStatByName(ARMOR))).append("\n");
		sb.append(UtilMenu.separate("Magic resistance", getCurrentStatByName(MAGIC_RESISTANCE))).append("\n");
		sb.append(UtilMenu.separate("Mana", getCurrentStatByName(MANA))).append("\n");
		sb.append("=".repeat(50)).append("\n");
		return sb.toString();
	}
}
