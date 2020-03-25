package threads;

import application.Controller;
import model.Hippodrome;

public class ClockThread extends Thread {

	private Controller cc;
	private Hippodrome h;

	public ClockThread(Controller cc,Hippodrome h) {
		this.cc = cc;
		this.h = h;
	}

	public void run() {
		try {
			while (!h.stopBets()) {
				sleep(1000);
				h.getClock().time();
				cc.moveTime();
			}
//			m.endGame();
//			cc.setVisibility();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
