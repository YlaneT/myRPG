package Models.Skills;

abstract class AbstractSkill {
	double cooldown;
	double castTime;
	double manaCost;
	double energyCost;
	
	abstract void apply (/*Character target*/);
}



public abstract class Skill extends AbstractSkill {
	
	public Skill (double cooldown, double castTime, double manaCost, double energyCost) {
		this.cooldown = cooldown;
		this.castTime = castTime;
		this.manaCost = manaCost;
		this.energyCost = energyCost;
	}
}
