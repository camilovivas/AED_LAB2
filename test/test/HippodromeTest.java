package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import model.Hippodrome;

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
	
	
}
