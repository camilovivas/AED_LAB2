package model;

import java.util.ArrayList;

public class HashTable<K, V > implements HashFuntion<K, V>{
	private ArrayList<Hash<K, V>> table;
	
	public HashTable() {
		createTable();
	}
	

	@Override//Exploracion lineal
	public int hash(K key, int i) {
		int k = (int) key; 
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
		Hash<K, V> h = new Hash<>(key,value);
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
		Hash<K,V> toReturn = null;
		for (int i = 0; i <M && !stop ; i++) {
			int position = hash(key, i);
			toReturn = table.get(position);
			if(toReturn.getKey().equals(key)) {
				stop = true;
			}
		}
		return toReturn.getNode();
	}

	public void createTable() {
		table = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			table.add(null);
		}		
	}
}
