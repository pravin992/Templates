// https://www.mkyong.com/java/json-simple-example-read-and-write-json/
import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class JSONFileCreation {

    public static void main(String[] args) {
    	
    	// Create JSON Object as a root element 
        JSONObject obj = new JSONObject();
        
        // Add Data into JSON object 
        obj.put("name", "mkyong.com");    // key - value pair
        obj.put("age", new Integer(100)); // key - value pair

        // Create JSON Array 
        JSONArray list = new JSONArray();
        
        // Add Value into Array 
        list.add("msg 1");
        list.add("msg 2");
        list.add("msg 3");
        
        // At the End put all these values into root Element 
        obj.put("messages", list);

        // Create JSON File 
        try (FileWriter file = new FileWriter("G:\\Eclipse Projects\\Template\\JSON_OUTPUT.json")) {
        	
        	// Write JSON Object into JSON File 
            file.write(obj.toJSONString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }

        // Print JSON Object 
        System.out.print(obj);

    }

}


