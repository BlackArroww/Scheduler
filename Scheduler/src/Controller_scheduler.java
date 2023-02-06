import java.awt.event.ActionEvent;
import java.lang.reflect.Array;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.text.View;

public class Controller_scheduler {
	
	private Model_scheduler model;
	private View_scheduler view;
	private Logic_scheduler scheduler;
	private String name;
	private String priority;
	private String worktime;
	private String waittime;
	private int priority_number;
	
	public ArrayList<ArrayList<String>> ProcessList = new ArrayList();
	public ArrayList<String> PrioList = new ArrayList();
	
	

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
		PutElementsTogether();
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

	public void runScheduler(ActionEvent e) {
		scheduler.run();
		System.out.println(ProcessList);
		
	}
	
	public void PutElementsTogether(){
		
		name = view.getName_fld().toString();
		priority = view.getPriority_fld().toString();
		worktime = view.getWork_fld().toString();
		waittime = view.getWait_fld().toString();
		
		String prio = view.getPriority_fld().getText();
		priority_number = Integer.parseInt(prio);
		
		if (view.getName_fld().getText().isEmpty() || view.getPriority_fld().getText().isEmpty() || view.getWork_fld().getText().isEmpty() || view.getWait_fld().getText().isEmpty()) {
			
			JOptionPane.showMessageDialog(null,"Bitte gib erst alles für einen Prozess ein, bevor du ihn hinzufügst !!!","Mitteilung", JOptionPane.WARNING_MESSAGE);
		}
		
		else if(priority_number > 15) {
			JOptionPane.showMessageDialog(null,"Bitte gib keine Priorität größer als 15 ein!!!","Mitteilung", JOptionPane.WARNING_MESSAGE);
		}
		
		else {
			ArrayList<String> Process = new ArrayList<>();
			
			Process.add(view.getName_fld().getText());
			Process.add(view.getPriority_fld().getText());
			
			//String "auseinader schneiden"
			
			String String1 = view.getWork_fld().getText();
			String sub[] = String1.split(";");
			String String2 = view.getWait_fld().getText();
			String sub2[] = String2.split(";");
			
			PrioList.add(view.getPriority_fld().getText());
		
			for (int x = 0; x < sub.length; x++) {
				Process.add(sub[x]);
			    if (x < sub2.length) {					//Wird benötigt wenn es mehr Rechenzeiten(RZ) als Wartezeiten(WZ) gibt und die Prozesse MÜSSEN mit einer RZ aufhören 
			    										//--> bzw es gibt immer eine WZ weniger als RZ
					Process.add(sub2[x]);
				}
			}
			
			ProcessList.add(Process);
			System.out.println("Prozess wurde gesichert");

		}
		
	}
}
