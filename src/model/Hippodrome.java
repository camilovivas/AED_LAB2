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

//	public QueueGeneric<Jockey> outcome() {
//		QueueGeneric<Jockey> result = new QueueGeneric<Jockey>();
//		QueueFuntion<Jockey> temp1 = jockeys;
//		QueueGeneric<Jockey> temp2 = new QueueGeneric<Jockey>();
//		boolean firstTime = true;
//		while (firstTime || temp2.isEmpty() == false || temp1.isEmpty() == false ) {
//			firstTime = false;
//			if (temp1.size() >= temp2.size()) {
//				int exit = (int) Math.random() * temp1.size() + 1;
//				boolean found = false;
//				int i = 0;
//				while (found == false && temp1.isEmpty() == false) {
//					if (i == exit) {
//						result.offer(temp1.poll());
//						found = true;
//					} else {
//						i++;
//						temp2.offer(temp1.poll());
//					}
//				}
//			} else {
//				int exit = (int) Math.random() * temp2.size() + 1;
//				boolean found = false;
//				int i = 0;
//				while (found == false && temp2.isEmpty() == false) {
//					Jockey view = temp2.poll();
//					if (i == exit) {
//						result.offer(temp2.poll());
//						found = true;
//					} else {
//						i++;
//						if(temp2.peek() != null)
//						temp1.offer(temp2.poll());
//					}
//				}
//			}
//
//		}
//		return result;
//	}

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
