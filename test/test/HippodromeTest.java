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
		a.addJockey("camilo3", "pony3");
		a.addJockey("camilo4", "pony4");
		a.addJockey("camilo5", "pony5");
		a.addJockey("camilo6", "pony6");
		a.addJockey("camilo7", "pony7");
		assertEquals(a.outcome().size(), 7);
	}
	@Test
	void invertTest() {
		Hippodrome a = new Hippodrome();
		a.addJockey("camilo", "pony");
		a.addJockey("camilo2", "pony2");
		a.addJockey("camilo3", "pony3");
		a.addJockey("camilo4", "pony4");
		a.addJockey("camilo5", "pony5");
		a.addJockey("camilo6", "pony6");
		a.addJockey("camilo7", "pony7");
		a.invertQueue();
		String actual = a.getJockeys().peek().getNameHorse();
		assertEquals("pony7", actual);
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
		assertEquals("PODIO:"+"\n"+"ganador pony"+"\n"+ "segundo pony2"+"\n"+ "tercero pony3", actual);
	}
	
}
