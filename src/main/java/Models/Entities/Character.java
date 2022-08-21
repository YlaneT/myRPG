package Models.Entities;

import Constants.Side;
import Constants.Statistic_name;
import Models.Information.Statistics;

public class Character {
	String     name;
	int        level;
	Statistics stats;
	Side       side;
	
	public Character (String name, Side side) {
		this.name = name;
		this.level = 1;
		this.side = side;
		setCharacterstats();
	}
	
	private void setCharacterstats () {
		this.setEachStat(50, 0, 0, 30, 600, 23, 27, 4, 265, 6, 0, 0);
	}
	
	public int getStat (Statistic_name name) {
		if (name.equals(Statistic_name.ATTACK_DAMAGE)) {
			return getStats().getATTACK_DAMAGE();
		}
		else if (name.equals(Statistic_name.ABILITY_POWER)) {
			return getStats().getABILITY_POWER();
		}
		else if (name.equals(Statistic_name.CRITICAL_CHANCE)) {
			return getStats().getCRITICAL_CHANCE();
		}
		else if (name.equals(Statistic_name.CRITICAL_DAMAGE)) {
			return getStats().getCRITICAL_DAMAGE();
		}
		else if (name.equals(Statistic_name.HEALTH)) {
			return getStats().getHEALTH();
		}
		else if (name.equals(Statistic_name.ARMOR)) {
			return getStats().getARMOR();
		}
		else if (name.equals(Statistic_name.MAGIC_RESISTANCE)) {
			return getStats().getMAGIC_RESISTANCE();
		}
		else if (name.equals(Statistic_name.HEALTH_REGENERATION)) {
			return getStats().getHEALTH_REGENERATION();
		}
		else if (name.equals(Statistic_name.MANA)) {
			return getStats().getMANA();
		}
		else if (name.equals(Statistic_name.MANA_REGENERATION)) {
			return getStats().getMANA_REGENERATION();
		}
		else if (name.equals(Statistic_name.HEAL_SHIELD)) {
			return getStats().getHEAL_SHIELD();
		}
		else if (name.equals(Statistic_name.ABILITY_HASTE)) {
			return getStats().getABILITY_HASTE();
		}
		else {
			System.err.println("Error getting stat { " + name + " }");
			return -1;
		}
	}
	
	public void setStat (Statistic_name name, int value) {
		if (name.equals(Statistic_name.ATTACK_DAMAGE)) {
			getStats().setATTACK_DAMAGE(value);
		}
		else if (name.equals(Statistic_name.ABILITY_POWER)) {
			getStats().setABILITY_POWER(value);
		}
		else if (name.equals(Statistic_name.CRITICAL_CHANCE)) {
			getStats().setCRITICAL_CHANCE(value);
		}
		else if (name.equals(Statistic_name.CRITICAL_DAMAGE)) {
			getStats().setCRITICAL_DAMAGE(value);
		}
		else if (name.equals(Statistic_name.HEALTH)) {
			getStats().setHEALTH(value);
		}
		else if (name.equals(Statistic_name.ARMOR)) {
			getStats().setARMOR(value);
		}
		else if (name.equals(Statistic_name.MAGIC_RESISTANCE)) {
			getStats().setMAGIC_RESISTANCE(value);
		}
		else if (name.equals(Statistic_name.HEALTH_REGENERATION)) {
			getStats().setHEALTH_REGENERATION(value);
		}
		else if (name.equals(Statistic_name.MANA)) {
			getStats().setMANA(value);
		}
		else if (name.equals(Statistic_name.MANA_REGENERATION)) {
			getStats().setMANA_REGENERATION(value);
		}
		else if (name.equals(Statistic_name.HEAL_SHIELD)) {
			getStats().setHEAL_SHIELD(value);
		}
		else if (name.equals(Statistic_name.ABILITY_HASTE)) {
			getStats().setABILITY_HASTE(value);
		}
		else {
			System.err.println("Error setting stat { " + name + " / " + value + " }");
		}
	}
	
	public String getName () {
		return name;
	}
	
	public void setName (String name) {
		this.name = name;
	}
	
	public int getLevel () {
		return level;
	}
	
	public void setLevel (int level) {
		this.level = level;
	}
	
	public Statistics getStats () {
		return stats;
	}
	
	public void setStats (Statistics stats) {
		this.stats = stats;
	}
	
	public void setEachStat (int ad, int ap, int cc, int cd, int hp, int ar, int mr, int hp_s, int mana, int mana_s,
		int heal, int ah) {
		getStats().setAll(ad, ap, cc, cd, hp, ar, mr, hp_s, mana, mana_s, heal, ah);
	}
}
