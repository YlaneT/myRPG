package Model.Effects;

import static Model.Effects.Effects_types.FIRE;

public class Effect_Fire extends Effect {
	public Effect_Fire () {
		this.type = FIRE;
	}
	
	void apply () {
		// Character damage ELEMENTAL/MAGIC (with armor)
		decrement_duration();
	}
}
