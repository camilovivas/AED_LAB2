package model;


public class Hippodrome  {
	private QueueFuntion<Jockey> jockeys;
	private int number;
	
	public Hippodrome() {
		jockeys =  new QueueGeneric<>();
		number = jockeys.size()+1;
		
	}
	public QueueFuntion<Jockey> getJockeys() {
		return jockeys;
	}
	
	public void addJockey(String jockey, String horse) {
		Jockey j = new Jockey(jockey, horse, number);
		jockeys.offer(j);
	}
	
	
	
	
	

	
}
