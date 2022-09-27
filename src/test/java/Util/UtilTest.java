package Util;


import org.junit.Test;

import static Util.Util.*;
import static org.junit.Assert.assertEquals;

public class UtilTest {
	@Test
	public void somme_entiersTest () {
		assertEquals(0, somme_entiers(0));
		assertEquals(1, somme_entiers(1));
		assertEquals(3, somme_entiers(2));
		assertEquals(6, somme_entiers(3));
		assertEquals(10, somme_entiers(4));
		assertEquals(15, somme_entiers(5));
		assertEquals(21, somme_entiers(6));
		assertEquals(28, somme_entiers(7));
		assertEquals(120, somme_entiers(15));
	}
	
	@Test
	public void fiboTest () {
		assertEquals(0, fibo(0));
		assertEquals(1, fibo(1));
		assertEquals(1, fibo(2));
		assertEquals(2, fibo(3));
		assertEquals(3, fibo(4));
		assertEquals(5, fibo(5));
		assertEquals(8, fibo(6));
		assertEquals(13, fibo(7));
		assertEquals(610, fibo(15));
	}
	
	
	@Test
	public void factoTest () {
		assertEquals(1, facto(0));
		assertEquals(1, facto(1));
		assertEquals(2, facto(2));
		assertEquals(6, facto(3));
		assertEquals(24, facto(4));
		assertEquals(120, facto(5));
		assertEquals(720, facto(6));
		assertEquals(5040, facto(7));
		assertEquals(479001600, facto(12));
		assertEquals(479001600, facto(14));
	}
	
	@Test
	public void reverse_factoTest () {
		assertEquals(1, reverse_facto(1));
		assertEquals(2, reverse_facto(3));
		assertEquals(3, reverse_facto(9));
		assertEquals(4, reverse_facto(27));
		assertEquals(4, reverse_facto(81));
		assertEquals(5, reverse_facto(243));
		assertEquals(6, reverse_facto(729));
		assertEquals(6, reverse_facto(2187));
		assertEquals(7, reverse_facto(6561));
		assertEquals(7, reverse_facto(19683));
		assertEquals(8, reverse_facto(59049));
		assertEquals(8, reverse_facto(177147));
		assertEquals(9, reverse_facto(531441));
		assertEquals(9, reverse_facto(1594323));
		assertEquals(10, reverse_facto(3628800));
		assertEquals(12, reverse_facto(479009999));
	}
}
