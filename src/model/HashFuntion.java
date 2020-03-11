package model;

public interface HashFuntion<T> {
	
	public int hash(int key);
	public boolean isEmpty();
	public void tableInset(Object T);
	public void tableRetrieve(int id);

}
