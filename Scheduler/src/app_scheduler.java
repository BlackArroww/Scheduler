import java.io.FileNotFoundException;
import java.io.IOException;


public class app_scheduler {
	
	public static void main(String[] args) throws FileNotFoundException, IOException { 

	    //Model m = new Model(); 
	    view_scheduler v = new view_scheduler(); 
	    //Controller c = new Controller(m, v); 
	    //c.readData();
	    v.setVisible(true); 

	  } 
}

