import java.awt.event.ActionEvent;
import java.lang.reflect.Array;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.text.View;

public class Controller_scheduler {
	
	@SuppressWarnings("unused")
	private Model_scheduler model;
	private View_scheduler view;
	private int priority_number;
	private int faktor;
	
	public ArrayList<Prozess> ProcessList = new ArrayList<Prozess>();

	
	

	public Controller_scheduler(Model_scheduler m, View_scheduler v) { 

		   this.model = m; 
		   this.view = v;

	} 

	public void initController(){
		view.getHzf_btn().addActionListener(e ->saveProcess(e) );
		view.getApl_btn().addActionListener(e ->deleteArrayList(e));
		}

	public void saveProcess(ActionEvent e) {
		CreateProcessObject();
		if(view.getName_fld().getText().isEmpty() || view.getPriority_fld().getText().isEmpty() || view.getWork_fld().getText().isEmpty() || view.getWait_fld().getText().isEmpty() || priority_number > 15) {
		
		}
		else {
			DeleteTextFields();
		}
		
	}
	
	private void DeleteTextFields() {
		view.getName_fld().setText("");
		view.getPriority_fld().setText("");
		view.getWork_fld().setText("");
		view.getWait_fld().setText("");
	}

	public void deleteArrayList(ActionEvent e) {
		DeleteAllProcesses();
		System.out.println("Alle Prozesse gelöscht");
		
	}
	
	private void DeleteAllProcesses() {
		ProcessList.clear();
	}

	
	public void CreateProcessObject(){
		
		
		
		if (view.getName_fld().getText().isEmpty() || view.getPriority_fld().getText().isEmpty() || view.getWork_fld().getText().isEmpty() || view.getWait_fld().getText().isEmpty()) {
			
			JOptionPane.showMessageDialog(null,"Bitte gib erst alles für einen Prozess ein, bevor du ihn hinzufügst !!!","Mitteilung", JOptionPane.WARNING_MESSAGE);
		}
		
		
		else {
			
			String prio = view.getPriority_fld().getText();
			priority_number = Integer.parseInt(prio);
			
			if(priority_number > 15) {
				JOptionPane.showMessageDialog(null,"Bitte gib keine Priorität größer als 15 ein!!!","Mitteilung", JOptionPane.WARNING_MESSAGE);
			}
			
			ArrayList<String> Prozess = new ArrayList<>();

			
//			//String "auseinader schneiden"

			
			String String1 = view.getWork_fld().getText();
			String sub[] = String1.split(";");
			String String2 = view.getWait_fld().getText();
			String sub2[] = String2.split(";");
		
			for (int x = 0; x < sub.length; x++) {
				Prozess.add(sub[x]);
			    if (x < sub2.length) {					//Wird benötigt wenn es mehr Rechenzeiten(RZ) als Wartezeiten(WZ) gibt und die Prozesse MÜSSEN mit einer RZ aufhören 
			    										//--> bzw es gibt immer eine WZ weniger als RZ
					Prozess.add(sub2[x]);
				}
			}
			
			
			ArrayList<String> process_queue = new ArrayList<String>();
			for (int x = 0; x < Prozess.size();x++) {
				String Faktor = Prozess.get(x);
				faktor = Integer.parseInt(Faktor);
			
				for (int y=faktor; y>0; y--) {
					if(x % 2 == 0){
						process_queue.add("R");
					}
					else {
						process_queue.add("W");
					}
				}
			
			
			}
			
			Prozess p = new Prozess();
			
			p.name = view.getName_fld().getText();
			p.prio = priority_number;
			p.queue = process_queue;
			p.pState = State.READY;
			p.waittime = 0;
			p.worktime = 0; 
			
			System.out.println(p.queue);
			System.out.println("Prozess wurde gesichert");
			ProcessList.add(p);

		}
		
	}

	public ArrayList<Prozess> getProcessList() {
		return ProcessList;
	}
}
