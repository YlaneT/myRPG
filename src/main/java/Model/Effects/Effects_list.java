package Model.Effects;

import Constants.Moment;

import java.util.ArrayList;
import java.util.Iterator;

public class Effects_list {
	ArrayList<Effect> effects;
	
	public void apply_phase (Moment phase) {
		for(Effect e : effects) {
			if (e.getPhase().equals(phase)) {
				e.apply();
			}
		}
		check_null_duration();
	}
	
	private void check_null_duration () {
		Iterator<Effect> it = effects.iterator();
		while (it.hasNext()) {
			Effect e = it.next();
			if (e.getDuration() == 0) {
				it.remove();
			}
		}
	}
}
