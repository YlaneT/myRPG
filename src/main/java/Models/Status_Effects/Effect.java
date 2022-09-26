package Models.Status_Effects;


import Constants.Moment;
import lombok.Data;

import static Util.Util.minus;

@Data
abstract class AbstractEffect {
	// Character launcher
	// Character target
	public Moment phase;
	
	abstract void apply ();
}



public abstract class Effect extends AbstractEffect {

}
