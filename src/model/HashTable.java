package model;

import java.util.ArrayList;

public class HashTable<K, V > implements HashFuntion<K, V>{
	private ArrayList<Hash<V>> table;
	
	public HashTable() {
		createTable();
	}
	

	@Override//Exploracion lineal
	public int hash(K key, int i) {
		int k = key.hashCode(); 
		int ret = (int) Math.floor(k%M)+i;
		return ret;
	}

	@Override
	public boolean isEmpty() {
		// TODO mira si esta vacio
		return false;
	}

	@Override
	public void tableInsert(K key, V value) {
		Hash<V> h = new Hash<>(value);
		boolean stop = false;
		for (int i = 0; i <M && !stop ; i++) {
			int position = hash(key, i);
			if(table.get(position)==  null) {
				table.set(position, h);
				stop = true;
			}
			
		}
		
	}

	@Override
	public V tableRetrieve(K key) {
		boolean stop = false;
		for (int i = 0; i <M && !stop ; i++) {
			int position = hash(key, i);
			//TODO
		}
		
		return null;
	}

	@Override
	public void createTable() {
		table = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			table.add(null);
		}		
	}
}
