package Models.Entities;

import Constants.Side;
import org.junit.Test;

import static org.junit.Assert.*;
import static Constants.Stats.Statistic_name.*;

import Models.Entities.Player;

public class CharacterMinimalConstructorTest {
	@Test
	public void PrimaryStatsTest () {
		String name       = "nameTest";
		Side   side       = Side.ALLY;
		Player playerTest = new Player(name);
		assertEquals(name, playerTest.getName());
		assertEquals(side, playerTest.getSide());
		assertEquals(0, playerTest.getLevel(), 0);
		assertEquals(0, playerTest.getFOR(), 0);
		assertEquals(0, playerTest.getDEX(), 0);
		assertEquals(0, playerTest.getINT(), 0);
		assertEquals(0, playerTest.getCON(), 0);
		assertEquals(0, playerTest.getWIS(), 0);
	}
	
	@Test
	public void BaseStatsTest () {
		String name       = "nameTest";
		Player playerTest = new Player(name);
		assertEquals(name, playerTest.getName());
		
		// HEALTH
		assertEquals(50, playerTest.getBaseStatByName(MAX_HEALTH), 0);
		assertEquals(5, playerTest.getBaseStatByName(HEALTH_REGENERATION), 0);
		assertEquals(0, playerTest.getBaseStatByName(HEALTH_REGEN_AUGMENT), 0);
		// MANA
		assertEquals(50, playerTest.getBaseStatByName(MAX_MANA), 0);
		assertEquals(5, playerTest.getBaseStatByName(MANA_REGENERATION), 0);
		assertEquals(0, playerTest.getBaseStatByName(MANA_REGEN_AUGMENT), 0);
		// OFFENSE
		assertEquals(5, playerTest.getBaseStatByName(ATTACK_DAMAGE), 0);
		assertEquals(0, playerTest.getBaseStatByName(ABILITY_POWER), 0);
		// DEFENSE
		assertEquals(5, playerTest.getBaseStatByName(ARMOR), 0);
		assertEquals(0, playerTest.getBaseStatByName(MAGIC_RESISTANCE), 0);
		// CRITICAL
		assertEquals(10, playerTest.getBaseStatByName(CRITICAL_CHANCE), 0);
		assertEquals(30, playerTest.getBaseStatByName(CRITICAL_DAMAGE), 0);
		// MISC
		assertEquals(0, playerTest.getBaseStatByName(HEAL), 0);
		assertEquals(0, playerTest.getBaseStatByName(SHIELD), 0);
		assertEquals(0, playerTest.getBaseStatByName(ABILITY_HASTE), 0);
		// ENERGY
		assertEquals(5, playerTest.getBaseStatByName(MAX_ENERGY), 0);
	}
	
	@Test
	public void BonusStatsTest () {
		String name       = "nameTest";
		Player playerTest = new Player(name);
		assertEquals(name, playerTest.getName());
		
		// HEALTH
		assertEquals(0, playerTest.getBonusStatByName(MAX_HEALTH), 0);
		assertEquals(0, playerTest.getBonusStatByName(HEALTH_REGENERATION), 0);
		assertEquals(0, playerTest.getBonusStatByName(HEALTH_REGEN_AUGMENT), 0);
		// MANA
		assertEquals(0, playerTest.getBonusStatByName(MAX_MANA), 0);
		assertEquals(0, playerTest.getBonusStatByName(MANA_REGENERATION), 0);
		assertEquals(0, playerTest.getBonusStatByName(MANA_REGEN_AUGMENT), 0);
		// OFFENSE
		assertEquals(0, playerTest.getBonusStatByName(ATTACK_DAMAGE), 0);
		assertEquals(0, playerTest.getBonusStatByName(ABILITY_POWER), 0);
		// DEFENSE
		assertEquals(0, playerTest.getBonusStatByName(ARMOR), 0);
		assertEquals(0, playerTest.getBonusStatByName(MAGIC_RESISTANCE), 0);
		// CRITICAL
		assertEquals(0, playerTest.getBonusStatByName(CRITICAL_CHANCE), 0);
		assertEquals(0, playerTest.getBonusStatByName(CRITICAL_DAMAGE), 0);
		// MISC
		assertEquals(0, playerTest.getBonusStatByName(HEAL), 0);
		assertEquals(0, playerTest.getBonusStatByName(SHIELD), 0);
		assertEquals(0, playerTest.getBonusStatByName(ABILITY_HASTE), 0);
		// ENERGY
		assertEquals(0, playerTest.getBonusStatByName(MAX_ENERGY), 0);
	}
	
	@Test
	public void CharacterMinimalConstrutor_GaugesTest () {
		String name       = "nameTest";
		Player playerTest = new Player(name);
		assertEquals(name, playerTest.getName());
		
		// HEALTH
		assertEquals(50, playerTest.getHealth().getMax(), 0);
		assertEquals(5, playerTest.getHealth().getRegen(), 0);
		assertEquals(0, playerTest.getHealth().getRegen_augment(), 0);
		// MANA
		assertEquals(50, playerTest.getMana().getMax(), 0);
		assertEquals(5, playerTest.getMana().getRegen(), 0);
		assertEquals(0, playerTest.getMana().getRegen_augment(), 0);
	}
}
