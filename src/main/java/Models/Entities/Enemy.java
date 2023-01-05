package Models.Entities;

import static Constants.Side.ENEMY;

public abstract class Enemy extends Character {
	
	public Enemy (String name) {
		super(name, ENEMY);
	}
}
