package Models.Entities;

import Constants.Side;

public class Player extends Character {
	public Player (String name) {
		super(name, Side.ALLY);
	}
	
	
/*	public String toString () {
		StringBuilder sb;
		sb = new StringBuilder();
		sb.append(UtilMenu.title("PLAYER : " + name.toUpperCase())).append("\n");
		sb.append("Level           \t").append(getLevel()).append("\n");
		sb.append("Attack damage   \t").append(getBonusStatByName(ATTACK_DAMAGE)).append("\n");
		sb.append("Ability power   \t").append(getBonusStatByName(ABILITY_POWER)).append("\n");
		sb.append("Health          \t").append(getBonusStatByName(HEALTH)).append("\n");
		sb.append("Armor           \t").append(getBonusStatByName(ARMOR)).append("\n");
		sb.append("Magic resistance\t").append(getBonusStatByName(MAGIC_RESISTANCE)).append("\n");
		sb.append("Mana            \t").append(getBonusStatByName(MANA)).append("\n");
		sb.append("=".repeat(50) + "\n");
		return sb.toString();
	}*/
}
