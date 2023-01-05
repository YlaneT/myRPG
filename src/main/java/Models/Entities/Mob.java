package Models.Entities;

/**
 * The lowest kind of monster, they don't give much XP
 * but they are easy to kill and drop miscallenous items
 */
public class Mob extends Enemy {
	public Mob (String name) {
		super(name);
	}
}
