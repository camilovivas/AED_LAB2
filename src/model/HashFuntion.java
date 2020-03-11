package model;


public interface HashFuntion<T> {
	
	public void  createTable();
	public int M = 100;
	public int hash(int key);
	public boolean isEmpty();
	public void tableInset(T t);
	public void tableRetrieve(int id);

}
