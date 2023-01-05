package Models.Information;

import lombok.Getter;
import lombok.Setter;
import org.json.JSONArray;

import static Util.UtilJson.readJsonArray;

@Getter
@Setter
public class Experience {
	private int level;
	private int experience;
	private int total_experience;
	private int next_level;
	
	/* CONSTRUCTORS */
	public Experience () {
		this.level = 0;
		this.experience = 0;
		this.total_experience = 0;
		setNext_level();
	}
	
	public Experience (int value, String type) {
		if (type.equalsIgnoreCase("total exp")) {
			setTotal_experience(value);
		}
		else if (type.equalsIgnoreCase("level")) {
			setLevel(value);
		}
	}
	
	/* Complex setters */
	public void setLevel (int level) {
		JSONArray exp_per_level = readJsonArray("src/main/java/Constants/Experience/experience_per_level.json");
		int       sommeExp      = 0;
		for(int i = 0 ; i < level ; i++) {
			sommeExp += exp_per_level.getInt(i);
		}
		setTotal_experience(sommeExp);
		
		setNext_level();
	}
	
	public void setTotal_experience (int total_exp) {
		if (this.total_experience == 0) {
			this.giveExperience(total_exp);
		}
		else {
			this.giveExperience(total_exp - this.total_experience);
		}
	}
	
	private void setNext_level () {
		JSONArray exp_per_level = readJsonArray("src/main/java/Constants/Experience/experience_per_level.json");
		setNext_level(exp_per_level.getInt(level));
	}
	
	/* On enemy kill */
	public void giveExperience (int amount) {
		while (this.experience + amount >= next_level && amount > 0) {
			int used = next_level - experience;
			amount -= used;
			total_experience += used;
			levelUp();
		}
		if (amount > 0) {
			this.experience += amount;
			this.total_experience += amount;
		}
	}
	
	private void levelUp () {
		this.level += 1;
		this.experience = 0;
		this.setNext_level();
	}
}
