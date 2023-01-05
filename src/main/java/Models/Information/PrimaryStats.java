package Models.Information;

import Constants.Stats.DD_Stats;
import Constants.Stats.Statistic_name;
import Util.UtilMenu;
import lombok.Data;
import org.json.JSONObject;

import java.util.Iterator;

import static Constants.Stats.DD_Stats.*;
import static Util.UtilJson.readJson;

@Data
public class PrimaryStats {
	private Experience exp_object;
	
	private int force;
	private int dexterity;
	private int intelligence;
	private int constitution;
	private int wisdom;
	private int UNATTRIBUTED;
	
	/* CONSTRUCTORS */
	public PrimaryStats () {
		this.exp_object = new Experience();
		this.force = 0;
		this.dexterity = 0;
		this.intelligence = 0;
		this.constitution = 0;
		this.wisdom = 0;
		this.UNATTRIBUTED = 0;
	}
	
	public PrimaryStats (int level) {
		this.exp_object = new Experience(level, "level");
		
		this.force = 0;
		this.dexterity = 0;
		this.intelligence = 0;
		this.constitution = 0;
		this.wisdom = 0;
		this.UNATTRIBUTED = level;
	}
	
	public PrimaryStats (int level, String type, int FOR, int DEX, int INT, int CON, int WIS, int UNA) {
		// TODO : Check if type in "level" / "total exp"
		this.exp_object = new Experience(level, type);
		
		this.force = FOR;
		this.dexterity = DEX;
		this.intelligence = INT;
		this.constitution = CON;
		this.wisdom = WIS;
		this.UNATTRIBUTED = UNA;
	}
	
	/* GETTERS / SETTERS */
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
			case UNA:
				setUNATTRIBUTED(value);
				break;
		}
	}
	
	public int getStat (DD_Stats name) {
		switch (name) {
			case FOR:
				return getForce();
			case DEX:
				return getDexterity();
			case INT:
				return getIntelligence();
			case CON:
				return getConstitution();
			case WIS:
				return getWisdom();
			case UNA:
				return getUNATTRIBUTED();
			default:
				UtilMenu.error("Couldn't find " + name);
				return -1;
		}
	}
	
	/* EXPERIENCE */
	public void giveExp (int amount) {
		int startLevel = this.getExp_object().getLevel();
		this.exp_object.giveExperience(amount);
		this.UNATTRIBUTED += this.getExp_object().getLevel() - startLevel;
	}
	
	public void setLevel (int level) {
		int startLevel = this.getExp_object().getLevel();
		this.exp_object.setLevel(level);
		this.UNATTRIBUTED += this.getExp_object().getLevel() - startLevel;
	}
	
	public void setTotal_experience (int amount) {
		int startLevel = this.getExp_object().getLevel();
		this.exp_object.setTotal_experience(amount);
		this.UNATTRIBUTED += this.getExp_object().getLevel() - startLevel;
	}
	
	
	/* ADD PRIMARY STAT POINTS */
	public void incrementStat (DD_Stats statName) {
		this.incrementStat(statName, 1);
	}
	
	public void incrementStat (DD_Stats statName, int value) {
		switch (statName) {
			case FOR:
				this.force += value;
				break;
			case DEX:
				this.dexterity += value;
				break;
			case INT:
				this.intelligence += value;
				break;
			case CON:
				this.constitution += value;
				break;
			case WIS:
				this.wisdom += value;
				break;
			case UNA:
				this.UNATTRIBUTED += value;
				break;
		}
	}
	
	public void putStat (DD_Stats statName) {
		putStat(statName, 1);
	}
	
	public void putStat (DD_Stats statName, int value) {
		if (this.UNATTRIBUTED >= value) {
			incrementStat(statName, value);
			this.UNATTRIBUTED -= value;
		}
		else {
			UtilMenu.warning("Not enough unattributed stat points");
		}
	}
	
	public void specializedPattern (DD_Stats name) {
		this.putStat(name, UNATTRIBUTED);
	}
	
	public void pattern (String pattern) {
		int    other;
		switch (pattern) {
			case "Mage":
				int intel = UNATTRIBUTED / 2;
				other = UNATTRIBUTED - intel;
				this.putStat(INT, intel);
				for(int i = 0 ; i < other ; i++) {
					putStat(randomStat(INT, WIS, CON));
				}
				break;
			case "Tank":
				int constit = UNATTRIBUTED / 2;
				other = UNATTRIBUTED - constit;
				this.putStat(CON, constit);
				for(int i = 0 ; i < other ; i++) {
					putStat(randomStat(true));
				}
				break;
			case "Random":
				while (UNATTRIBUTED > 0) {
					putStat(randomStat(true));
				}
				break;
			default:
				UtilMenu.error("Error in PrimaryStat.pattern. pattern not found : " + pattern);
		}
	}
	
	/* BASE STATS */
	public Statistics calculateBaseStats () {
		Statistics baseStats = new Statistics();
		
		String statsFolder = "src/main/java/Constants/Stats/";
		String filename1   = statsFolder + "stats_level_0.json";
		String filename2   = statsFolder + "stats_per_primary.json";
		String filename3   = statsFolder + "stats_level_up.json";
		
		// Set stats at level 0
		JSONObject lvl_0_object = readJson(filename1);
		for(Iterator<String> it = lvl_0_object.keys() ; it.hasNext() ; ) {
			String stat = it.next();
			baseStats.setStatByName(Statistic_name.valueOf(stat), lvl_0_object.getDouble(stat));
		}
		
		// Add stats per Primary
		JSONObject stats_per_DD_object = readJson(filename2);
		int        multiplier;
		for(Iterator<String> it = stats_per_DD_object.keys() ; it.hasNext() ; ) {
			String stat = it.next();
			switch (stat) {
				case "FOR":
					multiplier = getForce();
					break;
				case "DEX":
					multiplier = getDexterity();
					break;
				case "INT":
					multiplier = getIntelligence();
					break;
				case "CON":
					multiplier = getConstitution();
					break;
				case "WIS":
					multiplier = getWisdom();
					break;
				default:
					UtilMenu.error("Primary stat not found");
					multiplier = 0;
			}
			if (multiplier != 0) {
				JSONObject secondaries_for_DD = stats_per_DD_object.getJSONObject(stat);
				for(Iterator<String> ite = secondaries_for_DD.keys() ; ite.hasNext() ; ) {
					String secondary = ite.next();
					baseStats.incrementStatByName(Statistic_name.valueOf(secondary),
						secondaries_for_DD.getDouble(secondary) * multiplier);
				}
			}
		}
		
		// Add stats per level
		JSONObject stats_per_level_object = readJson(filename3);
		for(Iterator<String> it = stats_per_level_object.keys() ; it.hasNext() ; ) {
			String stat = it.next();
			baseStats.incrementStatByName(Statistic_name.valueOf(stat),
				stats_per_level_object.getDouble(stat) * exp_object.getLevel());
		}
		
		return baseStats;
	}
	
}
