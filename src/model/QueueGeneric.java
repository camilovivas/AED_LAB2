package model;


public class QueueGeneric<T> implements QueueFuntion<T> {
	
	private ListGeneric<T> first;
	private ListGeneric<T> last;
	
	public QueueGeneric() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean offer(T t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public T peek() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T poll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
