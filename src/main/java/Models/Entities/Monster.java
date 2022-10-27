package Models.Entities;

import static Constants.Side.*;

import Models.Information.Statistic;

import java.util.ArrayList;

public abstract class Monster extends Character {
	
	public Monster (String name) {
		super(name, ENEMY);
	}
	
	@Override
	protected void initCharacterstats () {}
}
