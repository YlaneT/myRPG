package Models.Entities;

import Constants.Side;
import Constants.Stats.DD_Stats;
import Constants.Stats.Statistic_name;
import Models.Information.*;
import lombok.Data;

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
	
	/** Create character lvl 0 */
	public Character (String name, Side side) {
		this.name = name;
		this.side = side;
		primaryStats = new PrimaryStats();
		baseStats = primaryStats.calculateBaseStats();
		bonusStats = calculateBonusStats();
		initGauges();
	}
	
	/** Create a Character at given level with unattributed Primary stats points */
	public Character (String name, Side side, int level) {
		this(name, side, level, DD_Stats.UNA);
	}
	
	// Specialized (all stats points in the same stat)
	
	/** Create a *specialized* preset Character with all its stats points on the same stat */
	public Character (String name, Side side, int level, DD_Stats specialization) {
		this.name = name;
		this.side = side;
		primaryStats = new PrimaryStats();
		primaryStats.setLevel(level);
		primaryStats.specializedPattern(specialization);
		baseStats = primaryStats.calculateBaseStats();
		bonusStats = calculateBonusStats();
		initGauges();
	}
	
	/** Create a preset Character with a pattern "Mage" / "Tank" / "Random" */
	public Character (String name, Side side, int level, String pattern) {
		this.name = name;
		this.side = side;
		primaryStats = new PrimaryStats();
		primaryStats.setLevel(level);
		primaryStats.pattern(pattern);
		baseStats = primaryStats.calculateBaseStats();
		bonusStats = calculateBonusStats();
		initGauges();
	}
	
	/* SECONDARY STATS */
	// FIXME when Items are implemented
	protected Statistics calculateBonusStats () {
		return new Statistics();
	}
	
	protected void initGauges () {
		double max_health    = getCurrentStatByName(Statistic_name.MAX_HEALTH);
		double health_regen  = getCurrentStatByName(Statistic_name.HEALTH_REGENERATION);
		double regen_augment = getCurrentStatByName(Statistic_name.HEALTH_REGEN_AUGMENT);
		this.health = new Gauge(max_health, health_regen, regen_augment);
		
		double max_mana     = getCurrentStatByName(Statistic_name.MAX_MANA);
		double mana_regen   = getCurrentStatByName(Statistic_name.MANA_REGENERATION);
		double mana_augment = getCurrentStatByName(Statistic_name.MANA_REGEN_AUGMENT);
		this.mana = new Gauge(max_mana, mana_regen, mana_augment);
	}
	
/*
	private void setBaseStatByName (Statistic_name name, double value) {
		getBaseStats().setStatByName(name, value);
	}
	
	private void setCurrentStatByName (Statistic_name name, double value) {
		getBonusStats().setStatByName(name, value);
	}
*/
	
	/* FAST EXP */
	private void giveExp (int amount) {
		this.primaryStats.giveExp(amount);
		this.primaryStats.calculateBaseStats();
	}
	
	private void setTotal_experience (int amount) {
		this.primaryStats.setTotal_experience(amount);
		this.primaryStats.calculateBaseStats();
	}
	
	/* FAST GETTERS */
	protected int getLevel () {
		return getPrimaryStats().getExp_object().getLevel();
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
	
	protected int getUNA () {
		return getPrimaryStats().getUNATTRIBUTED();
	}
	
	protected double getBaseStatByName (Statistic_name name) {
		return getBaseStats().getStatByName(name);
	}
	
	protected double getBonusStatByName (Statistic_name name) {
		return getBonusStats().getStatByName(name);
	}
	
	protected double getCurrentStatByName (Statistic_name name) {
		return getBaseStatByName(name) + getBonusStatByName(name);
	}
}
