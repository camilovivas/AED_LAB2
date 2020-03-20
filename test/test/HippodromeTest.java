package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import model.*;

class HippodromeTest {
	
	@Test
	void namesJockeyTest() {
		Hippodrome a = new Hippodrome();
		a.addJockey("camilo", "pony");
		a.addJockey("camilo2", "pony2");
		String actual = a.namesJockey();
		assertEquals("1.pony camilo"+"\n"+"2.pony2 camilo2"+"\n", actual);
	}
	
	@Test
	void outcomeTest() {
		Hippodrome a = new Hippodrome();
		a.addJockey("camilo", "pony");
		a.addJockey("camilo2", "pony2");
		assertEquals(a.outcome().size(), 2);
	}
	
	@Test
	void addBettorTest() {
		Hippodrome a = new Hippodrome();
		a.addJockey("felipe", "pony");
		a.addBettor("1006015105", "jaime", 1000, "pony");
		Bettor actual = a.getBettors().tableRetrieve(1006015105);
		assertEquals("pony", actual.getJockeyBettor().getNameHorse());
	}
	
	@Test
	void search() {
		Hippodrome a = new Hippodrome();
		a.addJockey("camilo", "pony");
		a.addJockey("camilo2", "pony2");
		Jockey actual = a.search("pony2");
		assertEquals("camilo2", actual.getNameJockey());
	}
	
	@Test
	void podio() {
		Hippodrome a = new Hippodrome();
		a.addJockey("camilo", "pony");
		a.addJockey("camilo2", "pony2");
		a.addJockey("camilo3", "pony3");
		String actual = a.podio();
		assertEquals("ganador pony segundo pony2 tercero pony3", actual);
	}
	
}
