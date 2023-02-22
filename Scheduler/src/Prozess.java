import java.util.ArrayList;


public class Prozess {
	
	String name;
	int prio;
	int clock;
	int waittime;
	int worktime;
	State pState;
	
	ArrayList<String> queue = new ArrayList<String>();
	ArrayList<String> history = new ArrayList<String>();
	
//*******************************************************************************************************************************************************************************
//*******************************************************************************************************************************************************************************
//*******************************************************************************************************************************************************************************
	
	
	public int getPrio() {
		
		return prio;
		
	}
	
	public State setState(State state) {
		pState = state;
		return pState;
	}
	
	public int getClock() {
		return clock;
	}

	public void increaseClock() {		//Prozess eigene Uhr , damit man der Prozess weiß wo er sich befindet im Takt
		
		clock++;
		
	}
	
	public void increaseWorktime() {		//Prozess eigene Uhr , damit man der Prozess weiß wo er sich befindet im Takt
		
		worktime ++;
		
	}
	
	public void decreasePrio() {//Verringert die Priorität des Prozesses immer um 2 (wenn es geht) und achtet dabei darauf das die Prio nicht unter Null fällt 
		
		if (prio >= 2) {			
			prio = prio - 2;
		} 
		else if (prio == 1) {
			prio--;
		}
		else if (prio == 0){
			prio = 0;
		}
		
	}

	public int getWorktime() {
		return worktime;
	}

	public void setWorktime(int i) {
		worktime = i;
	}

	public void increaseWaittime() {
		waittime++;
		
	}
	
	public void handleState(int t){
		if (t == queue.size()) {
			pState = State.FINISHED;
			history.add("O");
			System.out.println("Prozess " + name + " ist fertig");
		}
		else if (t != queue.size()) {
			if (queue.get(t) == "R") {
				  System.out.println("R wäre in der Queue also muss dieser Prozess "+ name +" unfreiwillig warten ('O' in History)");
				  history.add("O");
				  pState = State.READY;
			}
			else if (queue.get(t) == "W") {
				System.out.println("W wäre in der Queue also muss dieser Prozess "+ name +" eh warten ('I' in History) und hakt das also ab");
				history.add("I");
				pState = State.WAIT;
				clock++;
			}
		}
	}

	public int getWaittime() {
		return waittime;
	}


	
}
