/* https://www.mkyong.com/java/how-to-read-and-parse-csv-file-in-java/ */

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Read_CSV {

	public Read_CSV() {
		// Constructor to initialize Class Instance Variable 
	}

	public static void main(String[] args) throws IOException {
		
		String csvFile = "/Users/mkyong/csv/country.csv"; 
		// String csvFile = "12thNovDataForSimulation.csv"; <- if file is in same WorkPlace then use directly file name 
		
		BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        
        List<Double[]> locationArr = new ArrayList<Double[]>(); 	//lat_lang
        List<String> jobID = new ArrayList<String>();				//Row_label
        List<Integer> weight = new ArrayList<Integer>();
        
        try 
        {

            br = new BufferedReader(new FileReader(csvFile));
            
            // Skip Header Line 
            br.readLine();  // <- Comment this Statement if you want to Read "Header Line" Also 
            
            //Reading from the second line
            while ((line = br.readLine()) != null) {

                // use comma as separator
            	// read "row by row" from .csv file and store each cell data into String Array  
                String[] country = line.split(cvsSplitBy);
                
                jobID.add(new String(country[1]));
                weight.add(new Integer(Math.round(Float.parseFloat(country[3]))));
                locationArr.add(new Double[] {Double.valueOf(country[5]),Double.valueOf(country[6])});
                
                System.out.println("jobId " + country[4] + " , weight=" + country[5]);

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

	}

}
