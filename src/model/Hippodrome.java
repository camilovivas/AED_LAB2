package model;

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
		QueueGeneric<Jockey> result = new QueueGeneric<Jockey>();
		QueueFuntion<Jockey> temp1 = jockeys;
		QueueGeneric<Jockey> temp2 = new QueueGeneric<Jockey>();
		boolean firstTime = true;
		while (firstTime || temp2.isEmpty() == false || temp1.isEmpty() == false ) {
			firstTime = false;
			if (temp1.size() >= temp2.size()) {
				int exit = (int) Math.random() * temp1.size() + 1;
				boolean found = false;
				int i = 0;
				while (found == false && temp1.isEmpty() == false) {
					if (i == exit) {
						result.offer(temp1.poll());
						found = true;
					} else {
						i++;
						temp2.offer(temp1.poll());
					}
				}
			} else {
				int exit = (int) Math.random() * temp2.size() + 1;
				boolean found = false;
				int i = 0;
				while (found == false && temp2.isEmpty() == false) {
					Jockey view = temp2.poll();
					if (i == exit) {
						result.offer(temp2.poll());
						found = true;
					} else {
						i++;
						if(temp2.peek() != null)
						temp1.offer(temp2.poll());
					}
				}
			}

		}
		return result;
	}
	
	public QueueGeneric<Jockey> test(){
		Jockey j = new Jockey("Jaime", "Pegaso", 1);
		QueueGeneric<Jockey> lj = new QueueGeneric<Jockey>();
		lj.offer(j);
		return lj;
	}
}
