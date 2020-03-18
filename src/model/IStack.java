package model;

public interface IStack<T> {
	
	public T peek();
	public T pop();
	public void push(T item);
	public boolean isEmpty();
	public int size();

}
