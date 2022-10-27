package Models.Information;

import lombok.Data;

@Data
public class Gauge {
	private double max;
	private double current;
	private double regen;
	private double regen_augment;
	
	public Gauge (double max, double regen, double regen_augment) {
		this.max = max;
		this.current = max;
		this.regen = regen;
		this.regen_augment = regen_augment;
	}
	
	public void resetCurrent () {
		current = max;
	}
	
	public void add (double value) {
		add(value, false);
	}
	
	public void add (double value, boolean canExceed) {
		if (value + current < max) {
			current += value;
		}
		else if (canExceed) {
			if (current >= max) {
				double exceeding = current + value - max;
				current = max + exceeding / 2;
			}
			else {
				current += value / 2;
			}
		}
		else {
			current = max;
		}
	}
	
	public void remove (double value) {
		current = Math.max(current - value, 0);
	}
	
	public void regen () {
		double total_regen = regen * (1 + regen_augment / 100);
		this.add(total_regen, false);
	}
	
	public void init () {
		// TODO : initialiser avec max, regen et regen augment
	}
}
