import java.awt.event.ActionEvent;
import java.lang.reflect.Array;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.text.View;

public class Controller_scheduler {
	
	private Model_scheduler model;
	private View_scheduler view;
	private Process_scheduler process;
	private Logic_scheduler scheduler;
	private String name;
	private String priority;
	private String worktime;
	private String waittime;
	public ArrayList<ArrayList<String>> ProcessList = new ArrayList();

	

	public Controller_scheduler(Model_scheduler m, View_scheduler v) { 

		   this.model = m; 
		   this.view = v; 

		  } 

	public void initController(){
		view.getHzf_btn().addActionListener(e ->saveProcess(e));
		view.getApl_btn().addActionListener(e ->deleteArrayList(e));
		view.getRun_btn().addActionListener(e ->runScheduler(e));
		}

	public void saveProcess(ActionEvent e) {
		PutElementsTogether();
		DeleteTextFields();
		
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
		
		
		System.out.println(ProcessList);
		
	}
	
	public void PutElementsTogether(){
		
		name = view.getName_fld().toString();
		priority = view.getPriority_fld().toString();
		worktime = view.getWork_fld().toString();
		waittime = view.getWait_fld().toString();
		
		if (view.getName_fld().getText().isEmpty() || view.getPriority_fld().getText().isEmpty() || view.getWork_fld().getText().isEmpty() || view.getWait_fld().getText().isEmpty()) {
			
			JOptionPane.showMessageDialog(null,"Bitte gib erst alles für einen Prozess ein, bevor du ihn hinzufügst !!!","Mitteilung", JOptionPane.WARNING_MESSAGE);
		}
		
		else {
			ArrayList<String> Process = new ArrayList<>();
			
			Process.add(view.getName_fld().getText());
			Process.add(view.getPriority_fld().getText());
			
			//String "auseinader schneiden"
			
			String String1 = view.getWork_fld().getText();
			String sub[] = String1.split(";");
		
			for (int x = 0; x < sub.length; x++) {
				Process.add(sub[x]);
			}
			
			String String2 = view.getWait_fld().getText();
			String sub2[] = String2.split(";");
		
			for (int y = 0; y < sub2.length; y++) {
				Process.add(sub2[y]);
			}
			
			ProcessList.add(Process);
			System.out.println("Prozess wurde gesichert");

		}
		
		
	}
}
