import java.io.FileNotFoundException;
import java.io.IOException;


public class App_scheduler {
	
	public static void main(String[] args) throws FileNotFoundException, IOException { 

	    Model_scheduler m = new Model_scheduler(); 
	    View_scheduler v = new View_scheduler(); 
	    Controller_scheduler c = new Controller_scheduler(m, v);
	    Logic_scheduler s = new Logic_scheduler(m,v,c);
	    
	    v.setVisible(true); 
	    c.initController();

	  } 
}

