package model;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Hippodrome {
	private QueueFuntion<Jockey> jockeys;
	private int number;

	public Hippodrome() {
		jockeys = new QueueGeneric<>();

	}

	public QueueFuntion<Jockey> getJockeys() {
		return jockeys;
	}

	public void addJockey(String jockey, String horse) {
		number = jockeys.size();
		Jockey j = new Jockey(jockey, horse, number + 1);
		jockeys.offer(j);
	}

	public String namesJockey() {
		String names = "";
		QueueFuntion<Jockey> temp = jockeys;
		while (temp.isEmpty() == false) {
			names += temp.poll().toString() + "\n";
		}
		return names;
	}

	public QueueGeneric<Jockey> outcome() {
		QueueGeneric<Jockey> qj = new QueueGeneric<Jockey>();
		ArrayList<Jockey> lj = new ArrayList<Jockey>();
		QueueFuntion<Jockey> temp = jockeys;
		ArrayList<Integer> numbersExit = new ArrayList<Integer>();
		boolean firstTime = true;
		while (temp.isEmpty() == false) {
			lj.add(temp.poll());
		}
		while (qj.size() != lj.size()) {
			int exit = 	(int) Math.round(Math.random() * lj.size());
			while(exit>lj.size()-1) {
			exit = 	(int) Math.round(Math.random() * lj.size());
			}
			if(firstTime) {
				qj.offer(lj.get(exit));
				numbersExit.add(exit);
				firstTime = false;
			}
			for (int i = 0; i < numbersExit.size() ; i++) {
				boolean found = false;
				if(numbersExit.get(i) == exit) {
					found = true;
				}
				if(found == false) {
					qj.offer(lj.get(exit));
				}
			}
		}
		return qj;
	}

}
