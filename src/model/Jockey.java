package model;

public class Jockey {
	private String nameJockey;
	private String nameHorse;
	private int number;
	private boolean win;
	
	public Jockey(String nameJockey, String nameHorse, int number) {
		this.nameJockey = nameJockey;
		this.nameHorse = nameHorse;
		this.number = number;
		win = false;
	}

	public String getNameHorse() {
		return nameHorse;
	}

	public void setNameHorse(String nameHorse) {
		this.nameHorse = nameHorse;
	}

	public String getNameJockey() {
		return nameJockey;
	}

	public void setNameJockey(String nameJockey) {
		this.nameJockey = nameJockey;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public boolean isWin() {
		return win;
	}

	public void setWin(boolean win) {
		this.win = win;
	}
	
	@Override
	public String toString() {
		String toReturn = "";
		toReturn += number+"."+nameHorse+" "+nameJockey;
		return toReturn;
	}
	
	
	
}
