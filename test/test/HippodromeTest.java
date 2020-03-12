package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedList;

import org.junit.jupiter.api.Test;

import model.Hippodrome;
import model.Jockey;
import java.util.Queue;

class HippodromeTest {

	@Test
	void offer() {
		Hippodrome a = new Hippodrome(); 
		Jockey a1 = new Jockey("camilo", "pony", 1);
		Jockey a2 = new Jockey("camilo2", "pony2", 2);
		a.getJockeys().offer(a1);
		a.getJockeys().offer(a2);
		Queue <Jockey> prueba = new LinkedList<>();
		prueba.offer(a1);
		prueba.offer(a2);
		assertEquals(prueba.size(), a.getJockeys().size());
	}
	
	@Test
	void peek() {
		Hippodrome a = new Hippodrome(); 
		Jockey a1 = new Jockey("camilo", "pony", 1);
		Jockey a2 = new Jockey("camilo2", "pony2", 2);
		a.getJockeys().offer(a1);
		a.getJockeys().offer(a2);
		Queue <Jockey> prueba = new LinkedList<>();
		prueba.offer(a1);
		prueba.offer(a2);
		assertEquals(prueba.peek(), a.getJockeys().peek());
	}
	
	@Test
	void pool() {
		Hippodrome a = new Hippodrome(); 
		Jockey a1 = new Jockey("camilo", "pony", 1);
		Jockey a2 = new Jockey("camilo2", "pony2", 2);
		a.getJockeys().offer(a1);
		a.getJockeys().offer(a2);
		Queue <Jockey> prueba = new LinkedList<>();
		prueba.offer(a1);
		prueba.offer(a2);
		prueba.poll();
		a.getJockeys().poll();
		assertEquals(prueba.size(), a.getJockeys().size());
	}
	
	@Test
	void pool2() {
		Hippodrome a = new Hippodrome(); 
		Jockey a1 = new Jockey("camilo", "pony", 1);
		Jockey a2 = new Jockey("camilo2", "pony2", 2);
		a.getJockeys().offer(a1);
		a.getJockeys().offer(a2);
		Queue <Jockey> prueba = new LinkedList<>();
		prueba.offer(a1);
		prueba.offer(a2);
		String p1 = prueba.poll().getNameHorse();
		String p2 = a.getJockeys().poll().getNameHorse();
		assertEquals(p1,p2);
	}

}
