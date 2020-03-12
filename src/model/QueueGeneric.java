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
		ListGeneric<T> a = new ListGeneric<>(t);
		if(first == null) {
			first = a;
			last = a;
			size++;
			retorno = true;
		}
		else {
			last.setNext(a);
			last = a;
			retorno = true;
			size++;
		}
		return retorno;
	}

	@Override
	public T peek() {
		return  first.getNode();
	}

	@Override
	public T poll() {
		T retorno = first.getNode();
		first = first.getNext();
		size--;
		return retorno;
	}

	@Override
	public int size() {
		return size;
	}
	
	
	
}
