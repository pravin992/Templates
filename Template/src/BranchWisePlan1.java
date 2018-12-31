import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

	 
public class BranchWisePlan1 {
	//print Header
	static void headerFormat(FileWriter fw,String levelId) throws IOException {
		fw.append(levelId);
		fw.append('\n');
		fw.append("levelId");
        fw.append(',');
        fw.append("rideName");
        fw.append(',');
        fw.append("ridestartEndLocation");
        fw.append(',');
        fw.append("rideData");
        fw.append('\n');
	}
	
	//print data in requested Format 
	static void displayFormat(String levelId,int count,String ridestartEndLocation,String str,FileWriter fw ) throws IOException {
		fw.append(levelId);
        fw.append(',');
        fw.append("Trip"+count);
        fw.append(',');
        fw.append(ridestartEndLocation);
        fw.append(',');
		fw.append(str);
		fw.append("\n");
	}

	public static void main(String[] args) {
		FileWriter fw=null;
		BufferedReader br = null;
		Scanner sc = new Scanner(System.in);
		
		String csvFile = "Hullahali_Plan.csv";
		
		String line = "";
        String cvsSplitBy = ",";	
        String str="";
        
        int count=1; 
        
        System.out.println("Enter levelId :");
        String levelId = sc.next();
        System.out.println("Enter ridestartEndLocation :");
        String ridestartEndLocation = sc.next();
        
		try {
			br = new BufferedReader(new FileReader(csvFile));
			fw = new FileWriter("output_csv.csv",true);
		
			headerFormat(fw,levelId);
			
			br.readLine();  
            //Reading from the second line
            while ((line = br.readLine()) != null) 
            {
            	String[] output = line.split(cvsSplitBy);
            	
            	int trip = Integer.parseInt(output[0]);
            	
            	if(trip!=count) // execute when trip is not same 
                {
            		displayFormat(levelId,count,ridestartEndLocation,str,fw ) ;
            		count++;
            		str="";
                }
            	str = str.concat(output[2]+","+output[3]+";"); //fetch all lat-lang of same trip and concat them 
            	
            } // end of while
            
            displayFormat(levelId, count, ridestartEndLocation, str, fw );
            
        	fw.append('\n');   // if you separate data of other file by newline 
        	
            fw.close();
            sc.close();
           
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}
	


