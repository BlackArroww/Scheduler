
public class Logic_scheduler {
	
	private Model_scheduler model;
	private View_scheduler view;
	private Controller_scheduler controller;
	
	public Logic_scheduler(Model_scheduler m, View_scheduler v) { 

		   this.model = m; 
		   this.view = v;

	} 
	
	public void run(){
		if (view.getComboBox().getSelectedItem().equals("Abi - Scheduler")) {
			
			System.out.println("Hallo");
			
		}
	}
	
}
