
public class Logic_scheduler {
	
	private Model_scheduler model;
	private static View_scheduler view;
	private static Controller_scheduler controller;
	
	private static int ProcessCount = 0; 
	
	public Logic_scheduler(Model_scheduler m, View_scheduler v, Controller_scheduler c) { 

		   this.model = m; 
		   Logic_scheduler.view = v;
		   Logic_scheduler.controller = c;
		   												
	} 
	
	public static void run(){
		if (view.getComboBox().getSelectedItem().equals("Abi - Scheduler")) {
			
			ProcessCount = controller.ProcessList.size();
			
			System.out.println(ProcessCount);
			
			
			
			
			
			
			
		}
	}
	
}
