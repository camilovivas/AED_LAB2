package model;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Hippodrome {
	private Queue <Jockey> jockeys;
	private Queue <Jockey> winners;//TODO1 cuando han pasado los 3 minutos se empiezan a poner randomicamente los jockeys aqui 
	private LinkedList<Bettor> hashTable;//preguntar si es con linked

	public Hippodrome() {
		jockeys = new LinkedList<>();
		winners = new LinkedList<>();
	}

	public Queue<Jockey> getJockeys() {
		return jockeys;
	}
	
	//TODO1
	public void winners() {
		
	}
	
	
	
}
