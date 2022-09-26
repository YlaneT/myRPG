package Models.Status_Effects;

import static Models.Status_Effects.StatusTypes.FIRE;

public class StatusFire extends Status {
	public StatusFire () {
		this.type = FIRE;
	}
	
	void apply () {
		// TODO : Inflict damage and reduce armor/MR
	}
}
