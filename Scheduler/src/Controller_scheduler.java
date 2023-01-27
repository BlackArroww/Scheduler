import java.awt.event.ActionEvent;
import java.lang.reflect.Array;

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
		
		PutArraysTogether();
		
		System.out.println("Prozess wurde gesichert");
		
	}
	
	public void deleteArrayList(ActionEvent e) {
		
		System.out.println("Alle Prozesse gelöscht");
		
	}
	
	public void runScheduler(ActionEvent e) {

		System.out.println(name +""+ priority +""+ worktime +""+ waittime);
		
	}
	
	public void PutArraysTogether(){
		
		String name = view.getName_fld().toString();
		String priority = view.getPriority_fld().toString();
		String worktime = view.getWork_fld().toString();
		String waittime = view.getWait_fld().toString();
		
	}
}
