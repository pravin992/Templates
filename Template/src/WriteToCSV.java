import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class WriteToCSV {
	
	//print Header : Column Names 
	static void headerFormat(FileWriter fw) throws IOException { 
		//fw.append("\n");
		fw.append("levelId");
        fw.append(',');
        fw.append("rideName");
        fw.append(',');
        fw.append("ridestartEndLocation");
        fw.append(',');
        fw.append("rideData");
        fw.append('\n');
	}
	
	public static void main(String[] args) {
		FileWriter fw=null;
		BufferedReader br = null;
		
		String csvFile = "Hullahali_Plan.csv";							//extension for .csv file is mandatory
		
		String line = "";   											// content of each row is stored in "line"
        String cvsSplitBy = ",";										// split each row by "," 
        
        try {
			br = new BufferedReader(new FileReader(csvFile));
			fw = new FileWriter("output_csv.csv",true); 				// remove true if you want to override content of .csv file
		
			headerFormat(fw);											// write header line into .csv file 
			
			br.readLine();  											// skip reading header line from .csv
            
			//Reading from the second line
            while ((line = br.readLine()) != null) 
            {
            	String[] output = line.split(cvsSplitBy);  				//tokenize row and store it into output array
            	
            	for(int i=0;i<output.length;i++)						//read whole row and write it into .csv file 
            	{
            		fw.append(output[i]);
            		fw.append(",");
            	}
            	fw.append("\n");										// after reading current row put "\n" 
            	
            } // end of while
            
            fw.append("\n");											// put "\n" to display data of other .csv file separately 
            fw.close();
          
           
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}
	


