package model;


public interface HashFuntion<K, V> {
	
	public int M = 100;
	public int hash(K key, int i);
	public boolean isEmpty();
	public void tableInsert(K key, V value);
	public V tableRetrieve(K key);

}
