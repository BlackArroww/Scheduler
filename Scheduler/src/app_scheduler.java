import java.io.FileNotFoundException;
import java.io.IOException;


public class App_scheduler {
	
	public static void main(String[] args) throws FileNotFoundException, IOException { 

	    Model_scheduler m = new Model_scheduler(); 
	    View_scheduler v = new View_scheduler(); 
	    Logic_scheduler s = new Logic_scheduler(m, v);
	    Controller_scheduler c = new Controller_scheduler(m, v, s); 
	    
	    v.setVisible(true); 
	    c.initController();

	  } 
}

