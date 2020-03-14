package test;

import static org.junit.jupiter.api.Assertions.*;
import java.util.LinkedList;
import java.util.Queue;
import org.junit.jupiter.api.Test;
import model.Jockey;
import model.QueueFuntion;
import model.QueueGeneric;

class QueueTest {

	@Test
	void offer() {
		QueueFuntion<Jockey> a = new QueueGeneric<>(); 
		Jockey a1 = new Jockey("camilo", "pony", 1);
		Jockey a2 = new Jockey("camilo2", "pony2", 2);
		a.offer(a1);
		a.offer(a2);
		Queue <Jockey> prueba = new LinkedList<>();
		prueba.offer(a1);
		prueba.offer(a2);
		assertEquals(prueba.size(), a.size());
	}
	
	@Test
	void peek() {
		QueueFuntion<Jockey> a = new QueueGeneric<>();
		Jockey a1 = new Jockey("camilo", "pony", 1);
		Jockey a2 = new Jockey("camilo2", "pony2", 2);
		a.offer(a1);
		a.offer(a2);
		Queue <Jockey> prueba = new LinkedList<>();
		prueba.offer(a1);
		prueba.offer(a2);
		assertEquals(prueba.peek(), a.peek());
	}
	
	@Test
	void pool() {
		QueueFuntion<Jockey> a = new QueueGeneric<>();  
		Jockey a1 = new Jockey("camilo", "pony", 1);
		Jockey a2 = new Jockey("camilo2", "pony2", 2);
		a.offer(a1);
		a.offer(a2);
		Queue <Jockey> prueba = new LinkedList<>();
		prueba.offer(a1);
		prueba.offer(a2);
		prueba.poll();
		a.poll();
		assertEquals(prueba.size(), a.size());
	}
	
	@Test
	void pool2() {
		QueueFuntion<Jockey> a = new QueueGeneric<>(); 
		Jockey a1 = new Jockey("camilo", "pony", 1);
		Jockey a2 = new Jockey("camilo2", "pony2", 2);
		a.offer(a1);
		a.offer(a2);
		Queue <Jockey> prueba = new LinkedList<>();
		prueba.offer(a1);
		prueba.offer(a2);
		String p1 = prueba.poll().getNameHorse();
		String p2 = a.poll().getNameHorse();
		assertEquals(p1,p2);
	}


}
