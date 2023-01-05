package Models.Information;

import Constants.Stats.Statistic_name;
import org.junit.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class StatisticsTest {
	
	private final ByteArrayOutputStream outContent  = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent  = new ByteArrayOutputStream();
	private final PrintStream           originalOut = System.out;
	private final PrintStream           originalErr = System.err;
	
	@Before
	public void setUpStreams () {
		System.setOut(new PrintStream(outContent));
		System.setErr(new PrintStream(errContent));
	}
	
	@After
	public void restoreStreams () {
		System.setOut(originalOut);
		System.setErr(originalErr);
	}
	
	@Test
	public void testGetStatByName () {
		Statistics stats = new Statistics();
		
		// Test getting the value of a field with a positive value
		stats.setMAX_HEALTH(100);
		assertEquals(100, stats.getStatByName(Statistic_name.MAX_HEALTH), 0);
		
		stats.setHEALTH_REGENERATION(100);
		assertEquals(100, stats.getStatByName(Statistic_name.HEALTH_REGENERATION), 0);
		
		stats.setHEALTH_REGEN_AUGMENT(100);
		assertEquals(100, stats.getStatByName(Statistic_name.HEALTH_REGEN_AUGMENT), 0);
		
		stats.setMAX_MANA(100);
		assertEquals(100, stats.getStatByName(Statistic_name.MAX_MANA), 0);
		
		stats.setATTACK_DAMAGE(100);
		assertEquals(100, stats.getStatByName(Statistic_name.ATTACK_DAMAGE), 0);
		
		stats.setMANA_REGEN_AUGMENT(100);
		assertEquals(100, stats.getStatByName(Statistic_name.MANA_REGEN_AUGMENT), 0);
		
		stats.setABILITY_POWER(100);
		assertEquals(100, stats.getStatByName(Statistic_name.ABILITY_POWER), 0);
		
		stats.setARMOR(100);
		assertEquals(100, stats.getStatByName(Statistic_name.ARMOR), 0);
		
		stats.setMAGIC_RESISTANCE(100);
		assertEquals(100, stats.getStatByName(Statistic_name.MAGIC_RESISTANCE), 0);
		
		stats.setCRITICAL_CHANCE(100);
		assertEquals(100, stats.getStatByName(Statistic_name.CRITICAL_CHANCE), 0);
		
		// Test getting the value of a field with a decimal value
		stats.setCRITICAL_CHANCE(1.5);
		assertEquals(1.5, stats.getStatByName(Statistic_name.CRITICAL_CHANCE), 0);
		
		stats.setCRITICAL_DAMAGE(1.5);
		assertEquals(1.5, stats.getStatByName(Statistic_name.CRITICAL_DAMAGE), 0);
		
		stats.setHEAL(100);
		assertEquals(100, stats.getStatByName(Statistic_name.HEAL), 0);
		
		// Test getting the value of a field with a negative value
		stats.setABILITY_HASTE(-10);
		assertEquals(-10, stats.getStatByName(Statistic_name.ABILITY_HASTE), 0);
		
		// Test getting the value of a field with a zero value
		stats.setMAX_ENERGY(0);
		assertEquals(0, stats.getStatByName(Statistic_name.MAX_ENERGY), 0);
		
		
		// Test getting the value of an invalid field
		assertEquals(-1, stats.getStatByName(null), 0);
		assertEquals("Error getting stat { null }" + System.lineSeparator(), errContent.toString());
	}
	
	@Test
	public void testSetStatByName () {
		Statistics basicSet = new Statistics();
		Statistics quickSet = new Statistics();
		
		// Test getting the value of a field with a positive value
		basicSet.setMAX_HEALTH(100);
		quickSet.setStatByName(Statistic_name.MAX_HEALTH, 100);
		assertEquals(basicSet.getMAX_HEALTH(), quickSet.getMAX_HEALTH(), 0);
		
		basicSet.setHEALTH_REGENERATION(10.5);
		quickSet.setStatByName(Statistic_name.HEALTH_REGENERATION, 10.5);
		assertEquals(basicSet.getHEALTH_REGENERATION(), quickSet.getHEALTH_REGENERATION(), 0);
		
		basicSet.setHEALTH_REGEN_AUGMENT(0);
		quickSet.setStatByName(Statistic_name.HEALTH_REGEN_AUGMENT, 0);
		assertEquals(basicSet.getHEALTH_REGEN_AUGMENT(), quickSet.getHEALTH_REGEN_AUGMENT(), 0);
		
		basicSet.setMAX_MANA(220);
		quickSet.setStatByName(Statistic_name.MAX_MANA, 220);
		assertEquals(basicSet.getMAX_MANA(), quickSet.getMAX_MANA(), 0);
		
		basicSet.setMANA_REGENERATION(15.3);
		quickSet.setStatByName(Statistic_name.MANA_REGENERATION, 15.3);
		assertEquals(basicSet.getMANA_REGENERATION(), quickSet.getMANA_REGENERATION(), 0);
		
		basicSet.setMANA_REGEN_AUGMENT(0);
		quickSet.setStatByName(Statistic_name.MANA_REGEN_AUGMENT, 0);
		assertEquals(basicSet.getMANA_REGEN_AUGMENT(), quickSet.getMANA_REGEN_AUGMENT(), 0);
		
		basicSet.setATTACK_DAMAGE(43.5);
		quickSet.setStatByName(Statistic_name.ATTACK_DAMAGE, 43.5);
		assertEquals(basicSet.getATTACK_DAMAGE(), quickSet.getATTACK_DAMAGE(), 0);
		
		basicSet.setABILITY_POWER(50);
		quickSet.setStatByName(Statistic_name.ABILITY_POWER, 50);
		assertEquals(basicSet.getABILITY_POWER(), quickSet.getABILITY_POWER(), 0);
		
		basicSet.setARMOR(63);
		quickSet.setStatByName(Statistic_name.ARMOR, 63);
		assertEquals(basicSet.getARMOR(), quickSet.getARMOR(), 0);
		
		basicSet.setMAGIC_RESISTANCE(52);
		quickSet.setStatByName(Statistic_name.MAGIC_RESISTANCE, 52);
		assertEquals(basicSet.getMAGIC_RESISTANCE(), quickSet.getMAGIC_RESISTANCE(), 0);
		
		basicSet.setCRITICAL_CHANCE(0);
		quickSet.setStatByName(Statistic_name.CRITICAL_CHANCE, 0);
		assertEquals(basicSet.getCRITICAL_CHANCE(), quickSet.getCRITICAL_CHANCE(), 0);
		
		basicSet.setCRITICAL_DAMAGE(47.5);
		quickSet.setStatByName(Statistic_name.CRITICAL_DAMAGE, 47.5);
		assertEquals(basicSet.getCRITICAL_DAMAGE(), quickSet.getCRITICAL_DAMAGE(), 0);
		
		basicSet.setHEAL(38);
		quickSet.setStatByName(Statistic_name.HEAL, 38);
		assertEquals(basicSet.getHEAL(), quickSet.getHEAL(), 0);
		
		basicSet.setSHIELD(15);
		quickSet.setStatByName(Statistic_name.SHIELD, 15);
		assertEquals(basicSet.getSHIELD(), quickSet.getSHIELD(), 0);
		
		basicSet.setABILITY_HASTE(15);
		quickSet.setStatByName(Statistic_name.ABILITY_HASTE, 15);
		assertEquals(basicSet.getABILITY_HASTE(), quickSet.getABILITY_HASTE(), 0);
		
		basicSet.setMAX_ENERGY(5.5);
		quickSet.setStatByName(Statistic_name.MAX_ENERGY, 5.5);
		assertEquals(basicSet.getMAX_ENERGY(), quickSet.getMAX_ENERGY(), 0);
		
		
		// Test getting the value of an invalid field
		assertEquals(-1, basicSet.getStatByName(null), 0);
		assertEquals("Error getting stat { null }" + System.lineSeparator(), errContent.toString());
	}
}
