
public class Logic_scheduler {
	
	private Model_scheduler model;
	private static View_scheduler view;
	private static Controller_scheduler controller;
	
	public Logic_scheduler(Model_scheduler m, View_scheduler v, Controller_scheduler c) { 

		   this.model = m; 
		   this.view = v;
		   this.controller = c;
		   												
	} 
	
	public static void run(){
		if (view.getComboBox().getSelectedItem().equals("Abi - Scheduler")) {
			
			for (int x = 0; x > controller.ProcessList.size(); x++) {
				
				System.out.println(controller.ProcessList);
				
			}
			
			
		}
	}
	
}
