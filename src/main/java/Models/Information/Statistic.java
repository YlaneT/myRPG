package Models.Information;

import Constants.Stats.Statistic_name;
import lombok.Data;

@Data
public class Statistic {
	Statistic_name name;
	double         base;
	double         current;
	
	public Statistic (Statistic_name name, double base) {
		this.name = name;
		this.base = base;
		this.current = base;
	}
	
	public void add (double value) {
		base += value;
	}
	
	public void remove (double value) {
		base = Math.max(base - value, 0);
	}
}
