package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import model.*;

class StackTest {

	@Test
	void peekTest() {
		Stack<Jockey> a =  new Stack<>();
		Jockey j = new Jockey("camilo", "pony", 1);
		Jockey jo = new Jockey("jaime", "pony2", 2);
		a.push(j);
		a.push(jo);
		Jockey actual = a.peek();
		assertEquals("pony2", actual.getNameHorse());
	}
	
	@Test
	void popTest() {
		Stack<Jockey> a =  new Stack<>();
		Jockey j = new Jockey("camilo", "pony", 1);
		Jockey jo = new Jockey("jaime", "pony2", 2);
		a.push(j);
		a.push(jo);
		a.pop();
		Jockey actual = a.peek();
		assertEquals("pony", actual.getNameHorse());
	}
	
	@Test
	void popTest2() {
		Stack<Jockey> a =  new Stack<>();
		Jockey j = new Jockey("camilo", "pony", 1);
		Jockey jo = new Jockey("jaime", "pony2", 2);
		a.push(j);
		a.push(jo);
		a.pop();
		assertEquals(1, a.size());
	}
	
	

}
