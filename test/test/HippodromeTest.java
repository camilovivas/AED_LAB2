package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import model.Hippodrome;
import model.Jockey;

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
		a.outcome();
	}
	
	@Test
	void search() {
		Hippodrome a = new Hippodrome();
		a.addJockey("camilo", "pony");
		a.addJockey("camilo2", "pony2");
		Jockey actual = a.search(2);
		assertEquals("camilo2", actual.getNameJockey());
	}
	
	@Test
	void outcomeTest2() {
		Hippodrome a = new Hippodrome();
		a.addJockey("camilo", "pony");
		a.addJockey("jaime", "pony2");
		a.addJockey("felipe", "littlePony");
		a.addJockey("aristi", "pony3");		
		a.addJockey("jeison", "pony4");		
		a.outcome2();
		
	}
}
