import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Collections;

public class Logic_scheduler {
	
	private Model_scheduler m;
	private View_scheduler v;
	private Controller_scheduler c;
	
	private int ProcessCount = 0; 
	private int activeProcessInt = 0;
	private boolean run = false;
	private boolean procF = false;
	
	public Logic_scheduler(Model_scheduler m, View_scheduler v, Controller_scheduler c) { 

		   this.m = m; 
		   this.v = v;
		   this.c = c;
		   												
	} 
	
	public void initScheduler() {
		v.getRun_btn().addActionListener(e ->run(e));
	}
	 
	public void run(ActionEvent e) {
		AufgabeLaden();
		if (v.getComboBox().getSelectedItem().equals("Abi - Scheduler")) {
			
			ProcessCount = c.ProcessList.size();
			PrioComparator prioComparator = new PrioComparator();
			Collections.sort(c.getProcessList(), prioComparator);						//Sortiert die ArrayListe auf die Höchste Priorität
			run = true;
			
			while (run == true) {
				
					switch (c.getProcessList().get(activeProcessInt).pState){
						case READY:
							c.getProcessList().get(activeProcessInt).setState(State.CALC);
							break;
						case CALC:	
							System.out.println("------");
							calc();
							c.getProcessList().get(activeProcessInt).setWorktime(0);
							
							System.out.println("------");
							if(procF == false) {
								PrioComparator prioComparator1 = new PrioComparator();
								Collections.sort(c.getProcessList(), prioComparator1);
								System.out.println("Prozess Liste wird neugeladen");
								activeProcessInt = 0;
							}
							else{
								System.out.println("proCf = false");
								procF = false;
							}
							
							break;
						case WAIT:
							System.out.println("Ok");
							waiting();
							if(oneLeft() == true) {
								System.out.println("Einer übrig!");
								
								int last = c.getProcessList().get(activeProcessInt).getClock();
								int lastOtherProcess = (c.getProcessList().get(activeProcessInt).queue.size()-1)-last;
								
								for(int s = 0; s <= last; s++) {
									c.getProcessList().get(activeProcessInt).history.add(c.getProcessList().get(activeProcessInt).queue.get(s));
								}
								
								for (int r = 0; r <= lastOtherProcess; r++) {
									for (int w = 0; w < ProcessCount; w++) {
										
											c.getProcessList().get(w).handleState(c.getProcessList().get(w).getClock());
											c.getProcessList().get(w).increaseWaittime();
											c.getProcessList().get(activeProcessInt).setState(State.READY);
									}
								}
								
								 c.getProcessList().get(activeProcessInt).setState(State.FINISHED);
							}
							System.out.println("Ok2");
							break;
						case FINISHED:
							checkAllEquals(c.getProcessList());
							if (checkAllEquals(c.getProcessList()) == true) {
								System.out.println("Alle Prozesse fertig");
								System.out.println("Prozess:" + c.getProcessList().get(0).name + " hat folgenden State " +c.getProcessList().get(0).pState);
								System.out.println("Prozess:" + c.getProcessList().get(1).name + " hat folgenden State " +c.getProcessList().get(1).pState);
								System.out.println("Prozess:" + c.getProcessList().get(2).name + " hat folgenden State " +c.getProcessList().get(2).pState);
								run = false;
								break;
							}
							else if (checkAllEquals(c.getProcessList()) == false) {
								activeProcessInt++;
								returnEverythingToGUI();
								
								
								break;
							}
					}
			}
		}
	}
	

	private boolean oneLeft() {
		int count = 0;
		
		for (int t = 0; t < ProcessCount; t++)
		    {	
				if(c.ProcessList.get(t).pState == State.FINISHED) {
					count++;
				}
		    }
		if (count == ProcessCount -1) {
			return true;
		}
		
			return false;	
		
	}

	private void returnEverythingToGUI() {
	
		
	}

	public void calc() {
		final Prozess active_Process = c.getProcessList().get(activeProcessInt);
		while (active_Process.queue.get(active_Process.getClock()) == "R") {
			//System.out.println(c.getProcessList().get(0).getClock());
			System.out.println("Prozess "+ active_Process.name +" hat eine Rechenzeiten verbraucht");
			active_Process.history.add(active_Process.getClock(), "X");
			active_Process.setWaittime(0);
			
			for (int w = 0; w < ProcessCount; w++) {
				if(w != activeProcessInt) {
					c.getProcessList().get(w).handleState(c.getProcessList().get(w).getClock());
					c.getProcessList().get(w).increaseWaittime();
				}
			}
			active_Process.increaseClock();
			active_Process.increaseWorktime();
			
			if(active_Process.getWorktime() == 5) {
				active_Process.setWorktime(0);
				active_Process.decreasePrio();
				System.out.println("Prozess "+ active_Process.name +" muss Prozessor abgeben da er 5 mal hintereinander rechnen durfte! Seine neue Prio ist: " + active_Process.getPrio());
				active_Process.setState(State.WAIT);
	
				
				System.out.println("Nun wir der Prozessor an den Prozess mit der längsten warte Zeit gegeben");
				ProcessForced();
				break;	
			}
			
			if(active_Process.queue.size() <= active_Process.getClock()) {
				active_Process.decreasePrio();
				
				System.out.println("Prozess "+ active_Process.name +" hat keine Rechen- und Wartezeiten mehr. Seine neue Prio ist: " + active_Process.getPrio());
				active_Process.setState(State.FINISHED);
				PrioComparator prioComparator1 = new PrioComparator();
				Collections.sort(c.getProcessList(), prioComparator1);
				break;
			}
			
			
			
			if(active_Process.queue.get(active_Process.getClock()) == "W") {		//Wenn Prozess keine Rechenzeiten mehr hat wird er auf Wait gesetzt und Prio Veringert
				active_Process.decreasePrio();
				active_Process.setState(State.WAIT);
				System.out.println("Prozess "+ active_Process.name +" hat nun keine Rechnzeit mehr und muss jetzt warten und hat -2 bei der Prio bekommen und seine neue Prio ist: " + active_Process.getPrio());
				break;
			}
		}
	}

	public void waiting() { 
		
		for (int r = activeProcessInt +1; r < ProcessCount; r++) {
			if (c.getProcessList().get(r).pState == State.READY) {
				activeProcessInt = r;
				break;
			}
			else if (c.getProcessList().get(r).pState != State.READY){
				activeProcessInt = ProcessCount;
			}
		}
		
		if (activeProcessInt == ProcessCount) {
			System.out.println("Alle Prozesse sind im warten Modus");
			activeProcessInt = 0;
			for (int d = 0; d < ProcessCount; d++) {
				c.getProcessList().get(d).handleState(c.getProcessList().get(d).getClock());
				c.getProcessList().get(d).increaseWaittime();
				if (c.getProcessList().get(d).queue.get(c.getProcessList().get(d).getClock()) == "R") {
					c.getProcessList().get(d).setState(State.READY);
				}
			}
			
			
		}
	}
	
	
	private boolean checkAllEquals(ArrayList<Prozess> ProcessList)
	  {
	    String value = "FINISHED";

	    for (int t = 0; t < ProcessCount; t++)
	    {	
	    	String str = c.ProcessList.get(t).pState.toString();
	    	if (str != value)
	    		{
	    			return false;
	    		}
	    }
	    return true;
	  }
	
	
	private void ProcessForced() {
		
		int fpInt = 0;
		
		for (int a = 0;  a < ProcessCount; a++) {
			int value =  c.ProcessList.get(fpInt).getWaittime();
			if (value < c.ProcessList.get(a).getWaittime() && c.ProcessList.get(a).pState != State.WAIT) {
				fpInt = a;
			}
		}
		procF = true;
		System.out.println("Prozessor wird an den Prozess: " + c.ProcessList.get(fpInt).name);
	}
	
	private void AufgabeLaden() {
		ArrayList<String> processqueue = new ArrayList<String>();
		ArrayList<String> processqueue1 = new ArrayList<String>();
		ArrayList<String> processqueue2 = new ArrayList<String>();
		Prozess A = new Prozess();
			A.name = "A";
			A.prio = 12;
			for(int t =0 ; t<2; t++) {
				processqueue1.add("R");
			}
			for(int t =0 ; t<4; t++) {
				processqueue1.add("W");
			}
			for(int t =0 ; t<6; t++) {
				processqueue1.add("R");	
			}
			A.queue =  processqueue1;
			A.pState = State.READY;
			A.waittime = 0;
			A.worktime = 0; 
			c.ProcessList.add(A);
		Prozess B = new Prozess();
			B.name ="Assi Prozess";
			B.prio = 10;
			processqueue.add("R");
			processqueue.add("W");
			processqueue.add("W");
			processqueue.add("R");
			processqueue.add("W");
			processqueue.add("W");
			processqueue.add("R");
			B.queue = processqueue;
			B.pState = State.READY;
			B.waittime = 0;
			B.worktime = 0; 
			c.ProcessList.add(B);
		Prozess C = new Prozess();
			C.name = "C";
			C.prio = 11;
			for(int t =0 ; t<2; t++) {
				processqueue2.add("R");
			}
			for(int t =0 ; t<2; t++) {
				processqueue2.add("W");
			}
			for(int t =0 ; t<5; t++) {
				processqueue2.add("R");	
			}
			C.queue = processqueue2;
			C.pState = State.READY;
			C.waittime = 0;
			C.worktime = 0;
			c.ProcessList.add(C);
			
	}
}