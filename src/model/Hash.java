package model;

public class Hash<K, V> {
	private V node;
	private K key;
	
	public Hash(K key, V node) {
		this.node = node;
		this.key = key;
	}

	public V getNode() {
		return node;
	}

	public void setNode(V node) {
		this.node = node;
	}

	public K getKey() {
		return key;
	}

	public void setKey(K key) {
		this.key = key;
	}
	
	
}
