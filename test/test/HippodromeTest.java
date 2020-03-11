package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.Hippodrome;
import model.Jockey;

class HippodromeTest {

	@Test
	void test() {
		fail("Not yet implemented");
	}
	
	
	@Test
	void add() {
		Hippodrome a = new Hippodrome(); 
		Jockey a1 = new Jockey("camilo", "pony", 1);
		Jockey a2 = new Jockey("camilo2", "pony2", 2);
		a.getJockeys().add(a1);
		a.getJockeys().add(a2);
		System.out.println(a.getJockeys().peek().getNameHorse());
	}

}
