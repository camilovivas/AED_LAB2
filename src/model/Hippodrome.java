package model;


public class Hippodrome  {
	private QueueFuntion<Jockey> jockeys;
	private int number;
	
	public Hippodrome() {
		jockeys =  new QueueGeneric<>();
		
	}
	public QueueFuntion<Jockey> getJockeys() {
		return jockeys;
	}
	
	public void addJockey(String jockey, String horse) {
		number = jockeys.size();
		Jockey j = new Jockey(jockey, horse, number+1);
		jockeys.offer(j);
	}
	
	public String namesJockey() {
		String names =  "";
		QueueFuntion<Jockey> temp = jockeys;
		while(temp.isEmpty() == false) {
			names += temp.poll().toString()+"\n";
		}
		return names;
	}
	
	
	
	

	
}
