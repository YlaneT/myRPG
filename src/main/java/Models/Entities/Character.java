package Models.Entities;

import Constants.Side;
import Constants.Stats.DD_Stats;
import Constants.Stats.Statistic_name;
import Models.Information.*;
import lombok.Data;
import org.json.JSONObject;
import org.json.JSONTokener;
import Util.UtilMenu;

import java.io.*;
import java.util.Iterator;

@Data
public abstract class Character {
	String       name;
	Side         side;
	Gauge        health;
	Gauge        mana;
	//	Gauge        energy;
	//	Gauge        exp;
	PrimaryStats primaryStats;
	Statistics   baseStats;
	Statistics   bonusStats;
	
	/* CONSTRUCTORS */
	// Create character lvl 0
	public Character (String name, Side side) {
		this.name = name;
		this.side = side;
		primaryStats = new PrimaryStats();
		baseStats = primaryStats.calculateBaseStats();
		//		bonusStats = calculateBonusStats();
		initGauges();
	}
	
	// Specialized (all stats points in the same stat)
	
	/** Create a *specialized* preset Character with all its stats points on the same stat */
	public Character (String name, Side side, int level, DD_Stats specialization) {
		this.name = name;
		this.side = side;
		primaryStats = new PrimaryStats();
		primaryStats.setLevel(level);
		primaryStats.setStat(specialization, level);
		baseStats = primaryStats.calculateBaseStats();
		//		bonusStats = calculateBonusStats();
		initGauges();
	}
	
	/** Create a preset Character with a pattern "Mage" / "Tank" / "Random" */
	public Character (String name, Side side, int level, String pattern) {
		this.name = name;
		this.side = side;
		primaryStats = new PrimaryStats();
		primaryStats.setLevel(level);
		primaryStats.pattern(level, pattern);
		baseStats = primaryStats.calculateBaseStats();
		//		bonusStats = calculateBonusStats();
		initGauges();
	}
	
	protected void initGauges () {
		// TODO : init gauges
	}
	
	protected void updateGauges () {
		// TODO : update gauges
	}
	
/*	private double getBaseStatByName (Statistic_name name) {
		return getBaseStats().getStatByName(name);
	}
	
	protected double getBonusStatByName (Statistic_name name) {
		return getBonusStats().getStatByName(name);
	}
	
	protected double getCurrentStatByName (Statistic_name name) {
		return getBaseStatByName(name) + getBonusStatByName(name);
	}
	
	private void setBaseStatByName (Statistic_name name, double value) {
		getBaseStats().setStatByName(name, value);
	}
	
	private void setCurrentStatByName (Statistic_name name, double value) {
		getBonusStats().setStatByName(name, value);
	}
	
	
	private void receiveDamage (Damage_Type type, double amount) {
		// TODO : Effects to reduce damage (flat)
		// TODO : Effects to reduce damage (percent) (Armor / MR)
	}
	
	private void addExp () {}
	
	private void levelUp () {}*/
	
/*	@Override
	public String toString () {
		StringBuilder sb;
		sb = new StringBuilder();
		// FIXME : .append(stat_name) doesn't show stat value
		sb.append(UtilMenu.title(getSide() + " : " + name.toUpperCase())).append("\n");
		sb.append(side.toString().toUpperCase()).append(" \t").append(name.toUpperCase()).append("\n");
		sb.append("Level           \t").append(getLevel()).append("\n");
		sb.append("Attack damage   \t").append(getCurrentStatByName(ATTACK_DAMAGE)).append("\n");
		sb.append("Ability power   \t").append(getCurrentStatByName(ABILITY_POWER)).append("\n");
		sb.append("Health          \t").append(getCurrentStatByName(HEALTH)).append("\n");
		sb.append("Armor           \t").append(getCurrentStatByName(ARMOR)).append("\n");
		sb.append("Magic resistance\t").append(getCurrentStatByName(MAGIC_RESISTANCE)).append("\n");
		sb.append("Mana            \t").append(getCurrentStatByName(MANA)).append("\n");
		sb.append("=".repeat(50) + "\n");
		return sb.toString();
	}*/
	
	/* FAST GETTERS */
	protected int getLevel () {
		return getPrimaryStats().getLevel();
	}
	
	protected int getFOR () {
		return getPrimaryStats().getForce();
	}
	
	protected int getDEX () {
		return getPrimaryStats().getDexterity();
	}
	
	protected int getINT () {
		return getPrimaryStats().getIntelligence();
	}
	
	protected int getCON () {
		return getPrimaryStats().getConstitution();
	}
	
	protected int getWIS () {
		return getPrimaryStats().getWisdom();
	}
}
