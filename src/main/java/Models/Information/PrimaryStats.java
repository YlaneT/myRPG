package Models.Information;

import Constants.Stats.DD_Stats;
import Util.UtilMenu;
import lombok.Data;

import java.util.Random;

import static Constants.Stats.DD_Stats.*;

@Data
public class PrimaryStats {
	private int level;
	private int force;
	private int dexterity;
	private int intelligence;
	private int constitution;
	private int wisdom;
	
	public PrimaryStats () {
		this.level = 0;
		this.force = 0;
		this.dexterity = 0;
		this.intelligence = 0;
		this.constitution = 0;
		this.wisdom = 0;
	}
	
	public PrimaryStats (int level) {
		this.level = level;
		this.force = 0;
		this.dexterity = 0;
		this.intelligence = 0;
		this.constitution = 0;
		this.wisdom = 0;
	}
	
	public PrimaryStats (int level, int FOR, int DEX, int INT, int CON, int WIS) {
		this.level = level;
		this.force = FOR;
		this.dexterity = DEX;
		this.intelligence = INT;
		this.constitution = CON;
		this.wisdom = WIS;
	}
	
	public void setStat (DD_Stats name, int value) {
		switch (name) {
			case FOR:
				setForce(value);
				break;
			case DEX:
				setDexterity(value);
				break;
			case INT:
				setIntelligence(value);
				break;
			case CON:
				setConstitution(value);
				break;
			case WIS:
				setWisdom(value);
				break;
		}
	}
	
	public Statistics levelUp (DD_Stats augmentedStat) {
		this.level += 1;
		incrementStat(augmentedStat);
		return calculateBaseStats();
	}
	
	public void incrementStat (DD_Stats statName) {
		switch (statName) {
			case FOR:
				this.force += 1;
				break;
			case DEX:
				this.dexterity += 1;
				break;
			case INT:
				this.intelligence += 1;
				break;
			case CON:
				this.constitution += 1;
				break;
			case WIS:
				this.wisdom += 1;
				break;
		}
	}
	
	public Statistics calculateBaseStats () {
		// TODO : Get values from Constants.Stats.v2
		UtilMenu.error("NOT IMPLEMENTED");
		return new Statistics();
	}
	
	public void pattern (int level, String pattern) {
		Random r = new Random();
		int    other;
		switch (pattern) {
			case "Mage":
				int intel = (int) Math.ceil((double) level / 2);
				other = level - intel;
				this.setStat(INT, intel);
				for(int i = 0 ; i < other ; i++) {
					int pick = r.nextInt(3);
					switch (pick) {
						case 0:
							incrementStat(INT);
							break;
						case 1:
							incrementStat(WIS);
							break;
						case 2:
							incrementStat(CON);
							break;
						default:
							UtilMenu.error("Error in PrimaryStat.pattern -> Mage. Random returned " + pick);
					}
				}
				break;
			case "Tank":
				int constit = (int) Math.ceil((double) level / 2);
				other = level - constit;
				this.setStat(CON, constit);
				for(int i = 0 ; i < other ; i++) {
					int pick = r.nextInt(values().length);
					incrementStat(values()[pick]);
				}
				break;
			case "Random":
				for(int i = 0 ; i < level ; i++) {
					int pick = r.nextInt(values().length);
					incrementStat(values()[pick]);
				}
				break;
			default:
				UtilMenu.error("Error in PrimaryStat.pattern. pattern not found : " + pattern);
		}
	}
}
