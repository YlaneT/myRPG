package Model.Effects;


import Constants.Moment;
import lombok.Data;

import static Util.Util.minus;

@Data
public abstract class Effect {
	public int           duration;
	// Character launcher
	// Character target
	public Effects_types type;
	public Moment        phase;
	
	abstract void apply ();
	
	void decrement_duration (int value) {
		this.duration = minus(this.duration, value);
	}
	
	void decrement_duration () {
		decrement_duration(1);
	}
	
	void increment_duration (int value) {
		this.duration = minus(this.duration, value);
	}
	
	void increment_duration () {
		increment_duration(1);
	}
}
