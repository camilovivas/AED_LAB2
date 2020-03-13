package model;

public interface IStack<T> {
	
	public T peek();
	public T pop();
	public T push(T item);
	public int search(Object o);
	public boolean isEmpty();
	public int size();

}
