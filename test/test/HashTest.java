package test;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;
import model.*;

class HashTest {

	@Test
	void tableInsertTest() {
		HashFuntion<Integer, Bettor> s = new HashTable<>();		
		Bettor a = new Bettor("3", "camilo", 1000);
		Bettor b = new Bettor("4", "no funciono", 1000);
		s.tableInsert(3, a);
		s.tableInsert(3, b);
		Bettor actual = s.tableRetrieve(3);
		assertEquals("camilo", actual.getName());
	}
	
	@Test
	void hash() {
		HashFuntion<Integer, Bettor> s = new HashTable<>();
		int actual = s.hash(3, 0);
		assertEquals(3, actual);
	}
	
	@Test
	void tebleRetrieveTest() {
		HashFuntion<Integer, Bettor> s = new HashTable<>();		
		Bettor a = new Bettor("3", "camilo", 1000);
		Bettor b = new Bettor("2", "felipe", 1000);
		Bettor c = new Bettor("5", "jaime", 1000);
		s.tableInsert(3, a);
		s.tableInsert(2, b);
		s.tableInsert(5, c);
		Bettor actual = s.tableRetrieve(2);
		assertEquals("felipe", actual.getName());
	}

}
