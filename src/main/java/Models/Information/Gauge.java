package Models.Information;

import Util.UtilMenu;
import lombok.Data;

@Data
public class Gauge {
	private String gaugeName;
	private double max;
	private double current;
	private double regen;
	private double regen_augment;
	
	public Gauge (double max, double regen, double regen_augment, String gaugeName) {
		this.max = max;
		this.current = max;
		this.regen = regen;
		this.regen_augment = regen_augment;
		this.gaugeName = gaugeName;
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
	
	public void update (double max, double regen, double regen_augment) {
		double healthPercentage = Math.ceil(this.current / this.max * 100);
		this.max = max;
		this.regen = regen;
		this.regen_augment = regen_augment;
		
		this.current = this.max * healthPercentage / 100;
	}
	
	public double percentRemaining () {
		return current / max * 100;
	}
	
	public double percentMissing () {
		return (max - current) / max * 100;
	}
	
	@Override
	public String toString () {
		StringBuilder sb = new StringBuilder();
		
		// Calculate percentage of current value relative to max value
		double percentage   = current / max * 100;
		int    numFullBars  = (int) percentage;
		int    numEmptyBars = 100 - numFullBars;
		
		// Build string with current value, max value, and gauge of full and empty bars
		String values      = (int) current + "/" + (int) max + " :";
		int    spacesB4    = Math.max(2, 18 - values.length());
		String barGauge    = "[" + "|".repeat(Math.min(100, numFullBars)) + " ".repeat(Math.max(0, numEmptyBars)) +
			"]";
		int    spacesAfter = Math.max(3, 124 - (values.length() + spacesB4 + barGauge.length()));
		String percent     = String.format("%.1f%%\t" + this.gaugeName, percentage);
		
		if (percentage > 100) {
			values = UtilMenu.bold(UtilMenu.green(values));
			percent = UtilMenu.bold(UtilMenu.green(percent));
		}
		
		sb.append(values).append(" ".repeat(spacesB4)).append(barGauge).append(" ".repeat(spacesAfter)).append(percent);
		
		return sb.toString();
	}
}
