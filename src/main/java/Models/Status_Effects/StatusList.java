package Models.Status_Effects;

import Constants.Moment;

import java.util.ArrayList;

public class StatusList {
	ArrayList<Status> statuses;
	
	public void apply_phase (Moment phase) {
		for(Status s : statuses) {
			if (s.getStatusEffect().getPhase().equals(phase)) {
				s.apply();
			}
		}
		check_null_duration();
	}
	
	private void check_null_duration () {
		statuses.removeIf(e -> e.getDuration() == 0);
	}
}
