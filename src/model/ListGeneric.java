package model;

public class ListGeneric<T> {
	private ListGeneric<T> next;
	private T node;
	
	public ListGeneric(T node) {
		this.node = node;
	}
	
	public T getNode() {
		return node;
	}

	public void setNode(T node) {
		this.node = node;
	}

	public ListGeneric<T> getNext() {
		return next;
	}

	public void setNext(ListGeneric<T> next) {
		this.next = next;
	}

}
