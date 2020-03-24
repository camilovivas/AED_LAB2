package model;

public interface QueueFuntion<T> {
	public boolean offer(T t);//agrega
	public T peek();//devuelve el primero pero no elimina
	public T poll();//devuelve primero y elimina
	public int size();// devuelve el tama�o
	public boolean isEmpty();
}
