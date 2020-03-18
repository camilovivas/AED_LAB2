package model;

public class Stack<T> implements IStack<T> {
	private ListGeneric<T> top;
	private int size;
	public Stack() {
		size = 0;
	}
	
	@Override
	public T peek() {
		return top.getNode();
	}
	@Override
	public T pop() {
		T toReturn = top.getNode();
		top = top.getNext();
		size--;
		return toReturn;
	}
	@Override
	public void push(T item) {
		ListGeneric<T> n = new ListGeneric<>(item);
		n.setNext(top);
		top = n;
		size++;
	}
	@Override
	public boolean isEmpty() {
		return (top == null);
	}

	@Override
	public int size() {
		return size;
	}

}
