package Model.Status_Effects;

import static Model.Status_Effects.StatusTypes.FIRE;

public class StatusFire extends Status {
	public StatusFire () {
		this.type = FIRE;
	}
	
	void apply () {
		// TODO : Inflict damage and reduce armor/MR
	}
}
