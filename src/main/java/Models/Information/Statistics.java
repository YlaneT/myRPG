package Models.Information;

import Constants.Stats.Statistic_name;
import lombok.Data;

@Data
public class Statistics {
	double MAX_HEALTH;
	double HEALTH_REGENERATION;
	double HEALTH_REGEN_AUGMENT;
	double MAX_MANA;
	double MANA_REGENERATION;
	double MANA_REGEN_AUGMENT;
	double ATTACK_DAMAGE;
	double ABILITY_POWER;
	double ARMOR;
	double MAGIC_RESISTANCE;
	double CRITICAL_CHANCE;
	double CRITICAL_DAMAGE;
	double HEAL;
	double SHIELD;
	double ABILITY_HASTE;
	double MAX_ENERGY;
	
	public Statistics () {
		this.MAX_HEALTH = 0;
		this.HEALTH_REGENERATION = 0;
		this.HEALTH_REGEN_AUGMENT = 0;
		this.MAX_MANA = 0;
		this.MANA_REGENERATION = 0;
		this.MANA_REGEN_AUGMENT = 0;
		this.ATTACK_DAMAGE = 0;
		this.ABILITY_POWER = 0;
		this.ARMOR = 0;
		this.MAGIC_RESISTANCE = 0;
		this.CRITICAL_CHANCE = 0;
		this.CRITICAL_DAMAGE = 0;
		this.HEAL = 0;
		this.SHIELD = 0;
		this.ABILITY_HASTE = 0;
		this.MAX_ENERGY = 0;
	}
	
	public double getStatByName (Statistic_name name) {
		if (name == null) {
			System.err.println("Error getting stat { " + name + " }");
			return -1;
		}
		switch (name) {
			case MAX_HEALTH:
				return getMAX_HEALTH();
			case HEALTH_REGENERATION:
				return getHEALTH_REGENERATION();
			case HEALTH_REGEN_AUGMENT:
				return getHEALTH_REGEN_AUGMENT();
			case MAX_MANA:
				return getMAX_MANA();
			case MANA_REGENERATION:
				return getMANA_REGENERATION();
			case MANA_REGEN_AUGMENT:
				return getMANA_REGEN_AUGMENT();
			case ATTACK_DAMAGE:
				return getATTACK_DAMAGE();
			case ABILITY_POWER:
				return getABILITY_POWER();
			case ARMOR:
				return getARMOR();
			case MAGIC_RESISTANCE:
				return getMAGIC_RESISTANCE();
			case CRITICAL_CHANCE:
				return getCRITICAL_CHANCE();
			case CRITICAL_DAMAGE:
				return getCRITICAL_DAMAGE();
			case HEAL:
				return getHEAL();
			case SHIELD:
				return getSHIELD();
			case ABILITY_HASTE:
				return getABILITY_HASTE();
			case MAX_ENERGY:
				return getMAX_ENERGY();
			default:
				System.err.println("Error getting stat { " + name + " }");
				return -1;
		}
	}
	
	public void setStatByName (Statistic_name name, double value) {
		switch (name) {
			case MAX_HEALTH:
				setMAX_HEALTH(value);
				break;
			case HEALTH_REGENERATION:
				setHEALTH_REGENERATION(value);
				break;
			case HEALTH_REGEN_AUGMENT:
				setHEALTH_REGEN_AUGMENT(value);
				break;
			case MAX_MANA:
				setMAX_MANA(value);
				break;
			case MANA_REGENERATION:
				setMANA_REGENERATION(value);
				break;
			case MANA_REGEN_AUGMENT:
				setMANA_REGEN_AUGMENT(value);
				break;
			case ATTACK_DAMAGE:
				setATTACK_DAMAGE(value);
				break;
			case ABILITY_POWER:
				setABILITY_POWER(value);
				break;
			case ARMOR:
				setARMOR(value);
				break;
			case MAGIC_RESISTANCE:
				setMAGIC_RESISTANCE(value);
				break;
			case CRITICAL_CHANCE:
				setCRITICAL_CHANCE(value);
				break;
			case CRITICAL_DAMAGE:
				setCRITICAL_DAMAGE(value);
				break;
			case HEAL:
				setHEAL(value);
				break;
			case SHIELD:
				setSHIELD(value);
				break;
			case ABILITY_HASTE:
				setABILITY_HASTE(value);
				break;
			case MAX_ENERGY:
				setMAX_ENERGY(value);
				break;
			default:
				System.err.println("Error setting stat { " + name + " / " + value + " }");
		}
	}
	
	public void incrementStatByName (Statistic_name name, double value) {
		setStatByName(name, getStatByName(name) + value);
	}
	
}
