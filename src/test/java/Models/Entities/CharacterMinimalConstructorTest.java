package Models.Entities;

import Constants.Side;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.List;

import static Constants.Stats.Statistic_name.*;
import static org.junit.Assert.assertEquals;

@RunWith(Enclosed.class)
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
		assertEquals(0, playerTest.getUNA(), 0);
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
		assertEquals(15, playerTest.getBaseStatByName(ATTACK_DAMAGE), 0);
		assertEquals(0, playerTest.getBaseStatByName(ABILITY_POWER), 0);
		// DEFENSE
		assertEquals(20, playerTest.getBaseStatByName(ARMOR), 0);
		assertEquals(10, playerTest.getBaseStatByName(MAGIC_RESISTANCE), 0);
		// CRITICAL
		assertEquals(0, playerTest.getBaseStatByName(CRITICAL_CHANCE), 0);
		assertEquals(30, playerTest.getBaseStatByName(CRITICAL_DAMAGE), 0);
		// MISC
		assertEquals(0, playerTest.getBaseStatByName(HEAL), 0);
		assertEquals(0, playerTest.getBaseStatByName(SHIELD), 0);
		assertEquals(0, playerTest.getBaseStatByName(ABILITY_HASTE), 0);
		// ENERGY
		assertEquals(5, playerTest.getBaseStatByName(MAX_ENERGY), 0);
	}
	
	@Test
	public void GaugesTest () {
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
	


	@RunWith(Parameterized.class)
	public static class ExperienceObjectTest {
		private int level;
		private int experience;
		private int total_experience;
		private int next_level;
		
		private int added;
		
		public ExperienceObjectTest (int level, int experience, int total_experience, int next_level, int added) {
			this.level = level;
			this.experience = experience;
			this.total_experience = total_experience;
			this.next_level = next_level;
			this.added = added;
		}
		
		@Parameterized.Parameters
		public static List<Object[]> data () {
			return Arrays.asList(new Object[][] {
				{0, 0, 0, 50, 40},
				{1, 0, 50, 62, 41},
				{3, 0, 188, 93, 49},
				{5, 0, 396, 141, 65},
				{7, 0, 711, 214, 89},
				{9, 0, 1188, 323, 121},
				{15, 0, 4650, 1120, 265},
				{30, 0, 108407, 24984, 940}
			});
		}
		
		@Test
		public void setLevelTest () {
			Player playerTest = new Player("playerTest", level);
			
			assertEquals(level, playerTest.getLevel());
			assertEquals(experience, playerTest.getPrimaryStats().getExp_object().getExperience());
			assertEquals(total_experience, playerTest.getPrimaryStats().getExp_object().getTotal_experience());
			assertEquals(next_level, playerTest.getPrimaryStats().getExp_object().getNext_level());
		}
		
		@Test
		public void setTotal_experienceStartLevelTest () {
			Player playerTest = new Player("playerTest");
			playerTest.getPrimaryStats().setTotal_experience(total_experience);
			
			assertEquals(level, playerTest.getLevel());
			assertEquals(experience, playerTest.getPrimaryStats().getExp_object().getExperience());
			assertEquals(total_experience, playerTest.getPrimaryStats().getExp_object().getTotal_experience());
			assertEquals(next_level, playerTest.getPrimaryStats().getExp_object().getNext_level());
		}
		
		@Test
		public void setTotal_experienceTest () {
			Player playerTest = new Player("playerTest");
			playerTest.getPrimaryStats().setTotal_experience(total_experience + added);
			
			assertEquals(level, playerTest.getLevel());
			assertEquals(experience + added, playerTest.getPrimaryStats().getExp_object().getExperience());
			assertEquals(total_experience + added, playerTest.getPrimaryStats().getExp_object().getTotal_experience());
			assertEquals(next_level, playerTest.getPrimaryStats().getExp_object().getNext_level());
		}
	}
}
