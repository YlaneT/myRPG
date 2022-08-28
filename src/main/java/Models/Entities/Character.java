package Models.Entities;

import Constants.Damage_Type;
import Constants.Side;
import Constants.Stats.Statistic_name;
import Models.Information.*;
import lombok.Data;

import java.util.ArrayList;

import static Constants.Stats.Statistic_name.*;

@Data
public class Character {
	String     name;
	int        level;
	Side       side;
	Gauge      health;
	Gauge      mana;
	Gauge      energy;
	Statistics baseStats;
	Statistics currentStats;
	
	public Character (String name, Side side) {
		this.name = name;
		this.level = 1;
		this.side = side;
		initCharacterstats(getCharacterStats());
	}
	
	private ArrayList<Statistic> getCharacterStats () {
		ArrayList<Statistic> stats = new ArrayList<Statistic>();
		// TODO : Récupérer les valeurs dans stats_base.json
		return stats;
	}
	
	private void initCharacterstats (ArrayList<Statistic> stats) {
		// TODO : Affecter à baseStats et gauge
	}
	
	private double getBaseStatByName (Statistic_name name) {
		return getBaseStats().getStatByName(name);
	}
	
	private double getCurrentStatByName (Statistic_name name) {
		return getCurrentStats().getStatByName(name);
	}
	
	private void setBaseStatByName (Statistic_name name, double value) {
		getBaseStats().setStatByName(name, value);
	}
	
	private void setCurrentStatByName (Statistic_name name, double value) {
		getCurrentStats().setStatByName(name, value);
	}
	
	private int getMaxHealth () {
		return (int) getHealth().getMax();
	}
	
	private int getCurrentHealth () {
		return (int) getHealth().getCurrent();
	}
	
	private int getMaxMana () {
		return (int) getMana().getMax();
	}
	
	private int getCurrentMana () {
		return (int) getMana().getCurrent();
	}
	
	private int getMaxEnergy () {
		return (int) getEnergy().getMax();
	}
	
	private int getCurrentEnergy () {
		return (int) getEnergy().getCurrent();
	}
	
	private void receiveDamage (Damage_Type type, double amount) {
		// TODO : Effects to reduce damage (flat)
		// TODO : Effects to reduce damage (percent) (Armor / MR)
	}
	
	private void addExp () {}
	
	private void levelUp () {}
	
	@Override
	public String toString () {
		StringBuilder sb;
		sb = new StringBuilder();
		sb.append("==============================");
		sb.append(side.toString().toUpperCase()).append(" \t").append(name.toUpperCase()).append("\n");
		sb.append("------------------------------\n");
		sb.append("Level           \t").append(level).append("\n");
		sb.append("Attack damage   \t").append(ATTACK_DAMAGE).append("\n");
		sb.append("Ability power   \t").append(ABILITY_POWER).append("\n");
		sb.append("Health          \t").append(HEALTH).append("\n");
		sb.append("Armor           \t").append(ARMOR).append("\n");
		sb.append("Magic resistance\t").append(MAGIC_RESISTANCE).append("\n");
		sb.append("Mana            \t").append(MANA).append("\n");
		sb.append("==============================\n");
		return sb.toString();
	}
}
