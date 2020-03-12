package model;


public class QueueGeneric<T> implements QueueFuntion<T> {
	
	private ListGeneric<T> first;
	private ListGeneric<T> last;
	private int size;
	
	public QueueGeneric() {
		size = 0;
		
	}

	@Override
	public boolean offer(T t) {
		boolean retorno = false;
		if(first == null) {
			first = (ListGeneric<T>) t;
			last = (ListGeneric<T>) t;
			size++;
			retorno = true;
		}
		else {
			last.setNext((ListGeneric<T>) t);
			last = (ListGeneric<T>) t;
			retorno = true;
			size++;
		}
		return retorno;
	}

	@Override
	public T peek() {
		return (T) last;
	}

	@Override
	public T poll() {
		T retorno = (T) last;
		last = (ListGeneric<T>) first.deleteLast();
		size--;
		return retorno;
	}

	@Override
	public int size() {
		return size;
	}
	
	
	
}
