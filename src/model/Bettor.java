package model;

public class Bettor {
	private String id;
	private String name;
	private int money;
	private Jockey jockeyBettor;
	
	public Bettor(String id, String name, int money) {
		this.id = id;
		this.name = name;
		this.money = money;
	}
	
	
	public Jockey getJockeyBettor() {
		return jockeyBettor;
	}	
	public void setJockeyBettor(Jockey jockeyBettor) {
		this.jockeyBettor = jockeyBettor;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	
	@Override
	public String toString() {
		String toReturn = "";
		toReturn += name +"\n"+ id + "\n";
		if(jockeyBettor.isWin()) {
			toReturn += jockeyBettor.getNameHorse()+" ha ganado";
		}
		else {
			toReturn += jockeyBettor.getNameHorse()+" ha perdido";
		}
		return toReturn;
	}
	
	
}
