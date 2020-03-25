package model;

import java.util.ArrayList;

public class Hippodrome {
	private QueueFuntion<Jockey> jockeys;
	private IStack<Jockey> jockeysRematch;
	private HashFuntion<Integer, Bettor> bettors;
	private int number;
	private Clock clock;

	public Hippodrome() {
		jockeys = new QueueGeneric<>();
		bettors = new HashTable<>();
		jockeysRematch = new Stack<>();
		clock = new Clock();
	}
	
	public boolean stopBets() {
		boolean ret = false;
		if(clock.getSeconds()>180) {
			ret = true;
		}
		return ret;
	}
	
	public Clock getClock() {
		return clock;
	}

	public void setClock(Clock clock) {
		this.clock = clock;
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
	
	public void invertQueue() {
		while (!jockeys.isEmpty()) {
			jockeysRematch.push(jockeys.poll());
		}
		
		while (!jockeysRematch.isEmpty()) {
			Jockey a = jockeysRematch.pop();
			a.setWin(false);
			jockeys.offer(a);
		}
	}
	
	
	public void addBettor(String id, String name, int money, String horse) {
		Bettor b = new Bettor(id, name, money);
		Jockey a = search(horse);
		b.setJockeyBettor(a);
		int cast = Integer.parseInt(id);
		bettors.tableInsert(cast, b);
		
	}
	
	public String checkBettor(String id) throws Exception{
		int cast = Integer.parseInt(id);
		String toReturn = "";
		Bettor temp = bettors.tableRetrieve(cast);
		toReturn += temp.toString();
		return toReturn;
	}

	public String namesJockey() {
		String names = "";
		QueueFuntion<Jockey> temp = new QueueGeneric<>();
		while (jockeys.isEmpty() == false) {
			Jockey tempj = jockeys.poll();
			names += tempj.toString() + "\n";
			temp.offer(tempj);
		}
		jockeys = temp;
		return names;
	}
	
	public void newGame() {
		jockeys = new QueueGeneric<>();
		bettors = new HashTable<>();
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
		Jockey a = jockeys.poll();
		Jockey b = jockeys.poll();
		Jockey c = jockeys.poll();
		String ganador ="PODIO:"+"\n"+"ganador "+a.getNameHorse()+"\n";	
		String segundo = "segundo "+b.getNameHorse()+"\n";
		String tercero = "tercero "+c.getNameHorse();
		String toReturn = ganador+segundo+tercero;
		temp.offer(a);
		temp.offer(b);
		temp.offer(c);
		while(jockeys.isEmpty() == false) {
			temp.offer(jockeys.poll());
		}
		jockeys =  temp;
		return toReturn;				
	}
	public String play() {
		jockeys = outcome2();
		return podio();
	}
//	//OTRO METODO PARA ELEGIR GANADOR 
	public  QueueFuntion<Jockey> outcome2() {
		QueueFuntion<Jockey> temp2 = new QueueGeneric<>();
		int[] numbers = createNumbers();
		for (int i = 0; i < numbers.length; i++) {
			Jockey a = search2(numbers[i]); 
			if(i == 0) {
				a.setWin(true);
			}
			temp2.offer(a);	
		}		
		return temp2;
	}
	
	public int[] createNumbers() {
		int [] numbers = new int[jockeys.size()];
		for (int i = 0; i < numbers.length; i++) {
			int num =(int) (Math.random()*jockeys.size()+1);
			for (int j = i; j >=0; j--) {
				if(numbers[j] == num) {
					num =  (int) (Math.random()*jockeys.size()+1);
					j = i;
				}
			}
			numbers[i] = num;
		}
		return numbers;
	}
	
	public Jockey search2(int num) {
		QueueFuntion<Jockey> temp1 = new QueueGeneric<>();
		Jockey toReturn = null;
		boolean stop = false;
		while(!stop) {
			if(!jockeys.isEmpty()) {
				Jockey a = jockeys.poll();
				temp1.offer(a);
				if(a.getNumber() == num) {  
					toReturn = a;
					stop = true;
				}
			}
			else {
				stop = true;
			}
		}
		while(!jockeys.isEmpty()) {
			temp1.offer(jockeys.poll());
		}
		jockeys = temp1;
		return toReturn;
	}
	//FIN
	public Jockey search(String horse) {
		QueueFuntion<Jockey> temp1 = new QueueGeneric<>();
		Jockey toReturn = null;
		boolean stop = false;
		while(!stop) {
			if(!jockeys.isEmpty()) {
				Jockey a = jockeys.poll();
				temp1.offer(a);
				if(a.getNameHorse().compareToIgnoreCase(horse) == 0) {  
					toReturn = a;
					stop = true;
				}
			}
			else {
				stop = true;
			}
		}
		while(!jockeys.isEmpty()) {
			temp1.offer(jockeys.poll());
		}
		jockeys = temp1;
		return toReturn;
	}

}
