package Models.Information;

import Constants.Stats.Statistic_name;
import lombok.Data;

@Data
public class Statistics {
	double ATTACK_DAMAGE;
	double ABILITY_POWER;
	double CRITICAL_CHANCE;
	double CRITICAL_DAMAGE;
	double ARMOR;
	double MAGIC_RESISTANCE;
	double HEAL_SHIELD;
	double ABILITY_HASTE;
	
	public double getStatByName (Statistic_name name) {
		switch (name) {
			case ATTACK_DAMAGE:
				return getATTACK_DAMAGE();
			case ABILITY_POWER:
				return getABILITY_POWER();
			case CRITICAL_CHANCE:
				return getCRITICAL_CHANCE();
			case CRITICAL_DAMAGE:
				return getCRITICAL_DAMAGE();
			case ARMOR:
				return getARMOR();
			case MAGIC_RESISTANCE:
				return getMAGIC_RESISTANCE();
			case HEAL_SHIELD:
				return getHEAL_SHIELD();
			case ABILITY_HASTE:
				return getABILITY_HASTE();
			default:
				System.err.println("Error getting stat { " + name + " }");
				return -1;
		}
	}
	
	public void setStatByName (Statistic_name name, double value) {
		switch (name) {
			case ATTACK_DAMAGE:
				setATTACK_DAMAGE(value);
				break;
			case ABILITY_POWER:
				setABILITY_POWER(value);
				break;
			case CRITICAL_CHANCE:
				setCRITICAL_CHANCE(value);
				break;
			case CRITICAL_DAMAGE:
				setCRITICAL_DAMAGE(value);
				
				break;
			case ARMOR:
				setARMOR(value);
				break;
			case MAGIC_RESISTANCE:
				setMAGIC_RESISTANCE(value);
				break;
			case HEAL_SHIELD:
				setHEAL_SHIELD(value);
				break;
			case ABILITY_HASTE:
				setABILITY_HASTE(value);
				break;
			default:
				System.err.println("Error setting stat { " + name + " / " + value + " }");
		}
	}
	
	@Override // FIXME : Way too long
	public String toString () {
		StringBuilder sb;
		sb = new StringBuilder();
		sb.append("Attack damage   \t").append(ATTACK_DAMAGE).append("\n");
		sb.append("Ability power   \t").append(ABILITY_POWER).append("\n");
		sb.append("Critical chance \t").append(CRITICAL_CHANCE).append("\n");
		sb.append("Critical damage \t").append(CRITICAL_DAMAGE).append("\n");
		sb.append("Armor           \t").append(ARMOR).append("\n");
		sb.append("Magic resistance\t").append(MAGIC_RESISTANCE).append("\n");
		sb.append("Heal & Shield   \t").append(HEAL_SHIELD).append("\n");
		sb.append("Ability Haste   \t").append(ABILITY_HASTE).append("\n");
		return sb.toString();
	}
	
	public void setAll (Statistic... statistics) {
		for(Statistic s : statistics) {
			setStatByName(s.getName(), s.getBase());
		}
	}
}
