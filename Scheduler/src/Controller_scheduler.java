import java.awt.event.ActionEvent;
import java.lang.reflect.Array;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.text.View;

public class Controller_scheduler {
	
	private Model_scheduler model;
	private View_scheduler view;
	private Logic_scheduler scheduler;
	private int priority_number;
	private int faktor;
	
	public ArrayList<ArrayList<String>> ProcessList = new ArrayList<ArrayList<String>>();

	
	

	public Controller_scheduler(Model_scheduler m, View_scheduler v, Logic_scheduler s) { 

		   this.model = m; 
		   this.view = v;
		   this.scheduler = s;

	} 

	public void initController(){
		view.getHzf_btn().addActionListener(e ->saveProcess(e) );
		view.getApl_btn().addActionListener(e ->deleteArrayList(e));
		view.getRun_btn().addActionListener(e ->runScheduler(e));
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
		System.out.println("Alle Prozesse gel�scht");
		
	}
	
	private void DeleteAllProcesses() {
		ProcessList.clear();
	}

	public void runScheduler(ActionEvent e) {
		scheduler.run();
		System.out.println(ProcessList);
		
	}
	
	public void CreateProcessObject(){
		
		
		
		if (view.getName_fld().getText().isEmpty() || view.getPriority_fld().getText().isEmpty() || view.getWork_fld().getText().isEmpty() || view.getWait_fld().getText().isEmpty()) {
			
			JOptionPane.showMessageDialog(null,"Bitte gib erst alles f�r einen Prozess ein, bevor du ihn hinzuf�gst !!!","Mitteilung", JOptionPane.WARNING_MESSAGE);
		}
		
		
		else {
			
			String prio = view.getPriority_fld().getText();
			priority_number = Integer.parseInt(prio);
			
			if(priority_number > 15) {
				JOptionPane.showMessageDialog(null,"Bitte gib keine Priorit�t gr��er als 15 ein!!!","Mitteilung", JOptionPane.WARNING_MESSAGE);
			}
			
			ArrayList<String> Prozess = new ArrayList<>();
//			
//			Process.add(view.getName_fld().getText());
//			Process.add(view.getPriority_fld().getText());
//			
//			//String "auseinader schneiden"
//			
//			String String1 = view.getWork_fld().getText();
//			String sub[] = String1.split(";");
//			String String2 = view.getWait_fld().getText();
//			String sub2[] = String2.split(";");
//		
//			for (int x = 0; x < sub.length; x++) {
//				Process.add(sub[x]);
//			    if (x < sub2.length) {					//Wird ben�tigt wenn es mehr Rechenzeiten(RZ) als Wartezeiten(WZ) gibt und die Prozesse M�SSEN mit einer RZ aufh�ren 
//			    										//--> bzw es gibt immer eine WZ weniger als RZ
//					Process.add(sub2[x]);
//				}
//			}
//			ProcessList.add(Process);
			
			String String1 = view.getWork_fld().getText();
			String sub[] = String1.split(";");
			String String2 = view.getWait_fld().getText();
			String sub2[] = String2.split(";");
		
			for (int x = 0; x < sub.length; x++) {
				Prozess.add(sub[x]);
			    if (x < sub2.length) {					//Wird ben�tigt wenn es mehr Rechenzeiten(RZ) als Wartezeiten(WZ) gibt und die Prozesse M�SSEN mit einer RZ aufh�ren 
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
			
			System.out.println(process_queue);
			System.out.println("Prozess wurde gesichert");

		}
		
	}
}
