import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyFileLoad {

	public static void main(String[] args) {
// Load Property File 
        
        Properties prop = new Properties();
      	InputStream input = null;
 		
      	try {
      		input = new FileInputStream("config.properties");

     		// load a properties file
     		prop.load(input);
      	} 
      	catch (IOException ex) {
     		ex.printStackTrace();
     	}
      	
     // get the property value and print it out
     		System.out.println(prop.getProperty("timeBackToDepot"));
     		System.out.println(prop.getProperty("speed"));
     		System.out.println(prop.getProperty("timeFactor"));
     		
     // Convert Property Value into Respective Data Type as Below
     		int val = Integer.parseInt(prop.getProperty("horizon"));
     		System.out.println("Val :"+val);
          
	}

}
