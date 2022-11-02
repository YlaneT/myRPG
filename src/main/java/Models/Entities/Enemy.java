package Models.Entities;

import static Constants.Side.*;

import Models.Information.Statistic;

import java.util.ArrayList;

public abstract class Enemy extends Character {
	
	public Enemy (String name) {
		super(name, ENEMY);
	}
}
