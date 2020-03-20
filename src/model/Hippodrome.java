package model;

import java.util.ArrayList;

public class Hippodrome {
	private QueueFuntion<Jockey> jockeys;
	private HashFuntion<Integer, Bettor> bettors;
	private int number;

	public Hippodrome() {
		jockeys = new QueueGeneric<>();
		bettors = new HashTable<>();

	}

	public QueueFuntion<Jockey> getJockeys() {
		return jockeys;
	}

	public HashFuntion<Integer, Bettor> getBettors() {
		return bettors;
	}

	public void addJockey(String jockey, String horse) {
		number = jockeys.size();
		Jockey j = new Jockey(jockey, horse, number + 1);
		jockeys.offer(j);
	}
	
	public void addBettor(String id, String name, int money, String horse) {
		Bettor b = new Bettor(id, name, money);
		Jockey a = search(horse);
		b.setJockeyBettor(a);
		int cast = Integer.parseInt(id);
		bettors.tableInsert(cast, b);
		
	}
	
	public String checkBettor(String id) {
		int cast = Integer.parseInt(id);
		String toReturn = "";
		Bettor temp = bettors.tableRetrieve(cast);
		toReturn += temp.toString();
		return toReturn;
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
			Jockey win = temp.poll();
			win.setWin(true);
			lj.add(win);
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
	
	public String podio() {
		QueueFuntion<Jockey> temp = new QueueGeneric<>();
		temp = jockeys;
		String ganador = "ganador "+temp.poll().getNameHorse()+" ";
		String segundo = "segundo "+temp.poll().getNameHorse()+" ";
		String tercero = "tercero "+temp.poll().getNameHorse();
		String toReturn = ganador+segundo+tercero;
		return toReturn;				
	}
	
//	//OTRO METODO PARA ELEGIR GANADOR 
//	public  QueueGeneric<Jockey> outcome2() {
//		QueueGeneric<Jockey> temp2 = new QueueGeneric<>();
//		int[] numbers = createNumbers();
//		for (int i = 0; i < numbers.length; i++) {
//			Jockey a = search(numbers[i]); 
//			temp2.offer(a);	
//		}		
//		return temp2;
//	}
//	
//	public int[] createNumbers() {
//		int [] numbers = new int[jockeys.size()];
//		for (int i = 0; i < numbers.length; i++) {
//			int num =(int) (Math.random()*jockeys.size()+1);
//			for (int j = i; j >=0; j--) {
//				if(numbers[j] == num) {
//					num =  (int) (Math.random()*jockeys.size()+1);
//					j = i;
//				}
//			}
//			numbers[i] = num;
//		}
//		return numbers;
//	}
//	
	public Jockey search(String horse) {
		QueueFuntion<Jockey> temp1 = jockeys;
		Jockey toReturn = null;
		boolean stop = false;
		while(!stop) {
			if(!temp1.isEmpty()) {
				Jockey a = temp1.poll();
				if(a.getNameHorse().compareToIgnoreCase(horse) == 0) {  
					toReturn = a;
					stop = true;
				}
			}
			else {
				stop = true;
			}
		}
		return toReturn;
	}

}
