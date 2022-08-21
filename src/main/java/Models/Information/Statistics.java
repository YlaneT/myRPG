package Models.Information;

public class Statistics {
	int ATTACK_DAMAGE;
	int ABILITY_POWER;
	int CRITICAL_CHANCE;
	int CRITICAL_DAMAGE;
	int HEALTH;
	int ARMOR;
	int MAGIC_RESISTANCE;
	int HEALTH_REGENERATION;
	int MANA;
	int MANA_REGENERATION;
	int HEAL_SHIELD;
	int ABILITY_HASTE;
	
	public int getATTACK_DAMAGE () {
		return ATTACK_DAMAGE;
	}
	
	public void setATTACK_DAMAGE (int ATTACK_DAMAGE) {
		this.ATTACK_DAMAGE = ATTACK_DAMAGE;
	}
	
	public int getABILITY_POWER () {
		return ABILITY_POWER;
	}
	
	public void setABILITY_POWER (int ABILITY_POWER) {
		this.ABILITY_POWER = ABILITY_POWER;
	}
	
	public int getCRITICAL_CHANCE () {
		return CRITICAL_CHANCE;
	}
	
	public void setCRITICAL_CHANCE (int CRITICAL_CHANCE) {
		this.CRITICAL_CHANCE = CRITICAL_CHANCE;
	}
	
	public int getCRITICAL_DAMAGE () {
		return CRITICAL_DAMAGE;
	}
	
	public void setCRITICAL_DAMAGE (int CRITICAL_DAMAGE) {
		this.CRITICAL_DAMAGE = CRITICAL_DAMAGE;
	}
	
	public int getHEALTH () {
		return HEALTH;
	}
	
	public void setHEALTH (int HEALTH) {
		this.HEALTH = HEALTH;
	}
	
	public int getARMOR () {
		return ARMOR;
	}
	
	public void setARMOR (int ARMOR) {
		this.ARMOR = ARMOR;
	}
	
	public int getMAGIC_RESISTANCE () {
		return MAGIC_RESISTANCE;
	}
	
	public void setMAGIC_RESISTANCE (int MAGIC_RESISTANCE) {
		this.MAGIC_RESISTANCE = MAGIC_RESISTANCE;
	}
	
	public int getHEALTH_REGENERATION () {
		return HEALTH_REGENERATION;
	}
	
	public void setHEALTH_REGENERATION (int HEALTH_REGENERATION) {
		this.HEALTH_REGENERATION = HEALTH_REGENERATION;
	}
	
	public int getMANA () {
		return MANA;
	}
	
	public void setMANA (int MANA) {
		this.MANA = MANA;
	}
	
	public int getMANA_REGENERATION () {
		return MANA_REGENERATION;
	}
	
	public void setMANA_REGENERATION (int MANA_REGENERATION) {
		this.MANA_REGENERATION = MANA_REGENERATION;
	}
	
	public int getHEAL_SHIELD () {
		return HEAL_SHIELD;
	}
	
	public void setHEAL_SHIELD (int HEAL_SHIELD) {
		this.HEAL_SHIELD = HEAL_SHIELD;
	}
	
	public int getABILITY_HASTE () {
		return ABILITY_HASTE;
	}
	
	public void setABILITY_HASTE (int ABILITY_HASTE) {
		this.ABILITY_HASTE = ABILITY_HASTE;
	}
	
	public void setAll (int ad, int ap, int cc, int cd, int hp, int ar, int mr, int hp_s, int mana, int mana_s,
		int heal, int ah) {
		setATTACK_DAMAGE(ad);
		setABILITY_POWER(ap);
		setCRITICAL_CHANCE(cc);
		setCRITICAL_DAMAGE(cd);
		setHEALTH(hp);
		setARMOR(ar);
		setMAGIC_RESISTANCE(mr);
		setHEALTH_REGENERATION(hp_s);
		setMANA(mana);
		setMANA_REGENERATION(mana_s);
		setHEAL_SHIELD(heal);
		setABILITY_HASTE(ah);
	}
	
	@Override
	public String toString () {
		StringBuilder sb;
		sb = new StringBuilder("Attack damage   \t").append(ATTACK_DAMAGE).append("\n");
		sb.append("Ability power   \t").append(ABILITY_POWER).append("\n");
		sb.append("Critical chance \t").append(CRITICAL_CHANCE).append("\n");
		sb.append("Critical damage \t").append(CRITICAL_DAMAGE).append("\n");
		sb.append("Health          \t").append(HEALTH).append("\n");
		sb.append("Armor           \t").append(ARMOR).append("\n");
		sb.append("Magic resistance\t").append(MAGIC_RESISTANCE).append("\n");
		sb.append("Health regen    \t").append(HEALTH_REGENERATION).append("\n");
		sb.append("Mana            \t").append(MANA).append("\n");
		sb.append("Mana regen      \t").append(MANA_REGENERATION).append("\n");
		sb.append("Heal & Shield   \t").append(HEAL_SHIELD).append("\n");
		sb.append("Ability Haste   \t").append(ABILITY_HASTE).append("\n");
		return sb.toString();
	}
}
