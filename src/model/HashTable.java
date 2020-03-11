package model;

import java.util.LinkedList;

public class HashTable<T> implements HashFuntion{
	private LinkedList<Object> table;
	
	public HashTable() {
		table = new LinkedList<>();//preguntar
	}

	@Override
	public int hash(int key) {
		// TODO la funcion hash
		return 0;
	}

	@Override
	public boolean isEmpty() {
		// TODO mira si esta vacio
		return false;
	}

	@Override
	public void tableInset(Object T) {
		// TODO agrega
		
	}

	@Override
	public void tableRetrieve(int id) {
		// TODO busca
		
	}
}
