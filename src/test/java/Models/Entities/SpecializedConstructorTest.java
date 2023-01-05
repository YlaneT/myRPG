package Models.Entities;

import Constants.Side;
import Constants.Stats.DD_Stats;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.List;

import static Constants.Stats.DD_Stats.*;
import static Constants.Stats.Statistic_name.*;
import static org.junit.Assert.assertEquals;

@RunWith(Enclosed.class)
public class SpecializedConstructorTest {
	static String name = "nameTest";
	static Side   side = Side.ALLY;
	
	@Test
	public void BonusStatsTest () {
		String name       = "nameTest";
		Player playerTest = new Player(name);
		assertEquals(name, playerTest.getName());
		
		// HEALTH
		assertEquals(0, playerTest.getBonusStatByName(MAX_HEALTH), 0.000001);
		assertEquals(0, playerTest.getBonusStatByName(HEALTH_REGENERATION), 0.000001);
		assertEquals(0, playerTest.getBonusStatByName(HEALTH_REGEN_AUGMENT), 0.000001);
		// MANA
		assertEquals(0, playerTest.getBonusStatByName(MAX_MANA), 0.000001);
		assertEquals(0, playerTest.getBonusStatByName(MANA_REGENERATION), 0.000001);
		assertEquals(0, playerTest.getBonusStatByName(MANA_REGEN_AUGMENT), 0.000001);
		// OFFENSE
		assertEquals(0, playerTest.getBonusStatByName(ATTACK_DAMAGE), 0.000001);
		assertEquals(0, playerTest.getBonusStatByName(ABILITY_POWER), 0.000001);
		// DEFENSE
		assertEquals(0, playerTest.getBonusStatByName(ARMOR), 0.000001);
		assertEquals(0, playerTest.getBonusStatByName(MAGIC_RESISTANCE), 0.000001);
		// CRITICAL
		assertEquals(0, playerTest.getBonusStatByName(CRITICAL_CHANCE), 0.000001);
		assertEquals(0, playerTest.getBonusStatByName(CRITICAL_DAMAGE), 0.000001);
		// MISC
		assertEquals(0, playerTest.getBonusStatByName(HEAL), 0.000001);
		assertEquals(0, playerTest.getBonusStatByName(SHIELD), 0.000001);
		assertEquals(0, playerTest.getBonusStatByName(ABILITY_HASTE), 0.000001);
		// ENERGY
		assertEquals(0, playerTest.getBonusStatByName(MAX_ENERGY), 0.000001);
	}
	
	@Test
	public void GaugesTest () {
		String name       = "nameTest";
		Player playerTest = new Player(name);
		assertEquals(name, playerTest.getName());
		
		// HEALTH
		assertEquals(50, playerTest.getHealth().getMax(), 0.000001);
		assertEquals(5, playerTest.getHealth().getRegen(), 0.000001);
		assertEquals(0, playerTest.getHealth().getRegen_augment(), 0.000001);
		// MANA
		assertEquals(50, playerTest.getMana().getMax(), 0.000001);
		assertEquals(5, playerTest.getMana().getRegen(), 0.000001);
		assertEquals(0, playerTest.getMana().getRegen_augment(), 0.000001);
	}
	
	
	@RunWith(Parameterized.class)
	public static class BaseStatsWithDDTest {
		private int      level;
		private DD_Stats spe;
		
		private int force;
		private int dexterity;
		private int intelligence;
		private int con;
		private int wis;
		
		private double max_health;
		private double health_regeneration;
		private double health_regen_augment;
		private double max_mana;
		private double mana_regeneration;
		private double mana_regen_augment;
		private double attack_damage;
		private double ability_power;
		private double armor;
		private double magic_resistance;
		private double critical_chance;
		private double critical_damage;
		private double heal;
		private double shield;
		private double ability_haste;
		private double max_energy;
		private Player playerTest;
		
		public BaseStatsWithDDTest (DD_Stats spe, int level, int force, int dexterity, int intelligence, int con,
			int wis, double max_health, double health_regeneration, double health_regen_augment, double max_mana,
			double mana_regeneration, double mana_regen_augment, double attack_damage, double ability_power,
			double armor, double magic_resistance, double critical_chance, double critical_damage, double heal,
			double shield, double ability_haste, double max_energy) {
			this.spe = spe;
			this.level = level;
			this.force = force;
			this.dexterity = dexterity;
			this.intelligence = intelligence;
			this.con = con;
			this.wis = wis;
			this.max_health = max_health;
			this.health_regeneration = health_regeneration;
			this.health_regen_augment = health_regen_augment;
			this.max_mana = max_mana;
			this.mana_regeneration = mana_regeneration;
			this.mana_regen_augment = mana_regen_augment;
			this.attack_damage = attack_damage;
			this.ability_power = ability_power;
			this.armor = armor;
			this.magic_resistance = magic_resistance;
			this.critical_chance = critical_chance;
			this.critical_damage = critical_damage;
			this.heal = heal;
			this.shield = shield;
			this.ability_haste = ability_haste;
			this.max_energy = max_energy;
			this.playerTest = new Player(name, level, spe);
		}
		
		@Parameterized.Parameters
		public static List<Object> data () {
			return Arrays.asList(new Object[][] {
				{FOR, 5, 5, 0, 0, 0, 0, 355, 8.75, 0, 75, 7, 0, 42.5, 0, 37.5, 20, 0, 35, 25, 0, 0, 5.5},
				{DEX, 6, 0, 6, 0, 0, 0, 266, 8, 0, 140, 12.8, 0, 39, 0, 32, 10, 0, 60, 0, 0, 30, 5.6},
				{INT, 7, 0, 0, 7, 0, 0, 288, 8.5, 0, 260, 14.8, 0, 18.5, 70, 41, 27.5, 0, 30, 0, 21, 0, 5.7},
		 		{CON, 8, 0, 0, 0, 8, 0, 610, 13, 0, 90, 8.2, 0, 27, 8, 76, 50, 0, 30, 40, 0, 0, 5.8},
				{WIS, 9, 0, 0, 0, 0, 9, 500, 9.5, 0, 230, 23, 0, 24, 45, 47, 37, 0, 34.5, 27, 27, 0, 5.9}
			});
		}
		
		@Test
		public void primaryStatsTest () {
			for(DD_Stats stat : DD_Stats.values()) {
				if (stat == spe) {
					assertEquals(level, playerTest.getPrimaryStats().getStat(stat));
				}
				else {
					assertEquals(0, playerTest.getPrimaryStats().getStat(stat));
				}
			}
		}
		
		@Test
		public void baseStatsTest () {
			
			// HEALTH
			assertEquals(max_health, playerTest.getBaseStatByName(MAX_HEALTH), 0.000001);
			assertEquals(health_regeneration, playerTest.getBaseStatByName(HEALTH_REGENERATION), 0.000001);
			assertEquals(health_regen_augment, playerTest.getBaseStatByName(HEALTH_REGEN_AUGMENT), 0.000001);
			// MANA
			assertEquals(max_mana, playerTest.getBaseStatByName(MAX_MANA), 0.000001);
			assertEquals(mana_regeneration, playerTest.getBaseStatByName(MANA_REGENERATION), 0.000001);
			assertEquals(mana_regen_augment, playerTest.getBaseStatByName(MANA_REGEN_AUGMENT), 0.000001);
			// OFFENSE
			assertEquals(attack_damage, playerTest.getBaseStatByName(ATTACK_DAMAGE), 0.000001);
			assertEquals(ability_power, playerTest.getBaseStatByName(ABILITY_POWER), 0.000001);
			// DEFENSE
			assertEquals(armor, playerTest.getBaseStatByName(ARMOR), 0.000001);
			assertEquals(magic_resistance, playerTest.getBaseStatByName(MAGIC_RESISTANCE), 0.000001);
			// CRITICAL
			assertEquals(critical_chance, playerTest.getBaseStatByName(CRITICAL_CHANCE), 0.000001);
			assertEquals(critical_damage, playerTest.getBaseStatByName(CRITICAL_DAMAGE), 0.000001);
			// MISC
			assertEquals(heal, playerTest.getBaseStatByName(HEAL), 0.000001);
			assertEquals(shield, playerTest.getBaseStatByName(SHIELD), 0.000001);
			assertEquals(ability_haste, playerTest.getBaseStatByName(ABILITY_HASTE), 0.000001);
			// ENERGY
			assertEquals(max_energy, playerTest.getBaseStatByName(MAX_ENERGY), 0.000001);
		}
	}
	
	
	
	@RunWith(Parameterized.class)
	public static class BaseStatsWithLevelAndNoDD {
		private int    level;
		private double max_health;
		private double health_regeneration;
		private double health_regen_augment;
		private double max_mana;
		private double mana_regeneration;
		private double mana_regen_augment;
		private double attack_damage;
		private double ability_power;
		private double armor;
		private double magic_resistance;
		private double critical_chance;
		private double critical_damage;
		private double heal;
		private double shield;
		private double ability_haste;
		private double max_energy;
		private Player playerTest;
		
		public BaseStatsWithLevelAndNoDD (int level, double max_health, double health_regeneration,
			double health_regen_augment, double max_mana, double mana_regeneration, double mana_regen_augment,
			double attack_damage, double ability_power, double armor, double magic_resistance, double critical_chance,
			double critical_damage, double heal, double shield, double ability_haste, double max_energy) {
			this.level = level;
			this.max_health = max_health;
			this.health_regeneration = health_regeneration;
			this.health_regen_augment = health_regen_augment;
			this.max_mana = max_mana;
			this.mana_regeneration = mana_regeneration;
			this.mana_regen_augment = mana_regen_augment;
			this.attack_damage = attack_damage;
			this.ability_power = ability_power;
			this.armor = armor;
			this.magic_resistance = magic_resistance;
			this.critical_chance = critical_chance;
			this.critical_damage = critical_damage;
			this.heal = heal;
			this.shield = shield;
			this.ability_haste = ability_haste;
			this.max_energy = max_energy;
			this.playerTest = new Player(name, level);
		}
		
		@Parameterized.Parameters
		public static List<Object[]> data () {
			return Arrays.asList(new Object[][] {{0, 50, 5, 0, 50, 5, 0, 15, 0, 20, 10, 0, 30, 0, 0, 0, 5}, {2, 118, 6
				, 0, 60, 5.8, 0, 16, 0, 24, 10, 0, 30, 0, 0, 0, 5.2}, {5, 220, 7.5, 0, 75, 7, 0, 17.5, 0, 30, 10, 0,
																	   30, 0, 0, 0, 5.5}, {9, 356, 9.5, 0, 95, 8.6, 0,
																						   19.5, 0, 38, 10, 0, 30, 0,
																						   0, 0, 5.9}, {14, 526, 12, 0
													 , 120, 10.6, 0, 22, 0, 48, 10, 0, 30, 0, 0, 0, 6.4}, {20, 730, 15
													 , 0, 150, 13, 0, 25, 0, 60, 10, 0, 30, 0, 0, 0, 7}, {27, 968,
																										  18.5, 0, 185
													 , 15.8, 0, 28.5, 0, 74, 10, 0, 30, 0, 0, 0, 7.7}, {35, 1240, 22.5
													 , 0, 225, 19, 0, 32.5, 0, 90, 10, 0, 30, 0, 0, 0, 8.5}});
		}
		
		@Test
		public void BaseStatsWithNoDDTest () {
			// HEALTH
			assertEquals(max_health, playerTest.getBaseStatByName(MAX_HEALTH), 0.000001);
			assertEquals(health_regeneration, playerTest.getBaseStatByName(HEALTH_REGENERATION), 0.000001);
			assertEquals(health_regen_augment, playerTest.getBaseStatByName(HEALTH_REGEN_AUGMENT), 0.000001);
			// MANA
			assertEquals(max_mana, playerTest.getBaseStatByName(MAX_MANA), 0.000001);
			assertEquals(mana_regeneration, playerTest.getBaseStatByName(MANA_REGENERATION), 0.000001);
			assertEquals(mana_regen_augment, playerTest.getBaseStatByName(MANA_REGEN_AUGMENT), 0.000001);
			// OFFENSE
			assertEquals(attack_damage, playerTest.getBaseStatByName(ATTACK_DAMAGE), 0.000001);
			assertEquals(ability_power, playerTest.getBaseStatByName(ABILITY_POWER), 0.000001);
			// DEFENSE
			assertEquals(armor, playerTest.getBaseStatByName(ARMOR), 0.000001);
			assertEquals(magic_resistance, playerTest.getBaseStatByName(MAGIC_RESISTANCE), 0.000001);
			// CRITICAL
			assertEquals(critical_chance, playerTest.getBaseStatByName(CRITICAL_CHANCE), 0.000001);
			assertEquals(critical_damage, playerTest.getBaseStatByName(CRITICAL_DAMAGE), 0.000001);
			// MISC
			assertEquals(heal, playerTest.getBaseStatByName(HEAL), 0.000001);
			assertEquals(shield, playerTest.getBaseStatByName(SHIELD), 0.000001);
			assertEquals(ability_haste, playerTest.getBaseStatByName(ABILITY_HASTE), 0.000001);
			// ENERGY
			assertEquals(max_energy, playerTest.getBaseStatByName(MAX_ENERGY), 0.000001);
		}
	}
	
	
	
	@RunWith(Parameterized.class)
	public static class PrimaryStatsTest {
		private int level;
		
		public PrimaryStatsTest (int level) {
			this.level = level;
		}
		
		
		@Parameterized.Parameters
		public static List<Object[]> data () {
			return Arrays.asList(new Object[][] {{0}, {2}, {5}, {9}, {14}});
		}
		
		
		@Test
		public void PrimaryStatsTestNoPattern () {
			Player playerTest = new Player(name, level);
			
			assertEquals(name, playerTest.getName());
			assertEquals(side, playerTest.getSide());
			assertEquals(level, playerTest.getLevel(), 0);
			assertEquals(0, playerTest.getFOR(), 0);
			assertEquals(0, playerTest.getDEX(), 0);
			assertEquals(0, playerTest.getINT(), 0);
			assertEquals(0, playerTest.getCON(), 0);
			assertEquals(0, playerTest.getWIS(), 0);
			assertEquals(level, playerTest.getUNA(), level);
		}
	}
}
