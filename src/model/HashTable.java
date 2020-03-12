package model;


public class HashTable<T> implements HashFuntion<T>{
	private T[] hash;
	
	public HashTable() {
		hash = (T[]) new Object [M];
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

	@Override
	public void createTable() {
		// TODO Auto-generated method stub
		
	}
}
