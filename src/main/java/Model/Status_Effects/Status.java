package Model.Status_Effects;

import Util.Util;
import lombok.Data;

import static Util.Util.minus;

@Data
public class Status {
	public int         duration;
	public Effect      statusEffect;
	public StatusTypes type;
	
	void apply () {
		if (duration != 0) {
			decrement_duration();
			statusEffect.apply();
		}
	}
	
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
