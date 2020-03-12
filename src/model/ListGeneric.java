package model;

public class ListGeneric<T> {
	private ListGeneric<T> next;
	private T node;
	
	public ListGeneric(T node) {
		this.node = node;
	}

	public ListGeneric<T> getNext() {
		return next;
	}

	public void setNext(ListGeneric<T> next) {
		this.next = next;
	}
	
	public T deleteLast() {
		T retorno = null;
		if(next.getNext() == null) {
			next = null;
			retorno = (T) this;
		}
		else {
			next.deleteLast();
		}
		return retorno;
	}
}
