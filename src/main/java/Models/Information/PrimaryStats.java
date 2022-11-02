package Models.Information;

import Constants.Stats.DD_Stats;
import Constants.Stats.Statistic_name;
import Util.UtilMenu;
import lombok.Data;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.InputStream;

import java.util.*;

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
		}
	}
	
	public Statistics calculateBaseStats () {
		Statistics baseStats = new Statistics();
		
		String filename1 = "src/main/java/Constants/Stats/stats_level_0.json";
		String filename2 = "src/main/java/Constants/Stats/stats_per_primary.json";
		String filename3 = "src/main/java/Constants/Stats/stats_level_up.json";
		
		InputStream input1 = PrimaryStats.class.getResourceAsStream(filename1);
		InputStream input2 = PrimaryStats.class.getResourceAsStream(filename2);
		InputStream input3 = PrimaryStats.class.getResourceAsStream(filename3);
		
		assert input1 != null;
		assert input2 != null;
		assert input3 != null;
		
		// Set stats at level 0
		JSONTokener lvl_0_tokener = new JSONTokener(input1);
		JSONObject  lvl_0_object  = new JSONObject(lvl_0_tokener);
		for(Iterator<String> it = lvl_0_object.keys() ; it.hasNext() ; ) {
			String stat = it.next();
			baseStats.setStatByName(Statistic_name.valueOf(stat), lvl_0_object.getDouble(stat));
		}
		
		// Add stats per Primary
		JSONTokener stats_per_DD_tokener = new JSONTokener(input2);
		JSONObject  stats_per_DD_object  = new JSONObject(stats_per_DD_tokener);
		int         multiplier;
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
			baseStats.incrementStatByName(Statistic_name.valueOf(stat),
				stats_per_DD_object.getDouble(stat) * multiplier);
		}
		
		// Add stats per level
		JSONTokener stats_per_level_tokener = new JSONTokener(input3);
		JSONObject  stats_per_level_object  = new JSONObject(stats_per_level_tokener);
		for(Iterator<String> it = stats_per_DD_object.keys() ; it.hasNext() ; ) {
			String stat = it.next();
			baseStats.incrementStatByName(Statistic_name.valueOf(stat), stats_per_DD_object.getDouble(stat) * level);
		}
		
		return baseStats;
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