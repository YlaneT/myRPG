package Models.Information;

import Constants.Stats.DD_Stats;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(Enclosed.class)
public class PrimaryStatsPatternTest {
	
	
	@RunWith(Parameterized.class)
	public static class MagePatternTest {
		private int level;
		private int intelligence;
		
		public MagePatternTest (int levelTest, int intel) {
			this.level = levelTest;
			this.intelligence = intel;
		}
		
		@Parameterized.Parameters
		public static List<Object[]> data () {
			return Arrays.asList(new Object[][] {
				{5, 2}, {7, 3}, {20, 10}
			});
		}
		
		@Test
		public void magePatternTest () {
			PrimaryStats statsMage = new PrimaryStats();
			statsMage.setLevel(this.level);
			
			// Place half points in INT
			// Randomly place rest in INT | WIS | CON
			statsMage.pattern("Mage");
			
			// Checks total number of stats
			int allStats =
				statsMage.getForce() + statsMage.getDexterity() + statsMage.getIntelligence() + statsMage.getConstitution() + statsMage.getWisdom();
			assertEquals(this.level, allStats);
			
			// Checks that there is no points in FOR and DEX
			assertEquals(0, statsMage.getForce());
			assertEquals(0, statsMage.getDexterity());
			
			// Checks that there is at least 2 points in INT
			assertTrue(statsMage.getIntelligence() >= this.intelligence);
		}
	}
	
	
	
	@RunWith(Parameterized.class)
	public static class TankPatternTest {
		private int level;
		private int minConst;
		
		public TankPatternTest (int levelTest, int main) {
			this.level = levelTest;
			this.minConst = main;
		}
		
		@Parameterized.Parameters
		public static List<Object[]> data () {
			return Arrays.asList(new Object[][] {
				{5, 2}, {7, 3}, {20, 10} // Tank
			});
		}
		
		@Test
		public void tankPatternTest () {
			PrimaryStats statsTank = new PrimaryStats();
			statsTank.setLevel(this.level);
			
			// Place half points int CON
			// Place rest in order FOR - DEX - INT - CON - WIS
			statsTank.pattern("Tank");
			
			// Checks total number of stats
			int allStats =
				statsTank.getForce() + statsTank.getDexterity() + statsTank.getIntelligence() + statsTank.getConstitution() + statsTank.getWisdom();
			assertEquals(this.level, allStats);
			
			// Checks min requirements for CON
			assertTrue(statsTank.getConstitution() >= this.minConst);
		}
	}
	
	
	
	@RunWith(Parameterized.class)
	public static class RandomPatternTest {
		private int level;
		
		public RandomPatternTest (int levelTest) {
			this.level = levelTest;
		}
		
		@Parameterized.Parameters
		public static List<Object[]> data () {
			return Arrays.asList(new Object[][] {{5}, {7}, {10}, {20}});
		}
		
		@Test
		public void randomPatternTest () {
			PrimaryStats statsRandom = new PrimaryStats();
			statsRandom.setLevel(this.level);
			
			statsRandom.pattern("Random");
			
			// Checks total number of stats
			int allStats =
				statsRandom.getForce() + statsRandom.getDexterity() + statsRandom.getIntelligence() + statsRandom.getConstitution() + statsRandom.getWisdom();
			assertEquals(this.level, allStats);
		}
	}
	
	
	
	@RunWith(Parameterized.class)
	public static class SpecializedPatternTest {
		private int      level;
		private DD_Stats specialization;
		
		
		public SpecializedPatternTest (int levelTest, DD_Stats spe) {
			this.level = levelTest;
			this.specialization = spe;
		}
		
		@Parameterized.Parameters
		public static List<Object[]> data () {
			return Arrays.asList(new Object[][] {
				{1, DD_Stats.FOR}, {3, DD_Stats.FOR}, {6, DD_Stats.DEX}, {10, DD_Stats.DEX}, {15, DD_Stats.INT}, {
				21, DD_Stats.INT
			}, {28, DD_Stats.CON}, {29, DD_Stats.CON}, {31, DD_Stats.WIS}, {34, DD_Stats.WIS}
			});
		}
		
		@Test
		public void specializedPatternTest () {
			PrimaryStats statsSpe = new PrimaryStats();
			statsSpe.setLevel(this.level);
			
			statsSpe.specializedPattern(specialization);
			
			// Checks total number of stats
			int allStats =
				statsSpe.getForce() + statsSpe.getDexterity() + statsSpe.getIntelligence() + statsSpe.getConstitution() + statsSpe.getWisdom();
			assertEquals(this.level, allStats);
			
			// Checks each stat
			switch (this.specialization) {
				case FOR:
					assertEquals(this.level, statsSpe.getForce());
					assertEquals(0, statsSpe.getDexterity());
					assertEquals(0, statsSpe.getIntelligence());
					assertEquals(0, statsSpe.getConstitution());
					assertEquals(0, statsSpe.getWisdom());
					break;
				case DEX:
					assertEquals(0, statsSpe.getForce());
					assertEquals(this.level, statsSpe.getDexterity());
					assertEquals(0, statsSpe.getIntelligence());
					assertEquals(0, statsSpe.getConstitution());
					assertEquals(0, statsSpe.getWisdom());
					break;
				case INT:
					assertEquals(0, statsSpe.getForce());
					assertEquals(0, statsSpe.getDexterity());
					assertEquals(this.level, statsSpe.getIntelligence());
					assertEquals(0, statsSpe.getConstitution());
					assertEquals(0, statsSpe.getWisdom());
					break;
				case CON:
					assertEquals(0, statsSpe.getForce());
					assertEquals(0, statsSpe.getDexterity());
					assertEquals(0, statsSpe.getIntelligence());
					assertEquals(this.level, statsSpe.getConstitution());
					assertEquals(0, statsSpe.getWisdom());
					break;
				case WIS:
					assertEquals(0, statsSpe.getForce());
					assertEquals(0, statsSpe.getDexterity());
					assertEquals(0, statsSpe.getIntelligence());
					assertEquals(0, statsSpe.getConstitution());
					assertEquals(this.level, statsSpe.getWisdom());
					break;
				default:
					fail("Specialization error");
			}
		}
	}
}
